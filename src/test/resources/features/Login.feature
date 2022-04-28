Feature: User should be able to login and logout

  Scenario Outline: As a user, I should  be able to login
    Given I am on the login page
    When I type in <username>
    When I type in <password>
    When I click the button
    Then I should be redirected to BYTE-SIZED shopping homepage

    Examples:
      | username        | password |
      | joejoe          | password |


