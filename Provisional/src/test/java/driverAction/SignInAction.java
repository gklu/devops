package driverAction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import pageObjects.Home_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class SignInAction {

	// iTestcaseRow is the row number of our Testcase name in the Test Data sheet

	// iTestcaseRow is passed as an Argument to this method, so that it can used
	// inside this method

	public static void Execute(int iTestCaseRow) throws Exception {

		Log.info("Click action is perfromed -- not used,can be removed");
		
		Login.LogInPage.first_agree();
		
		Login.LogInPage.accept_session();
		
		Login.LogInPage.first_agree();

		String sUserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_UserName);

		// Here we are sending the UserName string to the UserName Textbox on the LogIN
		// Page

		// This is call Page Object Model (POM)
		
	

	
		Login.LogInPage.txtbx_UserName().sendKeys(sUserName);

		// Printing the logs for what we have just performed

		Log.info(sUserName + " is entered in UserName text box");

		String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Password);

		Login.LogInPage.txtbx_Password().sendKeys(sPassword);

		Log.info(sPassword + " is entered in Password text box");

		Login.LogInPage.btn_LogIn().click();

		Log.info("Click action is performed on Submit button");

		// Now it will wait 5 secs separately before jumping out to next step

		//Utils.waitForElement(Home_Page.link_LogOut());

		// This is another type of logging, with the help of TestNg Reporter log

		// This has to be very carefully used, you should only print the very important
		// message in to this

		// This will populate the logs in the TestNG HTML reports

		// I have used this Reporter log just once in this whole module

		Reporter.log("SignIn Action is successfully perfomred");

	}

}