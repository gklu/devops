package gov.nih.k9dc;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;




public class NewTest {
	
	private WebDriver driver;

  @Test
  public void f() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      driver.get("http://www.google.com");

      String search_text = "Google Search";
      WebElement search_button = driver.findElement(By.name("btnK"));

      String text = search_button.getAttribute("value");

      Assert.assertEquals(text, search_text, "Text not found!");
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
	  driver = new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
