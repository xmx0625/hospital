package com.zhiyou100.controller;

import java.util.HashMap;
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
import com.zhiyou100.model.Doctor;
import com.zhiyou100.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService service;
	
	@RequestMapping("/list")
	public String list(@RequestParam(defaultValue = "")String id,@RequestParam(defaultValue = "")String name,
			@RequestParam(defaultValue = "")String secco_name,@RequestParam(defaultValue="1")int pageNo,Model model) {
		Map<String,Object> map = new HashMap<>();
		map.put("id", id);
		map.put("name", name);
		map.put("secco_name", secco_name);
		
		int total = service.count(map);
		
		PageHelper.startPage(pageNo, 2);
		
		
		// 登录成功,展现全部用户
		List<Doctor> doctors = service.findAll(map);
		PageInfo<Doctor> pageInfo = new PageInfo<>(doctors);
		System.out.println("登录成功查询的全部用户 : " + doctors);
		model.addAttribute("doctors", pageInfo.getList());
		model.addAttribute("map", map);
		model.addAttribute("page", pageInfo);
		
		return "doctor/index";
	}
	
	
	@RequestMapping("/look")
	public String look(int id,Model model){
		Doctor doctor = service.findDoctorById(id);
		model.addAttribute("doctor", doctor);
		return "doctor/look";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String editGet(int id,Model model){
		Doctor doctor = service.findDoctorById(id);
		model.addAttribute("doctor", doctor);
		return "doctor/edit";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String editPost(Doctor doctor,Model model){
		
		int rowNum = service.updateDoctor(doctor);
		model.addAttribute("msg", "更新失败");
		if(rowNum > 0){
			return "forward:/doctor/list";
		}
		return "doctor/edit";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addGet() {
		return "doctor/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addPost(Doctor doctor,Model model) {
		int rowNum = service.addDoctor(doctor);
		model.addAttribute("msg", "更新失败");
		if(rowNum > 0){
			return "forward:/doctor/list";
		}
		return "doctor/add";
	}
	
	
	
	
	
	
	
}
