package com.taochejian.execute;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Excute {
public static Logger log = Logger.getLogger(LoginCase.class);
	
	@SuppressWarnings("deprecation")
	public static void implementation (AndroidDriver<WebElement> driver) throws InterruptedException{
		log.info("开始执行");
		driver.findElementByXPath("//*[@text='允许']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//*[@text='允许']").click();
		Thread.sleep(1000);
		log.info("立即起航");		
//		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
//		WebElement reject=driver.findElementById("com.umetrip.android.msky.app:id/tv_reject");		                                         
//		reject.click();
//		Thread.sleep(1000);
		TouchAction ta = new TouchAction(driver);
		ta.tap(500,1700).release().perform();
		Thread.sleep(1000);
		
		log.info("点击同意");
		TouchAction agree = new TouchAction(driver);
		agree.tap(800,1600).release().perform();
		Thread.sleep(1000);		
		
		log.info("点击底部我的");
		List<WebElement> lines=driver.findElements(By.id("com.umetrip.android.msky.app:id/tv_text"));
		lines.get(4).click();
		Thread.sleep(1000);		
		
		
		Map<String,String> map = new HashMap<String, String>(); 
		map.put("13009809923", "lili5979");
		map.put("18553506017", "aabbcc");
		List<Map<String, String>> list = new ArrayList<Map<String, String>>(); 
		list.add(map); 
		for (Map<String, String> m : list){ 
			 for (String k : m.keySet()){ 
				 
				 log.info("点击登录");
					driver.findElementById("com.umetrip.android.msky.app:id/cl_person_info").click();
					Thread.sleep(1000);		
					
					//driver.findElementById("com.umetrip.android.msky.app:id/custom5_loginButton").click();
					log.info("输入用户名");
					String phoneNum=k;
					WebElement username = driver.findElementById("com.umetrip.android.msky.app:id/regist_name_edit");
					username.clear();
				    username.sendKeys(phoneNum);
				    
				    log.info("输入密码");
				    WebElement password= driver.findElementById("com.umetrip.android.msky.app:id/regist_pass_edit");
				    password.clear();
				    password.sendKeys(m.get(k));
				    Thread.sleep(1000);		
				    
				    log.info("点击登录按钮");
				    driver.findElementById("com.umetrip.android.msky.app:id/login_button").click();
				    Thread.sleep(2000);
				    
				    log.info("个人信息");
				    if(finELement(driver,phoneNum)){
				    	log.info("成功");
				    }else{
				    	log.error("失败");
				    }
				    
				    log.info("屏幕整体上滑");
				    swipeUp(driver);
				    log.info(" 点击设置");
				    WebElement personCenteragain = driver.findElementById("com.umetrip.android.msky.app:id/rv_person_center");
				    personCenteragain.findElement(By.xpath("//*[@text='设置']")).click();
				    Thread.sleep(1000);	
				    
				    log.info(" 点击退出l");
				    driver.findElementById("com.umetrip.android.msky.app:id/ll_logout").click();
				    Thread.sleep(1000);	
				    log.info("点击确定");
				    driver.findElementByXPath("//*[@text='确定']").click();
				    Thread.sleep(1000);	
			 }
		}
		
		
	    
	    
	  	
	} 	  
	public static Boolean finELement(AndroidDriver<WebElement> driver,String phoneNum){
		
		try
		{
			WebElement	personCenter = driver.findElementById("com.umetrip.android.msky.app:id/rv_person_center");
			List<WebElement> list=personCenter.findElements(By.className("android.view.ViewGroup"));
			WebElement mycar=list.get(1);
			mycar.findElement(By.xpath("//*[@text='已认证']"));			
			return true;
			
		}catch (Exception e) {
			screenshot(driver,phoneNum);
			return false;
		}

	}
	public static void screenshot(AndroidDriver<WebElement> driver,String fileName){
		String filePath = "";
		
		try{
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			filePath = "result/screenshots/"+ fileName + ".png";
			File destFile = new File(filePath);
			if(destFile.exists()){
				 destFile.delete();
			 }
			FileUtils.copyFile(screenshot, destFile);
			log.info("["+fileName + "] 截图 " + "[ " + filePath + " ]");
			
		}catch(Exception e){
			log.error("截图失败");
		}
		
		   
		 		 		
	}
	public static void swipeUp(AndroidDriver<WebElement> driver){
		int width = driver.manage().window().getSize().width;//获取当前屏幕的宽度
        int height = driver.manage().window().getSize().height;//获取当前屏幕的高度
        driver.swipe(width/2, height*3/4, width/2, height/4, 500);
	}
}
