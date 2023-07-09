package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import testBase.TestBase;

public class Hooks extends TestBase {

	/**
	 * Before annotation > Setup test method will run before start of every scenario.
	 * Here getting isRemote value from system environment.
	 * You can setup the environment variable using "-DisRemote=true"
	 */
	@Before()
	public void setup() {
		boolean isRemote = false;
		try {
			if (System.getProperty("isRemote").equalsIgnoreCase("true")) {
				isRemote = true;
			}
		} catch (Exception e) {
			isRemote = false;
		}
		getDriver(isRemote);
	}

	/**
	 * After annotation > teardown test will run after end of every scenario.
	 */
	@After()
	public void teardown() {
		quitDriver();
	}

}