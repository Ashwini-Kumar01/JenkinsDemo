package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import managers.PageObjectManager;
import pageObjects.LoginPage;

public class End2End_Test {

	WebDriver driver;
	LoginPage lp;
	PageObjectManager pageObjectManager;
	
	@Given("^User is on login page$")
	public void user_is_on_login_page() throws Throwable {
		ConfigFileReader configFileReader= new ConfigFileReader();
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Dyanda\\Desktop\\Ashwini\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",configFileReader.getDriverPath());
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://www.facebook.com");	
		 loadPages();
	}
	
	public void loadPages()
	{
		pageObjectManager=new PageObjectManager(driver);
		lp=pageObjectManager.getLoginPage();
	}
	
	@When("^User enters \"([^\"]*)\" as UserName$")
	public void user_enters_as_UserName(String arg1) throws Throwable {	
	    lp.enter_UserName(arg1);
	}

	@When("^User enters \"([^\"]*)\" as Password$")
	public void user_enters_as_Password(String arg1) throws Throwable {
		lp.enter_Password(arg1);
	}

	@When("^User clicks on LoginButton$")
	public void user_clicks_on_LoginButton() throws Throwable {
	    lp.click_Login();
	}


	@Then("^User navigates to \"([^\"]*)\"$")
	public void user_navigates_to(String arg1) throws Throwable {
	   driver.getCurrentUrl().equals(arg1);
	}

}
