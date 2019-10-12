package com.zhiyou100.mapper;

import java.util.Map;

import com.zhiyou100.model.User;

public interface UserMapper {

	User findUserByUsername(Map<String, String> map);

}
