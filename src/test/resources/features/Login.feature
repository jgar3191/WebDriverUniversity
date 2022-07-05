@login

Feature: WebDriver University - Login Page

  Background:
    Given I access the webdriver university login page

  Scenario: Validate Successful login - Correct Credentials
    When I enter a username webdriver
    And I enter a password webdriver123
    And I click on the login button
    Then I should be presented with a successful login alert message

  Scenario: Validate Unsuccessful login - Incorrect Password
    When I enter a username webdriver
    And I enter a password incorrectpassword
    And I click on the login button
    Then I should be presented with an unsuccessful login alert message

  @scenario-outline
  Scenario Outline: Validate - Successful & Unsuccessful Login
    When I enter a username <username>
    And I enter a password <password>
    And I click on the login button
    Then I should be presented with the following login validation message <loginValidationMessage>

    Examples:
      | username  | password     | loginValidationMessage |
      | webdriver | webdriver123 | validation succeeded   |
      | webdriver | webdriver1   | validation failed      |
      | joe_blogs | password3    | validation failed      |

