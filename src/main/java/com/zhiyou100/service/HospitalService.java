package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.HospitalInfor;
import com.zhiyou100.model.RegistrationInfor;



public interface HospitalService {

	List<RegistrationInfor> findAll(Map<String, String> map);

	int addHospital(HospitalInfor hospital);

	void deleteHosp(String id);

	void deleteRep(String id);

	RegistrationInfor findOne(String id);

	void editHosp(RegistrationInfor reg);

	void delsHosp(String[] ids);

	void delsRep(String[] ids);

}
