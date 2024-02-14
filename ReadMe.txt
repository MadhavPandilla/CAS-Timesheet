************************************************PROJECT DESCRIPTION*****************************************************************
 
Problem Statement : Timesheet
1.Login into Be.cognizant
2.Verify the Username
3.open timesheet and verify the Date and Status dropdown.

Detailed Description: Main Project
 
1)Launch the browser 
2)Go to "https://be.cognizant.com"
3)Verify the user profile and print it.(which is present at the top right corner)
4)Check whether the "One Cognizant" is being displayed or not.
5)Click on "one cognizant".
6)Verify whether it is navigating to 1C or not.
7)Handle the windows.
8)Search the "timesheet" and click on submit "timesheet", also verify it.
9)Get the last 3 weeks timesheet details to compare with the system dates by the respective date format.(Saturday to friday)
10)Verify whether the "searchBy" field is displayed or not, click "date" and verify whether the date is displayed or not. Then click todays date and search it and Verify only current week timesheet is displayed.
11)Change "date" to "status" in searchBy, then check whether status dropdown appeared or not.
12)Click all the elements from the dropdown seperatly and verify it.
13)Close the browser. 
 
Key Automation Scope:
 
Capturing the screenshot
Navigation to new page
Printing all the values in console and excel sheet
 
 
**********************************************************STEPS TO EXECUTE*************************************************************
 
-unzip the folder
-On eclipse, goto file->import->select the maven->click on existing maven project->next->browse the location where u unzip the folder-> click on finish
-Now go to the TestNG.xml file and run as TestNGSuite.
-Now the file will Execute and we get the expected output as shown below.
 
*******************************************************FILES DESCRIPTION**************************************************************
 
1.src/test/java- There are five packages in this folder.

->  Factory   :In this package there is one class Baseclass.

->pageObjects : In this file, the BasePage,TimesheetPage and ValidationPage classes are defined.

->stepDefinitions : In this file, AccountValidationSteps, Hooks and Timesheet classes are defined.

->testRunner  : In this file, TestRunner class is defined.

->utilities   : In this file, excel class is defined.
 
2.src/test/resources- There are two folders in this folder.

-> FeatureFiles  : In this folder, there are accountValidation and timesheetValidation feature files are defined.

->Testdata  : In this folder, there are timesheet.xlsx, config.properties and extent.properties are defined.


3.JRE System Library: In this File we have all dependencies of JAR.files.         
 
4.Maven Dependencies: In this File we have all the directory on the local machine, where all the project artifacts are stored. when a Maven build is executed,
Maven automatically downloads all the dependency jars into the local repository. Usually, this directory is named.
 
5.Report: In this folder the Report.html is present which is the report of the project
 
6.src: In this, there are two folders
	-main:It is an empty folder
	-test:It is an empty folder
 
7.target: It is an empty folder

8.pom.xml: The pom.xml file contains information of project and configuration information for the maven to build the project such as dependencies,
build directory, source directory, test source directory, plugin, goals etc. Maven reads the pom.xml file, then executes the goal.

9.testng.xml : In this file, xml code is there.
 

***************************************************************************************************************************************
 
                                                        OUTPUT ON CONSOLE
 
***************************************************************************************************************************************
 
Scenario: sucessfull login                                  # src/test/resources/FeatureFiles/accountValidation.feature:3

  Given user is on the becognizant site                     # stepDefinitions.AccountValidationSteps.user_is_on_the_becognizant_site()
 
    Embedding sucessfull login [image/png 238623 bytes]
 
  When user login into site with valid credentials username # stepDefinitions.AccountValidationSteps.user_login_into_site_with_valid_credentials_username()
 
    Embedding sucessfull login [image/png 274007 bytes]
 
  And user login into site with valid credentials password  # stepDefinitions.AccountValidationSteps.user_login_into_site_with_valid_credentials_password()
 
    Embedding sucessfull login [image/png 277321 bytes]
 
  And user requested to authenticate the site for approval  # stepDefinitions.AccountValidationSteps.user_requested_to_authenticate_the_site_for_approval()
 
    Embedding sucessfull login [image/png 277321 bytes]
 
 
Scenario: Successful validation of user account details # src/test/resources/FeatureFiles/accountValidation.feature:9

  Given user navigates to the beCognizant portal        # stepDefinitions.AccountValidationSteps.user_navigates_to_the_be_cognizant_portal()
 
    Embedding Successful validation of user account details [image/png 277321 bytes]
 
  Then user clicks on myaccount menu                    # stepDefinitions.AccountValidationSteps.user_clicks_on_myaccount_menu()
 
    Embedding Successful validation of user account details [image/png 277437 bytes]
 
Account Verified

  Then user should see user account details             # stepDefinitions.AccountValidationSteps.user_should_see_user_account_details()
 
    Embedding Successful validation of user account details [image/png 304088 bytes]
 
 
Scenario: Opening the Timesheet                         # src/test/resources/FeatureFiles/timesheetValidation.feature:3

  Given the user is on the be cognizant page            # stepDefinitions.Timesheet.the_user_is_on_the_be_cognizant_page()
 
    Embedding Opening the Timesheet [image/png 277193 bytes]
 
OneCognizant is present

  Then user need to verify one cognizant text           # stepDefinitions.Timesheet.user_need_to_verify_one_cognizant_text()
 
    Embedding Opening the Timesheet [image/png 97065 bytes]
 
  And user need to redirect one cognizant site          # stepDefinitions.Timesheet.user_need_to_redirect_one_cognizant_site()
 
    Embedding Opening the Timesheet [image/png 367348 bytes]
 
  And user need to provide required text to be searched # stepDefinitions.Timesheet.user_need_to_provide_required_text_to_be_searched()
 
    Embedding Opening the Timesheet [image/png 544635 bytes]
 
 
Scenario: Timesheet verification                            # src/test/resources/FeatureFiles/timesheetValidation.feature:9

  Given the user is on the Timesheet page                   # stepDefinitions.Timesheet.the_user_is_on_the_Timesheet_page()
 
    Embedding Timesheet verification [image/png 146218 bytes]
 
week 01 timesheet is verified

week 11 timesheet is verified

week 21 timesheet is verified

  Then verify the recent three weeks timesheety             # stepDefinitions.Timesheet.verify_the_recent_three_weeks_timesheety()
 
    Embedding Timesheet verification [image/png 155729 bytes]
 
Search By is displayed

  And user need to verify the search by field               # stepDefinitions.Timesheet.user_need_to_verify_the_search_by_field()
 
    Embedding Timesheet verification [image/png 155729 bytes]
 
Date Field is displayed

  And user need to verify the date field                    # stepDefinitions.Timesheet.user_need_to_verify_the_date_field()
 
    Embedding Timesheet verification [image/png 169801 bytes]
 
timesheet is verified

  And user need to verify the current week timesheet status # stepDefinitions.Timesheet.user_need_to_verify_the_current_week_timesheet_status()
 
    Embedding Timesheet verification [image/png 85996 bytes]
 
Approved

Passed: Approved

Passed: Approved

Passed: Approved

Passed: Approved

Passed: Approved

Passed: Approved

Passed: Approved

Passed: Approved

Passed: Approved

Passed: Approved

Passed: Approved

Passed: Approved

Passed: Approved

Passed: Approved

Passed: Approved

Passed: Approved

Passed: Approved

Passed: Approved

Passed: Approved

Overdue

failed:  No results found

Partially Approved

failed:  No results found

Pending

Passed: Pending

Passed: Not Submitted

Saved

failed:  No results found

Sent Back for Revision

failed:  No results found

Submitted for Approval

Passed: Submitted for Approval

  Then verify all the status dropdown list                  # stepDefinitions.Timesheet.verify_all_the_status_dropdown_list()
 
    Embedding Timesheet verification [image/png 103388 bytes]
 
┌──────────────────────────────────────────────────────────────────────────┐

│ View your Cucumber Report at:                                            │

│ https://reports.cucumber.io/reports/961e1826-78a3-46ca-a789-a7b913b4dff7 │

│                                                                          │

│ This report will self-destruct in 24h.                                   │

│ Keep reports forever: https://reports.cucumber.io/profile                │

└──────────────────────────────────────────────────────────────────────────┘

===============================================

Suite

Total tests run: 4, Passes: 4, Failures: 0, Skips: 0

===============================================
