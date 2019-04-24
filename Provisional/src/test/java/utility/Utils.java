package utility;



import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Utils {

		public static WebDriver driver = null;
		
		static String ChromePath = "./Provisional/src/test/resources/driver/chromedriver";
		static String FirefoxPath = "./Provisional/src/test/resources/driver/geckodriver.exe";
		static String IEDriverPath = "./Provisional/src/test/resources/driver/IEDriverServer.exe";



	public static WebDriver OpenBrowser(int iTestCaseRow) throws Exception{
		

		
		String sBrowserName;
		


		String 	environmentName = ExcelUtils.getCellData(iTestCaseRow,Constant.Col_Environment);
		
		String 	InstanceName = ExcelUtils.getCellData(iTestCaseRow,Constant.Col_Instance);

		

		try{

		sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Browser);

			Utils.driver = instantiateDriver(sBrowserName, environmentName, InstanceName);
		}catch (Exception e){

			Log.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());

		}

		return driver;
	}
	
	


public static WebDriver instantiateDriver (String sBrowserName, String environmentname, String InstanceName ){
	WebDriver driver = null;
	switch(sBrowserName) { 

	case "Mozilla":
				// update the gecko driver exe as needed
				//System.setProperty("webdriver.firefox.marionette", FirefoxPath);
				System.setProperty("webdriver.gecko.driver", FirefoxPath);

				driver = new FirefoxDriver();
				driver.manage().window().maximize();

				break;
				
	case "Chrome":

				System.setProperty("webdriver.chrome.driver",ChromePath );
				
				driver = new ChromeDriver();
				driver.manage().window().maximize();


				break;
		
	case "Explorer":
				System.setProperty("webdriver.ie.driver",IEDriverPath);
		        driver = new InternetExplorerDriver();

				driver.manage().window().maximize();

				break;

			    default:

				throw new RuntimeException("Driver Not Found");
	}

	String environmentUrl = null;
			
	switch(environmentname) { 

			case "TEST":
				// BP2
				if (InstanceName.equals(Constant.BP2_Instance)) {
					environmentUrl = Constant.BP2_Test_URL;
				}
				// Provisioning
				else if (InstanceName.equals(Constant.Provisioning_Instance))
					environmentUrl = Constant.Provisioning_Test_URL;
				break;
	
			case "Pre-Prod":
		//BP2
		if (InstanceName.equals(Constant.BP2_Instance)){
			environmentUrl = Constant.BP2_PreProd_URL;	
		}
				//Provisioning
				else if (InstanceName.equals(Constant.Provisioning_Instance))
					environmentUrl = Constant.Provisioning_PreProd_URL;

				
				break;

			case "Prod":
				// BP2
				if (InstanceName.equals(Constant.BP2_Instance)) {
					environmentUrl = Constant.BP2_PROD_URL;
				}
				//Provisioning
				else if (InstanceName.equals(Constant.Provisioning_Instance))
					environmentUrl = Constant.Provisioning_PROD_URL;



		break;
		
		

	default:
		throw new RuntimeException("Env  Not Found");
	}
	

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		Log.info("Implicit wait applied on the driver for 10 seconds");

    driver.get(environmentUrl);
	System.out.println("Running Test on: " + environmentUrl);
    
    return driver;
}





	public static String getTestCaseName(String sTestCase)throws Exception{

		String value = sTestCase;

		try{

			int posi = value.indexOf("@");

			value = value.substring(7, posi);

			posi = value.lastIndexOf(".");	

			value = value.substring(posi + 1);

			return value;

				}catch (Exception e){

			Log.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());

			throw (e);

					}

			}

	 public static void mouseHoverAction(WebElement mainElement, String subElement){

		 Actions action = new Actions(driver);

         action.moveToElement(mainElement).perform();

         if(subElement.equals("Create Account Portfolio")){

        	 action.moveToElement(driver.findElement(By.xpath("//SPAN[@ng-bind-html='::item.label'][text()='Create Account Portfolio']")));

        	 Log.info("Create Account Portfolio link is accessible");
        	 
        	

         }

		if (subElement.equals("DISA Tools")) {

			action.moveToElement(driver.findElement(By.linkText("id")));

			Log.info("DISA Tools");

         }

		if (subElement.equals("Service Catalog")) {

			action.moveToElement(driver.findElement(By.linkText("id")));

			Log.info("Service Catalog");

         }

		if (subElement.equals("Reports")) {

			action.moveToElement(driver.findElement(By.linkText("id")));

			Log.info("Reports");

         }

         action.click();

         action.perform();

		Log.info("My Tools");

	 }

	public static void waitForElement(WebElement element) throws InterruptedException {


		WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.elementToBeClickable(element));

	 	}


	public static void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception {

		try {

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(scrFile, new File(Constant.Path_ScreenShot + sTestCaseName + ".jpg"));

		} catch (Exception e) {

			Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "
					+ e.getMessage());

			throw new Exception();

		}

	}



	public static void SendGmail(WebDriver driver) {
		// Sender's email ID needs to be mentioned
		String from = "mohammed.basit@gdit.com";  // source email address
		String pass = "Webdriver2019";
		// Recipient's email ID needs to be mentioned.
		String to = "mbasit@outlook.com";  // target email address replace with actual

		String host = "smtp.gmail.com";

		// Get system properties
		Properties properties = System.getProperties();
		// Setup mail server
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.user", from);
		properties.put("mail.smtp.password", pass);
		properties.put("mail.smtp.port", "dummy replace with new "); // Need SMTP server port
		properties.put("mail.smtp.auth", "true");

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("This is the Subject Line!");

			// Now set the actual message
			message.setText("This is actual message");

			// Send message
			Transport transport = session.getTransport("smtp");

			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}


}


	
