package com.cg.parallelproject.service;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.parallelproject.dto.Customer;


import com.cg.parallelproject.exception.MyException;

import com.cg.parallelproject.dao.WalletRepo;
import com.cg.parallelproject.dao.WalletRepoImpl;

public class WalletServiceImpl implements WalletService{
	WalletRepo repo;
	public WalletServiceImpl()
	{
		// TODO Auto-generated constructor stub
		repo=new WalletRepoImpl();
	}
	

	@Override
	public Customer createAccount(String name, String mobileno,
			double amount) throws MyException {
		// TODO Auto-generated method stub
		Customer c1=repo.findOne(mobileno);
		if(c1==null)
		{
		//Wallet w=new Wallet(amount);
		Customer c=new Customer(name,mobileno,amount);
		if(repo.createNewDetails(c))
		return c;
		else
			throw new MyException("Invalid Details");
		}
		else 
			throw new MyException("Number already Exists");
	}

	@Override
	public Customer showBalance(String mobileno) throws MyException {
		// TODO Auto-generated method stub
		Customer c=repo.findOne(mobileno);
		if(c!=null)
		return c;
		else
			throw new MyException("The number does not exist ");
	}

	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo,
			double amount) throws MyException {
		Customer c=repo.findOne(sourceMobileNo);
		Customer c1=repo.findOne(targetMobileNo);
		if(amount<=0)
			throw new MyException(" Amount Should be more than zero and amount cannot be less than or equal to zero");
		if(c==null)
			throw new MyException("Sender Number not  registered ");
		if(c1==null)
			throw new MyException("Reciever Number not registered");
		if(c!=null&&c1!=null)
		{
		withdrawAmount(sourceMobileNo,amount);
		depositAmount(targetMobileNo,amount);
		return c;
		}
		else
		throw new MyException(" Failed to Transfer");
		// TODO Auto-generated method stub
	}

	@Override
	public Customer depositAmount(String mobileNo,double amount) throws MyException {
		// TODO Auto-generated method stub
		//return dao.depositAmount(mobileNo, amount);
		Customer cu=repo.findOne(mobileNo);
		//Wallet w=cu.getWallet();
		if(amount<=0)
			throw new MyException("Please enter amount more than zero and amount cannot be less than or equal to zero");
		if(cu!=null)
		{
		cu.setBalance(cu.getBalance()+amount);
		repo.save(cu);
		return cu;
		}
		throw new MyException("Mobile Number not found Please enter registered mobile number");
	}

	@Override
	public Customer withdrawAmount(String mobileNo, double amount) throws MyException{
		// TODO Auto-generated method stub
		//return dao.withdrawAmount(mobileNo, amount);
		Customer cu=repo.findOne(mobileNo);
		if(cu==null)
			throw new MyException("Mobile Number not found Please enter registered mobile number");
		//Wallet w=cu.getWallet();
		if((cu.getBalance()-amount)>=500)
		{
		cu.setBalance(cu.getBalance()-amount);
		repo.save(cu);
		return cu;
		}
		else
			throw new MyException(" Cannot deduct money because we need to maintain minimum of 500 balance");
	}


	@Override
	public boolean validateName(String name) throws MyException{
		// TODO Auto-generated method stub
		Pattern p=Pattern.compile("[A-Z][a-z]{0,19}");
		Matcher m=p.matcher(name);
		if(m.matches())
			return true;
		else
		throw new MyException("Name is invalid first letter Should be capital and other should be small letter and maximum of 20 characters ");
	}


	@Override
	public boolean validateNumber(String number) throws MyException {
		// TODO Auto-generated method stub
		Pattern p=Pattern.compile("[6-9][0-9]{9}");
		Matcher m=p.matcher(number);
		if(m.matches())
			return true;
		else
			throw new MyException("Number is not correct please enter 10 digit Mobile number");
	}


	@Override
	public boolean validateBalance(double number) throws MyException {
		// TODO Auto-generated method stub
		if(number>=500)
		return true;
		else
			throw new MyException("Amount is less than 500 deposit minimum 500 to create account");
	}


	

}
