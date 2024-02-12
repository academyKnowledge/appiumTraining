package appium2;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class Actions extends Parameters{

	
	public void addTwoNumbers(String num1 , String num2) {
		List<WebElement> Keys =  driver.findElements(By.className("android.widget.ImageButton"));
		
		for(int i =0 ; i<Keys.size(); i++) {
			String resourceId =  Keys.get(i).getAttribute("resource-id");
			
			if(resourceId != null &&  resourceId.contains(num1)) {
				Keys.get(i).click();
				driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
				break;
			}
			
			else if(resourceId != null && resourceId.contains(num2)) {
				Keys.get(i).click();
				driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
				break;
			}
			 
			else if(!resourceId.contains("digit")) {
				System.out.println("You send invalid data");
				break;
			}
		}
		
//		driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
//		
//		for(int i =0 ; i<Keys.size(); i++) {
//			String resourceId =  Keys.get(i).getAttribute("resource-id");
//			if(resourceId != null && resourceId.contains(num2)) {
//				Keys.get(i).click();
//				break;
//			}
//			else if(!resourceId.contains("digit")) {
//				System.out.println("You send invalid data");
//			}
//		}
//		
//		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
		
	}
	
	public void takeScreenshot() {
		
		Date currentDate = new Date();
		String actualDate = currentDate.toString().replace(":", "_");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		
		
		File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationpath = System.getProperty("user.dir") + File.separator + "screenshots" + 
		File.separator +  actualDate + ".png";
		
        
        File finalDestination = new File(destinationpath);
        
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
