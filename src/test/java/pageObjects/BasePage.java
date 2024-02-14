package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@SuppressWarnings("unchecked")
	public WebDriver switchDriver(WebDriver d)
	{
	this.driver = d;
	String s ="";
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	List<String> l = new ArrayList(driver.getWindowHandles());

	for(int i=0;i<l.size();i++)
	{
		s = l.get(i);
	}
	driver.switchTo().window(s);
	return driver;
	}
	
}
