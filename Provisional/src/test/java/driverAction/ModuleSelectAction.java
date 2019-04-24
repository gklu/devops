package driverAction;

import org.openqa.selenium.WebDriver;

import utility.Constant;
import utility.ExcelUtils;
import utility.Log;


// This is called Modularization, when we club series of actions in to one Module


public class ModuleSelectAction {
	
	//static WebDriver driver

	// iTestcaseRow is the row number of our Test case name in the Test Data sheet

	// iTestcaseRow is passed as an Argument to this method, so that it can used inside this method

	
	public static void Modules(int iTestCaseRow, WebDriver driver) throws Exception{

		try{
			//====================  Create Account Portfolio ================
			if("MissionPartner".equals(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Modules))){

				ModuleOverview.createAccountPortfolio().click(); 
				Log.info("Create account portfolio is selected from the top menu");

			}
			//==================== My Tools ================
			if("My Tools".equals(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Modules))){
						
				ModuleOverview.myToolsLink().click();
				Log.info("My Tools is selected from the top menu");

			}

			

	    }catch(Exception e){

			// Here I have used this as just for the sake of an example

			// I am just catching the Exception and again throwing it back to the Main testcase, without handling it

	    	// You may like to print some information here, in case of exception

	    	throw(e);

			}

	

		

		}

	}