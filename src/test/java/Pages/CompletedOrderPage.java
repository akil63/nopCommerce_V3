package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletedOrderPage  {
	private WebDriver driver;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	  WebElement continueButton;
						
	public  CompletedOrderPage(WebDriver driver) {
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
	
    }
	
	public HomePage CompletedOrder() throws InterruptedException {	
		continueButton.click();
		Thread.sleep(5000);
		
		return new HomePage(driver);
		
		
	} 
	
}


/*package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompletedOrderPage  {
	private WebDriver driver;
	
	//@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[3]/button")
	@FindBy(xpath="//button[normalize-space()='Continue']")
	//@FindBy(css = "button-1.order-completed-continue-button ")
	//@FindBy(css = "body > div.master-wrapper-page > div.master-wrapper-content > div > div > div > div.page-body.checkout-data > div > div.buttons > button\r\n"
			//+ " ")
	  WebElement continueButton;
					
	
	public  CompletedOrderPage(WebDriver driver) {
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
	
    }
	
	public HomePage CompletedOrder() throws InterruptedException {	
		Thread.sleep(10000);
		continueButton.click();
		Thread.sleep(5000);
		
		return new HomePage(driver);
		
		
	} 
	
	/*public HomePage CompletedOrder() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
        Thread.sleep(5000);

        return new HomePage(driver);
    }  */
	
	






	
	/*public HomePage CompletedOrder() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
        Thread.sleep(5000);

        return new HomePage(driver);
    }  */
	
	


//button[normalize-space()='Continue'] //continue button on checkout completed page chrome

//   /html/body/div[6]/div[3]/div/div/div/div[2]/div/div[3]/button


//button[normalize-space()='Continue'] // relative xpath from ffox

//   /html/body/div[6]/div[3]/div/div/div/div[2]/div/div[3]/button //xpath from inspect ffox





//   .button-1.order-completed-continue-button // cssSelector

//body > div.master-wrapper-page > div.master-wrapper-content > div > div > div > div.page-body.checkout-data > div > div.buttons > button





//.button-1.order-completed-continue-button