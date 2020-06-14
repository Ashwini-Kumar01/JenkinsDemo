package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;

public class PageObjectManager {

	private WebDriver driver;

	private LoginPage lp;
	
	 public PageObjectManager(WebDriver driver) {
		 
		 this.driver = driver;
		 
		 }
	 
	 public LoginPage getLoginPage()
	 {
		return (lp==null)? new LoginPage(driver):lp;
		 
	 }

	
}
