package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class beCognizant extends BasePage{
//    WebDriver driver;
    
    public beCognizant(WebDriver driver)
    {
        super(driver);
    }

    // WebElements
    @FindBy(name = "passwd")
    WebElement txt_username;

    @FindBy(xpath = "//strong[text()=\"Around Cognizant\"]")
    WebElement scrollElement;

    
    @FindBy(xpath = "//div[@Title=\"OneCognizant\"]")
    WebElement onecog;
    
    @FindBy(xpath = "//div[@class='_8ZYZKvxC8bvw1xgQGSkvvA==']")
    WebElement d1;
    
    @FindBy(id = "mectrl_currentAccount_primary")
    WebElement user;
    
    
    //Action
    public String profile() throws InterruptedException{
        
        Thread.sleep(5000);
        Actions action= new Actions(driver);
        action.moveToElement(d1).click().perform();
        String actualUsername = user.getText();
        System.out.println("Uname:"+actualUsername);
        Thread.sleep(3000);
        WebElement d2 = driver.findElement(By.xpath("//*[@id=\"mectrl_headerPicture\"]"));
        d2.click();
        return actualUsername;
    }
    
    
    

    public void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", scrollElement);
    }

    public String onecognizant() {
    	String c= onecog.getText();
        onecog.click();
        return c;
    }
}