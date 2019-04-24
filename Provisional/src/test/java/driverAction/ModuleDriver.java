package driverAction;



import org.openqa.selenium.WebDriver;

import utility.Constant;
import utility.ExcelUtils;
import utility.Log;


// This is called Modularization, when we club series of actions in to one Module



public class ModuleDriver {
	
	//static WebDriver driver

	// iTestcaseRow is the row number of our Testcase name in the Test Data sheet

	// iTestcaseRow is passed as an Argument to this method, so that it can used inside this method

	// For use of Functions &amp; Parameters, please see http://toolsqa.com/selenium-webdriver/function-parameters/

	public static void Modules(int iTestCaseRow, WebDriver driver) throws Exception{


		try{
			//==================== Create Account Portfolio ================
			if ("MissionPartner".equals(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Modules))) {

				ModuleOverview.createAccountPortfolio().click(); 
				
				Log.info("Create Account Prortfoliolink is selected from the Main Navigaton");

			}
		
			
			

			//====================  Impersonate User ================
			if("Impersonate".equals(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Modules))){

				ModuleOverview.impersonateUser().click();

				Log.info("User successfully impersonated");

			}
			
			//====================  My Tools ================
			if ("My Tools".equals(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Modules))) {

				ModuleOverview.myToolsLink().click();

				Log.info("Mission Partner navaigation link was selected ");

			}
			
			
			//====================  My Requests ================
			if ("My Requests".equals(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Modules))) {

				ModuleOverview.myRequestsLink().click();

				Log.info("Mission Partner navaigation link was selected ");

			}
			
			//====================  My Accounts ================
			if ("Impersonate CAR".equals(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Modules))) {

				ModuleOverview.myRequestsLink().click();

				Log.info("Mission Partner navaigation link was selected ");

			}
			
			

		// Every exception thrown from any class or method, will be catch here and will be taken care off

		

	    }catch(Exception e){

			// Here I have used this as  an example

			//  catching the Exception and again throwing it back to the Main test case, without handling it

	    	//  print some information here, in case of exception

	    	throw(e);

			}

	

		

		}

	}