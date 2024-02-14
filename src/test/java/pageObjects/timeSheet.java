package pageObjects;

import java.text.ParseException;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
public class timeSheet extends BasePage {
	
	public timeSheet(WebDriver driver) {
        super(driver);
    }
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));

    // Elements declaration
    @FindBy(id = "CTS_TS_LAND_WRK_CTS_TS_SEARCH")
    WebElement selectby;
    
    @FindBy(id = "CTS_TS_LAND_WRK_DATE")
    WebElement date;

    @FindBy(id = "CTS_TS_LAND_WRK_SEARCH")
    WebElement search;
    
    @FindBy(id = "CTS_TS_LAND_WRK_PB_CLEAR")
    WebElement refreshpage;
    
    @FindBy(xpath="//div[@class='ps_box-link timesheet_period']")
    List<WebElement> date1;
    
    @FindBy(id = "CTS_TS_LAND_WRK_CTS_TS_LAND_STATUS")
    WebElement sts;
    
    @FindBy(xpath="//*[@class='ps_box-group psc_layout timesheet_period_group_box']/div[2]/span")
    List<WebElement> title;
    
    @FindBy(id = "#ICOK")
    WebElement popup;
    
    @FindBy(xpath = "//div[text()='Submit Timesheet']")
    WebElement submitTimesheet;
    

    public void assertElementDisplayed(WebElement element, String errorMessage) {
        Assert.assertTrue(element.isDisplayed(), errorMessage);
    }
    
    public void validateCurrentDate() throws InterruptedException {
    	 assertElementDisplayed(selectby, "Select By element is not displayed");
         selectby.click();
         Select scm = new Select(selectby);
         String q = "Date";
         scm.selectByVisibleText(q);
         LocalDate currentDate = LocalDate.now();
         DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
         String formatteddate=currentDate.format(formatter);
         date.sendKeys(formatteddate);        
         search.click();
    }
    
    public void refreshpage() throws InterruptedException {
        Thread.sleep(5000);
        refreshpage.click();
        Thread.sleep(5000);
    }
    
    public String navigatetotimesheet() throws InterruptedException {
    	 Set<String> id = new HashSet<String>();
         id = driver.getWindowHandles();
         List<String> list = new ArrayList<String>(id);
         String parent = list.get(0);
         String child = list.get(1);
         driver.switchTo().window(child);
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("arguments[0].scrollIntoView();", submitTimesheet);
         js.executeScript("arguments[0].click();", submitTimesheet);
         Thread.sleep(5000);
         
         Set<String> id1 = new HashSet<String>();
         id1 = driver.getWindowHandles();
         List<String> m = new ArrayList<String>(id1);
         String d = m.get(2);
         driver.switchTo().window(d);
         Thread.sleep(2000);
         String title = driver.getTitle();
         System.out.println(title);
         return title;

    }
    
public void verifyWeekDates() {
        assert date1 != null : "date1 list must not be null";
        assert date1.size() >= 3 : "date1 list must contain at least 3 elements";
          for(int i = 0; i < 3; i++) {
                System.out.println(date1.get(i).getText());
                String d1 = date1.get(i).getText();
                String givenStartDate = d1.substring(0, 11);
                String givenEndDate = d1.substring(15, 26);
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
                try {
               	 Date startDate = sdf.parse(givenStartDate);
               	 Date endDate = sdf.parse(givenEndDate);
               	 // Check if start date is Saturday
               	 Calendar startCalendar = Calendar.getInstance();
               	 startCalendar.setTime(startDate);
               	 if (startCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
               	 System.out.println("Start date is a Saturday");
               	 } else {
               	 System.out.println("Start date is not a Saturday");
               	 }
               	 // Check if end date is Friday
               	 Calendar endCalendar = Calendar.getInstance();
               	 endCalendar.setTime(endDate);
               	 if (endCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
               	 System.out.println("End date is a Friday");
               	 } else {
               	 System.out.println("End date is not a Friday");
               	 }
               	 // Check if start and end together form a complete week
               	 if (startCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY && endCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
               	 System.out.println("Start and end together form a complete week");
               	 } else {
               	 System.out.println("Start and end do not form a complete week");
               	 }
               	 } catch (ParseException e) {
               	 e.printStackTrace();
               	 }
               	 }
               	}
    
    public void statusVerification() throws InterruptedException {

    		Thread.sleep(5000);
    		int g=0;
    		int z=0;
    		int p=0;
//    		excel.setCellData(File, "Sheet1", z, 0, "Status");					
//    		excel.setCellData(File, "Sheet1", z, 1, "Results");	
    		z+=1;
    		wait.until(ExpectedConditions.elementToBeClickable(refreshpage));
    		refreshpage.click();
    		wait.until(ExpectedConditions.elementToBeClickable(refreshpage));
    		Thread.sleep(5000);
    		selectby.click();		
    		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"CTS_TS_LAND_WRK_CTS_TS_SEARCH\"]/option[2]"))));
    		Select scm = new Select(selectby);
    		scm.selectByIndex(2);
    		Select status = new Select(sts);
    		int size = status.getOptions().size();
    		for(int i=1;i<size;i++) {
    			Thread.sleep(5000);
    			scm = new Select(selectby);
    			scm.selectByIndex(2);
    			status = new Select(sts);
    			status.selectByIndex(i);
    			String text =status.getFirstSelectedOption().getText();
    			//wait.until(ExpectedConditions.textToBePresentInElement((WebElement) status,text));
    			Thread.sleep(5000);
    			search.click();
//    			wait.until(ExpectedConditions.elementToBeClickable(search));
    			Thread.sleep(5000);
    				try
    				{
    					//explicitClickableElementWait(ok);
    					popup.click();
//    					excel.setCellData(File, "Sheet1", z, 0, text);
//    					excel.setCellData(File, "Sheet1", z, 1, "No Results found Passed");
    					g+=1;
    					z+=1;
    				}
    				catch(Exception e)
    				{
    				}			
    				List<WebElement> l = title;
    				int c=0;
    				for(int k = 0;k<l.size();k++)
    				{
    					if((l.get(k).getText()).equals(text))
    					{
    						System.out.println("Passed: "+l.get(k).getText());
    						String a = "Passed: "+ l.get(k).getText();
//    						excel.setCellData(File, "Sheet1", k, i, a);
//    						c+=1;
    					}
    					else if((l.get(k).getText().equals("Not Submitted")) && (text.equals("Pending")))
    					{
    						System.out.println("Passed: "+l.get(k).getText());
    						String b="Passed: "+l.get(k).getText();
//    						excel.setCellData(File, "Sheet1", k, i, b);
//    						c=+1;
    					}
    					else
    						System.out.println("failed: "+l.get(k).getText()+"No results found");
    						String u= "failed: "+l.get(k).getText()+"No results found";
//    						excel.setCellData(File, "Sheet1", k, i,u);
//    						c=+1;
    				}
//    				if(c==l.size()){
//    				excel.setCellData(File, "Sheet1", z, 0, text);					
//    				excel.setCellData(File, "Sheet1", z, 1, "Passed");				
//    				g+=1;
//    				z+=1;
//    				}
//    				else{
//    					excel.setCellData(File, "Sheet1", z, 0, text);					
//    					excel.setCellData(File, "Sheet1", z, 1, "Failed");				
//    					g+=1;
//    					z+=1;
//    					}
        			Thread.sleep(5000);
    				refreshpage.click();
    			wait.until(ExpectedConditions.elementToBeClickable(refreshpage));
     
    		}
    	}}

