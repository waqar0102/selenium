package com.bank.testcases;



import java.io.IOException;

import org.bytedeco.javacpp.opencv_legacy.lsh_hash;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageobject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	@Test
	public void logiTest() throws IOException, InterruptedException {
		
		logger.info("URL as open");
		LoginPage l=new LoginPage(driver);
		l.setUserName(username);
		logger.info("enter username");
         l.setPassword(password);
         logger.info("enter password");
         l.clickSubmit();
         Thread.sleep(3000);
         if(isAlertPresent()==true) {
        	 driver.switchTo().alert().accept();
        	 driver.switchTo().defaultContent();
        	 Assert.assertTrue(false);
        	 logger.warning("Login failed");
        	 }
         else {
        	 Assert.assertTrue(true);
        	 l.clickLogout();
        	 driver.switchTo().alert().accept();
        	 driver.switchTo().defaultContent();
        	
         }
         
	   
	
         
         
         if(driver.getTitle().equals("guru99 bank manageruuuu homepage")) {
        	 Assert.assertTrue(true);
        	 logger.info("login test pass");
         }
         else {
        	 captureScreen(driver,"loginTest");
        	 Assert.assertFalse(false);
        	 logger.info("test case fail");
         }
	}
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
		return false;
		
	}
	
}}

