package com.taochejian.util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;


public class util{
	
	public static Logger log = LoggerFactory.getLogger(util.class);

	//截屏功能 
	public static String screenshot(AndroidDriver driver) {
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		File screen = driver.getScreenshotAs(OutputType.FILE);
		File screenFile = new File("E:\\screen\\" + sdf.format(dt) + ".png");
		try {
			FileUtils.copyFile(screen, screenFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sdf.format(dt);
	}
	
    //滚屏封装，下滑
    public static void swipeToDown(AndroidDriver driver, float x) throws InterruptedException {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        Thread.sleep(1000);
        driver.swipe(width / 2, (int) (height * 4 / 5), width / 2, (int) (height / x), 1500);
    }

    //滚屏封装，上滑
    public static void swipeToUp(AndroidDriver driver, float x) throws InterruptedException {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        Thread.sleep(1000);
        driver.swipe(width / 2, (int) (height / x), width / 2, (int) (height * 4 / 5), 1500);
    }
    
	/**
	 * Windows下传入端口号终止本地进程
	 * @param port 
	 */
	public static void killProcess(int port) {
        String[] str = null;
        String temp = null;
        String line = null;
        String command = "cmd /c netstat -ano | findstr " + port + " | findstr  LISTENING";
		try {
			Process process = Runtime.getRuntime().exec(command);
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));	 			
	        while ((line = reader.readLine()) != null) {
	        	System.out.println(line.toString());
	        	str = line.toString().split(" ");		
				for(String s: str) {
					temp = s;
				}			
				command("taskkill /F /PID " + temp);	        	
	        }
	        process.waitFor();
	     log.info("进程已杀");
		} catch (IOException | InterruptedException e) {
			e.getMessage();
		}
	} 
	
	/**
	 * 执行dos命令
	 * @param command
	 */
	public static void command(String command) {
		try {
			Runtime.getRuntime().exec(command);
//			process.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
	/**
	 * Thread.sleep
	 * @param d
	 */
	public static void sleep(double d) {
		try {
			d *= 1000;
			Thread.sleep((int)d);
		} catch(Exception e) {}
	}
	
	/**
	 * 在当前页面下拉查找元素，直到找到或下拉num次
	 * @param driver
	 * @param by
	 * @return
	 */
	public static boolean swipe(AndroidDriver<AndroidElement> driver, By by, int num) {
		boolean flag = util.isElementExist(driver, by);
		int i = 0;
		Dimension windowSize = driver.manage().window().getSize();
		while(!flag && i < num) {						
			driver.swipe(windowSize.getWidth() / 2, windowSize.getHeight() / 2 + 200, windowSize.getWidth() / 2, 100 , 0);
			flag = util.isElementExist(driver, by);
			i++;
		}		
		util.sleep(1.5);
		return flag;
	}
	
	
	
	
	/**
	 * 在当前滚动查找文本，滚动到文本指定的位置。
	 * @param driver
	 * @param by
	 * @return 
	 */
	public static boolean scrollTo(AndroidDriver<AndroidElement> driver, By by, String text) {		
		swipe(driver, by, 1);
		boolean flag = false;
		while(!flag) {		
			Dimension windowSize = driver.manage().window().getSize();
			driver.swipe(windowSize.getWidth() / 2, windowSize.getHeight() / 2 + 200, windowSize.getWidth() / 2, 300 , 0);
			WebElement list = (WebElement) driver.findElements(by);		
				if (list.getText().equals(text)) {
					flag = true;
					break;
				}
			}
		return flag;
		}
    
	/** 
	 * 判断元素是否存在
     * @param driver
     * @return true or false
     */
	public static boolean isElementExist(AndroidDriver driver, By by) { 
        try { 
            driver.findElement(by);
            return true; 
        } catch(NoSuchElementException e) { 
            return false; 
        } 
    }
	
	/**
	 * 在给定的时间内去查找元素，如果没找到则超时，抛出异常
	 * */
	public static void waitForElementToLoad(AndroidDriver driver,int timeOut, final By By) {
		log.info("开始查找元素[" + By + "]");
		try {
			(new WebDriverWait(driver, timeOut)).until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driver) {
					WebElement element = driver.findElement(By);
					return element.isDisplayed();
				}
			});
		} catch (TimeoutException e) {
			log.error("超时!! " + timeOut + " 秒之后还没找到元素 [" + By + "]");
			Assert.fail("超时!! " + timeOut + " 秒之后还没找到元素 [" + By + "]");

		}
		log.info("找到了元素 [" + By + "]");
	}
	
	/**
	 * 恢复默认输入法为搜狗
	 */
	public static void setInputMethod() {
		command("adb shell ime set com.sohu.inputmethod.sogou.xiaomi/.SogouIME");
		util.sleep(3);
	}
	
	/**
     *恢复Appium输入法 unicodeKeyboard（输入中文）
     */
    public static void setInputAppiumMethod() {
//      String path = System.getProperty("user.dir");
//      cmd("cmd /c " + path + "\\scripts\\SetInputAppiumMethod.vbs");
        command("adb shell ime set io.appium.android.ime/.UnicodeIME");         //ios
        util.sleep(3);
    }
    
}