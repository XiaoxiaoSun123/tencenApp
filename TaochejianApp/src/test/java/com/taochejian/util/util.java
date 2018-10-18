package com.taochejian.util;

import io.appium.java_client.android.AndroidDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}