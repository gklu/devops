package gov.utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
public class Driver {
public  static WebDriver driver;

	public static WebDriver getInstance () {
		if (getDriver() == null ||((RemoteWebDriver) getDriver()).getSessionId() == null ){


			switch (Config_Reader.getProperty("browser")){

			case "firefox":

			System.setProperty("webdriver.gecko.driver", Config_Reader.getProperty("gecko.driver.path"));

			setDriver(new FirefoxDriver());

			break;

			case "chrome":
				ChromeOptions options = new ChromeOptions();
		        options.addArguments( "--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");

		      
				System.setProperty("webdriver.chrome.driver", Config_Reader.getProperty("chrome.driver.path"));
				  setDriver(new ChromeDriver(options));
			//setDriver(new ChromeDriver());

			break;
			
				
			case "ie":

			System.setProperty("webdriver.ie.driver", Config_Reader.getProperty("ie.driver.path"));

			setDriver(new InternetExplorerDriver());

			break;

			case "safari":

			setDriver(new SafariDriver());

			break;

			default:

			System.setProperty("webdriver.chrome.driver", Config_Reader.getProperty("chrome.driver.path"));


			setDriver(new ChromeDriver());

			}

			}

			return getDriver();

			}


	public static void closeDriver() {

		if (getDriver() != null) {

		getDriver().quit();

		setDriver(null);

		}


		}


		public static WebDriver getDriver() {
			return driver;
		}


		public static void setDriver(WebDriver driver) {
			Driver.driver = driver;
		}

}
