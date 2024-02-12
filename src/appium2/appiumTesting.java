package appium2;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class appiumTesting extends Parameters{
	
	Actions action = new Actions();
	
	@BeforeTest
	public void setup() {
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "myphone");
		
		// only for mobile browsers 
//		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
//		caps.setCapability("chromedriverExecutable", System.getProperty("user.dir")+File.separator+
//				"driver"+File.separator+"chromedriver.exe");
				
		// only for mobile application 
		
		caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+File.separator+
				"app"+File.separator+"calculator.apk");
		
	}
	
//	@Test
//	public void myFirstTest() throws MalformedURLException {
//		
//		var appuimServerUrl = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
//		driver = new AndroidDriver(appuimServerUrl , caps);
//		
//		driver.get("https://www.google.com/");
//		driver.findElement(By.id("XSqSsc")).sendKeys("facebook"+Keys.ENTER);
//	}
	
	
	@Test
	public void addNumbers() throws MalformedURLException {
		var appuimServerUrl = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
		driver = new AndroidDriver(appuimServerUrl , caps);
//		driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
//		driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
//		driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
//		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
		action.addTwoNumbers("3", "4");
		action.takeScreenshot();
		action.addTwoNumbers("7", "8");
		action.takeScreenshot();
		
	}
	
	@AfterTest
	public void myAfter() {
		
	}

}
