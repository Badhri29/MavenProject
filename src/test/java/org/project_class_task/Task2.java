package org.project_class_task;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.base.testingmethods.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Task2 extends BaseClass {
	
	private static void simpleMethod(String url) {


		driverLaunch(10, true);
		urlLaunch(url);

		int showingSize;

		try {

			// search product name in WebPage
			sendKeysWithEnter(By.name("q"), "Google smartphone");

			// Get all product Name list
			List<WebElement> productNameList = driver.findElements(By.xpath("(//div[@class='KzDlHZ'])"));
			// Get all product price list
			List<WebElement> productPriceList = driver.findElements(By.xpath("(//div[@class='Nx9bqj _4b5DiR'])"));

			showingSize = productNameList.size();

			// print list of ProductName with ProductPrice & conversion amount string to integer and add into TreeSet
			Set<Integer> sortAmount = new TreeSet<>();
			for (int i = 0; i < showingSize; i++) {

				// print list of ProductName with ProductPrice
				System.out.println("\n" + (i + 1) + " - Product Name = " + productNameList.get(i).getText()
						+ "\n  - Product Price = " + productPriceList.get(i).getText());

				// conversion amount string to integer and add into TreeSet
				int amount = Integer.parseInt((productPriceList.get(i).getText()).replace("₹", "").replaceAll(",", ""));
				sortAmount.add(amount);
			}

			// change all set into list because print with index value
			List<Integer> li = new LinkedList<>(sortAmount);

			// print no of product
			System.out.println("\nTotal product showing in this page : " + showingSize);

			//print total result
			String totalResult = driver.findElement(By.className("BUOuZu")).getText();
			System.out.println("\nYour total Result is = "+totalResult.split("of")[1].split("results")[0].trim());
			
			// print min, max amount
			System.out.println("minimum amount = " + li.get(0));
			System.out.println("maximium amount = " + li.get(li.size() - 1));

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			exit("quit");
			System.out.println("\nBrowser clossed successfully");
		}

	
	}
	
	public static void main(String[] args) {
		simpleMethod("https://www.flipkart.com");
	}

}
