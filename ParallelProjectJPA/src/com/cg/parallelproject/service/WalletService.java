package com.cg.parallelproject.service;
import java.math.BigDecimal;

import com.cg.parallelproject.dto.Customer;
import com.cg.parallelproject.exception.MyException;


public interface WalletService {
public Customer createAccount(String name ,String mobileno, double amount) throws MyException;
public Customer showBalance (String mobileno) throws MyException;
public Customer fundTransfer (String sourceMobileNo,String targetMobileNo, double amount) throws MyException;
public Customer depositAmount (String mobileNo,double amount ) throws MyException;
public Customer withdrawAmount(String mobileNo, double amount) throws MyException;
public boolean validateName(String name) throws MyException;
public boolean validateNumber(String number) throws MyException;
public boolean validateBalance(double number) throws MyException;
}
