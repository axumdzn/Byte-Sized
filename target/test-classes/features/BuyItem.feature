Feature: A buyer should be able to buy an item:
    Scenario: AS a buyer, I should be able to buy an item so that I can get items I need or want
        Given I am logged in
        When I click on an item I want
        When I click the purchase button
        Then I get a confirmation message that I bought something