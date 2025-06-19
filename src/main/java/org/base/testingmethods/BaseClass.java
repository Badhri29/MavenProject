package org.base.testingmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

enum Browser {
	CHROME, EDGE
}

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver driverLaunch(String browserName, boolean window_Maximize) {
		WebDriver driver = null;
		try {
			Browser selected = Browser.valueOf(browserName.toUpperCase());
			switch (selected) {
			case CHROME:
				driver = new ChromeDriver();
				if (window_Maximize)
					driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				System.out.println("Chrome Browser Launched...\n");
				return driver;
			case EDGE:
				driver = new EdgeDriver();
				if (window_Maximize)
					driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				System.out.println("Edge Browser Launched...\n");
				return driver;
			default:
				System.out.println("sorry choose another browser...");
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid browser: " + browserName);
		} catch (Exception e) {
			System.out.println("Failed to launch browser: " + e.getMessage());
		}
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

	
	
}
