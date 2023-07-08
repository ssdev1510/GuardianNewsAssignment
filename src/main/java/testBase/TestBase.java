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
	 * Setting up the driver and activating the session. Case when isHeadless equals
	 * True > Test will run in headless mode.
	 **/
	public static WebDriver getDriver(boolean isHeadless ) {
		ChromeOptions options = new ChromeOptions();
	//	boolean IsRemote = false;
		if (isHeadless) {
			options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
		//	driver = new ChromeDriver(options);
	//	} else if (IsRemote) {
			//options.setCapability("browserVersion", "67");
		//	options.setCapability("platformName", "Windows XP");
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