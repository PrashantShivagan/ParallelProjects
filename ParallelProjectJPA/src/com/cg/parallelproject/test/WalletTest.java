package com.cg.parallelproject.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.parallelproject.dto.Customer;
import com.cg.parallelproject.exception.MyException;
import com.cg.parallelproject.service.WalletService;
import com.cg.parallelproject.service.WalletServiceImpl;

public class WalletTest {

	static Customer cust;
	static WalletService ws;
    @BeforeClass
    public static void init(){
        System.out.println("In Before Class..");
        cust=new Customer();
        ws=new WalletServiceImpl();

    }
    
    @Test
    public void  test_createAccount_1() throws MyException {
            assertNotNull(ws.createAccount("Sunny", "7896541230", 963));
    }
    
    @Test
    public void  test_showbalance() throws MyException {
            assertNotNull(ws.showBalance("9989334999"));
    }
    @Test
    public void  test_depositbalance() throws MyException {
            assertNotNull(ws.depositAmount("9989334999",45));
    }
    @Test
    public void  test_withdraw() throws MyException {
            assertNotNull(ws.withdrawAmount("9989334999", 963));
    }
    
    @Test
    public void  test_fundtransfer() throws MyException {
            assertNotNull(ws.fundTransfer("8686682001", "9989334999", 963));
    }
    
    

}
