Feature: Contacts page


  Scenario: default page number
    Given the user is on the login page
    And the user enters the driver information
    When the user navigates to "Customers" "Contacts"
    Then default page number should be 1


  Scenario: Menu Options
    Given the user logged in as "driver"
    Then the user should see following options
    |Fleet|
    |Customers|
    |Activities|
    |System    |

Scenario: login as given user
  Given the user is on the login page
  When the user logs in using following credentials
  |username| user10|
  |password| UserUser123|
  |firstname| Brenden |
  |lastname |Schneider|
  Then the user should be able to login