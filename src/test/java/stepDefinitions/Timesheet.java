package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Factory.Baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.TimesheetPage;
import pageObjects.ValidationPage;
import utilities.excel;

public class Timesheet {
	WebDriver driver;
	TimesheetPage timesheet;
	String path = "C:\\Users\\2303831\\eclipse-workspace\\Timesheet\\src\\test\\resources\\Testdata\\timesheet.xlsx";

	@Given("the user is on the be cognizant page")
	public void the_user_is_on_the_be_cognizant_page() throws InterruptedException, IOException {
		timesheet = new TimesheetPage(Baseclass.getDriver());
		Thread.sleep(5000);
		timesheet.verifyingbecognizant();
	}

	@Then("user need to verify one cognizant text")
	public void user_need_to_verify_one_cognizant_text() throws InterruptedException {
		timesheet.clickOneCognizant();
	}

	@Then("user need to redirect one cognizant site")
	public void user_need_to_redirect_one_cognizant_site() {
		timesheet.redirectonecognizant();
	}

	@Then("user need to provide required text to be searched")
	public void user_need_to_provide_required_text_to_be_searched() throws InterruptedException {
		timesheet.clickSubmitTimesheet();
	}
	@Given("the user is on the Timesheet page")
	public void the_user_is_on_the_Timesheet_page() throws InterruptedException {
		timesheet = new TimesheetPage(Baseclass.getDriver());
		timesheet.verifyingtimesheetpage();
	}
	
	@Then("verify the recent three weeks timesheety")
	public void verify_the_recent_three_weeks_timesheety() throws InterruptedException, IOException {
		timesheet.verifying3weektimesheet();
	    
	}

	@Then("user need to verify the search by field")
	public void user_need_to_verify_the_search_by_field() {
		timesheet.verifyingsearchby();
	}

	@Then("user need to verify the date field")
	public void user_need_to_verify_the_date_field() throws InterruptedException {
		timesheet.clickondate();
	}

	@Then("user need to verify the current week timesheet status")
	public void user_need_to_verify_the_current_week_timesheet_status() throws InterruptedException {
		timesheet.checkthisweektimesheet();
	}

	@Then("verify all the status dropdown list")
	public void verify_all_the_status_dropdown_list() throws InterruptedException, IOException {
		timesheet.verifyingallstatus();
	}


}
