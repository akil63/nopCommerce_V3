package Pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class BaseClass {		
	    private static WebDriver driver;
	
		public static WebDriver getDriver() {			
			return driver;
		}
			
		public void baseSetup(String browser, String url) throws InterruptedException {
		
		String 	chrpath = System.getProperty ("user.dir") + "\\Browsers\\chromedriver.exe";
		String 	ffpath = System.getProperty ("user.dir") + "\\Browsers\\geckodriver.exe";
		
			
		switch(browser) {
		  case "firefox":
		    // disable all notification in firefox browser

		    FirefoxOptions ffoptions = new FirefoxOptions();
		    ffoptions.setProfile(new FirefoxProfile());
		    ffoptions.addPreference("dom.webnotifications.enabled", false);
		    ffoptions.setBinary("C://Program Files//Mozilla Firefox/firefox.exe");
		    System.setProperty("webdriver.gecko.driver", ffpath); 
		    driver = new FirefoxDriver(ffoptions);
		    System.out.println("Before Test Thread ID-Firefox : "+Thread.currentThread().getId());
		    break; 
		  		    
		  case "chrome": 
			// disable all notifications in an applicaiton shown in chrome browser
			System.out.println(chrpath);
			ChromeOptions chroptions = new ChromeOptions();
			chroptions.addArguments("--disable-notifications");
			//chroptions.addArguments("--remote-allow-origins=*");
			//Add options for --headed or --headless browser launch
	        //chromeOptions.addArguments("-headless");
			
			System.setProperty("webdriver.chrome.driver", chrpath);			 			
			driver = new ChromeDriver(chroptions); 	
			System.out.println("Before Test Thread ID-Chrome : "+Thread.currentThread().getId());
			break;	 	    	  
		}	
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			getDriver().get(url);  
			getDriver().manage().window().maximize();
			//Thread.sleep(3000);					
		}
		
		public static String takeSnapShot(String methodName) {
			//Convert web driver object to TakeScreenshot
			TakesScreenshot scrShot;
			
			scrShot = ((TakesScreenshot)getDriver());
		
			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			//Move image file to new destination
			LocalDateTime datetime = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy_HHmmss");
			String formattedDate = datetime.format(myFormatObj);
			
			//String strdatetime = datetime.toString();
			String destfile = "./screenShot/"+methodName+formattedDate+".png";
			System.out.println("dest file name is: "+ destfile);
			File DestFile=new File(destfile);
			
			//Copy file at destination
			try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (methodName+formattedDate+".png");
		}   

		public void tearDown() {
	    	if(getDriver()!=null) 
	    		getDriver().quit();
	    		
		}  

		
}
