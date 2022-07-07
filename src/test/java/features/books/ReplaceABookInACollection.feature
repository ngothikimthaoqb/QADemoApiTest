Feature: Replace a book from a collection

Scenario Outline: Replace a book in a collection successfully
  Given I create new user with username as <username> and password as <password>
  And I create token with username as <username> and password as <password>
  And I get list of books
  And I add a book to a collection
  When I replace a book from a collection
  Then I verify replace a book from a collection successfully

  Examples:
    | username     | password       |
    | "ThaoNgoKim02" | "KimThao1234@1" |
