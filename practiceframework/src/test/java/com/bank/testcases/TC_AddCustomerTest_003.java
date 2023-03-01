package com.bank.testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageobject.AddCustomerPage;
import com.banking.pageobject.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		addcust.custName("luna");
		addcust.custgender("male");
		addcust.custdob("10", "15", "1985");
		Thread.sleep(3000);
		addcust.custaddress("india");
		addcust.custcity("bangalore");
		addcust.custstate("karanatka");
		addcust.custpinno(560076);
		addcust.custtelephoneno("987653210");
		
		String email=randomstring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpasword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(6000);
		
		boolean res=driver.getPageSource().contains("customer registered successfully");
		if(res==true) {
			Assert.assertTrue(true);
		}
		else {
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	

}
