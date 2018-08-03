Feature: Shopping cart
  I as a user want to manage my shopping cart


  Scenario: Opening the shopping cart
    Given I have added an item to my shopping cart
    When I click the shopping cart icon
    Then I land on the shopping cart page
    And I can see the product in my shopping basket

  Scenario: Adding a product to cart
    Given I am on a product detail page
    When I select the size/color/amount
    And I click the add to cart button
    Then the product is added to my shopping cart