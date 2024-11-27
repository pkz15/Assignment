Feature: Dynamic Table Validation

  Scenario: Validate the table row count and field names after adding a new row
    Given I open the Dynamic page
    When I click the "Add Row" button to add a new row for 1 time
    Then the table should have 4 rows
    And the table should have the following field names:
      | NEW CELL1  | NEW CELL2  |
      | Row1 cell1 | Row1 cell2 |
    When I click the "Add Row" button to add a new row for 4 time
    Then the table should have 8 rows
    And the table should have the following field names:
      | NEW CELL1  | NEW CELL2  |
      | NEW CELL1  | NEW CELL2  |
      | NEW CELL1  | NEW CELL2  |
      | NEW CELL1  | NEW CELL2  |
      | NEW CELL1  | NEW CELL2  |
      | Row1 cell1 | Row1 cell2 |

  Scenario: Validate the table row count and field names after deleting a new row
    Given I open the Dynamic page
    When I click the "Remove Row" button to delete a new row for 1 time
    Then the table should have 2 rows
    And the table should have the following field names:
      | Row2 cell1 | Row2 cell2 |
    When I click the "Add Row" button to add a new row for 2 time
    Then the table should have 4 rows
    And the table should have the following field names:
      | NEW CELL1 | NEW CELL2 |
      | NEW CELL1 | NEW CELL2 |
    When I click the "Remove Row" button to delete a new row for 2 time
    And the table should have the following field names:
      | Row2 cell1 | Row2 cell2 |
    When I click the "Remove Row" button to delete a new row for 2 time
    And the table should have the following field names:
      |  |  |  |
