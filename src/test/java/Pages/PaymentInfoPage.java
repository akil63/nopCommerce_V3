package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentInfoPage {
	private WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"payment-info-buttons-container\"]/button")
	 WebElement continuebtn;
	
	
	
	
	public PaymentInfoPage(WebDriver driver) {
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
		   
	}
	
	public OrderConfirmationPage PaymentInfo() throws InterruptedException {		
		continuebtn.click();	
		Thread.sleep(7000);
		
		return new OrderConfirmationPage(driver);
		
	}


}


//*[@id="payment-info-buttons-container"]/button