package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CellPage {	
    private WebDriver driver;
    
    //@FindBy(xpath="//div[@class='picture']//img[@title='Show details for Nokia Lumia 1020']")
    @FindBy(xpath="//div[@class='picture']//img[@title='Show details for ']")
	private WebElement nokiapic;
	
	public CellPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
				 		  	
	public NokiaCellPage NokiapicClick() throws InterruptedException {			 
		nokiapic.click();
		Thread.sleep(3000);						
		return new NokiaCellPage(driver);		
		//nokiapic.getText();
	}
		
}     

	
