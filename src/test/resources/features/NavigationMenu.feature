@Navigate
Feature: Sales manager should be able to navigate to pages.

  Scenario: Navigate Fleet-->Vehicle
    Given the user is on the login page
    And the user enters the sales manager information
    When the user navigates to Fleet, Vehicles
    Then the title should be Vehicle

    @db
  Scenario: Navigating marketing - Campaigns
    Given the user is on the login page
    And the user enters the sales manager information
    When the user navigates to Marketing , Campaigns
    Then title should be Campaigns

  Scenario: Navigatung Activities-- Calendar Events
    Given the user is on the login page
    And the user enters the sales manager information
    When the user navigates to Activities, Calendar Events
    Then title should be Calendar