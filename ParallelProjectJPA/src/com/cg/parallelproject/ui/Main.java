package com.cg.parallelproject.ui;

import java.math.BigDecimal;
import java.util.Scanner;

import com.cg.parallelproject.dto.Customer;

import com.cg.parallelproject.exception.MyException;
import com.cg.parallelproject.service.WalletService;
import com.cg.parallelproject.service.WalletServiceImpl;

public class Main {
	private static Scanner sc;

	public static void main(String args[])
	{
	Customer c=new Customer();
	WalletService service=new WalletServiceImpl();
	sc = new Scanner(System.in);
	int ch;
	do
	{
		System.out.println("1.Create Account");
		System.out.println("2.Deposit Amount");
	    System.out.println("3.Withdraw");
		System.out.println("4.Show Balance");
		System.out.println("5.FundTransfer");
		System.out.println("6.Exit");
		System.out.println("Enter ur choice");
		ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			String name;
			String mob;
			double bal;
			do
			{
				try
				{
					System.out.println("Enter name");
					name=sc.next();
					service.validateName(name);
					System.out.println("Enter mobile number");
					mob=sc.next();
					service.validateNumber(mob);
					System.out.println("Enter intial balance");
					bal=sc.nextDouble();
					service.validateBalance(bal);
					if(service.validateName(name)&&service.validateNumber(mob)&&service.validateBalance(bal))
					{
						c=service.createAccount(name,mob,bal);
						break;
				
					}
				}
				catch(MyException i)
				{
					System.out.println(i.getMessage());
				}
			
			}while(true);
			
			
			System.out.println(c.getName()+" "+c.getMobileNo()+" "+c.getBalance());
			break;
			
		case 2:
			String mobi;
			Double amt;
			do
			{
			try
			{
				System.out.println("Enter the mobile no");
				mobi=sc.next();
				service.validateNumber(mobi);
				System.out.println(" Amount you want to deposit");
				amt=sc.nextDouble();
				service.validateBalance(amt);
				if(service.validateNumber(mobi))
				{
					c=service.depositAmount(mobi, amt);
					break;
				}
			}
			catch(MyException e)
			{
				System.out.println(e.getMessage());
			}
			
			}while(true);
			
			System.out.println(c.getName()+" "+c.getMobileNo()+" "+c.getBalance());
			break;
		case 3:
			do
			{
				try
				{
					System.out.println("Enter the mobile no");
					String mobil=sc.next();
					service.validateNumber(mobil);
					System.out.println(" Amount you want to withdraw");
					double at=sc.nextDouble();
					
					if(service.validateNumber(mobil))
					{
						c=service.withdrawAmount(mobil, at);
						break;
					}
				}
				catch(MyException e)
				{
					System.out.println(e.getMessage());
				}
			
		    
			}while(true);
			System.out.println(c.getName()+" "+c.getMobileNo()+" "+c.getBalance());
			break;
		case 4:
			do
			{
			System.out.println("Enter mobile no.");
			String mobile=sc.next();
		
			
			try
			{
				if(service.validateNumber(mobile))
				{
					c=service.showBalance(mobile);
					break;
				}
			}
			catch(MyException e)
			{
				System.out.println(e.getMessage());
			}
			
			}while(true);
			System.out.println(c.getName()+" Your Available Balance: "+c.getBalance());
			break;
		case 5:
			do
			{
				System.out.println("Enter mobile no.");
				String mob1=sc.next();
				System.out.println("Enter mobile no of the receiver");
				String mob2=sc.next();
			
				System.out.println("Enter amount you want to transfer");
				double amount=sc.nextDouble();
				try
				{
					if(service.validateNumber(mob1)&&service.validateNumber(mob2))
					{
						c=service.fundTransfer(mob1, mob2, amount);
						break;
					}
				}
				catch(MyException e)
				{
					System.out.println(e.getMessage());
				}
			
			}while(true);
			
			if(c!=null)
			{
				System.out.println(" Amount successfully Transfered");
				System.out.println("Available account balance is: "+c.getName()+" with mobile no. "+c.getMobileNo()+" is "+c.getBalance());
			}	
			else
				System.out.println("Transfer failed");
			break;
		
		case 6:
			System.out.println("Exit");
			break;
		}
		
		
	}while(ch!=6);
	
	}
}
