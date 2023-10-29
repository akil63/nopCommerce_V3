package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingMethodPage {
	private WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"shippingoption_1\"]")
	 WebElement nextdayair;
	
	@FindBy(xpath="//*[@id=\"shipping-method-buttons-container\"]/button")
	 WebElement continuebtn;
	
	
	
	
	public ShippingMethodPage(WebDriver driver) {
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
		   
	   }
	
	public PaymentMethodPage NextDayAir() {	
		nextdayair.click();		
		continuebtn.click();		
		return new PaymentMethodPage(driver);
		
		
	}
	
		

}



//*[@id="shippingoption_1"]  radio button next day air //*[@id="shippingoption_1"]
//*[@id="shipping-method-buttons-container"]/button   // continue-2 //*[@id="shipping-method-buttons-container"]/button



