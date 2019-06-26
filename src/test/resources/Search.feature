@Search
Feature: Search Function
  AS A customer
  I WANT TO search for a product
  SO THAT i will get the respective product

  @Smoke
  Scenario:
    Given I am on homepage
    When  I search for product "nike"
    Then  I should get the respective product

  @Regression
  Scenario Outline:Search for the product with valid credentials
    Given I am on homepage
    When  I search for product "<product>"
    Then I should get the respective product
    Examples:
      | product |
      | watch   |
      | adidas  |
