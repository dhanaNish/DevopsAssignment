@searchInAmazon
Feature: Search In Amazon.in site
  As a User
  I want to be able to quickly navigate to the Amazon.in website
  So that I can quickly view the products in Amazon 

  Scenario: Today's Deals menu is present in homepage
    Given user is on homepage
    When user checks for Today's Deals menu in top of homepage 
    Then Today's Deals menu is present in homepage header section 
  
  Scenario: Navigate to view Amazon Prime details
    Given user is on homepage
    When user clicks on Prime menu
    Then user is navigated to Amazon Prime details page
  