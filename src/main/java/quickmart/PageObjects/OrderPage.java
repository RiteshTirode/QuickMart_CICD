package quickmart.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import quickmart.AbstractComponent.AbstractComponent;

public class OrderPage extends AbstractComponent{

	public WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderPageElements;

	public boolean VerifyOrder() {
		boolean match=orderPageElements.stream().anyMatch(s->s.getText().equalsIgnoreCase("ZARA COAT 3"));
		return match;
	}
}
