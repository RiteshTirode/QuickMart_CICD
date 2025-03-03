package quickmart.ecommerce.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import quickmart.PageObjects.CartPage;
import quickmart.PageObjects.ProductCatalogue;
import quickmart.ecommerce.TestComponent.BaseTest;

public class ErrorValidation extends BaseTest{
	public ProductCatalogue productCatalogue;

	@Test(retryAnalyzer =quickmart.ecommerce.TestComponent.RetryAnalyser.class )
	 public void ProductErrorValidation() throws InterruptedException {
		productCatalogue=landingPage.LoginQuickMart("ritesht@teleworm.us","Ritesh@123");
		productCatalogue.getProductList();
		productCatalogue.getProductNames("ZARA COAT 3");
		productCatalogue.addProductToCart("ZARA COAT 3");
		CartPage cartPage=productCatalogue.goToCartPage();
		
		boolean foundProdOnCart=cartPage.verifyAddedProductOnCartPage("ZARA COAT 78");
		Assert.assertTrue(foundProdOnCart);
		System.out.println("Test");
	}
	

}
