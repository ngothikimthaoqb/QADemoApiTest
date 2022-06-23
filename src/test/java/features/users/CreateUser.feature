Feature: Create user

  Scenario Outline: : Verify create new user successfully
    When I create new user with username as <username> and password as <password>
    Then I verify create new user successfully
    Examples:
    |username|password|
    |"KimthaThi1111"|"Kimthao34451111%%"|