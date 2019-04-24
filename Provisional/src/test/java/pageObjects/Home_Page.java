package pageObjects;

import org.apache.poi.EmptyFileException;
//import org.apache.maven.plugin.logging.Log;
//import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import com.relevantcodes.extentreports.model.Log;

public class Home_Page extends BaseClass {
	
	private static WebElement element =null;

	public Home_Page(WebDriver driver) {
		super(driver);
		
	}

	public static WebElement link_MyAccount() throws Exception{
		
		try{
			
			element = driver.findElement(By.linkText(""));
			
			//Log.info("");
			
		}catch (Exception e) {
			
			//Log.error("");
			throw(e);
		}
		return element;
	}
	
public static WebElement link_LogOut() throws Exception{
		
		try{
			
			element = driver.findElement(By.id(""));
			
			//Log.info("");
			
		}catch (Exception e) {
			
			//Log.error("");
			throw(e);
		}
		return element;
	}
	
	
}
