Feature: Verify the pagination

  Scenario: Verify the pagination function as expected
    Given Use the List of Content pagination and Number of Item each page
      | List of Content | Number of Item each page |
      | abcdef          | 4                        |

    Then Get the Item Count
    Then Get the Page Count
    Then Get the Page Item Count
    Then Get the Page Index
