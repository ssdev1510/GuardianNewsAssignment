package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import testBase.TestBase;

public class Hooks extends TestBase {
	private static Logger Log = LogManager.getLogger();
	
	/**
	 * Before annotation > Method will run before start of every scenario.
	 * Here setup method is getting isRemote variable value from system environment.
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
			Log.debug("Did not find isRemote in system enviornment variable - hence running test scripts in UI mode");
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