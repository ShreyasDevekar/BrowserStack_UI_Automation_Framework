package pageEvents;

import pageObjects.HomePageElements;
import utils.Actions;
import utils.Constants;
import utils.ExcelUtils;

public class HomePageEvents extends Actions
{
	 // creation of ExcelUtils object to take test data from excel file.
	
	ExcelUtils excelData = new ExcelUtils(Constants.testDataFilePath,Constants.sheetName);

	/* Description: This method takes product to search in application.
	 * Created By: Shreyas Devekar 
	 */
	  
	public void searchProduct() 
	{
		waitForElementToBeVisible("xpath", HomePageElements.searchProduct);
		inputString("xpath", HomePageElements.searchProduct,excelData.getStringCellData(1,1));
		click("xpath",HomePageElements.searchProductButton);
		attachScreenshots("Searching product");
		
	}
}
