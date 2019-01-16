package com.taochejian.execute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;
import com.taochejian.element.TaochejianElement;
import com.taochejian.util.util;

public class ReportCase{
	
	public static Logger log = LoggerFactory.getLogger(ReportCase.class);
	
	public static int random=(int) (Math.random()*999+100);
	
	public static void report(AndroidDriver driver){

		try {
			util.sleep(8);
			log.info("进入检测任务列表");
			util.sleep(2);			
			driver.findElement(By.id(TaochejianElement.START_CHECK)).click();
			util.sleep(2);
			driver.tap(1, 1000, 100, 1);
			util.sleep(1);
			log.info("输入车主姓名");
			driver.findElement(By.id(TaochejianElement.CAR_NAME)).sendKeys("Mali");
			util.sleep(1);
			log.info("输入电话");
			driver.findElement(By.id(TaochejianElement.CAR_PHONE)).sendKeys("15811055517");
			util.sleep(1);
			driver.findElement(By.id(TaochejianElement.CAR_NU_CHO)).click();
			util.sleep(1);
			driver.findElement(By.id(TaochejianElement.CAR_TRUE)).click();
			log.info("输入车牌号");
			driver.findElement(By.id(TaochejianElement.CAR_NUMBER)).sendKeys("A8KYY5");
			String getText = driver.findElement(By.id(TaochejianElement.CAR_NUMBER)).getText();
			if(getText.contains("A8KYY5")){
				log.info("输入正确，继续执行");
			}else{
				log.info("输入错误"+ getText);
				driver.findElement(By.id(TaochejianElement.CAR_NUMBER)).clear();
				driver.findElement(By.id(TaochejianElement.CAR_NUMBER)).sendKeys("A8KYY5");
			}
			log.info("输入VIN码");
			WebElement vin = driver.findElement(By.id(TaochejianElement.CAR_VIN));
			vin.sendKeys("NTXKN889WKL70N" + random + "YMMKKTT989");
			log.info("输入的VIN码是：" + vin.getText());
			log.info("选则品牌车型");
			driver.findElement(By.id(TaochejianElement.CAR_TYPE)).click();
			util.sleep(1);
			driver.findElement(By.xpath(TaochejianElement.LUOMIOU)).click();
			util.sleep(1);     
			driver.findElement(By.id(TaochejianElement.CAR_PINPAI)).click();
			util.sleep(1); 
			driver.findElement(By.id(TaochejianElement.CAR_CHEXING)).click();
			log.info("车辆注册地");
			driver.findElement(By.id(TaochejianElement.CAR_REGISTER)).click();
			util.sleep(1);
			driver.findElement(By.xpath(TaochejianElement.SHANGHAI)).click();
			util.sleep(1);
			driver.findElement(By.id(TaochejianElement.CAR_SOURCE)).click();
			util.sleep(1);
			driver.findElement(By.id(TaochejianElement.CAR_ADD)).click();
			util.waitForElementToLoad(driver, 20, By.id(TaochejianElement.CONTINUE_CHECK));	
			if(util.isElementExist(driver, By.id(TaochejianElement.CONTINUE_CHECK)) == true){
				log.info("添加工单成功,欧耶~");
				driver.findElement(By.id(TaochejianElement.CONTINUE_CHECK)).click();
			}else{
				log.info("建单失败！");
				Assert.assertEquals(true, false);
			}
			util.sleep(4);	
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}