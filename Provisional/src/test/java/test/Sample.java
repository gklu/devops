package test;

import java.util.concurrent.TimeUnit;

//import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sample {
	public String baseUrl = "http://csman.evay.cloud:8080/client/";
	//String driverPath = "C:\\Users\\tester2\\Desktop\\MyTest\\Simple-Maven-Proj\\driver\\chromedriver.exe";
	public WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		// System.out.println("launching chrome browser");
		// System.setProperty("webdriver.chrome.driver","/bin/google-chrome");
		// driver = new ChromeDriver();
		//System.setProperty("webdriver.chrome.driver", driverPath);
		// System.setProperty("webdriver.firefox.marionette", driverPath);
		// driver = new FirefoxDriver();
		System.setProperty("webdriver.gecko.driver","/bin/firefox");
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		//driver.get(baseUrl);
	}

	@Test
	public void verifyBP2Login() {
		driver.manage().window().maximize();
		// Wait until the page is fully loaded
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Entering the URL to Login
		// driver.navigate().to(basUrl);
		// Thread.sleep(2000);
		// Click on "I Agree"
		driver.findElement(By.xpath("//*[@id=\"btn\"]")).click(); // I Agree
		// Thread.sleep(2000);
		// Click on "Click here"
		driver.findElement(By.xpath("//*[@id=\"newSessionDIV\"]/a")).click();
		// Thread.sleep(2000);
		// Click on "I Agree"
		driver.findElement(By.xpath("//*[@id=\"btn\"]")).click(); // I agree
		// Thread.sleep(2000);
		// Enter "user name"
		driver.findElement(By.xpath("//*[@id=\"input_1\"]")).sendKeys("mohammed.basit");
		// Thread.sleep(2000);
		// Enter "Password"
		driver.findElement(By.xpath("//*[@id=\"input_2\"]")).sendKeys("Test1234#");
		// Thread.sleep(2000);
		// Click on "Login" button.
		driver.findElement(By.xpath("//*[@id=\"submit_row\"]/td/input")).click();
		// Thread.sleep(5000);
		// Click on "Create Account Portfolio"
		driver.findElement(By.linkText("Create Account Portfolio")).click();
	}

	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}
}
