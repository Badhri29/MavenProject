package org.base.testingmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver driverLaunch(int waitSecond, boolean window_Maximize) {
		driver = new ChromeDriver();
		if (window_Maximize)
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitSecond));
		System.out.println("Browser Launched...");
		return driver;
	}

	public static void urlLaunch(String url) {
		driver.get(url);
		System.out.println("url launched...");
	}

	public static void sendKeysWithEnter(By locator, String values) {
		driver.findElement(locator).sendKeys(values, Keys.ENTER);
	}

	public static void sendKeys(By locator, String values) {
		driver.findElement(locator).sendKeys(values);
	}

	public static void exit(String exitType) {
		switch (exitType) {
		case "close":
			driver.close();
			break;
		case "quit":
			driver.quit();
			break;
		}
	}
	
	
}
