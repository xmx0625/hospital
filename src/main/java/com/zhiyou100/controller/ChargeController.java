package com.zhiyou100.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.model.ChargeManager;
import com.zhiyou100.model.PayItems;
import com.zhiyou100.model.RegistrationInfor;
import com.zhiyou100.service.ChargeService;

@Controller
@RequestMapping("/charge")
public class ChargeController {
	
	@Autowired
	private ChargeService service;
	
	@RequestMapping("/list")
	public String list(@RequestParam Map<String,String> map,@RequestParam(defaultValue="1")int pageNo,Model model) {
		PageHelper.startPage(pageNo, 2);
		List<ChargeManager> ChargeManagers = service.findAll(map);
		PageInfo<ChargeManager> pageInfo = new PageInfo<>(ChargeManagers);
		model.addAttribute("ChargeManagers", pageInfo.getList());
		model.addAttribute("page", pageInfo);
		model.addAttribute("map", map);
		return "charge/index";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addGet(String medical_record,String rname,Model model) {
		model.addAttribute("medical_record", medical_record);
		model.addAttribute("rname", rname);
		return "charge/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addPost(ChargeManager charge) {
		Date date = new Date();
		String time = new SimpleDateFormat("yyyy-MM-dd").format(date);
		charge.setCharge_time(time);
		System.out.println(charge);
		service.addCharge(charge);
		return "forward:/charge/list";
	}
	
	@RequestMapping("/se")
	public String se(int pay_items_id,Model model) {
		Double charge_money = service.findMoney(pay_items_id);
		model.addAttribute("charge_money", charge_money);
		model.addAttribute("pay_items_id", pay_items_id);
		return "charge/add";
	}
	
	@RequestMapping(value="/addPro",method=RequestMethod.GET)
	public String addGet() {
		
		return "charge/addPro";
	}
	@RequestMapping(value="/addPro",method=RequestMethod.POST)
	public String addPost(@RequestParam Map<String,Object> map) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeStr = sdf.format(date);
		try {
			map.put("time", sdf.parse(timeStr));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.addChargePro(map);
		return "forward:/charge/list";
	}
	
	@RequestMapping("/find")
	public String find(@RequestParam(defaultValue="")String id,@RequestParam(defaultValue="")String charge_item_name,Model model){
		RegistrationInfor reg = service.findReg(id);
		System.err.println(reg);
		PayItems pay = service.findPay(charge_item_name);
		System.err.println(pay);
		model.addAttribute("reg", reg);
		model.addAttribute("pay", pay);
		return "charge/addPro";
	}
	
	@RequestMapping("/echarts.do")
	@ResponseBody
	public double[] test() {
		double[] a = {40.0,30.0,38.0,67.0,56.0,45.0,54.0};
		return a;
	}
		
}
