package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Factory.Baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ValidationPage;

public class AccountValidationSteps {
	
	WebDriver driver;
	WebElement accountButton;
	ValidationPage validation;
	Properties p;
		
	@Given("user is on the becognizant site")
	public void user_is_on_the_becognizant_site() {
	    // Write code here that turns the phrase above into concrete actions

		validation = new ValidationPage(Baseclass.getDriver());
	}

	@When("user login into site with valid credentials username")
	public void user_login_into_site_with_valid_credentials_username() {
	    // Write code here that turns the phrase above into concrete actions
		validation.username();
		
	}

	@When("user login into site with valid credentials password")
	public void user_login_into_site_with_valid_credentials_password() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		validation.password();
	}

	@When("user requested to authenticate the site for approval")
	public void user_requested_to_authenticate_the_site_for_approval() {
	    // Write code here that turns the phrase above into concrete actions
		validation.authentication();
	}
	@Given("user navigates to the beCognizant portal")
	public void user_navigates_to_the_be_cognizant_portal() {
	    // Write code here that turns the phrase above into concrete actions
		validation = new ValidationPage(Baseclass.getDriver());
	}

	@Then("user clicks on myaccount menu")
	public void user_clicks_on_myaccount_menu() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions	
		Thread.sleep(3000);
		validation.clickMyAccount();
	}

	@Then("user should see user account details")
	public void user_should_see_user_account_details() throws IOException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		String actualEmailid = "2303831@cognizant.com";
		
		String email = validation.getUserId();
		String username = validation.getUsername();
		Assert.assertEquals(email,actualEmailid);
		System.out.println("Account Verified");
		Thread.sleep(5000);
		validation.clickMyAccount();
		
	}
	
}
