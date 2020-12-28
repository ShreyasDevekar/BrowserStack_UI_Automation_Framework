package pageEvents;

import pageObjects.ProductPageElements;
import utils.Actions;

public class ProductPageEvents extends Actions
{
	/* Description: This method returns selected product details.
	 * Created By: Shreyas Devekar 
	 */
	
	public String getProductDetails() 
	{
		waitForElementToBeVisible("xpath", ProductPageElements.productDescription);
		attachScreenshots("Fetching product details");
		String description = getElementText("xpath",ProductPageElements.productDescription);
		attachScreenshots("Product Details fetch successfully");
		return description;
	}
	
	/* Description: This method adds selected product to cart.
	 * Created By: Shreyas Devekar
	 */
	
	public void addToCart() 
	{
		scrollAndClick("xpath", ProductPageElements.addToCartButton);
		attachScreenshots("Adding product into the cart");
	}
	
	/* Description: This method navigates to cart.
	 * Created By: Shreyas Devekar
	 */
	
	public void goToCart() 
	{
		attachScreenshots("Navigating to cart");
		click("xpath", ProductPageElements.goToCartButton);
	}
}


