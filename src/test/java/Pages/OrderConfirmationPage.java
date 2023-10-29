package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
	private WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"confirm-order-buttons-container\"]/button")
	 WebElement confirmbtn;
					
	public OrderConfirmationPage(WebDriver driver) {
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
		   
	}
	
	public CompletedOrderPage OrderConfirmed() throws InterruptedException {		
		confirmbtn.click();
		Thread.sleep(3000);
		
		return new CompletedOrderPage(driver);
		
	}

}




