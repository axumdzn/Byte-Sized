Feature: User should be able to read message received and send messages

  Scenario Outline: As a user, I should be able to send a message to another user
    Given I am on the message page
    When I type in <title>
    When I type in <userid>
    When I type in <message>
    When I click a submit button
    Then I should be able to see the alert message

    Examples:
      | title         | userid | message                    |
      | hey you there | "1"      | your food is too expensive |
