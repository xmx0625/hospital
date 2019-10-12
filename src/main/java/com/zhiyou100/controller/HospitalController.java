package com.zhiyou100.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.model.HospitalInfor;
import com.zhiyou100.model.RegistrationInfor;
import com.zhiyou100.service.HospitalService;

@Controller
@RequestMapping("/hospital")
public class HospitalController {
	
	@Autowired
	private HospitalService service;
	
	@RequestMapping("/list")
	public String list(@RequestParam Map<String,String> map,@RequestParam(defaultValue="1")int pageNo,
			Model model) {
		PageHelper.startPage(pageNo,2);
		
		List<RegistrationInfor> regs = service.findAll(map);
		PageInfo<RegistrationInfor> pageInfo = new PageInfo<>(regs);
		model.addAttribute("regs", pageInfo.getList());
		model.addAttribute("page", pageInfo);
		model.addAttribute("map", map);
		return "hospital/index";
	}
	
	@RequestMapping("/look")
	public String look() {
		return "forward:/registration/look";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addGet() {
		return "hospital/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addPost(HospitalInfor hospital,Model model) {
		int rowNum = service.addHospital(hospital);
		if(rowNum > 0) {
			return "forward:/hospital/list";
		}
		model.addAttribute("msg", "添加失败");
		return "hospital/add";
	}
	
	@RequestMapping("/del")
	public String delete(String id) {
		service.deleteHosp(id);
		service.deleteRep(id);
		return "forward:/hospital/list";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String editGet(String id,Model model) {
		RegistrationInfor reg = service.findOne(id);
		model.addAttribute("reg", reg);
		return "hospital/edit";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String editPost(RegistrationInfor reg) {
		service.editHosp(reg);
		return "forward:/hospital/list";
	}
	
	public String dels(String[] ids) {
		service.delsHosp(ids);
		service.delsRep(ids);
		return "forward:/hospital/list";
	}
}
