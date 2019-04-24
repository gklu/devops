package mpAccount;

import org.openqa.selenium.WebDriver;

import utility.Constant;
import utility.ExcelUtils;

// This is called Modularization, when we club series of actions in to one Module

// For Modular Driven Framework, please see http://toolsqa.com/selenium-webdriver/modular-driven/ 

public class mpAccountDriver {
	
	public static void ModuleLinks(int iTestCaseRow, WebDriver driver) throws Exception{

		try{

			if ("MP01 Create MP Account".equals(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Links))) {

				mpAccountAction.createAccountPortfolio();

			}
			if ("MP02 Edit MP Account".equals(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Links))) {

				mpAccountAction.editMissionPartner();

			}


			

		} catch (Exception e) {
			throw (e);

			}

	}

}
