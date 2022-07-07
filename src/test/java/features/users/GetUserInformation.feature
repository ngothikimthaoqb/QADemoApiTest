Feature: Get user information

  Scenario Outline: : Verify get user information successfully
    Given I create new user with username as <username> and password as <password>
    And I generate token with username as <username> and password as <password>
    When I get user information
    Then I verify get user information successfully
    Examples:
      |username|password|
      |"ThaoNgoKim15"|"Kimthaao3445$1"|
