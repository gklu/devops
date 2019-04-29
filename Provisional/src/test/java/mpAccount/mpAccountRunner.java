package mpAccount;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import driverAction.ModuleDriver;
import driverAction.SignInAction;
import pageObjects.BaseClass;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;;


public class mpAccountRunner{
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	ExtentReports report;
	ExtentTest test;

	@BeforeTest
	public void beforeClass() {
		report = new ExtentReports("./XtentReport/MP-Automation-Report.html");
		test = report.startTest("MP Test Suite");
		test.log(LogStatus.INFO, "======= MP Test Suite ========");
		report.addSystemInfo("Selenium Version", "3.5.3");
	}



  @BeforeMethod
  public void Login() throws Exception {

		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase(sTestCaseName);
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "MissionPartner");

	}

	@Test  // (priority = 1)
	public void mpAccount_creation() throws Exception

	{
		// ==== To Run All rows
		//for (int i = 1; i <= ExcelUtils.getExcelRowCount(); i++) {

		// ==== To Run Specific rows
			 for (int i = 1; i <= 1; i++) {

			try {
				iTestCaseRow = i;
				sTestCaseName = this.toString();
				sTestCaseName = ExcelUtils.getCellData(iTestCaseRow, i);
				driver = Utils.OpenBrowser(iTestCaseRow);
				new BaseClass(driver);
				SignInAction.Execute(iTestCaseRow);// Login
				ModuleDriver.Modules(iTestCaseRow, driver);// excel module
				mpAccountDriver.ModuleLinks(iTestCaseRow, driver);// excel link
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
				test.log(LogStatus.PASS, (ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Links)));

			} catch (Exception e) {
				ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
				//Utils.takeScreenshot(driver, sTestCaseName);
				test.log(LogStatus.FAIL, (ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Links)));
				Log.error(e.getMessage());

				System.out.println(e);
				test.log(LogStatus.ERROR, e.getMessage());

			}
			// comment if you want to close after every testcase
			//driver.quit();

		}
	}

	@AfterMethod
	public void afterMethod() {
		Log.endTestCase(sTestCaseName);

	}


	@AfterClass
	public void afterClass() {
		report.endTest(test);
		report.flush();
	}

	@AfterTest
	public void SendEmailReport() throws IOException {
		// Send 2 emails on Fail
		// gmailReport.main(null);

		// ImpersonateEmailReport.main(null);
	}

}
