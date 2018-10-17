package com.taochejian.execute;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.appium.java_client.android.AndroidDriver;
import com.taochejian.util.Operation;
import com.taochejian.util.util;

public class ReportCase{
	
	public static Logger log = LoggerFactory.getLogger(ReportCase.class);
	
	public static int random=(int) (Math.random()*999+100);
	
	public static void report(AndroidDriver driver){


		try {
			util.sleep(8);
			log.info("登录");
			LoginCase.login(driver);
			log.info("进入检测任务列表");
			util.sleep(2);			
			driver.findElement(By.id("com.taoche.cardetection:id/pf_layout1_l2")).click();
			util.sleep(2);
			driver.tap(1, 1000, 100, 1);
			util.sleep(1);
			log.info("输入车主姓名");
			driver.findElement(By.id("com.taoche.cardetection:id/et_car_owner_name")).sendKeys("Mali");
			util.sleep(1);
			log.info("输入电话");
			driver.findElement(By.id("com.taoche.cardetection:id/et_car_owner_phone")).sendKeys("15811055517");
			driver.findElement(By.id("com.taoche.cardetection:id/tv_car_province")).click();
			util.sleep(1);
			driver.findElement(By.id("com.taoche.cardetection:id/dialog_common_btn_positive")).click();
			util.sleep(1);
			log.info("输入车牌号");
			driver.findElement(By.id("com.taoche.cardetection:id/et_car_num")).sendKeys("A889008989");
			log.info("输入VIN码");
			WebElement vin = driver.findElement(By.id("com.taoche.cardetection:id/et_car_vin"));
			vin.sendKeys("YTXKN889WKL70N" + random + "YMMKKTT989");
			log.info("输入的VIN码是：" + vin.getText());
			driver.findElement(By.id("com.taoche.cardetection:id/tv_car_type")).click();
			util.sleep(1);
			driver.findElement(By.id("com.taoche.cardetection:id/txt_item_brand_content_name")).click();
			util.sleep(1);
			driver.findElement(By.id("com.taoche.cardetection:id/layout_item_brand_content")).click();
			util.sleep(1);     
			driver.findElement(By.id("com.taoche.cardetection:id/txt_item_car_model_content_name")).click();
			util.sleep(1); 
			driver.findElement(By.id("com.taoche.cardetection:id/add")).click();
			util.sleep(5);
			if(driver.findElement(By.id("com.taoche.cardetection:id/add_task_confirm"))==null){
				log.error("没有找到开始行驶本检测按钮");
				util.sleep(8);
			}
			driver.findElement(By.id("com.taoche.cardetection:id/add_task_confirm")).click();
			util.sleep(2);
	
			log.info("开始行驶本检测");
			driver.findElement(By.id("com.taoche.cardetection:id/frg_drive_license_cb_un_pic")).click();
//			driver.findElement(By.xpath("//*[contains(@text, '行驶本正页')]")).click();
//			util.sleep(2);
//			log.info("开始点击拍照按钮");
//			driver.findElement(By.id("com.taoche.cardetection:id/camera_iv_take")).click();
//			util.sleep(2);
//			if(!(driver.findElement(By.id("com.taoche.cardetection:id/camera_tv_continue_take"))==null)){
//				for(int i =0;i<5;i++){	
//					util.sleep(1);
//					driver.findElement(By.id("com.taoche.cardetection:id/camera_tv_continue_take")).click();
//				}				
//			}
//			driver.findElement(By.id("com.taoche.cardetection:id/camera_tv_finish")).click();
			log.info("行驶本照片拍摄完毕，继续输入车主姓名");
			driver.findElement(By.xpath("//*[contains(@text, '请输入车主名称，最多输入20字')]")).sendKeys("mali");
//			driver.findElement(By.xpath("//*[contains(@text, '非运营')]")).click();
			log.info("点击非运营");
			driver.tap(1, 876, 1000, 1);
			util.sleep(5);
			
//			Operation.swipeToUp(driver, 10);
			Operation.swipeToUp(driver, 500, 1);
			util.sleep(2);
			log.info("输入品牌型号");
//			Operation.swipeToUp(driver, 20);
			driver.findElement(By.xpath("//*[contains(@text, '手动输入车辆品牌型号的非汉字部分')]")).sendKeys("T12890BJ");
			log.info("点击获取车型");
			util.sleep(2);
			driver.findElement(By.xpath("//*[contains(@text, '请获取车型')]")).click();
			util.sleep(2);
			driver.findElement(By.id("com.taoche.cardetection:id/txt_item_brand_content_name")).click();            
			driver.findElement(By.id("com.taoche.cardetection:id/txt_item_brand_content_name")).click();
			driver.findElement(By.id("com.taoche.cardetection:id/txt_item_car_model_content_name")).click();
			log.info("输入发动机号码");
//			Operation.swipeToUp(driver, 100);
			driver.findElement(By.xpath("//*[contains(@text, '请正确输入发动机号码')]")).sendKeys("5674677543");
			driver.findElement(By.xpath("//*[contains(@text, '请选择初登日期')]")).click();
			log.info("初登日期确定");
			driver.findElement(By.id("com.taoche.cardetection:id/tv_sure")).click();
			driver.findElement(By.id("com.taoche.cardetection:id/zkrs_5")).click();
			log.info("滑动后，输入年检到期");
			Operation.swipeToUp(driver, 500, 1);
			util.sleep(2);
			driver.findElement(By.xpath("//*[contains(@text, '请选择年检到期')]")).click();
			driver.findElement(By.id("com.taoche.cardetection:id/tv_sure")).click();
			log.info("年检到期点击完毕，点击下一步就进入下一检测项");
			driver.findElement(By.id("com.taoche.cardetection:id/frg_drive_license_tv_next_step")).click();
			util.sleep(3);
			log.info("进入登记证页操作");
			driver.findElement(By.id("com.taoche.cardetection:id/frg_registration_cb_un_pic")).click();
			driver.findElement(By.xpath("//*[contains(@text, '个人')]")).click();
			util.sleep(1);
			driver.findElement(By.xpath("//*[contains(@text, '注册地')]")).click();
			util.sleep(1);
			driver.findElement(By.xpath("//*[contains(@text, '北京')]")).click();
			util.sleep(1);
			driver.findElement(By.xpath("//*[contains(@text, '车辆登记颜色')]")).click();
			util.sleep(1);
			driver.findElement(By.id("com.taoche.cardetection:id/dialog_common_btn_positive")).click();
			log.info("车辆登记颜色颜色选则完毕");
			util.sleep(1);
			log.info("滑动一下下`~");
			Operation.swipeToUp(driver, 500, 1);
			util.sleep(1);
			driver.findElement(By.xpath("//*[contains(@text, '车身颜色')]")).click();
			util.sleep(1);
			driver.findElement(By.id("com.taoche.cardetection:id/dialog_common_btn_positive")).click();
			//%%%%%%%%%%%%%%%%
			util.sleep(1);
			driver.tap(1, 1555, 365, 1);
//			driver.findElement(By.xpath("//*[contains(@text, '国产')]")).click();
			util.sleep(1);
			driver.tap(1, 1743, 286, 1);
//			driver.findElement(By.xpath("//*[contains(@text, '纯电动')]")).click();
			util.sleep(1);
			Operation.swipeToUp(driver, 500, 1);
			driver.findElement(By.xpath("//*[contains(@text, '出厂日期')]")).click();
			driver.findElement(By.id("com.taoche.cardetection:id/tv_sure")).click();
			util.sleep(1);
			driver.findElement(By.xpath("//*[contains(@text, '过户次数')]")).click();
			util.sleep(1);
			driver.findElement(By.id("com.taoche.cardetection:id/dialog_common_btn_positive")).click();
			util.sleep(1);
			driver.findElement(By.id("com.taoche.cardetection:id/frg_registration_tv_next_step")).click();
			log.info("下一步，进入其他信息页");
			
			
//			List<WebElement> ment =driver.findElements(By.className("android.widget.RadioButton"));
//			int getList = ment.size();
//			for(int i=0;i<getList;i++ ){
//				ment.get(i).click();	
//			}

//			driver.findElement(By.className("android.widget.RadioButton")).getText();
//			driver.findElement(By.id("com.taoche.cardetection:id/widget_ccv_et_content")).sendKeys("mali");		
//			driver.tap(1, 1300, 1000, 1);
//			driver.findElement(By.xpath("//*[contains(@index, '1')]")).click();
//			driver.findElement(By.xpath("//*[contains(@text, '手动输入车辆品牌型号的非汉子部分')]")).sendKeys("THR8896");
//			driver.findElement(By.id("com.taoche.cardetection:id/widget_ccv_et_content")).sendKeys("THR8896");
			
			
			
			
			
		
			
		
			
			/*List<WebElement> lists=driver.findElementsByClassName("android.widget.TextView"); 
			
			for(WebElement element:lists)
			{
				log.info(element.getText());
			}*/
			
//			driver.findElement(By.id("com.taoche.cardetection:id/lt_main_title_right_tv")).click();
				/*WebElement cheyuan = driver.findElement(By.xpath("com.taoche.cardetection:id/navigation_car"));
				cheyuan.click();
				System.out.print("进入检测任务列表21212");
				WebElement wode = driver.findElement(By.id("com.taoche.cardetection:id/navigation_mine"));
				wode.click();
				System.out.print("进入检测任务列表3444");
			System.out.print("进入检测任务列表44222222");
			util.sleep(5);*/
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}