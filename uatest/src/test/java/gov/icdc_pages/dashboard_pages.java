package gov.icdc_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.utilities.Driver;

public class dashboard_pages {

	
	public dashboard_pages () {
		PageFactory.initElements(Driver.getInstance(),this);
	}

	@FindBy(linkText = "Dashboard")
	public WebElement dashboard;
	
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[1]/div/div/div/div[3]/h1[1]")
	public WebElement casesnumber;

}


