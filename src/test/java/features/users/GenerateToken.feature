Feature: Generate token

  Scenario Outline: : Verify generate token successfully
    Given I create new user with username as <username> and password as <password>
    When I generate token with username as <username> and password as <password>
    Then I verify generate token successfully
    Examples:
      |username|password|
      |"ThaoNgoKim14"|"Kimthao3445$1"|
