package gov.icdc_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.utilities.Driver;

public class programs_pages {
	
	public programs_pages () {
		PageFactory.initElements(Driver.getInstance(),this);
	}

	@FindBy(linkText = "All Programs")
	public WebElement programs;

}
