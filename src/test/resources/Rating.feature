@Rating
Feature: Customer Rating review
  AS A customer
  I WANT TO select product rating
  SO THAT i get the product in that selected rating

  @Sm
  Scenario:select a star rating
    Given I am on homepage
    When I search for product "nike"
    And i select a rating "4or more"
    Then i should get the products within rating range

  @Regression
  Scenario Outline:Search for a product
    Given I am on homepage
    When I search for product "nike"
    And i select a rating filter"<reviewFilter>"
    Then i should get the products within rating range
    Examples:
      | reviewFilter |
      | 5only        |
      | 4or more     |
      | 3or more     |
      | 2or more     |
      | 1or more     |
