package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.DoctorMapper;
import com.zhiyou100.model.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorMapper mapper;
	
	@Override
	public int count(Map<String, Object> map) {
		int total = mapper.count();
		return total;
	}

	@Override
	public List<Doctor> findAll(Map<String, Object> map) {
		List<Doctor> doctors = mapper.findAll(map);
		return doctors;
	}

	@Override
	public Doctor findDoctorById(int id) {
		Doctor doctor = mapper.findDoctorById(id);
		return doctor;
	}

	@Override
	public int updateDoctor(Doctor doctor) {
		int rowNum = mapper.updateDoctor(doctor);
		return rowNum;
	}

	@Override
	public int addDoctor(Doctor doctor) {
		int rowNum = mapper.addDoctor(doctor);
		return rowNum;
	}

}
