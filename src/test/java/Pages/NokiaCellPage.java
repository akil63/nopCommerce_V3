package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NokiaCellPage {
	private WebDriver driver;
	
	@FindBy(xpath="//button[@id='add-to-cart-button-20']")
	 private WebElement addtocartbtn;
	
   @FindBy(xpath="//span[@class='cart-label']")   	
	 private WebElement shopcartbtn; 
	
   public NokiaCellPage(WebDriver driver) {
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
	   
   }
   
   
   
   public ShopCartPage AddToCart() throws InterruptedException {	
	   addtocartbtn.click();
	   Thread.sleep(7000);
	   shopcartbtn.click();
	   Thread.sleep(5000);   
	   return new ShopCartPage(driver);
		
	}

}



