Feature: Buyers should  be able to cancel an item in their cart and see the seller's products
  Scenario: As a buyer, I should  be able to cancel an item so that I won’t be charged for it
    Given I am on the seller's page
    When I click the add to cart button
    When I click the remove button
    Then The item is removed and I am still on the seller's page

  Scenario: As a buyer, I should be able to see all of a seller's purchasable products
    Given I am on the seller's page
    Then I should see the seller's products


