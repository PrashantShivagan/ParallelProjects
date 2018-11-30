package com.wallet.test;

import static org.junit.Assert.assertEquals;
import junit.framework.Assert;

import org.junit.Test;

import com.wallet.exception.InvalidAmount;
import com.wallet.exception.InvalidPhoneNumber;
import com.wallet.exception.NameException;
import com.wallet.service.BankServiceImpl;

public class SBCBankTest {
	
	@Test
	public void ValidateNameTrue() throws NameException{
		BankServiceImpl bs = new BankServiceImpl();
		assertEquals(true, bs.validateUserName("Vamshidhar"));
	}
	
//	@Test (expected = InvalidNameFormat.class)
//	public void ValidateUserNameV1(){
//		BankServiceImpl bs = new BankServiceImpl();
		
//	}
	
	@Test
	public void ValidatePhonNumberTrue() throws InvalidPhoneNumber{
		BankServiceImpl bs = new BankServiceImpl();
		assertEquals(true, bs.validatePhoneNumber("9632584170"));
	}
	
	@Test
	public void ValidatePhoneNumber() throws InvalidPhoneNumber{
		BankServiceImpl bs = new BankServiceImpl();
		  
			    
		        String mobNo="ABCD91828288";
		 
		        boolean result= bs.validatePhoneNumber(mobNo);
		        Assert.assertEquals(false,result);
	}
	
	@Test 
	public void ValidateNameV2() throws NameException{
		BankServiceImpl bs = new BankServiceImpl();
		String name="prashant";
		 
        boolean result= bs.validateUserName(name);
        Assert.assertEquals(false,result);
	}
	
	@Test
	public void ValidateAmountTrue() throws InvalidAmount{
		BankServiceImpl bs = new BankServiceImpl();
		assertEquals(true, bs.validateAmount(100));
	}
	
	@Test (expected = InvalidAmount.class)
	public void ValidateAmount() throws InvalidAmount{
		BankServiceImpl bs = new BankServiceImpl();
		double amt= -400;
		 
        boolean result= bs.validateAmount(amt);
//        Assert.assertEquals(false,result);
		
	}

}
