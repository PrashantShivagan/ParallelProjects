package com.wallet.dao;

import java.util.List;
import java.util.Set;

import com.wallet.dto.Customer;
import com.wallet.exception.BankException;
import com.wallet.exception.InvalidPhoneNumber;

public interface BankDAO {
	
	public Customer createAccount(Customer c) throws BankException;
	public Customer getAccount(String mobileno);
	public boolean setAccount(String mobileNo, double amount);

}
