package testRunner;


import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
					features= {".\\src\\test\\resources\\FeatureFiles\\accountValidation.feature",".\\src\\test\\resources\\FeatureFiles\\timesheetValidation.feature"},
					glue="stepDefinitions",
					
					plugin= {"pretty", "html:reports/myreport.html", 
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							},
							monochrome=true,    // to avoid junk characters in output
							publish=true   // to publish report in cucumber server
							
					)

public class TestRunner extends AbstractTestNGCucumberTests { 
		
}
