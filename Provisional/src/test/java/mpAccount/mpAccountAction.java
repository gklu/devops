package mpAccount;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.BaseClass;
import utility.Log;

public class mpAccountAction extends BaseClass {

	public mpAccountAction(WebDriver driver) {
		super(driver);
		
	}
	
	
	
		
		// ***************************************************************
		// MPA01
		// This test case is to create Mission Partner Account with various attributes
		// ***************************************************************
		@SuppressWarnings("static-access")
		public static void createAccountPortfolio() throws Exception {

			System.out.println("\n=== MPA01 \n=== Create Mission Partner  === START ");
			Log.info("=== Create Mission Partner  === START ");

			//mpAccountPageObj MissionPartnerObjects = PageFactory.initElements(driver, mpAccountPageObj.class);
			
			Thread.sleep(3000);

			// Click on "Account Manager" tab
			driver.findElement(By.xpath("(//UIB-TAB-HEADING[@class='ng-scope'])[2]")).click();
			// Verify the fields are read-only and pre-populated with the logged in user's info
			driver.findElement(By.xpath("//form[@name='accountManagerForm']"));
			if (driver.getPageSource().contains("Account Manager"))
				if (driver.getPageSource().contains("Account Manager"))
					if (driver.getPageSource().contains("Fist name 'Abdus'"))
						if (driver.getPageSource().contains("Last name 'Bhuiyan'"))
							if (driver.getPageSource().contains("Email address 'abdus.bhuiyan@gdit.com'"))
								if (driver.getPageSource().contains("Business phone '0987654321'"))
			{
				System.out.println("Abdus, Bhuiyan, abdus.bhuiyan@gdit.com, 0987654321 are present (True)");
			}
			else {
				System.out.println("Abdus, Bhuiyan, abdus.bhuiyan@gdit.com, 0987654321 are NOT Present");
				
			}
			Thread.sleep(2000);
			// Verify Check box for milCloud Plus service.
			driver.findElement(By.xpath("//form[@name='accountManagerForm']//div[@class='col-md-12']"));
			if (driver.getPageSource().contains("checkbox"))
				
			{
				System.out.println("checkbox Present");
			}
			else {
				System.out.println("checkbox NOT Present");
				
			}
			Thread.sleep(2000);
			// Click on "Edit Contact Information"
			driver.findElement(By.xpath("//button[contains(text(),'Edit Contact Information')]")).click();
			// Verify "Edit profile"
			driver.findElement(By.xpath("//div[@class='modal-body']"));
			if (driver.getPageSource().contains("Fist name 'Abdus'"))
				if (driver.getPageSource().contains("Last name 'Bhuiyan'"))
					if (driver.getPageSource().contains("Email address 'abdus.bhuiyan@gdit.com'"))
						if (driver.getPageSource().contains("Business phone '0987654321'"))
							
						{
							System.out.println("Abdus, Bhuiyan, abdus.bhuiyan@gdit.com, 0987654321 are present (True)");
						}
						else {
							System.out.println("Abdus, Bhuiyan, abdus.bhuiyan@gdit.com, 0987654321 are NOT Present");
							
						}
			// Edit "Business Phone" number
			driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("1234567890");
			// Click on "Cancel" Button (for changes)
			driver.findElement(By.xpath("//a[@class='btn btn-sm']")).click();
			
			// Verify no changes has been made.
			driver.findElement(By.xpath("//div[@class='panel-body']"));
			//if (driver.getPageSource().contains("Account Manager"))
				if (driver.getPageSource().contains("Account Manager"))
					if (driver.getPageSource().contains("Fist name 'Abdus'"))
						if (driver.getPageSource().contains("Last name 'Bhuiyan'"))
							if (driver.getPageSource().contains("Email address 'abdus.bhuiyan@gdit.com'"))
								if (driver.getPageSource().contains("Business phone '0987654321'"))
			{
				System.out.println("Abdus, Bhuiyan, abdus.bhuiyan@gdit.com, 0987654321 are present");
			}
			else {
				System.out.println("Abdus, Bhuiyan, abdus.bhuiyan@gdit.com, 0987654321 are NOT Present (True)");
				
			}
				Thread.sleep(8000);
		    // Click on " Organization"
			driver.findElement(By.linkText("Organization")).click();
		    // "Organization" page verification no data.
			
			driver.findElement(By.xpath("//li[@class='uib-tab ng-scope ng-isolate-scope active']//a[@class='ng-binding']"));
			if (driver.getPageSource().contains("Organization"))
				
			driver.findElement(By.xpath("//div[@class='tab-content']"));
			if (driver.getPageSource().contains("fa fa-exclamation-circle red"))
			{
				System.out.println("Organization page has no data (True) ");
			}
			else {
				System.out.println("Organization page has data");
				
			}

			//Thread.sleep(3000);
			// Click on the DOD service/Branch drop down
			driver.findElement(By.className("select2-chosen")).click();
			//Thread.sleep(5000);
			// Select a DOD branch.
			driver.findElement(By.xpath("//div[@class='select2-additional-display-field'][contains(text(),'COAST GUARD')]")).click();
			//Thread.sleep(3000);
			// Click Sub-Service
			driver.findElement(By.id("select2-chosen-4")).click();
			//Thread.sleep(3000);
			// Select Sub-Service
			driver.findElement(By.xpath("//div[@class='select2-additional-display-field']")).click();
			//Thread.sleep(3000);
			//Thread.sleep(3000);
			// Select "Parent Command" 
			driver.findElement(By.xpath("//input[@name='parentCommand']")).sendKeys("DOD123");
			//Thread.sleep(3000);
			//Enter "Parent Command Description"
			driver.findElement(By.xpath("//input[@name='parentCommandDescription']")).sendKeys("DoD");
			//Thread.sleep(3000);
			// Enter "Organization Street Address"
			driver.findElement(By.xpath("//input[@name='organizationStreetAddress']")).sendKeys("123 Virginia Drive");
			//Thread.sleep(3000);
			// Enter "Organization City"
			driver.findElement(By.xpath("//input[@name='organizationCity']")).sendKeys("Sterling");
			//Thread.sleep(3000);
			// Enter "Organization State"
			driver.findElement(By.xpath("//input[@name='organizationState']")).sendKeys("VA");
			//Thread.sleep(3000);
			// Enter "Organization Zip / Postal Code"
			driver.findElement(By.xpath("//input[@name='organizationZipPostalCode']")).sendKeys("20164");
			//Thread.sleep(3000);
			// Enter Org Code
			driver.findElement(By.xpath("//input[@name='orgCode']")).sendKeys("AJB");
			//Thread.sleep(3000);
			// Enter Program Name
			driver.findElement(By.xpath("//input[@name='programName']")).sendKeys("AJB-COREtest5");
			//Thread.sleep(8000);
			driver.findElement(By.linkText("Organization")).click();
		    // "Organization" page verification has data.
			
			driver.findElement(By.xpath("//li[@class='uib-tab ng-scope ng-isolate-scope active']//a[@class='ng-binding']"));
			if (driver.getPageSource().contains("Organization"))
				
			driver.findElement(By.xpath("//div[@class='tab-content']"));
			if (driver.getPageSource().contains("fa fa-check green"))
			{
				System.out.println("Organization page has data (True) ");
			}
			else {
				System.out.println("Organization page has no data");
				
			}
			Thread.sleep(8000);
			// Click on Additional POCs
			driver.findElement(By.linkText("Additional POCs")).click();
			// Verify "Point of Contact" page fields are Empty.
			driver.findElement(By.xpath("//div[@class='tab-content']"));
			if (driver.getPageSource().contains("Points of Contact"))
				if (driver.getPageSource().contains("Project Manager"))
					if (driver.getPageSource().contains("Funding Manager"))
						if (driver.getPageSource().contains("Technical POC"))
							if (driver.getPageSource().contains("* Required"))
			{
				System.out.println("POC fiels are Empty (true)");
			}
			else {
				System.out.println("POC field has data");
				
			}
			// Verify "Additional POCs" tab has "RED exclamation" (Mean no data on POC page.
			driver.findElement(By.xpath("//li[@class='uib-tab ng-scope ng-isolate-scope active']//a[@class='ng-binding']"));
			if (driver.getPageSource().contains("fa fa-exclamation-circle red"))
	{
		System.out.println("POC fiels are Empty (True)");
	}
	else {
		System.out.println("POC field has data");
		
	}
			//Populate the required fields:
			
			
			//Thread.sleep(3000);
		    // Click on the Project Manager
			driver.findElement(By.id("select2-chosen-6")).click();
			//Thread.sleep(3000);
			// Select Project Manager
			driver.findElement(By.xpath("//div[contains(@class,'select2-additional-display-field')][contains(text(),'Abdus Bhuiyan')]")).click();
			//Thread.sleep(3000);
			// Click on the Funding Manager
			driver.findElement(By.id("select2-chosen-8")).click();
			//Thread.sleep(3000);
			// Select Project Manager
			driver.findElement(By.xpath("//div[contains(@class,'select2-additional-display-field')][contains(text(),'Abdus Bhuiyan')]")).click();
			//Thread.sleep(3000);
			// Click on the Technical POC
			driver.findElement(By.id("select2-chosen-10")).click();
			//Thread.sleep(3000);
			// Select Technical POC
			driver.findElement(By.xpath("//div[contains(@class,'select2-additional-display-field')][contains(text(),'Abdus Bhuiyan')]")).click();
			//Thread.sleep(3000);
			// Click on "Save / Submit" tab
			driver.findElement(By.xpath("//uib-tab-heading[contains(text(),'Save / Submit')]")).click();
			//Thread.sleep(3000);
			
			// Verify all pre-populated data and user-entered data is accurately reflected to user input
			driver.findElement(By.xpath("//div[@class='panel-body']"));
			if (driver.getPageSource().contains("Account Manager"))
				if (driver.getPageSource().contains("Organization"))
					if (driver.getPageSource().contains("Points of Contact"))
							
			{
				System.out.println("Label names match those of the fields from when the data was populated (True)");
			}
			else {
				System.out.println("label names DOES NOT match those of the fields from when the data was populated");
				
			}
			
			// Click on the Submit button
			//driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
			// Verify "Request" was created.
			driver.findElement(By.xpath("//div[@class='panel-body text-center sfcgs w100']"));
			if (driver.getPageSource().contains("Thank you for your submission. We look forward to working with you."))
				if (driver.getPageSource().contains("Next Steps"))
				
			{
				System.out.println("Request REQ000XXXX was created for you (True)");
			}
			else {
				System.out.println("Request REQ00XXXX was NOT created for you.");
				
			}
			
			// Verify a button "My Requests" is displayed on the submission page.
			driver.findElement(By.xpath("//div[@class='panel-body text-center sfcgs w100']"));
		    if (driver.getPageSource().contains("My Requests"))
				
			{
				System.out.println("My Requests button displayed (True)");
			}
			else {
				System.out.println("My Requests button DID NOT displayed");
			}
				
			// Click on "My Request" button
		    driver.findElement(By.xpath("//span[contains(text(),'My Requests')]")).click();
			driver.findElement(By.xpath("//div[contains(@class,'col-md-12')]"));
		    if (driver.getPageSource().contains("My Requests"))
					
				{
					System.out.println("My Request page displays (True)");
				}
				else {
					System.out.println("My Request' page DID Not displays");
					
				}
		   // System.out.println(" Create MP Account Test Passed");
		
		
		
	
}
		
		
		@SuppressWarnings("static-access")
		public static void editMissionPartner() throws Exception {

			System.out.println("\n=== MPA01 \n=== Create Mission Partner  === START ");
			Log.info("=== Create Mission Partner  === START ");

			mpAccountPageObj MissionPartnerObjects = PageFactory.initElements(driver, mpAccountPageObj.class);
			
			MissionPartnerObjects.bp2Login();
			
		
		
		
	
}	
	
}
