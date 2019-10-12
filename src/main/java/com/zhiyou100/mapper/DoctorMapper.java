package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Doctor;

public interface DoctorMapper {

	int count();

	List<Doctor> findAll(Map<String, Object> map);

	Doctor findDoctorById(int id);

	int updateDoctor(Doctor doctor);

	int addDoctor(Doctor doctor);

}
