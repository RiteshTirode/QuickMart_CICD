package quickmart.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import quickmart.AbstractComponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{

	public WebDriver driver;
	public CartPage cartPage;
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	By waitForProdList=By.className("mb-3");
	@FindBy(className ="mb-3")
	List<WebElement> visibleProdList;
	public List<WebElement> getProductList(){
		waitUntilAllElementsAreVisible(waitForProdList);
		return visibleProdList;
	}
	
	public WebElement getProductNames(String productName2){
		WebElement productName=getProductList().stream().filter(s->s.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName2)).findFirst().orElse(null);
		return productName;
	}
	
	By addToCartButton=By.cssSelector(".btn.w-10.rounded");
	
	By toastMessage=By.id("toast-container");
	
	@FindBy(className ="ng-animating" )
	WebElement spinner;
	
	@FindBy(xpath ="//button[@routerlink='/dashboard/cart']" )
	WebElement cartIcon;
	
	
	public void addProductToCart(String productName) {
		getProductNames(productName).findElement(addToCartButton).click();
		waitUntilVisiblityOfElementLocated(toastMessage);
		waitUntilInvisibilityOfElement(spinner);
		
	}
	
	public CartPage goToCartPage() {
		cartIcon.click();
		cartPage=new CartPage(driver);
		return cartPage;
	}
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderLink;
	public OrderPage goToOrdersPage() {
		orderLink.click();
		OrderPage orderPage=new OrderPage(driver);
		return orderPage;
	}
	
	
}
