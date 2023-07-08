package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

	public static WebDriver driver;

	/**
	 * Setting up the driver and activating the session. Case when isHeadless equals
	 * True > Test will run in headless mode.
	 **/
	public static WebDriver getDriver(boolean isHeadless) {
		ChromeOptions options = new ChromeOptions();

		if (isHeadless) {
			options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
		}
		driver = new ChromeDriver(options);
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