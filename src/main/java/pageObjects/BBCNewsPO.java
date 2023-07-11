package pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Keywords;
import utils.TestUtils;

public class BBCNewsPO extends Keywords {

	private WebDriver driver;
	private static Logger Log = LogManager.getLogger();
	
	public BBCNewsPO(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	private By bccInputBoxElement = By.id("search-input");
	private By bccNewsButtonElement = By.xpath("//button[@type='submit']");
	private By bccResultsElements = By.xpath("(//ul[@role='list'])[4]/li/div/div/div/div/a");

	// Page object class actions
	public void enterNewsArticleInBBCSearchBox(String FirstArticleDetails) {
		WebElement bbcInputBox = driver.findElement(bccInputBoxElement);
		enterText(bbcInputBox, FirstArticleDetails);
	}

	public void enterAndSearchSimilarNewsArticleBBC() {
		WebElement bbcSearchButton = driver.findElement(bccNewsButtonElement);
		clickEle(bbcSearchButton);
	}

	public int getCountFromBBCResult(String FirstArticleDetails) {
		int count = 0;
		List<WebElement> bbcResults = driver.findElements(bccResultsElements);
		for (WebElement ele : bbcResults) {
			if (TestUtils.checkStringsSimilarityScore(FirstArticleDetails, getText(ele))) {
				count++;
			} else {
				Log.debug("This News Article on BBC is not similar to exected news");
			}
		}
		return count;
	}
}
