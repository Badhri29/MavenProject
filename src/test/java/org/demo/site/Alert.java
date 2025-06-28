package org.demo.site;

import org.base.testingmethods.BaseClass;

public class Alert extends BaseClass{

	public static void main(String[] args) {
		
		driverLaunch("chrome", false, 5);
		urlLaunch("https://demo.automationtesting.in/Alerts.html");
		
		Alert_POM apom = new Alert_POM();
		
		apom.getSimpleAlert().click();
		apom.getSimpleAlertBtn().click();
		System.out.println(alert().getText());
		alert().accept();
		
		System.out.println("------------------------\n");
		
		apom.getConfirmAlert().click();
		apom.getConfirmAlertBtn().click();
		System.out.println(alert().getText());
		alert().dismiss();
		System.out.println(apom.getConfirmAlertMessage().getText());
		apom.getConfirmAlertBtn().click();
		alert().accept();
		System.out.println(apom.getConfirmAlertMessage().getText());
		
		System.out.println("------------------------\n");
		
		apom.getPromptAlert().click();
		apom.getPromptAlertBtn().click();
		System.out.println(alert().getText());
		alert().sendKeys("badhrinaryanan");
		alert().accept();
		System.out.println(apom.getPromptAlertMessage().getText());
		
		quit();
	}
}
