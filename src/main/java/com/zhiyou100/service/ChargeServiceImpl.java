package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.ChargeMapper;
import com.zhiyou100.model.ChargeManager;
import com.zhiyou100.model.PayItems;
import com.zhiyou100.model.RegistrationInfor;

@Service
public class ChargeServiceImpl implements ChargeService{

	@Autowired
	private ChargeMapper mapper;
	
	@Override
	public List<ChargeManager> findAll(Map<String, String> map) {
		List<ChargeManager> chargeManagers = mapper.findAll(map);
		return chargeManagers;
	}

	@Override
	public Double findMoney(int pay_items_id) {
		Double charge_money = mapper.findMoney(pay_items_id);
		return charge_money;
	}

	@Override
	public void addCharge(ChargeManager charge) {
		mapper.addCharge(charge);
	}

	@Override
	public RegistrationInfor findReg(String id) {
		RegistrationInfor reg = mapper.findReg(id);
		return reg;
	}

	@Override
	public PayItems findPay(String charge_item_name) {
		PayItems pay = mapper.findPay(charge_item_name);
		return pay;
	}

	@Override
	public void addChargePro(Map<String, Object> map) {
		mapper.addChargePro(map);
	}

}
