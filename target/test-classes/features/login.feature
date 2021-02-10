@login
Feature: Users should be able to login
Background:
  Given the user is on the login page

  Scenario: login as a driver

    When the user enters the driver information
    Then the user should be able to login

    @sales_manager
    Scenario: login as sales_manager

      When the user enters the sales manager information
      Then the user should be able to login

  Scenario: Login as store manager

    When the user enters the store manager information
    Then the user should be able to login

