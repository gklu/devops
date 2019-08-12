package gov.icdc_step_def;


import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.icdc_pages.dashboard_pages;
import gov.utilities.Config_Reader;
import gov.utilities.Driver;

public class dasnboard_stepdef {
	
	dashboard_pages dash = new dashboard_pages();
	
	@Given("^user in homepage$")
	public void user_in_homepage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Driver.getInstance().get(Config_Reader.getProperty("url"));
	}

	@When("^user clicks on the Dashboard menu option$")
	public void user_clicks_on_the_Dashboard_menu_option() throws Throwable {
	    dash.dashboard.click();
	  
	}

	@Then("^Dashboard page displays the total number of cases in the ICDC system$")
	public void dashboard_page_displays_the_total_number_of_cases_in_the_ICDC_system() throws Throwable {
	  String  casesnum =  dash.casesnumber.getText();
	  System.out.println(casesnum);
	  Assert.assertTrue(dash.casesnumber.isDisplayed());
	}



}
