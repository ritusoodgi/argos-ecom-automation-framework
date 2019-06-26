Feature: Price function
AS A customer
I WANT TO select product rating
SO THAT i get the product in that selected rating

  Scenario:select a rating
    Given I am on result page
    When i select rating range
    Then i should get the products in rating range


