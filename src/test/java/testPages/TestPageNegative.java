package testPages;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentTest;

import Pages.BillingInfoPage;
import Pages.CellPage;
import Pages.CheckoutAsGuestPage;
import Pages.CompletedOrderPage;
import Pages.HomePage;
import Pages.NokiaCellPage;
import Pages.OrderConfirmationPage;
import Pages.PaymentInfoPage;
import Pages.PaymentMethodPage;
import Pages.ShippingMethodPage;
import Pages.ShopCartPage;
import Pages.BaseClass;

public class TestPageNegative extends BaseClass{
	private HomePage hp;
	private BillingInfoPage bip;
	private CellPage cp;
	private CheckoutAsGuestPage cogp;
	private NokiaCellPage ncp;
	private ShippingMethodPage shmp;
	private PaymentMethodPage pmp;
	private PaymentInfoPage pip;
	private ShopCartPage shcp;
	private OrderConfirmationPage ocp;
	private CompletedOrderPage cop;	
	public static Logger log;
	public ExtentTest test;
	private Properties props;
	//private static String base_url = "http://demo.nopcommerce.com/";
	//private static String browser = "chrome";	
	//private static String browser = "firefox";
	
	
	@BeforeTest    
    public void baseSetup() throws InterruptedException { 
        // Configure Log4j with the log4j.properties file
        PropertyConfigurator.configure("src/test/resources/logs/log4j.properties");        
        log = Logger.getLogger(TestPage.class.getName());   
        log.info("Setting up the browser for the test");                    
        try {
			props = propFileReader();
		} catch (IOException e) {
			e.printStackTrace();
		} 
        //baseSetup(props.getProperty("browser"), props.getProperty("base_url")); //option with 2 parameters (browser, base_url)
        baseSetup(props.getProperty("browser")); //option with 1 parameter (browser)
        if (getDriver() != null) {   
            getDriver().get(props.getProperty("base_url"));  
            hp = new HomePage(getDriver());
            Assert.assertNotNull(hp, "ERROR!! nopCommerce home page is NOT launched");
            //Assert.assertNotNull(null, "ERROR!! nopCommerce home page is NOT launched"); //for negative tests TestPageNegative
            log.info("nopCommerce home page is launched successfully!");
        } else {
            log.error("Unable to set up the browser for the test");
        }
	}	   
	
	                //method for propFileReader inside the test page
	    /*public static Properties propFileReader() throws IOException {
	        Properties props = new Properties();
	        String propfile = System.getProperty("user.dir") + "/src/test/resources/logs/nopcommerce1.properties";
	        FileReader reader = new FileReader(propfile);
	        props.load(reader);
			return props;
	        
	    }  */
	
	/*@BeforeTest   //without properties file
	public void baseSetup() throws InterruptedException, IOException  { 	
		// Configure Log4j with the log4j.properties file
        PropertyConfigurator.configure("src/test/resources/logs/log4j.properties");
        
        log = Logger.getLogger(TestPage.class.getName());
        log.info("setting up the browser for the test");
        
    	baseSetup(browser, base_url);  //option with 2 parameters (browser, base_url)
    	//baseSetup(browser);  //option with one parameter (browser)
    	getDriver().get(base_url); 
    	hp = new HomePage(getDriver());
    	Assert.assertNotNull(hp, "home page is not displayed");
    	log.info("assert has been executed and failed");
    	log.info("nopcommerce application launch was successful!");
    	
    	}  	*/
    	  	
    			   
	@Test(priority=1)
	public void HooverCellPhoneLink() {
    	log.info("HooverCellPhoneLink test started");
		cp=hp.CellphoneLinkClick();			
		log.info(getDriver().getTitle());
	log.info(getDriver().getCurrentUrl());
		if (getDriver().getTitle().equalsIgnoreCase("nopCommerce demo store. Cell phones")) {
			Assert.assertNotNull(cp,"ERROR !! nopCommerce Cellphone page is NOT launched!");
			//Assert.assertNotNull(null,"ERROR !! nopCommerce Cellphone page is NOT launched!");
			log.info("nopCommerce Cellphone page is launched successfully!");
		}else {
			log.info("nopCommerce page Title is not Cellphone.Investigate further!");
		}    
						
	}  
	    
	@Test(priority=2)	
	public void CellphoneSelect() throws InterruptedException {
		log.info("CellphoneSelect test started");
		ncp= cp.NokiapicClick();
		Assert.assertNotNull(ncp,"Nokia cell page link click failure!");
		//Assert.assertNotNull(null,"Nokia cell page link click failure!");
		log.info("Nokia cell page is loaded");
		
	} 
		
	@Test(priority=3)	
	public void AddToCart() throws InterruptedException {	
		log.info("AddToCart test started");
		shcp = ncp.AddToCart();
		Assert.assertNotNull(shcp,"shopping cart link click failure!");
		log.info("shopping cart page is loaded");
		
	}  
	
	/*@Test(priority=4)
	public void ShopCart() throws InterruptedException {	
	    log.info("ShopCart test started");
		String totalboxText = shcp.getTotalboxText();
		log.info("Shopping Cart Total: " + totalboxText);			
		cogp = shcp.ShopCart();
		Assert.assertNotNull(cogp,"checkout as guest page link click failure!");
		log.info("checkout as guest page page is loaded");
		
	} 
			
	@Test(priority=5)
	public void CheckOutAsGuest() {
		log.info("CheckOutAsGuest test started");
		bip = cogp.CheckOutAsGuest();
		Assert.assertNotNull(bip,"billing information page link click failure!");
		log.info("billing information page is loaded");
		
	}
	
	@Test(priority=6)
	public void  BillingInfo() {
		log.info("BillingInfo test started");
		shmp = bip.DataInput();
		Assert.assertNotNull(shmp,"shipping method page link click failure!");
		log.info("shipping method page is loaded");		
	
	}
	
	@Test(priority=7)
	public void ShipmentMethod()  {
		log.info("ShipmentMethod test started");
		pmp = shmp.NextDayAir();
		Assert.assertNotNull(pmp,"payment method page link click failure!");
		log.info("payment method page is loaded");
		
	}
	
	@Test(priority=8)
	public void PaymentMethod() throws InterruptedException  {
		log.info("PaymentMethod test started");
		pip = pmp.MoneyOrder();
		Assert.assertNotNull(pip,"payment info page link click failure!");
		log.info("payment info page is loaded");
		
	}
	
	@Test(priority=9)
	public void PaymentInfo() throws InterruptedException  {
		log.info("PaymentInfo test started");
		ocp = pip.PaymentInfo();
		Assert.assertNotNull(ocp,"order confirmation page link click failure!");
		log.info("order confirmation page is loaded");
		
	}
	
	@Test(priority=10)
	public void OrderConfirmation() throws InterruptedException  {
		log.info("OrderConfirmation test started");
		cop = ocp.OrderConfirmed();
		//getDriver().navigate().refresh();
		Assert.assertNotNull(cop,"completed order page link click failure!");
		log.info("completed order page is loaded");
		
	}
	
	@Test(priority=11)
	public void CompletedOrder() throws InterruptedException  {
		log.info("CompletedOrder test started");
		hp = cop.CompletedOrder();
		Assert.assertNotNull(hp,"home page link click failure!");
		log.info("home page is loaded");
		
	}  
	
	@AfterTest
    public void afterTest() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().quit();
        log.info("Browser closed");
        
    }    */
	
				
}    
	
	
	


	
