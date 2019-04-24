package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory 
{

	
	static WebDriver driver;
	
	public static WebDriver getBrowser(String browserName)
	{
		
		if(browserName.equalsIgnoreCase("firefox"))
		{
			
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{	
	        System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePath());   		
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{

	       System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfig().getIEPath());   
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		
		return driver;
	}
	
	
	public static void closeBrowser()
	{
		driver.quit();
	}
	
	
}
