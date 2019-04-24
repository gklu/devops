package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot 
{

	
	public static String takeScreenshot(WebDriver driver,String screenshotname)
	{
		
	TakesScreenshot ts=(TakesScreenshot)driver;
		
	 File src= ts.getScreenshotAs(OutputType.FILE);  
	  
		String destination =
				"C:\\Users\\BasitM\\eclipse-workspace\\millCloud20\\src\\test\\resources\\data\\ScreenShots" + System.currentTimeMillis() + ".png";
		
	 try 
	 {
		FileUtils.copyFile(src, new File(destination));
	} 
	 catch (IOException e) 
	 {
		
	}
	 
	 return destination;
	 
	}
	
	
}
