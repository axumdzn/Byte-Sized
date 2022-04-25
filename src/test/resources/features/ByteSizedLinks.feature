Feature: Buyers should  be able to cancel an item in their cart, see the seller's products, view seller's stats, and send a message to sellers
  Scenario: As a buyer, I should  be able to cancel an item so that I won’t be charged for it
    Given I am on the checkout page
    When I click the remove button
    Then The item should be removed

  Scenario: As a buyer, I should be able to see all of a seller's purchasable products
    Given I am on the seller's page
    Then I should see the seller's products

  Scenario: As a buyer, I should be able too see the seller's stats or ratings so that I can determine their credibility
    Given I am on the seller's page
    Then I should see the seller's rating

  Scenario: As a buyer, I should be able to message sellers so I can get more information on a product
    Given I am on the seller’s page
    When I click the send a message link
    When I am on the send a message page
    When I type a message
    When I click on the send a message button
    Then A popup informs me that the message was sent successfully