package org.day11_task;

import java.util.List;

import org.base.testingmethods.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class question3 extends BaseClass{

	public static void main(String[] args) {

		/*
		 * URL : http://demo.guru99.com/test/write-xpath-table.html
		 * 
		 * NOTE: Find out Number of rows available in webPage
		 */
		
		driverLaunch("chrome",false);
		urlLaunch("http://demo.guru99.com/test/write-xpath-table.html");
		
		List<WebElement> elements = driver.findElements(By.xpath("//table//tr"));
		System.out.println(elements.size());
		
		exit("quit");
		
	}

}
