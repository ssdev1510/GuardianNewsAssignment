package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Keywords;

public class GuardianNewsPO extends Keywords {

	private WebDriver driver;

	public GuardianNewsPO(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	private By firstNewsDetailsElement = By.xpath("(//*[@class='fc-item__title'])[1]/a/span/span");
	private By secondNewsDetailsElement = By.xpath("(//*[@class='fc-item__title'])[2]/a/span/span");

	// Page object class actions
	public String reteriveFirstNewsDetails() {
		WebElement firstNewsDetails = driver.findElement(firstNewsDetailsElement);
		return getText(firstNewsDetails);
	}

	public String reteriveSecondNewsDetails() {
		WebElement secondNewsDetails = driver.findElement(secondNewsDetailsElement);
		return getText(secondNewsDetails);
	}
}
