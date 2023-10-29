package Pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BillingInfoPage {
	private WebDriver driver;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_FirstName']") 
	 WebElement firstnameinput;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_LastName']") 
	 WebElement lastnameinput;
	
	@FindBy(xpath="//*[@id=\"BillingNewAddress_Email\"]") 
	 WebElement emailinput;
	
	@FindBy(xpath="//select[@id='BillingNewAddress_CountryId']")
	 WebElement countryDropdown;
	
	
	@FindBy(xpath="//select[@id='BillingNewAddress_StateProvinceId']")
	 WebElement provinceDropdown;
		
	@FindBy(xpath="//input[@id='BillingNewAddress_City']") 
	 WebElement cityinput;
	
	@FindBy(xpath="	//input[@id='BillingNewAddress_Address1']") 
	 WebElement address1input;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_ZipPostalCode']") 
	 WebElement postalcodeinput;
			
	@FindBy(xpath="//input[@id='BillingNewAddress_PhoneNumber']") 
	 WebElement phonenumberinput;
	
	@FindBy(xpath="//*[@id=\"billing-buttons-container\"]/button[4]")
	 WebElement continuebtn;

	
	public BillingInfoPage(WebDriver driver) {
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
	}
	
	public ShippingMethodPage DataInput() {
		firstnameinput.sendKeys("Patric");
		lastnameinput.sendKeys("Roy");
		emailinput.sendKeys("patric23@gmail.com");		
		Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText("Canada");
        Select provinceSelect = new Select(provinceDropdown);
        provinceSelect.selectByVisibleText("Quebec");						
		cityinput.sendKeys("Montreal");
		address1input.sendKeys("25-2120 Tupper Street");
		postalcodeinput.sendKeys("H2B 2G5");
		phonenumberinput.sendKeys("(514)-797-5988");
		continuebtn.click();							    				
		return new ShippingMethodPage(driver);
						
	}

	
		
	
	
}	
	

	
	//input[@id='BillingNewAddress_City']
	
	//input[@id='BillingNewAddress_Address1']
	
	//input[@id='BillingNewAddress_ZipPostalCode']
	
	//input[@id='BillingNewAddress_PhoneNumber']
	
	//select[@id='BillingNewAddress_CountryId']

	//select[@id='BillingNewAddress_StateProvinceId']
	 
       //*[@id="billing-buttons-container"]/button[4]   //continue-1

//*[@id="BillingNewAddress_CountryId"]
//select[@id='BillingNewAddress_CountryId']  //countrydropbox

//select[@id='BillingNewAddress_StateProvinceId']   //provincedropbox
	
	
	
	
	
	
	
		   
	
		


