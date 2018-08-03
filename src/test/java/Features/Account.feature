Feature: Account
  I as a user want to be able to see and update my account details

  Background: : Login
    Given I navigate to the login page
    When I enter the following for Login
      | username                  | password  |
      | i.lepeskevicius@gmail.com | admin123* |
    And I click login button
    Then I should see my account page

  Scenario: Edit account
    Given I navigate to the personal information page
    When I update my details
    Then I receive feedback that my account is updated

  Scenario: Change address
    Given I navigate to the personal information page
    When I change my street name
    Then I receive feedback that my account is updated

  Scenario: Check orders
    When I navigate to my orders
    Then I see a list of my orders
    And I can open an order to see the order details

  Scenario: Logout
    When I click the Log out button
    Then I receive feedback that I am logged out
    And I cannot visit my account page anymore