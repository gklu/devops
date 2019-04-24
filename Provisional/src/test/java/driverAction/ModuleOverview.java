package driverAction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BaseClass;
import utility.Log;

public class ModuleOverview extends BaseClass{

    private static WebElement element = null;

public ModuleOverview(WebDriver driver){

    	super(driver);

}    

//====================  Create Account Portfolio ================

public static WebElement createAccountPortfolio() throws Exception{

    try{ 

    	//WebElement scroll = driver.findElement(By.xpath("//SPAN[@ng-bind-html='::item.label'][text()='Create Account Portfolio']"));
    	
    	 element = driver.findElement(By.xpath("//SPAN[@ng-bind-html='::item.label'][text()='Create Account Portfolio']"));
    	
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(250,0)", "");
    	//scroll.click();

         Log.info("Create Account Portfolio link is found on the home Page");

    }catch (Exception e){

    	Log.error("Create Account Portfolio link is not found on the home Page");

   		throw(e);

   		}

   	return element;

}

//====================  My Tools ================

public static WebElement myToolsLink() throws Exception{

  try{ 

  	 element = driver.findElement(By.xpath("//SPAN[@ng-bind-html='::item.label'][text()='My Tools']"));

  	Log.info("My Tools link is found on the home Page");

  }catch (Exception e){

	  Log.error("My Tools link is not found on the home Page");

 		throw(e);

 		}

 	return element;

}


public static WebElement myAccountsLink() throws Exception{

	  try{ 

	  	 element = driver.findElement(By.xpath("//SPAN[@ng-bind-html='::item.label'][text()='My Accounts']"));

	  	Log.info("My Tools link is found on the home Page");

	  }catch (Exception e){

		  Log.error("My Tools link is not found on the home Page");

	 		throw(e);

	 		}

	 	return element;

	}

public static WebElement myRequestsLink() throws Exception{

	  try{ 

	  	 element = driver.findElement(By.xpath("//SPAN[@ng-bind-html='::item.label'][text()='My Requests']"));

	  	Log.info("My Tools link is found on the home Page");

	  }catch (Exception e){

		  Log.error("My Tools link is not found on the home Page");

	 		throw(e);

	 		}

	 	return element;

	}

public static WebElement reportsLink() throws Exception{

	  try{ 

	  	 element = driver.findElement(By.xpath("//SPAN[@ng-bind-html='::item.label'][text()='Reports']"));

	  	Log.info("Reports link found in the home page");

	  }catch (Exception e){

		  Log.error("Reports link not found in the home page");

	 		throw(e);

	 		}

	 	return element;

	}

public static WebElement impersonateUser() throws Exception{

    try{ 

    	 element = driver.findElement(By.linkText("tbd")); // add code how to impersonate user 

    	 Log.info("Successfully impersonate the user");

    }catch (Exception e){

    	Log.error("Unable to impersonate the user");

   		throw(e);

   		}

   	return element;

}

public static WebElement cloudKey() throws Exception{

    try{ 

    	 element = driver.findElement(By.xpath("//SPAN[@ng-bind-html='::item.label'][text()='CloudKey']"));  

    	 Log.info("Cloudkey link is accessible from home page");

    }catch (Exception e){

    	Log.error("Cloudkey link is not accessible from home page");

   		throw(e);

   		}

   	return element;

}

	
	
	
	
	@FindBy(linkText="//SPAN[@ng-bind-html='::item.label'][text()='My Requests']") 
	WebElement myRequestslink;
	
	
	public void clickMyRequestslink()
	{
		myRequestslink.click();
	}
	
	
	

	
	}
