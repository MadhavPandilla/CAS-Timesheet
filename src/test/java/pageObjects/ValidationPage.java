package pageObjects;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Factory.Baseclass;

public class ValidationPage extends BasePage {
	
	public ValidationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	static Properties p;
	@FindBy(xpath="//input[@id=\\\"i0116\\\"]")
	WebElement username;
	
	@FindBy(xpath="//*[@id=\\\"idSIButton9\\\"]")
	WebElement usernameclick;
	
	@FindBy(xpath="//input[@type=\\\"password\\\"]")
	WebElement password;
	
	@FindBy(xpath ="//input[@value=\\\"Sign in\\\"]")
	WebElement signin;

	@FindBy(xpath = "//div[@id=\"O365_HeaderRightRegion\"]")
	WebElement account;
	
	@FindBy(xpath = "//div[@id=\"mectrl_currentAccount_secondary\"]")
	WebElement emailid;
	
	@FindBy(xpath ="//div[@id=\"mectrl_currentAccount_secondary\"]")
	WebElement u_name;
	
	By explicit=By.xpath("//*[@id=\"KmsiCheckboxField\"]");
	
	
	// Action Methods
	//sending the username to login
	public void username() {
		try {
			username.sendKeys(Baseclass.getProperties().getProperty("username"));//sending the username from config.properties
			usernameclick.click();//click ok
			}
			catch(Exception e) {
				
			}
	}
	//sending the password to login
	public void password() throws InterruptedException {
		Thread.sleep(5000);
		try {
			password.sendKeys(Baseclass.getProperties().getProperty("password"));//sending the password from config.properties
			signin.click();//clicking on sign in
		}catch(Exception e) {
			
		}
	}
	//Authentication
	public void authentication() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(explicit));
		    WebElement d = username;
		    d.click();//click ok
		    }
			catch (Exception e) {}    

	}
	//My account
	public void clickMyAccount() {
		account.click();//clicking on my account
	}
	
	//getting userid
	public String getUserId() {
		String emailId = emailid.getText();
		return emailId;
	}
	
	//geting username
	public String getUsername() {
		String username = u_name.getText();
		return username;
	}
	
	
}
