package testBase;
import java.io.File;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseClass {

	public WebDriver driver;
//	WebDriver driver;
	@Parameters("browser")
    @BeforeClass
    @Test(priority=1)

    public void setup(String br) {
    	if(br.equalsIgnoreCase("chrome"))
    	{
    	driver=new ChromeDriver();
    	}
    	else if(br.equalsIgnoreCase("edge"))
    	{
    	driver=new EdgeDriver();
    	}
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
    	driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
    	driver.manage().window().maximize();
    	}
	
	@AfterClass
	public void tearDown() {
        driver.quit();
	    }



	
}
