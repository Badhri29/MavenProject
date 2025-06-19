package org.day11_task;

import java.util.List;

import org.base.testingmethods.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class question2 extends BaseClass {

	public static void main(String[] args) {

		/*
		 * URL : http://demo.guru99.com/test/write-xpath-table.html
		 * 
		 * NOTE: Print all value in first row
		 */

		driverLaunch("chrome",false);
		urlLaunch("http://demo.guru99.com/test/write-xpath-table.html");

		try {
			List<WebElement> elements = driver.findElements(By.xpath("(//table//tbody//tr)[1]"));
			for (WebElement webElement : elements) {
				System.out.print(webElement.getText());
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			exit("quit");
		}

	}

}
