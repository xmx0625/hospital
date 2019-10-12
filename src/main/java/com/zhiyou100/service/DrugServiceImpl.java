package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.DrugMapper;
import com.zhiyou100.model.Drug;

@Service
public class DrugServiceImpl implements DrugService{
	
	@Autowired
	private DrugMapper mapper;
	
	@Override
	public List<Drug> findAll(Map<String, Object> map) {
		List<Drug> drugs = mapper.findAll(map);
		return drugs;
	}

	@Override
	public Drug findOne(String id) {
		Drug drug = mapper.findOne(id);
		return drug;
	}

	@Override
	public int addDrug(Drug drug) {
		int rowNum = mapper.addDrug(drug);
		return rowNum;
	}

	@Override
	public int editDrug(Drug drug) {
		int rowNum = mapper.editDrug(drug);
		return rowNum;
	}

}
