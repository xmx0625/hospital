package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.HospitalMapper;
import com.zhiyou100.model.HospitalInfor;
import com.zhiyou100.model.RegistrationInfor;

@Service
public class HospitalServiceImpl implements HospitalService{
	
	@Autowired
	private HospitalMapper mapper;
	
	@Override
	public List<RegistrationInfor> findAll(Map<String, String> map) {
		List<RegistrationInfor> regs = mapper.findAll(map);
		return regs;
	}

	@Override
	public int addHospital(HospitalInfor hospital) {
		int rowNum = mapper.addHospital(hospital);
		return rowNum;
	}

	@Override
	public void deleteHosp(String id) {
		mapper.deleteHosp(id);
	}

	@Override
	public void deleteRep(String id) {
		mapper.deleteRep(id);
	}

	@Override
	public RegistrationInfor findOne(String id) {
		RegistrationInfor reg = mapper.findOne(id);
		return reg;
	}

	@Override
	public void editHosp(RegistrationInfor reg) {
		mapper.editHosp(reg);
	}

	@Override
	public void delsHosp(String[] ids) {
		mapper.delsHosp(ids);
	}

	@Override
	public void delsRep(String[] ids) {
		mapper.delsRep(ids);
	}

}
