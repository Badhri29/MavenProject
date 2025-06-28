package sample;

import org.base.testingmethods.BaseClassTesting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM extends BaseClassTesting {

	public LoginPOM() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	private WebElement userName;

	@FindBy(id = "pass")
	private WebElement password;

	@FindBy(id = "reg_pages_msg")
	private WebElement text;

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getText() {
		return text;
	}
	
	
}
