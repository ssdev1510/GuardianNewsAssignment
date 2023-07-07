package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.TestUtils;

public class GuardianNewsPO {

	private WebDriver driver;
	//private static Logger Log = LogManager.getLogger();
	
	public GuardianNewsPO(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	private By firstNewsDetailsElement = By.xpath("(//*[@class='fc-item__title'])[1]/a/span/span");
	/*
	 * private By googleCookiesElement = By.id("L2AGLb"); private By
	 * googleInputBoxElement = By.name("q"); private By googleSearchButtonElement =
	 * By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[1]"); private By
	 * googleNewsButtonElement = By.xpath("//div[@class='nfdoRb']/a[1]"); private By
	 * googleResultsElements =
	 * By.xpath("//div[@class='MjjYud']/div/div/div/div/a/div/div[2]/div[2]");
	 * private By bccInputBoxElement = By.id("search-input"); private By
	 * bccNewsButtonElement = By.xpath("//button[@type='submit']"); private By
	 * bccResultsElements =
	 * By.xpath("(//ul[@role='list'])[4]/li/div/div/div/div/a");
	 */
	
	
	// Page object class actions
	public String reteriveDetails() {
		WebElement firstNewsDetails = driver.findElement(firstNewsDetailsElement);
		return firstNewsDetails.getText();	
	}

	public boolean isNewsArticleValidOrInvalid(int googleCount , int BBCCount , int expectedCount) {
		return TestUtils.checkOtherResoucesCountGreaterOrEqualTwo(googleCount, BBCCount, expectedCount);
	}
	
	
	/*
	 * public void searchSimilarArticleOnGoogle(String FirstArticleDetails) {
	 * WebElement googleCookies = driver.findElement(googleCookiesElement);
	 * googleCookies.click();
	 * 
	 * WebElement googleInputBox = driver.findElement(googleInputBoxElement);
	 * googleInputBox.sendKeys(FirstArticleDetails);
	 * 
	 * WebElement googleSearchButton =
	 * driver.findElement(googleSearchButtonElement); googleSearchButton.click();
	 * 
	 * WebElement googleNewsButton = driver.findElement(googleNewsButtonElement);
	 * googleNewsButton.click();
	 * 
	 * }
	 * 
	 * public int getResultsFromGoogle(String FirstArticleDetails) { int count = 0;
	 * List<WebElement> googleResults = driver.findElements(googleResultsElements);
	 * System.out.println(FirstArticleDetails + "xxxxxxxxxx"); for (WebElement ele :
	 * googleResults) { System.out.println(ele.getText() + "#########"); if
	 * (TestUtils.checkStringsSimilarityScore(FirstArticleDetails, ele.getText())) {
	 * count++; if (count > 2) { break; } } else {
	 * System.out.println("News not matched"); } }
	 * System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSs" + count); return count;
	 * }
	 * 
	 * public void searchSimilarArticleOnBBC(String FirstArticleDetails) {
	 * WebElement bbcInputBox = driver.findElement(bccInputBoxElement);
	 * bbcInputBox.sendKeys(FirstArticleDetails);
	 * 
	 * WebElement bbcSearchButton = driver.findElement(bccNewsButtonElement);
	 * bbcSearchButton.click(); }
	 * 
	 * public int getResultsFromBCC(String FirstArticleDetails) { int count = 0;
	 * List<WebElement> bbcResults = driver.findElements(bccResultsElements);
	 * System.out.println(FirstArticleDetails + "bbbbbbbbbbbbbbbbbb"); for
	 * (WebElement ele : bbcResults) { System.out.println(ele.getText() +
	 * "&&&&&&&&&&&&"); if
	 * (TestUtils.checkStringsSimilarityScore(FirstArticleDetails, ele.getText())) {
	 * count++; if (count > 2) { break; } } else {
	 * System.out.println("News not matched"); } }
	 * System.out.println("bbbbbcccccccccccccc" + count); return count; }
	 */

}
