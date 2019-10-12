package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.RegistrationMapper;
import com.zhiyou100.model.RegistrationInfor;

@Service
public class RegistrationServiceImpl implements RegistrationService{
	
	@Autowired
	private RegistrationMapper mapper;
	
	@Override
	public List<RegistrationInfor> findAll(Map<String, Object> map) {
		List<RegistrationInfor> rags = mapper.findAll(map);
		return rags;
	}

	@Override
	public RegistrationInfor findOne(String id) {
		RegistrationInfor reg = mapper.findOne(id);
		return reg;
	}

	@Override
	public int editOne(RegistrationInfor reg) {
		int rowNum = mapper.editOne(reg);
		return rowNum;
	}

	@Override
	public int addReg(RegistrationInfor reg) {
		int rowNum = mapper.addReg(reg);
		return rowNum;
	}

}
