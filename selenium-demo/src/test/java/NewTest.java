import static org.junit.Assert.*;

import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NewTest {

	@Test
	public void test() {
		String chromeDriverPath = "/usr/local/bin/chromedriver" ;  
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);  
		ChromeOptions options = new ChromeOptions();  
		options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");  
		WebDriver browser = new ChromeDriver(options);
		browser.get("https://www.saucelabs.com");
        WebElement href = browser.findElement(By.xpath("//a[@href='/beta/login']"));
        assertTrue((href.isDisplayed()));  
	}

}
