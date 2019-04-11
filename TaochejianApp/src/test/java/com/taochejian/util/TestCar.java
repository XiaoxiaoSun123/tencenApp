package com.taochejian.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.taochejian.execute.CheckCarCase;
import com.taochejian.execute.LoginCase;
import com.taochejian.execute.PapayaTest;
import com.taochejian.execute.ReportCase;


public class TestCar extends TestBase{

	public static Logger log = Logger.getLogger(TestCar.class);
	 
	  
//	  @Test(enabled = false)
//	  public void testAccountLogin() throws Exception {
//		  log.info("登录");
//		  LoginCase.login(driver);
//	      ReportCase.report(driver);  
//	      CheckCarCase.checkCar(driver);
//		  PapayaTest.papayaSy(driver);;
//	      
//	    }
//	  
	
	//自动dk
	  @SuppressWarnings("deprecation")
	@Test(enabled = true)
	  public void pushTencen() throws Exception{
		  util.sleep(5);
		  log.info("启动程序");

		  driver.tap(1, 910, 1800, 1);
		  util.sleep(2);
//		  driver.findElement(By.xpath("//*[contains(@text, '微信登录')]")).click();	
//		  driver.findElement(By.id("com.tencent.wework:id/cgz")).click();
		  driver.tap(1, 500, 1550, 1);
		  log.info("点击微信登录");
		  util.sleep(5);
		  
		  /*
		   * 获取微信登录
		   */
		  driver.findElement(By.xpath("//*[contains(@text, '请填写微信号/QQ号/邮箱')]")).sendKeys("hxm154");
		  util.sleep(1);
		  driver.findElement(By.xpath("//*[contains(@text, '请填写密码')]")).sendKeys("hxm_154321!@#");
		  util.sleep(1);
		  driver.findElement(By.id("com.tencent.mm:id/cov")).click();
		  util.sleep(25);
		 //*****************
		  driver.findElement(By.xpath("//*[contains(@text, '好车酷酷')]")).click();
		  log.info("选则好车酷酷");
		  util.sleep(3);
		  driver.findElement(By.xpath("//*[contains(@text, '进入企业')]")).click();
		  log.info("点击进入企业");
		  util.sleep(10);
		  driver.tap(1, 910, 1800, 1);
		  log.info("点击系统弹出的允许访问通讯录");
		  util.sleep(3);
		  driver.tap(1, 910, 1800, 1);
		  log.info("允许访问联系人");
		  util.sleep(3);
		  driver.tap(1, 910, 1800, 1);
		  log.info("允许以下权限");
		  util.sleep(6);
		 
		  driver.tap(1, 800, 1900, 1);
		  log.info("点击进入工作台");
		  util.sleep(10);
		  Operation.swipeToUp(driver, 980, 1);
		  util.sleep(2);
		  Operation.swipeToUp(driver, 600, 1);
		  util.sleep(5);
		  driver.tap(1, 200, 950, 1);
		  log.info("点击我的考勤");
		  util.sleep(10);
		  driver.findElement(By.xpath("//*[contains(@text, '考勤打卡')]")).click();
		  log.info("点击考勤打卡");
		  util.sleep(8);
		  
//		  if(util.isElementExist(driver, By.id("com.tencent.wework:id/bbb")) == true){
//			  log.info("点击允许获取地理位置");
//			  driver.findElement(By.id("com.tencent.wework:id/bbb")).click();
//			  util.sleep(10);
//		  }
		  log.info("点击允许获取地理位置");
		  driver.tap(1, 800, 1080, 1); 
		  util.sleep(10);
		  log.info("点击定位");
		  driver.tap(1, 740, 1800, 1); 
		  util.sleep(12);
		  log.info("点击签到");
		  driver.tap(1, 150, 1850, 1); 
		  util.sleep(1);	  

		  String tpath = "E:/screen/" + util.screenshot(driver) + ".png";
		  util.sleep(1);	
		  Mail.sendEmailAttach("你还记得年少时的梦吗", "像一朵永不凋零的花~", tpath);
		  util.sleep(3);	 
		  
	  }

}
