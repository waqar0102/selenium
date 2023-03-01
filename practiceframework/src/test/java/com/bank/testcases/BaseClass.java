package com.bank.testcases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	public String baseUrl=readconfig.getApplicationUrl();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	  public static Logger logger;
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\eclipse-workspace\\practiceframework\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxPath());
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseUrl);
		
		logger=Logger.getLogger("ebanking");
		//PropertyConfigurator.confi gure("Log4j.properties");
	}
	@AfterClass
	public void tearDown() {
		driver.quit();	
	}
	public static void captureScreen(WebDriver driver,String tname)throws IOException{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshot/" + tname + " .png");
	    FileUtils.copyFile(source, target);
	    System.out.println("Screenshot taken");
	}
	
	public String randomstring() {
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return  generatedstring;
	}
	public static String randomeNum() {
		String generatedString2=RandomStringUtils.randomNumeric(4);
		return(generatedString2);
	}	

}
