package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethodPage {
	private WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"shippingoption_1\"]")
	 WebElement moneyorder;
	
	@FindBy(xpath="//*[@id=\"payment-method-buttons-container\"]/button")
	 WebElement continuebtn;
	
	
	public PaymentMethodPage(WebDriver driver) {
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
	}
	
	public PaymentInfoPage MoneyOrder () throws InterruptedException {	
		moneyorder.click();	
		Thread.sleep(3000);
		continuebtn.click();	
		Thread.sleep(10000);
		return new PaymentInfoPage(driver);
		
	}

}



//*[@id="paymentmethod_0"] radiobutton payment

//*[@id="payment-method-buttons-container"]/button //continue1btn

//*[@id="payment-info-buttons-container"]/button  //continue2btn