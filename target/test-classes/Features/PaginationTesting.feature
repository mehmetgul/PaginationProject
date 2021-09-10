Feature: Verify the Pagination Helper Implementation

  Scenario Outline: Verify the pagination function with expected results
    Given Use the "<List of Content>" pagination and "<Number of Item each page>"
    Then Get the Item Count and compare with expected "<Item Count>"
    Then Get the Page Count and compare with expected "<Page Count>"
    Then Get the Page Item Count and compare with Expected Result
      | Page Item Count | Expected Result |
      | 0               | 4               |
      | 1               | 2               |
      | 2               | -1              |
    Then Get the Page Index> and compare the Expected Page Index
      | Page Index | Expected Page Index |
      | 5          | 1                   |
      | 2          | 0                   |
      | 20         | -1                  |
      | -10        | -1                  |
    Examples:initial data
      | List of Content | Number of Item each page | Item Count | Page Count |
      | abcdef          | 4                        | 6          | 2          |

  Scenario Outline: Verify the pagination function as expected (alternate scenario)
    Given Use the "<List of Content>" pagination and "<Number of Item each page>"
    Then Get the Item Count and compare with expected "<Item Count>"
    Then Get the Page Count and compare with expected "<Page Count>"
    Then Get the Page Item Count and compare with Expected Result
      | Page Item Count | Expected Result |
      | 0               | 3               |
      | 1               | 3               |
      | 2               | 3               |
      | 3               | 3               |
      | 4               | 2               |
      | 5               | -1              |
      | -1              | -1              |
    Then Get the Page Index> and compare the Expected Page Index
      | Page Index | Expected Page Index |
      | 5          | 1                   |
      | 2          | 0                   |
      | 20         | -1                  |
      | -10        | -1                  |
      | 10         | 3                   |
      | 13         | 4                   |
      | 100        | -1                  |
    Examples:initial data for second sample
      | List of Content | Number of Item each page | Item Count | Page Count |
      | abcdefghiklmnd  | 3                        | 14         | 5          |

