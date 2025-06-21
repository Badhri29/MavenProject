package org.selenium_task;

import org.base.testingmethods.BaseClass;
import org.pom.registration;

public class task1 extends BaseClass {

	public static void main(String[] args) {

		driverLaunch("chrome", true);
		urlLaunch("https://demo.automationtesting.in/Register.html");

		registration reg = new registration();

		sendKeys(reg.getFirstName(), "badhrinarayanan");
		sendKeys(reg.getLastName(), "Gandhinathan");
		sendKeys(reg.getAddress(), "5 barathi street kanchipuram ");
		sendKeys(reg.getEmailAddress(), "badhrinarayanan79@gmail.com");
		sendKeys(reg.getPhone(), "9600928195");
		reg.getGender('m');
		reg.getCricket().click();
		reg.getHockey().click();
		jsScrollDown(reg.getPhone());
		reg.dropdownLanguage().click();
		reg.getLanguages("english", "arabic", "urdu");
		selectOption(reg.getSkills(), 7);
		reg.getCountrySearchBasedSelect("India");
		selectOption(reg.getDobYear(), "2000");
		selectOption("February", reg.getDobMonth());
		selectOption(reg.getDobDay(), "29");
		sendKeys(reg.getPassword(), "12345");
		sendKeys(reg.getConfirmPassword(), "12345");
		reg.getSumbit().click();

		quit();
	}
}