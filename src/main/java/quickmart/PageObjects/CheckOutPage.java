package quickmart.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import quickmart.AbstractComponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent{


	public WebDriver driver;
	public OrderConfirmationPage orderConfirmationPage;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	By selCountry=By.xpath("//input[@placeholder='Select Country']");
	By selectDropOption=By.cssSelector(".ng-star-inserted:nth-child(3)");
	By clickSubmitButtonOnCheckout=By.className("action__submit");
	public void SelectCountry(String country){
		driver.findElement(selCountry).sendKeys(country);
		waitUntilElementToBeClickable(selectDropOption);
		driver.findElement(selectDropOption).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000000)");
		
	}
	
	public OrderConfirmationPage goToConfirmationPage()
	{
		waitUntilElementToBeClickable(clickSubmitButtonOnCheckout);
		driver.findElement(clickSubmitButtonOnCheckout).click();
		OrderConfirmationPage orderConfirmationPage=new OrderConfirmationPage(driver);
		return orderConfirmationPage;
	}

	
}
