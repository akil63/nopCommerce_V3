package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	
	@FindBy(xpath="//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']")
	private WebElement electronicsLink;
	
	@FindBy(xpath="//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']")
	private WebElement cellphoneLink;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
		
	}
	
	public CellPage CellphoneLinkClick() {
		Actions action = new Actions(driver);
		action.moveToElement(electronicsLink).pause(3000)		 		      
		      .moveToElement(cellphoneLink).pause(3000)
		      .click().pause(3000)
		      .perform();
		return new CellPage(driver);
		
	}
	
	
}

