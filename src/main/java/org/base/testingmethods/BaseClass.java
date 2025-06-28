package org.base.testingmethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver driverLaunch(String browserName, boolean window_Maximize, int implicitlySeconds) {
		WebDriver driver;

		switch (browserName.toUpperCase()) {
		case "CHROME":
			driver = new ChromeDriver();
			System.out.println("Chrome Browser Launched...\n");
			break;
		case "EDGE":
			driver = new EdgeDriver();
			System.out.println("Edge Browser Launched...\n");
			break;
		default:
			throw new IllegalArgumentException("   \"You entered an invalid BrowserName\" = " + browserName);
		}

		if (window_Maximize)
			driver.manage().window().maximize();
		if (implicitlySeconds < 0) {
			throw new IllegalArgumentException("Implicit wait time must be 0 or positive.");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlySeconds));

		return driver;
	}

	public static void urlLaunch(String url) {
		try {
			driver.get(url);
			System.out.println("url launched...");
		} catch (NullPointerException e) {
			e.printStackTrace();
//			System.out.println(e.getMessage());
		}
	}

	public static void sendKeysWithEnter(By locator, String values) {
		driver.findElement(locator).sendKeys(values, Keys.ENTER);
	}

	public static void sendKeys(By locator, String values) {
		driver.findElement(locator).sendKeys(values);
	}

	public static void sendKeysWithEnter(WebElement element, String values) {
		element.sendKeys(values, Keys.ENTER);
	}

	public static void sendKeys(WebElement element, String values) {
		element.sendKeys(values);
	}

	public static void screenShot() {
		/*
		 * no WebElement or locater no path location so it store to default location and
		 * take screenshot driver
		 */
		try {

			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File dis = new File(
					"D:\\Personal Folder\\Locker\\Greens Tech\\Selenium\\Selenium-Eclipse\\MavenProject\\.\\src\\test\\resources\\screenshot\\image.png");
			FileHandler.copy(src, dis);
			System.out.println("screenshot taken default location = " + dis.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void screenShot(String path) {
		/*
		 * no WebElement or locater take driver screenshot with given location
		 * 
		 */
		try {

			if (!path.endsWith(".png")) {
				path = path + ".png";
			}
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File dis = new File(path);
			FileHandler.copy(src, dis);
			System.out.println("screenshot taken - " + dis.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// take screenshot particular element argument using locater
	public static void screenShot(By locater, String path) {
		/*
		 * take particular webelement screenshot and store to given location
		 */
		try {

			if (!path.endsWith(".png")) {
				path = path + ".png";
			}
			WebElement tss = driver.findElement(locater);
			File src = tss.getScreenshotAs(OutputType.FILE);
			File dis = new File(path);

			FileHandler.copy(src, dis);
			System.out.println("screenshot taken - " + dis.getAbsolutePath());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// take screenshot particular element argument using element
	public static void screenShot(WebElement element, String path) {
		/*
		 * take particular webelement screenshot and store to given location
		 */
		try {

			if (!path.endsWith(".png")) {
				path = path + ".png";
			}
			File src = element.getScreenshotAs(OutputType.FILE);
			File dis = new File(path);

			FileHandler.copy(src, dis);
			System.out.println("screenshot taken - " + dis.getAbsolutePath());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// take screenshot particular element argument using locater
	public static void screenShot(By locater) {
		/*
		 * take particular webelement screenshot and store to default location
		 */
		try {

			WebElement tss = driver.findElement(locater);
			File src = tss.getScreenshotAs(OutputType.FILE);
			File dis = new File(
					"D:\\Personal Folder\\Locker\\Greens Tech\\Selenium\\Selenium-Eclipse\\MavenProject\\.\\src\\test\\resources\\screenshot\\image.png");

			FileHandler.copy(src, dis);
			System.out.println("screenshot taken - " + dis.getAbsolutePath());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// take screenshot particular element argument using element
	public static void screenShot(WebElement element) {
		/*
		 * take particular webelement screenshot and store to default location
		 */
		try {

			File src = element.getScreenshotAs(OutputType.FILE);
			File dis = new File(
					"D:\\Personal Folder\\Locker\\Greens Tech\\Selenium\\Selenium-Eclipse\\MavenProject\\.\\src\\test\\resources\\screenshot\\image.png");

			FileHandler.copy(src, dis);
			System.out.println("screenshot taken - " + dis.getAbsolutePath());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void moveToElement(By locater) {
		WebElement element = driver.findElement(locater);
		new Actions(driver).moveToElement(element).perform();
	}

	public static void dragAndDrop(By drag, By drop) {
		WebElement from = driver.findElement(drag);
		WebElement to = driver.findElement(drop);
		new Actions(driver).dragAndDrop(from, to).perform();

	}

	public static void clickAndHoldRelease(By hold, By release) {
		WebElement from = driver.findElement(hold);
		WebElement to = driver.findElement(release);
		new Actions(driver).clickAndHold(from).release(to).perform();

	}

	public static void doubleClick(By locater) {
		WebElement element = driver.findElement(locater);
		new Actions(driver).doubleClick(element).perform();
	}

	public static void contextClick(By locater) {
		WebElement element = driver.findElement(locater);
		new Actions(driver).contextClick(element).perform();
	}

	public static void quit() {
		try {
			Thread.sleep(5000);
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void robotKeyDown(int downTimes, boolean enter) {
		try {

			Robot r = new Robot();
			for (int i = 1; i <= downTimes; i++) {
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
			}
			if (enter) {
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	public static void robotKeyUp(int upTimes, boolean enter) {

		try {
			Robot r = new Robot();
			for (int i = 1; i <= upTimes; i++) {
				r.keyPress(KeyEvent.VK_UP);
				r.keyRelease(KeyEvent.VK_UP);
			}
			if (enter) {
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
			}

		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	public static void actionKeyDown(int downTimes, boolean enter) {
		Actions a = new Actions(driver);
		for (int i = 1; i <= downTimes; i++) {
			a.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
		}
		if (enter) {
			a.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		}

	}

	public static void actionKeyUp(int upTimes, boolean enter) {
		Actions a = new Actions(driver);
		for (int i = 1; i <= upTimes; i++) {
			a.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
		}
		if (enter) {
			a.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		}
	}

	// copy and paste using locater
	public static void copy(By copyLocater, By pasteLocater) {
		try {
			driver.findElement(copyLocater).click();
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_A);
			r.keyPress(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_CONTROL);

			driver.findElement(pasteLocater).click();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);

		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	// copy and paste using WebElement
	public static void copy(WebElement copyElement, WebElement pasteElement) {
		try {
			copyElement.click();
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_A);
			r.keyPress(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_CONTROL);

			pasteElement.click();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);

		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	// copy and paste using locater
	public static void cut(By copyLocater, By pasteLocater) {
		try {
			driver.findElement(copyLocater).click();
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_A);
			r.keyPress(KeyEvent.VK_X);
			r.keyRelease(KeyEvent.VK_X);
			r.keyRelease(KeyEvent.VK_CONTROL);

			driver.findElement(pasteLocater).click();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);

		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	// copy and paste using WebElement
	public static void cut(WebElement copyElement, WebElement pasteElement) {
		try {
			copyElement.click();
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_A);
			r.keyPress(KeyEvent.VK_X);
			r.keyRelease(KeyEvent.VK_X);
			r.keyRelease(KeyEvent.VK_CONTROL);

			pasteElement.click();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);

		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void selectOption(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public static void selectOption(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public static void selectOption(String visibleText, WebElement element) {
		Select s = new Select(element);
		s.selectByVisibleText(visibleText);
	}

	public static void jsScrollDown(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public static void jsScrollUp(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false)", element);
	}

	public static Alert alert() {
		return driver.switchTo().alert();
	}
}
