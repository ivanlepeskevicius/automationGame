Feature: Checkout
  I as a user want to be able to do a purchase

  Background: : Login
    Given I navigate to the login page
    When I enter the following for Login
      | username                  | password  |
      | i.lepeskevicius@gmail.com | admin123* |
    And I click login button
    Then I should see my account page

  Scenario: Successful checkout
    Given I have added an item to my shopping cart
    When I proceed to the check out
    And I enter valid delivery details
    And I select a payment method
    And I I confirm the order
    Then I am redirected to the thank you page

  Scenario: Checkout with incorrect delivery details
    Given I have added an item to my shopping cart
    And I click the shopping bag icon
    When I proceed to check out
    And I select a payment method
    And I enter invalid details
    And I click the pay button
    Then I receive feedback that the purchase details are incorrect