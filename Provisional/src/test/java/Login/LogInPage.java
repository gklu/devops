package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BaseClass;
import utility.Log;

public class LogInPage extends BaseClass {

	private static WebElement element = null;

	public LogInPage(WebDriver driver) {

		super(driver);

	}
	
@FindBy(xpath = "//*[@id=\\\"btn1\\\"]\"")  // I Agree
	WebElement Firstagree;

public void clickOnFirstAgree() {
		Firstagree.click();
	}

@FindBy(xpath = "//*[@id=\\\"newSessionDIV\\\"]/a")
WebElement clickHere;


@FindBy(xpath = "//*[@id=\\\"btn\\\"]\"")  // I Agree on second time
WebElement SecondAgree;

public void clickOnSecondAgree() {
	SecondAgree.click();
}


public static WebElement first_agree() throws Exception {
	
	

	try {

		Thread.sleep(2000);
		
		element = driver.findElement(By.xpath("//BUTTON[@id='btn']"));

		// element = driver.findElement(By.id("userNameField")); // Old Login Option
		element.click();

		Log.info("First I Agree Button was clicked successfully");

	} catch (Exception e) {

		Log.error("First I Agree Button wasn't clicked successfully");

		throw (e);

	}

	return element;

}




public static WebElement accept_session() throws Exception {
	

	try {

		Thread.sleep(2000);
		element = driver.findElement(By.xpath("//A[@href='/'][text()='click here.']"));
		
		element.click();

		// element = driver.findElement(By.id("userNameField")); // Old Login Option

		Log.info("click here link was clicked successfully");

	} catch (Exception e) {

		Log.error("click here wasn't clicked ");

		throw (e);

	}

	return element;

}



	
//txtbx_UserName for Excel use
	public static WebElement txtbx_UserName() throws Exception {
		
		

		try {

			element = driver.findElement(By.xpath("//*[@id=\"input_1\"]"));

			// element = driver.findElement(By.id("userNameField")); // Old Login Option

			Log.info("Username text box is found on the Login Pageeeeeeeee");

		} catch (Exception e) {

			Log.error("UserName text box is not found on the Login Pageeeeeeeee");

			throw (e);

		}

		return element;

	}

	public static WebElement txtbx_Password() throws Exception {

		try {

			element = driver.findElement(By.xpath("//*[@id=\"input_2\"]"));

			

			Log.info("Password text box is found on the Login page");

		} catch (Exception e) {

			Log.error("Password text box is not found on the Login Page");

			throw (e);

		}

		return element;

	}

	public static WebElement btn_LogIn() throws Exception {

		try {

			element = driver.findElement(By.xpath("//*[@id=\"submit_row\"]/td/input"));

			// element = driver.findElement(By.id("submit"));

			Log.info("Submit button is found on the Login page");

		} catch (Exception e) {

			Log.error("Submit button is not found on the Login Page");

			throw (e);

		}

		return element;

	}

	// maunal entry
	public static WebElement typeUserName() throws Exception {

		try {

			element = driver.findElement(By.id("username"));

			Log.info("Submit button is found on the Login page");

		} catch (Exception e) {

			Log.error("Submit button is not found on the Login Page");

			throw (e);

		}

		return element;

	}

}