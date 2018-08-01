Feature: LoginFeature
  I as a user should be able to log in and log off from the application

  Scenario: Login with correct username and password
    Given I navigate to the login page
    When I enter the following for Login
      | username                  | password  |
      | i.lepeskevicius@gmail.com | admin123* |
    And I click login button
    Then I should see my account page

  Scenario Outline: Login with incorrect username and password
    Given I navigate to the login page
    When I enter <username> and <password>
    And I click login button
    Then I should see an error message
    Examples:
      | username                  | password     |
      | i.lepeskevicius@gmail.com | admin        |
      | user                      | userpassword |
      | user@asd.com              | userpassword |