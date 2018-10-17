package com.taochejian.util;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.xml.serializer.utils.Utils;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;

public class TestBase {
	
	public static  AndroidDriver driver;
	
	 @BeforeMethod(alwaysRun = true)
	 
	    public void setUp() throws Exception {

	        DesiredCapabilities cap = new DesiredCapabilities();
	        cap.setCapability(CapabilityType.BROWSER_NAME, "");
	        cap.setCapability("platformName", "Android");
	        cap.setCapability("deviceName", "16d5c53d");
	        cap.setCapability("platformVersion", "7.1.1");
//	        cap.setCapability("appPackage", "com.taoche.cardetection");//淘车检     
//	        cap.setCapability("appActivity", "com.taoche.cardetection.business.appstart.AppStartActivity");//淘车检  
	        
	        cap.setCapability("appPackage", "com.tencent.wework");//企业微信
	        cap.setCapability("appActivity", "com.tencent.wework.launch.LaunchSplashActivity");//企业微信
	        
	        cap.setCapability("recreateChromeDriverSessions", "True");
	        cap.setCapability("unicodeKeyboard", "True");
	        cap.setCapability("resetKeyboard", "True");
	        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    }

	    @AfterMethod(alwaysRun = true)
	    public void tearDown() throws Exception {
//		 	util.killProcess(4723);
	        driver.quit();
	    }

}
