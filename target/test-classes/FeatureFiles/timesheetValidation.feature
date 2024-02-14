Feature: Timesheet validation

  Scenario: Opening the Timesheet
    Given the user is on the be cognizant page
    Then user need to verify one cognizant text
    And user need to redirect one cognizant site
    And user need to provide required text to be searched

  Scenario: Timesheet verification
    Given the user is on the Timesheet page
    Then verify the recent three weeks timesheety
    And user need to verify the search by field
    And user need to verify the date field
    And user need to verify the current week timesheet status
    Then verify all the status dropdown list
