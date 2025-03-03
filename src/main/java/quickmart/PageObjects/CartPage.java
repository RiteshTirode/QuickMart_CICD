package quickmart.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import quickmart.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	public WebDriver driver;
	public CheckOutPage checkOutPage;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(css =".cartSection h3" )
	List<WebElement> cartProducts;
	
	public boolean verifyAddedProductOnCartPage(String productName){
		waitUntilvisibilityOfAllElements(cartProducts);
		boolean foundProdOnCart=cartProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		return foundProdOnCart;
	}
	
	
	By checkOutButton=By.xpath("//button[normalize-space()='Checkout']");
	public CheckOutPage goToCheckoutPage(){
		waitUntilElementToBeClickable(checkOutButton);
		driver.findElement(checkOutButton).click();
		checkOutPage=new CheckOutPage(driver);
		return checkOutPage;
	}
	
}
