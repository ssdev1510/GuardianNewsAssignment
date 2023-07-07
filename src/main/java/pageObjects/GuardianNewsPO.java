package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.TestUtils;

public class GuardianNewsPO {

	private WebDriver driver;
	// private static Logger Log = LogManager.getLogger();

	public GuardianNewsPO(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	private By firstNewsDetailsElement = By.xpath("(//*[@class='fc-item__title'])[1]/a/span/span");

	// Page object class actions
	public String reteriveDetails() {
		WebElement firstNewsDetails = driver.findElement(firstNewsDetailsElement);
		return firstNewsDetails.getText();
	}

	public boolean isNewsArticleValidOrInvalid(int googleCount, int BBCCount, int expectedCount) {
		return TestUtils.checkOtherResoucesCountGreaterOrEqualTwo(googleCount, BBCCount, expectedCount);
	}

}
