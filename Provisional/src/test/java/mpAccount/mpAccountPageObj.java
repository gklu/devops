package mpAccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class mpAccountPageObj {
	
		
		 public static final String mpAccountEmail = null;
		//static BRICS_TestData  = new dataProvider.BRICS_TestData();

		static WebDriver driver;
		//// ----------- navigation -----------
		
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


		@FindBy(xpath = "//*[@id=\\\"input_1\\\"]")
		WebElement enterUserName;
		
		@FindBy(xpath = "//*[@id=\\\"input_2\\\"]")
		WebElement enterPassword;
		
		
		@FindBy(xpath = "//*[@id=\\\"submit_row\\\"]/td/input")
		WebElement loginButton;
		
		
		@FindBy(xpath = "//input[@name='orgCode']")
		WebElement OrgCode; // thiis 
		
		public void enterOrgCode() throws InterruptedException{
			String orgcode = "test" ;
			OrgCode.sendKeys(orgcode);
		}

		public void bp2Login() throws InterruptedException {
			Thread.sleep(2000);
			enterPassword.sendKeys("abdus.bhuiyan");
			Thread.sleep(2000);
			enterUserName.sendKeys("WQaz123456789!$");
			loginButton.click();

		}

		
}	
		
