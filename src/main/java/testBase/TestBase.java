package testBase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBase {

	public static WebDriver driver;

	/**
	 * Setting up the webDriver and activating the session. 
	 * Case when isRemote equals : True > Test will run in headless mode inside docker selenium/standalone-chrome server.
	 * False > Test will run in UI mode.
	 **/
	public static WebDriver getDriver(boolean isRemote) {
		ChromeOptions options = new ChromeOptions();
		if (isRemote) {
			options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else {
			driver = new ChromeDriver(options);
		}
		return driver;
	}

	/**
	 * Quite the active session by quiting the driver
	 **/
	public void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}