package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.TestUtils;

public class GuardianNewsPO {

	private WebDriver driver;

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

	/**
	 * Check here if Guardian news article matching with other sources news articles
	 * 
	 * @return : True incase article match otherwise false incase of false news
	 **/
	public boolean isNewsArticleValidOrInvalid(int googleCount, int BBCCount, int expectedCount) {
		return TestUtils.checkOtherResoucesCountGreaterOrEqualTwo(googleCount, BBCCount, expectedCount);
	}

}
