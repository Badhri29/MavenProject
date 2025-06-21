package org.base.testingmethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Trail extends BaseClass {

	public static void main(String[] args) throws AWTException {

		driverLaunch("chrome", true);
		urlLaunch("https://demo.automationtesting.in/Register.html");

		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		firstName.sendKeys("badhri");
		WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		lastName.sendKeys("nara");
		
		cut(firstName, lastName);
		

		quit();
	}

}
