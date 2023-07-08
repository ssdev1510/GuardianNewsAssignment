package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;

	public static WebDriver getDriver(boolean isHeadless) {
		// WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		if (isHeadless) {
			options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
		}
		driver = new ChromeDriver(options);
		return driver;
	}

	public void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}