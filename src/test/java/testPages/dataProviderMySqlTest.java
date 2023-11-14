package testPages;

import java.sql.SQLException;

//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
//mport org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.BaseClass;
import Pages.HomePage;

import Utilities.mySqlConnect;

public class dataProviderMySqlTest extends BaseClass{
	//private WebDriver driver;  //do not need
	private HomePage hp;
		
	@DataProvider
	public Object[][] mySqlReadData() throws ClassNotFoundException, SQLException {
		
		Object[][] data = mySqlConnect.getMySqlData();
		return data;
	}
	
	@Test(dataProvider = "mySqlReadData")			
	public void setUpTest(String browser, String url, String dummy) throws InterruptedException {
	//public void setUpTest(String url, String browser, String dummy) throws InterruptedException {	
		baseSetup(browser);	// initialize the browser
		//driver = getDriver();  //do not need
		getDriver().get(url);// open the url    
		hp = new HomePage(getDriver());
		Assert.assertNotNull(hp,"ERROR: nopCommerce homepage is not launched!");
		System.out.println("assert has been executed and failed");
    	System.out.println("nopcommerce application launch was successful!");
		Thread.sleep(3000);	
        getDriver().quit();
		
	}

}
