package com.bank.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.pageobject.LoginPage;
import com.utilities.XLUtils;

public class TC_loginDDT_002 extends BaseClass {
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);
		lp.clickSubmit();
	}
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/testdata/login.xlsx";
	
	
		int rownum=XLUtils.getRowConnt(path, "sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String [rownum][colcount];
		for(int i=1;i<=rownum;i++) {
			
		for(int j=0;j<colcount;j++) {
			logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			
		}
		}
		
		return logindata;		
		
	}
	
	

}
