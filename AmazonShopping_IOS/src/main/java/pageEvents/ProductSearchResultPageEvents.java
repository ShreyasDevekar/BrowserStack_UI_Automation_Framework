package pageEvents;

import pageObjects.ProductSearchResultPageElements;
import utils.Actions;

public class ProductSearchResultPageEvents extends Actions
{
	/* Description: This method selects random product from search results.
	 * Created By: Shreyas Devekar
	 */
	
	public void selectRandomProductFromSearchResults()
	{
		waitUntilElementIsClickable("xpath", ProductSearchResultPageElements.searchProductResult_xpath);
		attachScreenshots("Selecting product from search results");
		click("xpath", ProductSearchResultPageElements.searchProductResult_xpath);
	}

}
