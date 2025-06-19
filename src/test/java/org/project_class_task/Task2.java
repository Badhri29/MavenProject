package org.project_class_task;

import org.base.testingmethods.BaseClass;

public class Task2 extends BaseClass {
	
	private static void simpleMethod(String url) {


		driverLaunch("chrome", false);
		urlLaunch(url);


		try {
			
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.quit();
			System.out.println("\nBrowser clossed successfully");
		}

	
	}
	
	public static void main(String[] args) {
		simpleMethod("https://www.flipkart.com");
	}

}
