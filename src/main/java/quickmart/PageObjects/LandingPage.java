package quickmart.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public WebDriver driver;
	public ProductCatalogue productCatalogue;
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="userEmail")
	WebElement userEmail;
	
	@FindBy(id ="userPassword")
	WebElement userPassword;
	
	@FindBy(id ="login" )
	WebElement login;
	
	public ProductCatalogue LoginQuickMart(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
		productCatalogue=new ProductCatalogue(driver);
		return productCatalogue;
		
	}
	
	public void goToUrl() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}
