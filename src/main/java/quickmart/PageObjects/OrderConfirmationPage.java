package quickmart.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import quickmart.AbstractComponent.AbstractComponent;

public class OrderConfirmationPage extends AbstractComponent{

	public WebDriver driver;
	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css = ".hero-primary")
	WebElement conifrmMsg;
	
	public String getConirmationMessage(){
		String confirmMessage=conifrmMsg.getText();
		return confirmMessage;
	}
}
