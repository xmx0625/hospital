package com.zhiyou100.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhiyou100.model.User;
import com.zhiyou100.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password,Model model,HttpServletRequest req) {
		User user = service.findUserByUsername(username,password);
		System.out.println(user);
		model.addAttribute("user", user);
		if(user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			return "index";
		}
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "redirect:/index.jsp";
	}
}
