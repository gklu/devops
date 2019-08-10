package gov.icdc_step_def;

import org.junit.Assert;
import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.icdc_pages.case_details_page;
import gov.icdc_pages.dashboard_pages;
import gov.icdc_pages.programs_pages;
import gov.icdc_pages.studies_pages;
import gov.utilities.Config_Reader;
import gov.utilities.Driver;


public class footer_steps {
	
	dashboard_pages dash = new dashboard_pages();
	case_details_page cases = new case_details_page();
	programs_pages program = new programs_pages();
	studies_pages study  = new studies_pages();
	

	@Given("^user in the homepage$")
	public void user_in_the_homepage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Driver.getInstance().get(Config_Reader.getProperty("url"));
	}


	
//	@When("^user lands to the homepage$")
//	public void user_lands_to_the_homepage() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//		Driver.getInstance().get(Config_Reader.getProperty("url"));
//	}

		
	@When("^user lands to the Dashboaord$")
	public void user_lands_to_the_Dashboaord() throws Throwable {
		dash.dashboard.click();
	  
	}

	@When("^user lands to the All Programs$")
	public void user_lands_to_the_All_Programs() throws Throwable {
	  program.programs.click();

	}

	@When("^user lands to the All Studies$")
	public void user_lands_to_the_All_Studies() throws Throwable {
	   study.studies.click();
	  
	}

	@When("^user lands to  the About page$")
	public void user_lands_to_the_About_page() throws Throwable {
	    Driver.getInstance().findElement(By.linkText("About")).click();
	  
	}
	
	@Then("^the footer should be displayed$")
	public void the_footer_should_be_displayed() throws Throwable {
	  Assert.assertTrue("Footer is not displayed",Driver.getInstance().findElement(By.xpath("//*[@id=\"root\"]/footer")).isDisplayed());
	  
	}
}
