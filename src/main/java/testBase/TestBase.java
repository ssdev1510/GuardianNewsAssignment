package testBase;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBase {

	public static WebDriver driver;
	private static Logger Log = LogManager.getLogger();

	/**
	 * Setting up the webDriver and activating the session. Case when 
	 * isRemote equals : True > Test will run in headless mode inside docker selenium/standalone-chrome server. 
	 * isRemote equals : False > Test will run in UI mode.
	 **/
	public static WebDriver getDriver(boolean isRemote) {
		ChromeOptions options = new ChromeOptions();
		if (isRemote) {
			try {
				options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
			} catch (MalformedURLException e) {
				Log.debug("Problem with setting up RemoteWebDriver" + e);
			}
		} else {
			driver = new ChromeDriver(options);
		}
		return driver;
	}

	/**
	 * Quit the active driver session.
	 **/
	public void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}