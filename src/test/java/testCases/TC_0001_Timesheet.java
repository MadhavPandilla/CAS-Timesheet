package testCases;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//import Utilities.NavigationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
//import pageObjects.BasePage;
import pageObjects.beCognizant;
import pageObjects.timeSheet;
import testBase.BaseClass;
//import testBase.BaseClass;
//import Utilities.NavigationUtils;
public class TC_0001_Timesheet extends BaseClass{

	public WebDriver driver;
//	@Parameters("browser")
//    @BeforeClass
//
//    public void setup(String br) {
//    	if(br.equalsIgnoreCase("chrome"))
//    	{
//    	WebDriverManager.chromedriver().setup();
//    	driver=new ChromeDriver();
//    	}
//    	else if(br.equalsIgnoreCase("edge"))
//    	{
//    	WebDriverManager.edgedriver().setup();
//    	driver=new EdgeDriver();
//    	}
//    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
//    	driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
//    	driver.manage().window().maximize();
//    	}
//	


    @Test(priority=1)
    public void user() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        beCognizant bc = new beCognizant(driver);
        String actualUsername = bc.profile();
        String expectedUsername = "B, Manjari (Cognizant)";
//        Assert.assertEquals(actualUsername,expectedUsername,"Actual username does not match expected username");
        soft.assertEquals(actualUsername, expectedUsername, "Actual username does not match expected username");
        
        soft.assertAll();
    }

    @Test(priority=2)
    public void oneCognizant() throws InterruptedException {
        beCognizant bc = new beCognizant(driver);
        Thread.sleep(5000);
        bc.scroll();
        String oc = bc.onecognizant();
//        Assert.assertEquals(oc,"OneCognizant","One Cognizant element is not displayed");
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(oc, "OneCognizant", "One Cognizant element is not displayed");
        soft.assertAll();

    }

    @Test(priority=4)
    public void handleTimesheet() throws InterruptedException {
        timeSheet ts = new timeSheet(driver);
        String title1=ts.navigatetotimesheet();
//        Assert.assertEquals(title1,"Timesheet Landing Component","Page is not navigated to timesheet"); 
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(title1, "Timesheet Landing Component", "Page is not navigated to timesheet");
        soft.assertAll();

    }

    @Test(priority=5)
    public void verifyCurrentDate() throws InterruptedException {
        timeSheet ts = new timeSheet(driver);
        ts.validateCurrentDate();
    }

    @Test(priority=6)
    public void refresh() throws InterruptedException {
        timeSheet ts = new timeSheet(driver);
        ts.refreshpage();
    }

    @Test(priority=7, dependsOnMethods= {"refresh"})
    public void verifyLastThreeWeek() throws InterruptedException {
        timeSheet ts = new timeSheet(driver);
        ts.verifyWeekDates();
    }

    @Test(priority=8)
    public void verifyStatus() throws InterruptedException {
        timeSheet ts = new timeSheet(driver);
        ts.statusVerification();
    }
    

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }
//    

}
