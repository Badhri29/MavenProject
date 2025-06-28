package org.day11_task;

import java.util.List;

import org.base.testingmethods.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class question5 extends BaseClass{

	public static void main(String[] args) {

		/*
		 * URL : http://demo.guru99.com/test/write-xpath-table.html
		 * 
		 * NOTE: Print Even rows available in 4th webtable
		 */
		
		driverLaunch("chrome",false, 5);
		urlLaunch("http://demo.guru99.com/test/write-xpath-table.html");
		
		try {
			
			List<WebElement> elements = driver.findElements(By.xpath("//table//tr"));
			for(int i=0;i<elements.size();i++) {
				if((i+1)%2==0) {
					List<WebElement> elements2 = elements.get(i).findElements(By.tagName("td"));
					for (WebElement webElement : elements2) {
						System.out.println(webElement.getText());
					}
					
				}
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			driver.quit();
		}
		
	}

}
