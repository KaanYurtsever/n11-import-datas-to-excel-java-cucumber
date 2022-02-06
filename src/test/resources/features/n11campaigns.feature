Feature: Get campaign urls in n11 campaigns page

  @campaigns
  Scenario: Get campaigns and promotion urls and import to excel file
    Given User opens the browser and goes to the campaigns page
    When User clicks on each category one by one
    Then User imports each campaign urls in categories to excel file