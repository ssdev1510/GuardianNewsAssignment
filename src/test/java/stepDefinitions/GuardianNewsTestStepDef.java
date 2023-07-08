package stepDefinitions;

import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.TestUtils;
import pageObjects.GuardianNewsPO;
import pageObjects.GoogleNewsPO;
import pageObjects.BBCNewsPO;
import testBase.TestBase;

public class GuardianNewsTestStepDef extends TestBase {

	//private WebDriver driver;
	private static Logger Log = LogManager.getLogger();
	private GuardianNewsPO guardianNewsPO;
	private String FirstArticleDetails;
	private int countGoogle, countBBC;

	@Given("User launch The Guardian URL and navigate to news page {string}")
	public void user_launch_the_guardian_url_and_navigate_to_news_page(String endPoint) throws IOException {
		//boolean isHeadless = false;
		//if (System.getProperty("isHeadless").equalsIgnoreCase("true")) {
		//	isHeadless = true;
		//} else {isHeadless = false;}
		//driver = getDriver(isHeadless);
		// driver = new ChromeDriver();
		
		driver.get(TestUtils.getConfigProperty("guardianNewsURL") + endPoint);
		guardianNewsPO = new GuardianNewsPO(driver);

		Log.info("Opening Guardian URL in browser");

	}

	@Given("User reterive the first news article details from the Guardian news page")
	public void user_reterive_the_first_news_article_details_from_the_guardian_news_page() {
		FirstArticleDetails = guardianNewsPO.reteriveDetails();

		Log.info("First article headline from The Guardian New - " + FirstArticleDetails);

	}

	@When("User perform search the same news article on Google and obtains the number of similar articles on Google")
	public void user_perform_search_the_same_news_article_on_google_and_obtains_the_number_of_similar_articles_on_google()
			throws IOException {
		driver.navigate().to(TestUtils.getConfigProperty("googleURL"));

		GoogleNewsPO googleNewsPO = new GoogleNewsPO(driver);
		googleNewsPO.acceptGoogleCookies();
		googleNewsPO.enterNewsArticleInGoogleSearchBox(FirstArticleDetails);
		googleNewsPO.enterAndSearchSimilarNewsArticleOnGoogle();
		countGoogle = googleNewsPO.getCountFromGoogleResult(FirstArticleDetails);

		Log.info("Count of similar news article found on google found - " + countGoogle);
	}

	@When("User perform search the same news article on BBC and obtains the number of similar articles on BBC")
	public void user_perform_search_the_same_news_article_on_bbc_and_obtains_the_number_of_similar_articles_on_bbc()
			throws IOException {
		driver.navigate().to(TestUtils.getConfigProperty("BBCNewsURL"));

		BBCNewsPO bbcNewsPO = new BBCNewsPO(driver);
		bbcNewsPO.enterNewsArticleInBBCSearchBox(FirstArticleDetails);
		bbcNewsPO.enterAndSearchSimilarNewsArticleBBC();
		countBBC = bbcNewsPO.getCountFromBBCResult(FirstArticleDetails);

		Log.info("Count of similar news article found on BBC found - " + countBBC);
	}

	@Then("The news article from Guardian news page should considered valid if the number of similar articles on other sources is greater than or equal to {int}")
	public void the_news_article_from_guardian_news_page_should_considered_valid_if_the_number_of_similar_articles_on_other_sources_is_greater_than_or_equal_to(
			Integer expectedCount) {

		Assert.assertTrue(guardianNewsPO.isNewsArticleValidOrInvalid(countGoogle, countBBC, expectedCount),
				"News from The Guardian is invalid ");
	}

	
}
