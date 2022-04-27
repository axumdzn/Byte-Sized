Feature: Seller should be able to add an item to sale, remove an item, and view their sales data
  Scenario: As a seller, I should be able to add an item.
    Given I am on the home page
    When I click on the add button
    Then I added an item


  Scenario: As a seller, I should be able to remove an item.
    Given I am on the home page
    When I select an item to remove
    When I click on the remove button
    Then The item is removed


  Scenario: As a seller, I should be able to view sales data.
    Given I am on the home page
    When I click on the sales data button
    Then I can view all sales items
