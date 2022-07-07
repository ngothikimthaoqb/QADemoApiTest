Feature: Delete a book from a collection
  Scenario Outline: Delete a book from a collection successfully
    Given I create new user with username as <username> and password as <password>
    And I create token with username as <username> and password as <password>
    And I get list of books
    And I add a book to a collection
    When I delete a book from a collection
    Then I verify delete a book from a collection successfully

    Examples:
      | username     | password       |
      | "ThaoNgoKim1" | "KimThao1234@1" |