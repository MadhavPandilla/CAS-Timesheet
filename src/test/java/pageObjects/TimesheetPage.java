package pageObjects;

import java.util.Date;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import utilities.excel;

@SuppressWarnings("deprecation")
public class TimesheetPage extends BasePage {
	
	public TimesheetPage(WebDriver driver) {
		super(driver);
	}
	
	String File = System.getProperty("user.dir")+"/src/test/resources/Testdata/timesheet.xlsx";
	static LocalDate c = LocalDate.now();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
	
	@FindBy(xpath = "//div[@id=\"89c5ffca-2ffb-4052-a723-e99c8c9a14ef\"]")
	WebElement AppandTools;
	
	@FindBy(xpath = "//div[contains(text(),'OneCognizant')]")
	WebElement onecognizant;
		
	@FindBy(xpath="//input[@id='oneC_searchAutoComplete']")
	WebElement sendingkey;
		
	@FindBy(xpath = "//div[@class=\"quickActionsResultText\"]")
	WebElement submittimesheet;
	
	@FindBy(id="CTS_TS_LAND_WRK_DATE$prompt")
	WebElement dateoption;
		
	@FindBy(id ="CTS_TS_LAND_WRK_CTS_TS_SEARCH")
	WebElement date;	
	
	@FindBy(id ="curdate")
	WebElement currentdate;
	
	@FindBy(xpath = "//div[@class='ps_box-link timesheet_period']//span")
	List<WebElement> date1;
		
	@FindBy(id="CTS_TS_LAND_WRK_CTS_TS_SEARCH")
	WebElement selectby;
	
	@FindBy(id="CTS_TS_LAND_WRK_SEARCH")
	WebElement search;
	
	@FindBy(id="#ICOK")
	WebElement popup;
	
	@FindBy(id="CTS_TS_LAND_WRK_PB_CLEAR")
	WebElement refresh;
	
	@FindBy(id="CTS_TS_LAND_PER_DESCR30$0")
	WebElement todaytimesheet;
	
	@FindBy(xpath="//*[@class='ps_box-group psc_layout timesheet_period_group_box']/div[2]/span")
	List<WebElement> title;
	
	@FindBy(id="CTS_TS_LAND_WRK_CTS_TS_LAND_STATUS")
	WebElement status1;
	
	@FindBy(id = "CTS_TS_LAND_WRK_CTS_TS_SEARCH_LBL")
	WebElement searchby;
	
	@FindBy(id="CTS_TS_LAND_WRK_DATE_LBL")
	WebElement datefield;
	
	@FindBy(xpath="(//*[contains(text(),'Quick Actions')])[2]")
	WebElement quickaction;
	
	
	
	//Action Methods	
	//verifying be cognizant page title
	public void verifyingbecognizant() throws InterruptedException, IOException {
		String Title=driver.getTitle();//be cognizant page title in string title
		Assert.assertEquals( Title,"Be.Cognizant - Home", "Be cognizant page is found");//checking whether be cognizant page is present or not		
	}
	
	
	//verifying one cognizant is present or not and clicking on one cognizant
	public void clickOneCognizant() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor) driver;
	    js.executeScript("arguments [0].scrollIntoView();", AppandTools);//scrolling the page till all the apps
	    wait.until(ExpectedConditions.visibilityOf(AppandTools));//waiting till all apps visible	
		String cog= onecognizant.getText();	//one cognizant app text
		Assert.assertEquals(cog, "OneCognizant", "One Cognizant is present");//checking whether one cognizant is present or not
		onecognizant.click();//clicking on one cognizant
		System.out.println(cog + " is present");
	}
	
	
	//navigating to one cognizant page and verifying the page
	public void redirectonecognizant() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));//implicit wait
		this.driver = switchDriver(driver);//swithcing the driver from be cognizant page to one cognizant page
		String asd= driver.getTitle();//storing the one cognizant page title
		Assert.assertEquals(asd, "OneCognizant", "Redirected to one cognizant page");//checing whether one cognizant page is present or not
	}
	
	
	//clicking on the timesheet
	public void clickSubmitTimesheet() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(sendingkey));
		sendingkey.sendKeys("submittimesheet");//sending the submit timesheet key in the search button
		wait.until(ExpectedConditions.visibilityOf(submittimesheet));
	    submittimesheet.click();//Clicking on submit timesheet
	    Thread.sleep(5000);	
	}

	
	//Verifying timesheet page there or not
	public void verifyingtimesheetpage() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Thread.sleep(6000);
		this.driver = switchDriver(driver);//switching the driver from one cognizant page to timesheet page
		String a= driver.getTitle();//getting the title of timesheet page
		Assert.assertEquals(a, "Timesheet Landing Component", "User is on the timesheet page");//checking whether redirected to timesheet page or not
	}

	
	//Verifying the last 3 weeks timesheet displayed or not
	public void verifying3weektimesheet() throws InterruptedException, IOException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfAllElements(date1));
		List<WebElement> dat = date1;//storing all the timesheets into list
		int c=0;
		int d=1;
		for(int i=0;i<3;i++) {
			String d1 =dat.get(i).getText();//geting text of timesheets
			String givenStartDate = d1.substring(0,11);//by using sub string we can get start date of timesheet
			String givenEndDate = d1.substring(15,26);//by using sub string we can get start date of timesheet
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");//for changing the date format into simple date format 
			try {
				Date startDate = sdf.parse(givenStartDate);//changing the start date into simple date format
				Date endDate = sdf.parse(givenEndDate);//changing the end date into simple date format
				Calendar startCalendar = Calendar.getInstance();//getting the instance of calander
				startCalendar.setTime(startDate);//getting the day
				Calendar endCalendar = Calendar.getInstance();//getting the instance of calander
				endCalendar.setTime(endDate);//getting the day
				if (startCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY && endCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY)
				//checking the start day and end day with friday and saturday
				{
					System.out.println("week "+i+1+" timesheet is verified" );
					excel.setCellData(File, "Sheet6", c, 0, "week "+d+" timesheet is verified");//sending data into excel
					excel.fillGreenColor(File,"Sheet6",c,0);//excel
					d+=1;
					c+=1;
				} else {
					System.out.println("week "+i +" timesheet is not verified" );
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		Assert.assertEquals(c, 3);//validating whether all last 3 weeks is verified or not
     }

	
	//Verifying searchby field is displayed or not
	public void verifyingsearchby() {
		String q= searchby.getText();//getting text of search by field
		Assert.assertEquals(q, "Search By");//verifying the search by field
		System.out.println("Search By is displayed");
	}
	
	
	
	//Verifying date field is there or not and clicking on current date
	public void clickondate() throws InterruptedException {		
		selectby.click();//clicking on the select by
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"CTS_TS_LAND_WRK_CTS_TS_SEARCH\"]/option[2]"))));
		Select scm = new Select(selectby);//select class for select by field
		String q= "Date";
		scm.selectByVisibleText(q);//selecting the date option from the select by field
		dateoption.click();//clicking on the date option
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("clndrtitle"))));//waiting till the date field is visible
		String u=datefield.getText();//stroing the text of date field
		Assert.assertEquals(u, "Date");//verifying whether date field is displayed or not
		System.out.println("Date Field is displayed");
		currentdate.click();//clicking on current date
		search.click();//clicing on search
	}
	
	
	
	//now checking current week timesheet 
	public void checkthisweektimesheet() throws InterruptedException {
		int m=0;
		wait.until(ExpectedConditions.visibilityOf(todaytimesheet));
		Thread.sleep(3000);
		String e = todaytimesheet.getText();//geting the text of current week timesheet
		Thread.sleep(3000);
		wait.until(ExpectedConditions.textToBePresentInElement(todaytimesheet,e));
		String givenStartDate = e.substring(0,11);//start date
		String givenEndDate = e.substring(15,26);//end date
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");//changing the date format
		try {
			Date startDate = sdf.parse(givenStartDate);//changing the date format
			Date endDate = sdf.parse(givenEndDate);//changing the date format
			Calendar startCalendar = Calendar.getInstance();//getting the instance of date
			startCalendar.setTime(startDate);//getting the day
			Calendar endCalendar = Calendar.getInstance();//getting the instance of date
			endCalendar.setTime(endDate);//getting the day
			if (startCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY && endCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY)
			//checking the current week timesheet 
			{
				System.out.println(" timesheet is verified" );
				m+=1;
			} else {
				System.out.println(" timesheet is not verified");
			}
		} catch (ParseException q) {
			q.printStackTrace();
		}
		Assert.assertEquals(m,1);//validating whether timesheet is verified or not
	}
	
	
	//verifying all the status dropdown list	
	public void verifyingallstatus() throws InterruptedException, IOException {
		Thread.sleep(5000);
		int z=0;
		int p=0;
		excel.setCellData(File, "Sheet5", z, 0, "Status");//excel					
		excel.setCellData(File, "Sheet5", z, 1, "Results");//excel
		excel.fillRedColor(File,"Sheet5",z,0);//excel
		excel.fillRedColor(File,"Sheet5",z,1);//excel
		z+=1;
		wait.until(ExpectedConditions.elementToBeClickable(refresh));
		refresh.click();//clicking on refresh
		wait.until(ExpectedConditions.elementToBeClickable(refresh));
		Thread.sleep(5000);
		Select scm = new Select(selectby);//select class for selectby field
		scm.selectByIndex(2);//selecting the status 
		Select status = new Select(status1);//select class for status
		int size = status.getOptions().size();//size of the status field options
		int o=0;
		for(int i=1;i<size;i++) {
			Thread.sleep(5000);
			scm = new Select(selectby);
			scm.selectByIndex(2);//selecting the status
			status = new Select(status1);//select class for status
			status.selectByIndex(i);//selecting the option 
			String text =status.getFirstSelectedOption().getText();//text of the option
			System.out.println(text);
			Thread.sleep(5000);
			search.click();//clicking on search
			Thread.sleep(5000);
				try
				{
					popup.click();//if pop up is there it will be clicked in this block
					excel.setCellData(File, "Sheet5", z, 0, text);//excel
					excel.setCellData(File, "Sheet5", z, 1, "No Results found");//excel
					excel.fillGreenColor(File,"Sheet5",z,0);//excel
					excel.fillGreenColor(File,"Sheet5",z,1);//excel
					z+=1;
				}
				catch(Exception e)
				{
				}			
				List<WebElement> l = title;//storing all the timesheets for the given option into list
				int c=0;
				for(int k = 0;k<l.size();k++)
				{
					
					if((l.get(k).getText()).equals(text))
						//checking the option is mathched with text or not 
					{
						System.out.println("Passed: "+l.get(k).getText());
						c+=1;
						
					}
					else if((l.get(k).getText().equals("Not Submitted") || l.get(k).getText().equals("Pending")))
					{
						System.out.println("Passed: "+l.get(k).getText());
						excel.setCellData(File, "Sheet5", z, 0, text);					
						excel.setCellData(File, "Sheet5", z, 1, "Passed");
						excel.fillGreenColor(File,"Sheet5",z,0);
						excel.fillGreenColor(File,"Sheet5",z,1);
						z+=1;
						c=+1;
					}
					else
						System.out.println("failed: "+l.get(k).getText()+"No results found");
						
				}
				if(c==l.size()){
				excel.setCellData(File, "Sheet5", z, 0, text);//excel				
				excel.setCellData(File, "Sheet5", z, 1, "Passed");//excel
				excel.fillGreenColor(File,"Sheet5",z,0);//excel
				excel.fillGreenColor(File,"Sheet5",z,1);//excel
				z+=1;
				}
			o+=1;
			refresh.click();//clicking on refresh
			wait.until(ExpectedConditions.elementToBeClickable(refresh));
		}
		Assert.assertEquals(size-1, o);//validating all options are verified or not
		
	}
	
	
	}

