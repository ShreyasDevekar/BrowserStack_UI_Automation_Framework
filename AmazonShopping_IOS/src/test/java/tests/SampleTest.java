package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import pageEvents.CartPageEvents;
import pageEvents.HomePageEvents;
import pageEvents.ProductPageEvents;
import pageEvents.ProductSearchResultPageEvents;
import utils.ReportGeneration;

public class SampleTest extends BaseTest
{
	/* Description: This test case validates that the selected product and product present in the cart are same or not.
	 * Created By: Shreyas Devekar 
	 */
	ReportGeneration report;
	@Test
	public void ValidatingCartProductDetails() throws IOException 
	{
		HomePageEvents homePage = new HomePageEvents();
		homePage.searchProduct();
		
		ProductSearchResultPageEvents searchResult = new ProductSearchResultPageEvents();
		searchResult.selectRandomProductFromSearchResults();
		
		ProductPageEvents productPage = new ProductPageEvents();
		String selectedProductDetails = productPage.getProductDetails();
		productPage.addToCart();		
		productPage.goToCart();
		
		CartPageEvents cartPage = new CartPageEvents();
		String cartProductDetails = cartPage.getCartProductDetails();
		cartPage.compareProductDetails(selectedProductDetails, cartProductDetails);
	}

}
