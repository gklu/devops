package Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Global {

	// WebDriver driver;

	/*
	 * public Global (WebDriver driver) { this.driver=driver; }
	 */

	// Create Account Portfolio
	@FindBy(linkText = "Home")

	WebElement home_link;

	public void home_link() {
		home_link.click();
	}

	// My Tools link
	@FindBy(linkText = "My Tools")

	WebElement MyTools_link;

	public void MyTools_link() {
		MyTools_link.click();
	}

	// Reports link
	@FindBy(linkText = "Reports")

	WebElement Reports_link;

	public void Reports_link() {

		Reports_link.click();
	}

	// Reports link
	@FindBy(linkText = "DISA Tools")

	WebElement DISATools_link;

	public void DISATools_link() {

		DISATools_link.click();
	}

	// Impersonate MP User
	@FindBy(linkText = "MP")
	WebElement MP_User;

	public void ImpersonateMPUser() {
		MP_User.click();
	}
	
	// Impersonate CAR User
		@FindBy(linkText = "CAR")
		WebElement CAR_User;

		public void ImpersonateCARUser() {
			CAR_User.click();
		}
		
		// Impersonate FMLO User
				@FindBy(linkText = "FMLO")
				WebElement FMLO_User;

				public void ImpersonateFMLOUser() {
					FMLO_User.click();
				}
				
				// Impersonate OCF User
				@FindBy(linkText = "OCF")
				WebElement OCF_User;

				public void ImpersonateOCFUser() {
					OCF_User.click();
				}	
				
				// Impersonate OCL User
				@FindBy(linkText = "OCL")
				WebElement OCL_User;

				public void ImpersonateOCLUser() {
					OCF_User.click();
				}			

				
				// Impersonate OPS User
				@FindBy(linkText = "OPS")
				WebElement OPS_User;

				public void ImpersonateOPSUser() {
					OPS_User.click();
				}			


}