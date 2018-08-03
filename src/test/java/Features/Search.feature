Feature: Search
  I as a user want to search for products


  Scenario Outline: Do a valid search with a single keyword
    Given I am on the homepage to do a single keyword search
    When I do a single keyword search for <keyword>
    Then I see a single keyword search result page with more than zero results

    Examples:
      | keyword |
      | dress   |
      | t-shirt |
      | women   |

  Scenario Outline: Do a valid search with multiple keyword
    Given I am on the homepage to do a search with multiple keywords
    When I do a multiple keyword search for <key1> <key2>
    Then I see a multiple keyword search result page with more than zero results

    Examples:
      | key1   | key2  |
      | top    | blue  |
      | cotton | silk  |
      | new    | dress |

  Scenario Outline: Filtering the search result by size
    Given I have done a search using a valid search term
    And I see a certain amount of items
    When I filter using the size <filter>
    Then The results are filtered to display a smaller amount of items

    Examples:
      | filter |
      | S      |
      | M      |
      | L      |