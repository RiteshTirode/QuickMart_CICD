package quickmart.AbstractComponent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

	public WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
	}

	public void waitUntilAllElementsAreVisible(By findBy) 
	{
		WebDriverWait webWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		webWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}
	
	public void waitUntilVisiblityOfElementLocated(By findBy)
	{
		WebDriverWait webWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		webWait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	
	public void waitUntilInvisibilityOfElement(WebElement webEle){
		WebDriverWait webWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		webWait.until(ExpectedConditions.invisibilityOf(webEle)); 
	}
	
	
	public void waitUntilvisibilityOfAllElements(List<WebElement> webEle) {
		WebDriverWait webWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		webWait.until(ExpectedConditions.visibilityOfAllElements(webEle));
	}
	
	public void waitUntilElementToBeClickable(By findBy){
		WebDriverWait webWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		webWait.until(ExpectedConditions.elementToBeClickable(findBy));

	}
}
