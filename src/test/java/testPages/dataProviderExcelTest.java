package testPages;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.BaseClass;
import Pages.HomePage;
import Utilities.excelDataRead;

public class dataProviderExcelTest extends BaseClass{
	private HomePage hp;
	
	@DataProvider
    public Object[][] readExcelData() throws InvalidFormatException {
        Object[][] inputData;
        excelDataRead excelReader = new excelDataRead();
        inputData = excelReader.getTestData("Sheet1");
        return inputData;
    }

    @Test(dataProvider = "readExcelData")
    public void openBrowserAndURL(String browser, String url) throws InterruptedException {
        baseSetup(browser); // Initialize the browser
        getDriver().get(url); // Open the URL       
        hp = new HomePage(getDriver());        
        Assert.assertNotNull(hp, "Home page is not displayed");
        System.out.println("assert has been executed and failed");
    	System.out.println("nopcommerce application launch was successful!");

        Thread.sleep(3000);	
        getDriver().quit();
    
    }                       

    
}