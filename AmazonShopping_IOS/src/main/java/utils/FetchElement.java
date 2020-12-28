package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import tests.BaseTest;

public class FetchElement 
{
	/* Description: This method returns android element based on its locator type and locator value. 
	 * Created By: Shreyas Devekar
	 * Parameters : locatorType - locator type of element.
	 *              locatorValue - locator value of element.
	 */
	
	public IOSElement getElement(String locatorType, String locatorValue)
	{
		if(locatorType.equalsIgnoreCase("id"))
		{
			return BaseTest.driver.findElement(By.id(locatorValue));
		}
		else if(locatorType.equalsIgnoreCase("xpath"))
		{
			return BaseTest.driver.findElement(By.xpath(locatorValue));
		}
		else if(locatorType.equalsIgnoreCase("className"))
		{
			return BaseTest.driver.findElement(By.className(locatorValue));
		}
		else
		{
			return null;
		}
		
	}
	
	/* Description: This method returns android elements based on its locator type and locator value.
	 * Created By: Shreyas Devekar 
	 * Parameters : locatorType - locator type of element.
	 *              locatorValue - locator value of element.
	 */
	
	public List<IOSElement> getElements(String locatorType, String locatorValue)
	{
		if(locatorType.equalsIgnoreCase("id"))
		{
			return BaseTest.driver.findElements(By.id(locatorValue));
		}
		else if(locatorType.equalsIgnoreCase("xpath"))
		{
			return BaseTest.driver.findElements(By.xpath(locatorValue));
		}
		else if(locatorType.equalsIgnoreCase("className"))
		{
			return BaseTest.driver.findElements(By.className(locatorValue));
		}
		else
		{
			return null;
		}
	}
	
	/* Description: This method returns selector to fetch android element.
	 * Created By: Shreyas Devekar 
	 * Parameters : locatorType - locator type of element.
	 *              locatorValue - locator value of element.
	 */
	
	public By getBySelector(String locatorType, String locatorValue)
	{
		if(locatorType.equalsIgnoreCase("id"))
		{
			return By.id(locatorValue);
		}
		else if(locatorType.equalsIgnoreCase("xpath"))
		{
			return By.xpath(locatorValue);
		}
		else if(locatorType.equalsIgnoreCase("className"))
		{
			return By.className(locatorValue);
		}
		else
		{
			return null;
		}
	}

}
