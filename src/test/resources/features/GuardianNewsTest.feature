@tc-01
Feature: Verifying The Guardian news article authenticity to prevent fake news.

  @smoke @regression @p1
  Scenario: Verify The Guardian first news articles authenticity with similar information on other sources
    Given User launch The Guardian URL and navigate to news page "/tone/news"
    And User get the first news article from the Guardian news page
    When User search the same news article on Google and get the number of similar articles on Google
    And User search the same news article on BBC and get the number of similar articles on BBC 
    Then Verify whether the news article from The Guardian news page is valid or invalid 

 	@p2 @regression
  Scenario: Verify The Guardian second news articles authenticity with similar information on other sources
    Given User launch The Guardian URL and navigate to news page "/tone/news"
    And User get the second news article from the Guardian news page
    When User search the same news article on Google and get the number of similar articles on Google
    And User search the same news article on BBC and get the number of similar articles on BBC 
    Then Verify whether the news article from The Guardian news page is valid or invalid
 


      