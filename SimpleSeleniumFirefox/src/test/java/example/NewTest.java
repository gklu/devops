package example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

public class NewTest {

  public WebDriver driver;
  String driverPath = "/usr/local/bin/geckodriver";

  @Test
  public void firstTest() {

	  driver.get("http://www.google.com");
	  String title = driver.getTitle();
    System.out.println(driver.getPageSource());
	  System.out.println("Page title is - " + title );

}
  @BeforeTest
  public void beforeTest() {
	  FirefoxBinary firefoxBinary = new FirefoxBinary();
	  firefoxBinary.addCommandLineOptions("--headless");
	  System.setProperty("webdriver.gecko.driver", driverPath);
	  FirefoxOptions options = new FirefoxOptions();
	  options.setBinary(firefoxBinary);
	  //options.setHeadless(true);
    driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
