package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopCartPage {	
    private WebDriver driver;
  
    //@FindBy(xpath="//span[@class='product-subtotal']")  //*[@id="shopping-cart-form"]/div[1]/table/tbody/tr/td[6]/span
    @FindBy(xpath="//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[6]/span")
	private WebElement totalbox; 
	                                
	@FindBy(xpath="//input[@id='termsofservice']")
	private WebElement checkBox;
	
	@FindBy(xpath="//button[@id='checkout']")   	
	private WebElement checkoutBtn;
	
	public ShopCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		   		   
	}
		   
    public String getTotalboxText() {   	
    	return totalbox.getText();
    	
    }	
    	          
    public CheckoutAsGuestPage ShopCart() throws InterruptedException {   
    	//Thread.sleep(7000);
    	//totalbox.getText();
    	checkBox.click();
   	    Thread.sleep(3000);
   	    checkoutBtn.click();
   	    Thread.sleep(3000);   	   
   	    return new CheckoutAsGuestPage(driver);
   		
    	
    	 
    }

	
}






					


