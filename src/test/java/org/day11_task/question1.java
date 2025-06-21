package org.day11_task;



import java.util.List;

import org.base.testingmethods.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class question1 extends BaseClass{

	public static void main(String[] args) {

		/*
		 * URL : http://demo.guru99.com/test/write-xpath-table.html
		 * 
		 * NOTE: Print all the content in the dynamic webtable.
		 */
		
		driverLaunch("chrome",false);
		urlLaunch("http://demo.guru99.com/test/write-xpath-table.html");

		try {
			
			WebElement table = driver.findElement(By.xpath("//table"));
			List<WebElement> rows = table.findElements(By.tagName("tr"));

			for (WebElement row : rows) {
				List<WebElement> cells = row.findElements(By.tagName("td"));
				for (WebElement cell : cells) {
					System.out.print(cell.getText() + " | ");
				}
				System.out.println();
			}
			

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.quit();
		}

	}

}
