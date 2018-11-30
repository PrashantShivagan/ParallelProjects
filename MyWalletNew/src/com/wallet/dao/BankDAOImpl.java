package com.wallet.dao;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.wallet.dto.Customer;
import com.wallet.exception.BankException;

public class BankDAOImpl implements BankDAO {

	Map<String, Customer> map;

	public BankDAOImpl() {
		map = new HashMap<String, Customer>();
		map.put("7306451044", new Customer("Vamshi", "7306451044", 500));
		map.put("9963357591", new Customer("Sindhu", "9963357591", 1000));
	}

	@Override
	public Customer createAccount(Customer c) {
		// TODO Auto-generated method stub
		map.put(c.getMobileNumber(), c);
		return c;
	}

	@Override
	public Customer getAccount(String mobileno) {
		// TODO Auto-generated method stub
		Customer cShow = map.get(mobileno);
		return cShow;
	}

	@Override
	public boolean setAccount(String mobileNo, double amount) {
		// TODO Auto-generated method stub
		Customer cSet = map.get(mobileNo);
		cSet.setAmount(amount);
		System.out.println(cSet);
		map.put(mobileNo, cSet);
		return true;
	}


}
