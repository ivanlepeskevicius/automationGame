Feature: Product detail page
  I as a user want to see the details of the product


  Scenario: Product detail page
    Given I am on a product lister page
    When I select one of the items
    Then I am on the Product detail page of the selected item
    And I can see details of the product