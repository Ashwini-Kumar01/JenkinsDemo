package managers;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataProvider.ConfigFileReader;
import enums.DriverType;
import enums.EnvironmentType;

public class WebDriverManager {

	private WebDriver driver;
	 private static DriverType driverType;
	 private static EnvironmentType environmentType;
	 private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	 
	 public WebDriverManager() throws IOException {
	 ConfigFileReader configFileReader= new ConfigFileReader();
	 driverType = configFileReader.getBrowser();
	 environmentType = configFileReader.getEnvironment();
	 }
	 
	 public WebDriver getDriver() throws IOException {
	 if(driver == null) driver = createDriver();
	 return driver;
	 }
	 
	 private WebDriver createDriver() throws IOException {
	    switch (environmentType) {     
	         case LOCAL : driver = createLocalDriver();
	         	break;
	         case REMOTE : driver = createRemoteDriver();
	         	break;
	    }
	    return driver;
	 }
	 
	 private WebDriver createRemoteDriver() {
	 throw new RuntimeException("RemoteWebDriver is not yet implemented");
	 }
	 
	 private WebDriver createLocalDriver() throws IOException {
		 ConfigFileReader configFileReader= new ConfigFileReader();
	        switch (driverType) {     
	        case FIREFOX : driver = new FirefoxDriver();
	     	break;
	        case CHROME : 
	        	System.setProperty(CHROME_DRIVER_PROPERTY, configFileReader.getDriverPath());
	        	driver = new ChromeDriver();
	     break;
	        case INTERNETEXPLORER : driver = new InternetExplorerDriver();
	     break;
	        }
	 
	        
	 return driver;
	 } 
	 
	 public void closeDriver() {
	 driver.close();
	 driver.quit();
	 }
}
