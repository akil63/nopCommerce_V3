package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutAsGuestPage {
	private WebDriver driver;
	
	@FindBy(xpath="//button[normalize-space()='Checkout as Guest']")
	private WebElement checkOutAsGuestBtn;
	
	public CheckoutAsGuestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
				   		   
	}		
	
	public BillingInfoPage CheckOutAsGuest() {		
		checkOutAsGuestBtn.click();
	    return new BillingInfoPage(driver);
		    		     
	}
	

}
