package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	public LoginPage(WebDriver driver) {
	     PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(how = How.ID, using = "email") 
	 private WebElement txtbx_UserName;
	 
	 @FindBy(how = How.ID, using = "pass") 
	 private WebElement txtbx_Password;
	 
	 @FindBy(how = How.ID, using = "loginbutton") 
	 private WebElement btn_Login;
	 
	 public void enter_UserName(String name) {
		 txtbx_UserName.sendKeys(name);
	 }
	 
	 public void enter_Password(String name) {
		 txtbx_Password.sendKeys(name);
	 }
	 
	 public void click_Login() {
		 btn_Login.click();
	 }
	 
}
