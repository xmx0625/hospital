package com.zhiyou100.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.UserMapper;
import com.zhiyou100.model.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper mapper;
	
	@Override
	public User findUserByUsername(String username, String password) {
		Map<String,String> map = new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		User user = mapper.findUserByUsername(map);
		return user;
	}

}
