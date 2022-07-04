@login

Feature: WebDriver University - Login Page

  Scenario: Validate Successful login - Correct Credentials
    Given I access the webdriver university login page
    When I enter a username webdriver
    And I enter a password webdriver123
    And I click on the login button
    Then I should be presented with a successful login alert message

  Scenario: Validate Unsuccessful login - Incorrect Password
    Given I access the webdriver university login page
    When I enter a username webdriver
    And I enter a password incorrectpassword
    And I click on the login button
    Then I should be presented with an unsuccessful login alert message