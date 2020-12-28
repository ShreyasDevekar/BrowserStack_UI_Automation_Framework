package tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import utils.Actions;
import utils.Constants;
import utils.ReportGeneration;

public class BaseTest extends Actions
{
	// Initializing Android driver,properties, and report utility object to generate reports
	Properties prop;
	public static IOSDriver<IOSElement> driver;
	ReportGeneration report = new ReportGeneration();
	
	/* Description: This method initializes android driver with android device capabilities
	 * Created By: Shreyas Devekar 
	 */
	
	public void setUpDriver()
	{
		DesiredCapabilities caps = new DesiredCapabilities();
        prop = LoadProperties(Constants.capabilityPath);
		caps.setCapability("browserName", prop.getProperty("browserName"));
		caps.setCapability("device", prop.getProperty("device"));
		caps.setCapability("realMobile", prop.getProperty("realMobile"));
		caps.setCapability("os_version", prop.getProperty("os_version"));
		caps.setCapability("name", prop.getProperty("name"));
		String URL = "https://" + prop.getProperty("USERNAME") + ":" + prop.getProperty("AUTOMATE_KEY") + "@hub-cloud.browserstack.com/wd/hub";
		try 
		{
			driver = new IOSDriver<IOSElement>(new URL(URL), caps);
		    driver.get("http://www.amazon.in");
		}
		catch (IOException e) 
		{	
			e.printStackTrace();
		}
	}
	
	/* Description: This method calls initializeReport to initialize the report.
	 * Created By: Shreyas Devekar 
	 */
	
	@BeforeTest
	public void beforeTestMethod()
	{
		report.initializeReports();
	}
	
	/* Description: This method calls createTestLogger to create test logs and starts driver with capabilities.
	 * Created By: Shreyas Devekar 
	 * Parameters : test method   
	 */
	
	@BeforeMethod
	public void setUp(Method testMethod)
	{
		report.createTestLogger(testMethod);
		setUpDriver();
	}
	
	/* Description: This method calls getTestResultReport to generate test execution result report.
	 * Created By: Shreyas Devekar 
	 * Parameters : test result   
	 */
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		report.getTestResultReport(result);
		driver.quit();
	}
	
	/* Description: This method calls writeTestLog method to write test log in reports.
	 * Created By: Shreyas Devekar 
	 */
	
	@AfterTest
	public void afterTestMethod()
	{
		report.writeTestLog();
	}
	

}
