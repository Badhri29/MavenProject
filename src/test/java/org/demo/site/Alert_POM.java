package org.demo.site;

import org.base.testingmethods.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Alert_POM extends BaseClass{
	
	public Alert_POM() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[@class='analystic'])[1]")
	private WebElement simpleAlert;

	@FindBy(xpath = "//button[@onclick='alertbox()']")
	private WebElement simpleAlertBtn;
	
	@FindBy(xpath = "(//a[@class='analystic'])[2]")
	private WebElement confirmAlert;

	@FindBy(xpath = "//button[@onclick='confirmbox()']")
	private WebElement confirmAlertBtn;
	
	@FindBy(id = "demo")
	private WebElement confirmAlertMessage;
	
	@FindBy(xpath = "(//a[@class='analystic'])[3]")
	private WebElement promptAlert;

	@FindBy(xpath = "//button[@onclick='promptbox()']")
	private WebElement promptAlertBtn;


	@FindBy(id = "demo1")
	private WebElement promptAlertMessage;
	
	public WebElement getSimpleAlert() {
		return simpleAlert;
	}

	public WebElement getSimpleAlertBtn() {
		return simpleAlertBtn;
	}

	public WebElement getConfirmAlert() {
		return confirmAlert;
	}

	public WebElement getConfirmAlertBtn() {
		return confirmAlertBtn;
	}

	public WebElement getPromptAlert() {
		return promptAlert;
	}

	public WebElement getPromptAlertBtn() {
		return promptAlertBtn;
	}

	public WebElement getConfirmAlertMessage() {
		return confirmAlertMessage;
	}

	public WebElement getPromptAlertMessage() {
		return promptAlertMessage;
	}
}
