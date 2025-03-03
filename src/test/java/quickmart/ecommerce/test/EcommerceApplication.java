package quickmart.ecommerce.test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import quickmart.PageObjects.CartPage;
import quickmart.PageObjects.CheckOutPage;
import quickmart.PageObjects.OrderConfirmationPage;
import quickmart.PageObjects.OrderPage;
import quickmart.PageObjects.ProductCatalogue;
import quickmart.ecommerce.TestComponent.BaseTest;
import quickmart.ecommerce.data.JsonDataReader;

public class EcommerceApplication extends BaseTest{
	public ProductCatalogue productCatalogue;
	
	@Test(dataProvider = "getData")
	public  void testEcommerceProject(HashMap<String, String> input) {
		
		productCatalogue=landingPage.LoginQuickMart(input.get("email"),input.get("password"));
		productCatalogue.getProductList();
		WebElement prod=productCatalogue.getProductNames(input.get("productName"));
		Assert.assertNotNull(prod, "Product: " + input.get("productName") + " is not available for Email id:"+input.get("email")+". Please Try adding new Product. Thank You!!");
		productCatalogue.addProductToCart(input.get("productName"));
		CartPage cartPage=productCatalogue.goToCartPage();
		
		boolean foundProdOnCart=cartPage.verifyAddedProductOnCartPage(input.get("productName"));
		Assert.assertTrue(foundProdOnCart);
		CheckOutPage checkoutPage=cartPage.goToCheckoutPage();
		checkoutPage.SelectCountry("Ind");
		OrderConfirmationPage orderConfirmPage=checkoutPage.goToConfirmationPage();
		String confirmMessage=orderConfirmPage.getConirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}
	
	@Test(dependsOnMethods = {"testEcommerceProject"})
	public void OrderHistory(){
		productCatalogue=landingPage.LoginQuickMart("ritesht@teleworm.us", "Ritesh@123");
    	OrderPage orderPage=productCatalogue.goToOrdersPage();
    	Assert.assertTrue(orderPage.VerifyOrder());
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException{
		
		List<HashMap<String, String>> map=JsonDataReader.readJsonToHashMap(System.getProperty("user.dir")+"\\src\\test\\java\\quickmart\\ecommerce\\data\\purchaseData.json");
		return new Object[][] {{map.get(0)},{map.get(1)}};
	}
}
