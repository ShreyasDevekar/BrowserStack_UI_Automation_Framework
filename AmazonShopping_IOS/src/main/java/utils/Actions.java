package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import tests.BaseTest;

public class Actions extends FetchElement
{
	Properties prop = new Properties();
	WebDriverWait wait;
	public static int i=1;
	
	/* Description: This method waits until the element is enabled for clicking. 
	 * Created By: Shreyas Devekar
	 * Parameters : locatorType - locator type of element.
	 *              locatorValue - locator value of element.
	 */
	
	public void waitUntilElementIsClickable(String locatorType, String locatorValue)
	{
		try
		{
			wait=new WebDriverWait(BaseTest.driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(getBySelector(locatorType, locatorValue)));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ReportGeneration.logger.info("The element is not clickable");
			ReportGeneration.logger.info("Cause: "+e.getCause()+", "+"Message: "+e.getMessage());
			Assert.assertTrue(false);
		}

	}
	
	/* Description: This method waits until the element is visible. 
	 * Created By: Shreyas Devekar
	 * Parameters : locatorType - locator type of element.
	 *              locatorValue - locator value of element.
	 */
	
	public void waitForElementToBeVisible(String locatorType, String locatorValue)
	{
		try
		{
			wait=new WebDriverWait(BaseTest.driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(getBySelector(locatorType, locatorValue)));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ReportGeneration.logger.info("The element is not visible");
			ReportGeneration.logger.info("Cause: "+e.getCause()+", "+"Message: "+e.getMessage());
			Assert.assertTrue(false);
		}

	}
	
	/* Description: This method sends the string input to text field. 
	 * Created By: Shreyas Devekar
	 * Parameters : locatorType - locator type of element.
	 *              locatorValue - locator value of element.
	 *              value - input value.
	 */

	public void inputString(String locatorType, String locatorValue, String value)
	{
		try 
		{
			click(locatorType, locatorValue);
			getElement(locatorType, locatorValue).clear();
			getElement(locatorType, locatorValue).sendKeys(value);

		} 
		catch (Exception e)
		{
			e.printStackTrace();
			ReportGeneration.logger.info("Value unable to enter");
			ReportGeneration.logger.info("Cause: "+e.getCause()+", "+"Message: "+e.getMessage());
			Assert.assertTrue(false);
		}
	}
	
	/* Description: This method fetches the element text. 
	 * Created By: Shreyas Devekar
	 * Parameters : locatorType - locator type of element.
	 *              locatorValue - locator value of element.
	 */

	public String getElementText(String locatorType,String locatorValue)
	{
		try 
		{
			waitForElementToBeVisible(locatorType, locatorValue);
			String text = getElement(locatorType, locatorValue).getText();
			return text;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			ReportGeneration.logger.info("Element does not exist");
			ReportGeneration.logger.info("Cause: "+e.getCause()+", "+"Message: "+e.getMessage());
			Assert.assertTrue(false);
		}
		return null;
	}
	
	/* Description: This method validates that the one string contains another string or not. 
	 * Created By: Shreyas Devekar
	 * Parameters : str1 - 1st string value
	 *              str2 - 2nd string value.
	 */
	
	public boolean stringContains(String str1, String str2)
	{
		if(str1.contains(str2))
		{
			Assert.assertTrue(true);
			return true;
		}
		else
		{
			Assert.assertTrue(false);
			
		}
		return false;
	}
	
	
	/* Description: This methods scrolls down the screen till last element.
	 * Created By: Shreyas Devekar
	 */
	
	public static void scrollDown()
	{
		Dimension dimension = BaseTest.driver.manage().window().getSize();
		int scrollStart = (int) (dimension.getHeight() * 0.5);
		int scrollEnd = (int) (dimension.getHeight() * 0.2);

		new TouchAction((PerformsTouchActions) BaseTest.driver).press(PointOption.point(0,scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(0, scrollEnd)).release().perform();
	}
	
	/* Description: This method scrolls the screen till the required element is visible on screen. 
	 * Created By: Shreyas Devekar
	 * Parameters : locatorType - locator type of element.
	 *              locatorValue - locator value of element.
	 */
	
	public void scrollTillElementVisible(String locatorType, String locatorValue)
	{
		boolean status = isElementPresent(locatorType, locatorValue);
		int count = 0;
		while(!status && count<6)
		{
			scrollDown();
			status = isElementPresent(locatorType, locatorValue);
			count++;
			
		}
		
	}
	
	/* Description: This method scrolls screen till element is visible and clicks on it. 
	 * Created By: Shreyas Devekar
	 * Parameters : locatorType - locator type of element.
	 *              locatorValue - locator value of element.
	 */
	
	public void scrollAndClick(String locatorType, String locatorValue)
	{
		scrollTillElementVisible(locatorType, locatorValue);
		click(locatorType, locatorValue);
	}
	
	/* Description: This method returns true or false based on element is present or not. 
	 * Created By: Shreyas Devekar
	 * Parameters : locatorType - locator type of element.
	 *              locatorValue - locator value of element.
	 */
	
	public boolean isElementPresent(String locatorType, String locatorValue)
	{
		try 
		{
			if(getElement(locatorType, locatorValue)!=null)
			{
				return true;
			}
			else
			{
				return false;
			}	
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	/* Description: This method performs click operation. 
	 * Created By: Shreyas Devekar
	 * Parameters : locatorType - locator type of element.
	 *              locatorValue - locator value of element.
	 */
	
	public void click(String locatorType, String locatorValue)
	{
		try 
		{
			waitUntilElementIsClickable(locatorType, locatorValue);
			getElement(locatorType, locatorValue).click();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			ReportGeneration.logger.info("The element is not clickable");
			ReportGeneration.logger.info("Cause: "+e.getCause()+", "+"Message: "+e.getMessage());
			Assert.assertTrue(false);
		}	
	}
	
	/* Description: This method performs navigate to back action.
	 * Created By: Shreyas Devekar
	 */
	
	public void clickBackButton() 
	{
		BaseTest.driver.navigate().back(); 
	}
	
	/* Description: This method Captures Screenshot. 
	 * Created By: Shreyas Devekar
	 * Parameters : filePath - Destination file path for captured screenshot.
	 */
	
	public String captureScreenShot(String filePath)
	{
		File f = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
		String destinationPath = filePath;
		try 
		{
			FileUtils.copyFile(f,new File(filePath));
			return destinationPath;
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return destinationPath;
		
	}
	
	/* Description: This method attaches screenshot to that event log.
	 * Created By: Shreyas Devekar 
	 * Parameters : info - information of particular event.
	 */
	
	public void attachScreenshots(String info) 
	{
		String imageName = "Screenshot"+String.valueOf(Actions.i);
		MediaEntityModelProvider media = null;
		try 
		{
			media = MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(Constants.testEventSnips+imageName+".png")).build();
			ReportGeneration.logger.log(Status.INFO,info, media);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		Actions.i++;
	}
	
	/* Description: This method loads the property file. 
	 * Created By: Shreyas Devekar
	 * Parameters : propertyFilePath - property file path
	 */
	
	public Properties LoadProperties(String propertyFilePath) 
	{
		Properties prop = new Properties();
		try
		{
			FileInputStream inputFile = new FileInputStream(propertyFilePath);
			prop.load(inputFile);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		return prop;
	}
	
	/* Description: This method generates random value and passes to the element.
	 * Created By: Shreyas Devekar 
	 * Parameters : locatorType - locator type of element.
	 *              locatorValue - locator value of element.
	 */
	
	public void getRandomValue(String locatorType, String locatorValue)
	{
		try 
		{
			Random random = new Random();
			int randomValue = random.nextInt(getElements(locatorType, locatorValue).size());
			getElements(locatorType, locatorValue).get(randomValue).click();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			ReportGeneration.logger.info("Unable to select random value");
			Assert.assertTrue(false);
		}
		
	}

}
