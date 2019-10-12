package com.zhiyou100.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.model.Drug;
import com.zhiyou100.service.DrugService;

@Controller
@RequestMapping("/drug")
public class DrugController {
	
	@Autowired
	private DrugService service;
	
	@RequestMapping("/list")
	public String list(@RequestParam(defaultValue = "")String drug_num,@RequestParam(defaultValue = "")String drug_type,
			@RequestParam(defaultValue="1")int pageNo,Model model) {
		Map<String,Object> map = new HashMap<>();
		map.put("drug_num", drug_num);
		map.put("drug_type", drug_type);
		PageHelper.startPage(pageNo, 2);
		List<Drug> drugs = service.findAll(map);
		PageInfo<Drug> pageInfo = new PageInfo<>(drugs);
		model.addAttribute("drugs", pageInfo.getList());
		model.addAttribute("map", map);
		model.addAttribute("page", pageInfo);
		return "drug/index";
	}
	
	@RequestMapping("/look")
	public String look(String id,Model model) {
		Drug drug  = service.findOne(id);
		model.addAttribute("drug", drug);
		return "drug/look";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addGet() {
		return "drug/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addPost(Drug drug,Model model,@RequestParam("drug_url") MultipartFile drug_url,HttpServletRequest request) throws IOException {
		String realPath = request.getServletContext().getRealPath("/upload");
//		ServletContext servletContext = request.getServletContext();
		System.out.println(realPath);
		// 将最终目的文件夹创建出来
		File file = new File(realPath);
		// 判断该文件是否存在
		if(file.exists()){
			// 不存在则创建出
			file.mkdir();
		}
		// 获得文件名
		String fileName = drug_url.getOriginalFilename();
		// 确定上传路径
				File newFile = new File(file,fileName);
				// 上传
				FileUtils.writeByteArrayToFile(newFile, drug_url.getBytes());
		System.out.println("接收到的: "+drug);
		int rowNum = service.addDrug(drug);
		model.addAttribute("path", "/upload/"+fileName);
		if(rowNum > 0) {
			return "forward:/drug/list";
		}
		model.addAttribute("msg", "添加错误");
		return "drug/add";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String editGet(String id,Model model) {
		Drug drug  = service.findOne(id);
		model.addAttribute("drug", drug);
		return "drug/edit";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String editPost(Drug drug,Model model) {
		int rowNum = service.editDrug(drug);
		if(rowNum > 0) {
			return "forward:/drug/list";
		}
		model.addAttribute("msg", "添加错误");
		return "drug/edit";
	}
}
