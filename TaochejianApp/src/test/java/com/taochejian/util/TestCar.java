package com.taochejian.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.taochejian.execute.CheckCarCase;
import com.taochejian.execute.Excute;
import com.taochejian.execute.LoginCase;
import com.taochejian.execute.PapayaTest;
import com.taochejian.execute.ReportCase;


public class TestCar extends TestBase{

	public static Logger log = Logger.getLogger(TestCar.class);
	 
	  
	  @Test(enabled = true)
	  public void testAccountLogin() throws Exception {
		  Excute.implementation(driver);
		  log.info("登录");
		  LoginCase.login(driver);
	      ReportCase.report(driver);  
	      CheckCarCase.checkCar(driver);
		  PapayaTest.papayaSy(driver);;	      
	    } 
	  }


