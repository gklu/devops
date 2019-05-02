package example;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {

  public WebDriver driver;
  String driverPath = "/bin/geckodriver";

  @Test
  public void firstTest() {

		driver.get("http://demo.guru99.com/test/guru99home/");
	  String title = driver.getTitle();
	  //Assert.assertTrue(title.contains("Demo Guru99 Page"));
	  System.out.println("Page title is - " + title );


  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", driverPath);
	  FirefoxOptions options = new FirefoxOptions();
	  options.setHeadless(true);
    driver = new FirefoxDriver(options);
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
