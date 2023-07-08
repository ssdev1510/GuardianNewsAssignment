package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import testBase.TestBase;

public class Hooks extends TestBase {

	/**
	 * Before test will run before every scenario.
	 * Here getting isHeadless value from system environment.
	 * You can setup the environment variable using "-DisHeadless=true"
	 */
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

	/**
	 * After test will run after every scenario.
	 */
	@After()
	public void teardown() {
		quitDriver();
	}

}