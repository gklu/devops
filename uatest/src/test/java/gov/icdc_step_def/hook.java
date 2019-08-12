package gov.icdc_step_def;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import gov.utilities.Driver;

public class hook {

	@Before
	public void setUp() {

		Driver.getInstance().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Driver.getInstance().manage().window().maximize();

	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");

		}

		Driver.closeDriver();

	}
}
