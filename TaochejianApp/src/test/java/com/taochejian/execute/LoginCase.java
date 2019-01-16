package com.taochejian.execute;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

import com.taochejian.element.TaochejianElement;
import com.taochejian.util.util;

public class LoginCase {

	public static Logger log = Logger.getLogger(LoginCase.class);
	
	public static void login(AndroidDriver driver){
		log.info("开始登录操作");
		util.setInputMethod();
		util.sleep(2);  
		driver.tap(1, 910, 1800, 1);
		util.sleep(2);
		driver.tap(1, 600, 1100, 1);
		util.sleep(1);
		driver.navigate().back();
		driver.findElement(By.id(TaochejianElement.USERNAME)).sendKeys("158 1105 5530");
		util.sleep(1);
		driver.findElement(By.id(TaochejianElement.PASSWORD)).sendKeys("uat.portal");
		driver.findElement(By.id(TaochejianElement.SUBMIT)).click();
		util.sleep(2);
	}
}
