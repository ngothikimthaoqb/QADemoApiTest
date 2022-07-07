Feature: Create user

  Scenario Outline: : Verify create new user successfully
    When I create new user with username as <username> and password as <password>
    Then I verify create new user successfully
    Examples:
    |username|password|
    |"KimthaTheeei1111aaa"|"Kimthao34451111%%"|