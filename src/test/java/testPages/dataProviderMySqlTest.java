package testPages;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.BaseClass;
import Pages.HomePage;

import Utilities.mySqlConnect;

public class dataProviderMySqlTest extends BaseClass{
	private HomePage hp;
		
	@DataProvider
	public Object[][] mySqlReadData() throws ClassNotFoundException, SQLException {
		
		Object[][] data = mySqlConnect.getMySqlData();
		return data;
	}
	
	@Test(dataProvider = "mySqlReadData")
	public void setUpTest(String browser,String url) throws InterruptedException {
		baseSetup(browser);
		getDriver().get(url);
		hp = new HomePage(getDriver());
		Assert.assertNotNull(hp,"ERROR: nopCommerce homepage is not launched!");
		tearDown();
	}

}
