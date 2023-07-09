@tc-01
Feature: Verifying The Guardian news article authenticity to prevent fake news.
	
  @smoke @regression @p1
  Scenario: Verify the authenticity of The Guardians first news article by cross-referencing with other sources to validate its accuracy.
    Given User launch The Guardian URL and navigate to news page "/tone/news"
    And User reterive the first news article details from the Guardian news page
    When User perform search the same news article on Google and obtains the number of similar articles on Google
    And User perform search the same news article on BBC and obtains the number of similar articles on BBC
    Then The news article from Guardian news page should be considered valid if the number of similar articles on other sources is greater than or equal to 2 

  @regression @p2
  Scenario: Verify the authenticity of The Guardians second news article by cross-referencing with other sources to validate its accuracy.
    Given User launch The Guardian URL and navigate to news page "/tone/news"
    And User reterive the second news article details from the Guardian news page
    When User perform search the same news article on Google and obtains the number of similar articles on Google
    And User perform search the same news article on BBC and obtains the number of similar articles on BBC
    Then The news article from Guardian news page should be considered valid if the number of similar articles on other sources is greater than or equal to 2 
      
  @negative @regression @p2
  Scenario: Invalidate the authenticity of The Guardians first news article by cross-referencing with other sources.
    Given User launch The Guardian URL and navigate to news page "/tone/news"
    And User reterive the first news article details from the Guardian news page
    When User perform search the same news article on Google and obtains the number of similar articles on Google
    And User perform search the same news article on BBC and obtains the number of similar articles on BBC
    Then The news article from Guardian news page should be considered Invalid if the number of similar articles on other sources is less than 2 