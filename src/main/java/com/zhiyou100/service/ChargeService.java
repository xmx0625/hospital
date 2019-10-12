package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.ChargeManager;
import com.zhiyou100.model.PayItems;
import com.zhiyou100.model.RegistrationInfor;

public interface ChargeService {

	List<ChargeManager> findAll(Map<String, String> map);

	Double findMoney(int pay_items_id);

	void addCharge(ChargeManager charge);

	RegistrationInfor findReg(String id);

	PayItems findPay(String charge_item_name);

	void addChargePro(Map<String, Object> map);

}
