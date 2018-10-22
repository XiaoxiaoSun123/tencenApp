package com.taochejian.util;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class TestCar extends TestBase{

	public static Logger log = Logger.getLogger(TestCar.class);
	
//	  @Test(enabled = false)
//	  public void testAccountLogin() throws Exception {
//		  System.out.println("开始检测操作");
//	      ReportCase.report(driver);  
//	    }
	  
	
	//自动dk
	  @SuppressWarnings("deprecation")
	@Test()
	  public void pushTencen() throws Exception{
		  util.sleep(5);
		  driver.findElement(By.xpath("//*[contains(@text, '微信登录')]")).click();
		  log.info("点击微信登录");
		  util.sleep(5);
		  
		  /*
		   * 获取微信登录
		   */
		  driver.findElement(By.xpath("//*[contains(@text, '请填写微信号/QQ号/邮箱')]")).sendKeys("hxm154");
		  util.sleep(1);
		  driver.findElement(By.xpath("//*[contains(@text, '请填写密码')]")).sendKeys("hxm_154321!@#");
		  util.sleep(1);
		  driver.findElement(By.id("com.tencent.mm:id/ch6")).click();
		  util.sleep(10);
		 //*****************
		  driver.findElement(By.xpath("//*[contains(@text, '好车酷酷')]")).click();
		  log.info("选则好车酷酷");
		  util.sleep(3);
		  driver.findElement(By.xpath("//*[contains(@text, '进入企业')]")).click();
		  log.info("点击进入企业");
		  util.sleep(10);
		  driver.tap(1, 910, 1800, 1);
		  log.info("点击系统弹出的允许访问通讯录");
		  util.sleep(6);
		 
		  driver.tap(1, 800, 1900, 1);
		  log.info("点击进入工作台");
		  util.sleep(10);
		  driver.tap(1, 280, 1650, 1);
		  log.info("点击我的考勤");
		  util.sleep(2);
		  driver.findElement(By.xpath("//*[contains(@text, '考勤打卡')]")).click();
		  log.info("点击考勤打卡");
		  util.sleep(4);
		  
		  if(util.isElementExist(driver, By.id("com.tencent.wework:id/b2v")) == true){
			  log.info("点击允许获取地理位置");
			  driver.findElement(By.id("com.tencent.wework:id/b2v")).click();
			  util.sleep(8);
		  }
//		  driver.findElement(By.id("com.tencent.wework:id/b20")).click();
//		  log.info("点击允许获取地理位置");
//		  util.sleep(8);
		  driver.tap(1, 910, 1800, 1);
		  log.info("点击系统弹出的允许获取地理位置");
		  util.sleep(8);
		  driver.tap(1, 150, 1850, 1); 
		  util.sleep(1);	  
		  //##############33
		  String tpath = "E:/screen/" + util.screenshot(driver) + ".png";
		  util.sleep(1);	
		  Mail.sendEmailAttach("你还记得年少时的梦吗", "像一朵永不凋零的花~", tpath);
		  util.sleep(3);	  
	  }
}
