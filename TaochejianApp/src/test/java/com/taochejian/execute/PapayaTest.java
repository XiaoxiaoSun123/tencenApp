package com.taochejian.execute;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.taochejian.util.util;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class PapayaTest {
	
	public static void papayaSy(AndroidDriver driver){
		
		util.sleep(2);
		List<AndroidElement> eSelectTab = driver.findElements(By.id("com.taoche.cardetection:id/pf_layout1"));
//		List<AndroidElement> eTabName = driver.findElements(By.id(SubscribePageElements.TAB_NAME));		
		for (int i = 0; i < eSelectTab.size(); i++) {
//			if (eSelectTab.get(i).getAttribute("checked").equals("false")) {
				String pa = eSelectTab.get(i).getText();
				System.out.println(pa);

//				tabName = eTabName.get(i).getText();
//				LOG.info("订阅的内容: " + tabName);
//				break;
			}
	}
}
	
