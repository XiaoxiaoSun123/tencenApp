package com.taochejian.util;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * 封装滑动操作方法
 * @author Allin
 *
 */
public class Operation {

    public static AndroidDriver<AndroidElement> driver;


	public Operation(AndroidDriver<AndroidElement> driver){  
    	Operation.driver = driver; 
    }

	/**
	 * 向下滑动
	 * @param driverdw
	 * @param during
	 */
	 public static void swipeToDown(AndroidDriver<AndroidElement> driver, int during) {
	        int width = driver.manage().window().getSize().width;
	        int height = driver.manage().window().getSize().height;
	        driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, during);
	    }
	 
	 /**
	     * 向上滑动
	     * @param driver
	     * @param during
	     */
//	    public static void swipeToUp(AndroidDriver<AndroidElement> driver, int during) {
//	        int width = driver.manage().window().getSize().width;
//	        int height = driver.manage().window().getSize().height;
//	        driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);
//	    }


	    /**
	     * 向左滑动
	     * @param driver
	     * @param during
	     */
	    public static void swipeToLeft(AndroidDriver<AndroidElement> driver, int during) {
	        int width = driver.manage().window().getSize().width;
	        int height = driver.manage().window().getSize().height;
	        driver.swipe(width * 3 / 4, height * 471 / 1911, width * 1 / 4, height * 471 / 1911, during);
//	        driver.swipe(width * 3 / 4, height / 2, width / 4, height / 2, during);//这个用于滑动开始页面
	    }
	      

	    /**
	     * 向右滑动
	     * @param driver
	     * @param during
	     */
	    public static void swipeToRight(AndroidDriver<AndroidElement> driver, int during) {
	        int width = driver.manage().window().getSize().width;
	        int height = driver.manage().window().getSize().height;
	        driver.swipe(width / 4, height / 2, width * 3 / 4, height / 2, during);
	    }
	    
	    /**
	     * 上滑
	     * @param driver
	     * @param during
	     * @param num
	     */
	    public static void swipeToUp(AndroidDriver<AndroidElement> driver,int during, int num) {  
	        int width = driver.manage().window().getSize().width;  
	        int height = driver.manage().window().getSize().height;  
	        for (int i = 0; i < num; i++) {  
	            driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);  
	        }  
	    }
	    
	 // 向上滑动
//	    public static void swipeToUp(int duration) {
//	    	int width=driver.manage().window().getSize().width;
//
//	    	int height=driver.manage().window().getSize().height;
//
//	    	int y1 = height*3/4; //上滑的开始点，从y1开始也就是屏幕的四分之三处
//
//	    	int y2 = height*1/4; //上滑的结束点，到y2结束也就是屏幕的四分之一处
//
//	    	TouchAction tAction = new TouchAction(driver);
//
//	    	 tAction.press(width/2,y1).waitAction(200).moveTo(width/2,y2).release().perform();
//
//	    }
}
