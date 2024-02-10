package appium2;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.asynchttpclient.uri.Uri;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class appiumTesting {
	
	DesiredCapabilities caps = new DesiredCapabilities();
	AndroidDriver driver;
	
	@BeforeTest
	public void setup() {
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "qa");
		
		// only for mobile browsers 
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		caps.setCapability("chromedriverExecutable", System.getProperty("user.dir")+File.separator+
				"driver"+File.separator+"chromedriver.exe");
				
	}
	
	@Test
	public void myFirstTest() throws MalformedURLException {
		
		var appuimServerUrl = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
		driver = new AndroidDriver(appuimServerUrl , caps);
		driver.get("https://www.google.com/");
	}
	
	@AfterTest
	public void myAfter() {
		
	}

}
