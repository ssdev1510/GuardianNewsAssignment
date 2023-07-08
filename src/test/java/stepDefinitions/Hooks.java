package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import testBase.TestBase;

public class Hooks extends TestBase {

	@Before()
	public void setup() {
		boolean isHeadless = false;
		try {
			if (System.getProperty("isHeadless").equalsIgnoreCase("true")) {
				isHeadless = true;
			}
		} catch (Exception e) {
			isHeadless = false;
		}
		getDriver(isHeadless);
	}

	@After()
	public void teardown() {
		quitDriver();
	}

}