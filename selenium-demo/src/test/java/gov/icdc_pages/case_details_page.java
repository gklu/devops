package gov.icdc_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.utilities.Driver;

public class case_details_page {
	

	public case_details_page  () {
		PageFactory.initElements(Driver.getInstance(),this);
	}

	@FindBy(linkText = "All Cases")
	public WebElement all_cases ;


}
