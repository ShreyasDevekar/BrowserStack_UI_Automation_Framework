package pageEvents;

import java.util.StringTokenizer;

import pageObjects.CartPageElements;
import utils.Actions;
import utils.ReportGeneration;

public class CartPageEvents extends Actions
{
	/* Description : This method returns the details of product present in cart.
	 * Created By: Shreyas Devekar
	 */
	
	public String getCartProductDetails() 
	{
		String cartProductDetails = getElementText("xpath",CartPageElements.productDescriptionInCart);
		attachScreenshots("Fetching product details present in a cart");
		return cartProductDetails;
	}
	
	/* Description: This method compares details of selected product and product present in cart. 
	 * Created By: Shreyas Devekar
	 * Parameters : selectedProductDetails - details of product selected to add in cart.
	 *              cartProductDetails - details of product present in cart.
	 */
	
	public void compareProductDetails(String selectedProductDetails,String cartProductDetails) 
	{
		StringTokenizer st=new StringTokenizer(cartProductDetails, "...");
		attachScreenshots("Validating the selected product and cart product for checkout is same");
		if(selectedProductDetails.contains(st.nextToken()))
		{
			ReportGeneration.logger.info("The product Details are matched");
		}
		else
		{
			ReportGeneration.logger.info("The product Details are not matching");
		}
	}

}
