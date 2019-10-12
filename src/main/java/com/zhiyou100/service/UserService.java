package com.zhiyou100.service;

import com.zhiyou100.model.User;

public interface UserService {

	User findUserByUsername(String username, String password);
	
}
