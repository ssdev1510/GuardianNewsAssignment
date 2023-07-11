package pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.TestUtils;
import utils.Keywords;
public class GoogleNewsPO extends Keywords {

	private WebDriver driver;
	private static Logger Log = LogManager.getLogger();
	
	public GoogleNewsPO(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	private By googleCookiesElement = By.id("L2AGLb");
	private By googleInputBoxElement = By.name("q");
	private By googleSearchButtonElement = By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[1]");
	private By googleNewsButtonElement = By.xpath("//div[@class='nfdoRb']/a[1]");
	private By googleResultsElements = By.xpath("//div[@role='heading']");
	
	// Page object class actions
	public void acceptGoogleCookies() {
		WebElement googleCookies = driver.findElement(googleCookiesElement);
		clickEle(googleCookies);
	}

	public void enterNewsArticleInGoogleSearchBox(String FirstArticleDetails) {
		WebElement googleInputBox = driver.findElement(googleInputBoxElement);
		enterText(googleInputBox, FirstArticleDetails);
	}

	public void enterAndSearchSimilarNewsArticleOnGoogle() {
		WebElement googleSearchButton = driver.findElement(googleSearchButtonElement);
		clickEle(googleSearchButton);

		WebElement googleNewsButton = driver.findElement(googleNewsButtonElement);
		clickEle(googleNewsButton);
	}

	public int getCountFromGoogleResult(String FirstArticleDetails) {
		int count = 0;
		List<WebElement> googleResults = driver.findElements(googleResultsElements);

		for (WebElement ele : googleResults) {
			if (TestUtils.checkStringsSimilarityScore(FirstArticleDetails, getText(ele))) {
				count++;
			} else {
				Log.debug("This News Article on google is not similar to exected news");
			}
		}
		return count;
	}

}
