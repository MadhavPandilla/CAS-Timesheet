Feature: Validation oneCognizant

  Scenario: sucessfull login
    Given user is on the becognizant site
    When user login into site with valid credentials username
    And user login into site with valid credentials password
    And user requested to authenticate the site for approval

  Scenario: Successful validation of user account details
    Given user navigates to the beCognizant portal
    Then user clicks on myaccount menu
    Then user should see user account details
