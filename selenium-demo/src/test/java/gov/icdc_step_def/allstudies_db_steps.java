package gov.icdc_step_def;

import org.junit.Assert;
import org.openqa.selenium.By;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.icdc_pages.studies_pages;
import gov.utilities.Driver;


public class allstudies_db_steps {

	studies_pages study = new studies_pages();
	
	
@When("^the user clicks on the \"([^\"]*)\" page$")
public void the_user_clicks_on_the_page(String arg1) throws Throwable {
	study.studies.click();
 
}

@Then("^the user is redirected to the \"([^\"]*)\" page of the study in question$")
public void the_user_is_redirected_to_the_page_of_the_study_in_question(String arg1) throws Throwable {
   Assert.assertTrue(Driver.getInstance().getCurrentUrl().contains("studies"));
 
}


@Then("^the Statistics Bar is displayed at the top of the page$")
public void the_Statistics_Bar_is_displayed_at_the_top_of_the_page() throws Throwable {
   Assert.assertTrue(Driver.getInstance().findElement(By.cssSelector("#root > div.jss2 > div:nth-child(1) > div > div > div")).isDisplayed());
    
}

@Then("^the total number of studies associated with the study displayed in the Stats Bar should match the database record$")
public void the_total_number_of_studies_associated_with_the_study_displayed_in_the_Stats_Bar_should_match_the_database_record() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  
}

@Then("^the total number of cases associated with the study displayed in the Stats Bar should match the database record$")
public void the_total_number_of_cases_associated_with_the_study_displayed_in_the_Stats_Bar_should_match_the_database_record() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   
}

@Then("^the total number of samples associated with the study displayed in the Stats Bar should match the database record$")
public void the_total_number_of_samples_associated_with_the_study_displayed_in_the_Stats_Bar_should_match_the_database_record() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  
}

@Then("^the total number of biospecimen aliquots associated with the study displayed in the Stats Bar should match the database record$")
public void the_total_number_of_biospecimen_aliquots_associated_with_the_study_displayed_in_the_Stats_Bar_should_match_the_database_record() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  
}


}
