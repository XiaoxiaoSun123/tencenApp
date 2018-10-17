package com.taochejian.execute;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

import com.taochejian.util.util;

public class LoginCase {

	public static Logger log = Logger.getLogger(LoginCase.class);
	
	public static void login(AndroidDriver driver){
		log.info("开始登录操作");
		driver.findElement(By.id("com.taoche.cardetection:id/let_password_tel")).sendKeys("15811055530");
		
		util.sleep(1);
		driver.findElement(By.id("com.taoche.cardetection:id/let_new_password")).sendKeys("uat.portal");
		driver.findElement(By.id("com.taoche.cardetection:id/login_btn_submit")).click();
	}
}
