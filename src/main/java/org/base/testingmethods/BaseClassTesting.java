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

public class BaseClassTesting extends initial {
	public static WebDriver driver;

	public static void quit(long second) {
		try {
			Thread.sleep(second);
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void threadWait(long sec) {
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class initial extends SendKeys {

	public static WebDriver driverLaunch(String browserName, boolean window_Maximize, int implicitlySeconds) {

		switch (browserName.toUpperCase()) {
		case "CHROME":
			BaseClassTesting.driver = new ChromeDriver();
			System.out.println("-> Chrome Browser Launched...\n");
			break;
		case "EDGE":
			BaseClassTesting.driver = new EdgeDriver();
			System.out.println("-> Edge Browser Launched...\n");
			break;
		default:
			throw new IllegalArgumentException("   \"-> You entered an invalid BrowserName\" = " + browserName);
		}

		if (window_Maximize)
			BaseClassTesting.driver.manage().window().maximize();
		if (implicitlySeconds < 0) {
			throw new IllegalArgumentException("-> Implicit wait time must be 0 or positive.");
		}
		BaseClassTesting.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlySeconds));

		return BaseClassTesting.driver;
	}

	public static void urlLaunch(String url) {
		/*
		 * no need to handle exception because here we can't find your url working or
		 * not so, we just pass string what ever you given in case you try to send other
		 * type of datatype except string it throw complie error.
		 */

		BaseClassTesting.driver.get(url);
		System.out.println("-> url launched...");
	}

}

class SendKeys extends ScreenShot {

	public static void sendKeysWithEnterWE(WebElement element, String values) {
		element.sendKeys(values, Keys.ENTER);
	}

	public static void sendKeysWE(WebElement element, String values) {
		element.sendKeys(values);
	}

}

class ScreenShot extends Action {

	public static void screenShot() {
		/*
		 * no WebElement or locater no path location so it store to default location and
		 * take screenshot driver
		 */
		try {

			File src = ((TakesScreenshot) BaseClassTesting.driver).getScreenshotAs(OutputType.FILE);
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
			File src = ((TakesScreenshot) BaseClassTesting.driver).getScreenshotAs(OutputType.FILE);
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
}

class Action extends Robots {

	public static void moveToElement(By locater) {
		WebElement element = BaseClassTesting.driver.findElement(locater);
		new Actions(BaseClassTesting.driver).moveToElement(element).perform();
	}

	public static void dragAndDrop(By drag, By drop) {
		WebElement from = BaseClassTesting.driver.findElement(drag);
		WebElement to = BaseClassTesting.driver.findElement(drop);
		new Actions(BaseClassTesting.driver).dragAndDrop(from, to).perform();

	}

	public static void clickAndHoldRelease(By hold, By release) {
		WebElement from = BaseClassTesting.driver.findElement(hold);
		WebElement to = BaseClassTesting.driver.findElement(release);
		new Actions(BaseClassTesting.driver).clickAndHold(from).release(to).perform();

	}

	public static void doubleClick(By locater) {
		WebElement element = BaseClassTesting.driver.findElement(locater);
		new Actions(BaseClassTesting.driver).doubleClick(element).perform();
	}

	public static void contextClick(By locater) {
		WebElement element = BaseClassTesting.driver.findElement(locater);
		new Actions(BaseClassTesting.driver).contextClick(element).perform();
	}

	public static void actionKeyDown(int downTimes, boolean enter) {
		Actions a = new Actions(BaseClassTesting.driver);
		for (int i = 1; i <= downTimes; i++) {
			a.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
		}
		if (enter) {
			a.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		}

	}

	public static void actionKeyUp(int upTimes, boolean enter) {
		Actions a = new Actions(BaseClassTesting.driver);
		for (int i = 1; i <= upTimes; i++) {
			a.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
		}
		if (enter) {
			a.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		}
	}
}

class Robots extends Selects {

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

}

class Selects extends SwitchTo {

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

}

class SwitchTo extends CopyAndCut {

	public static Alert alert() {
		return BaseClassTesting.driver.switchTo().alert();
	}

}

class CopyAndCut extends Scrolling {

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

	// cut and paste using WebElement
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

}

class Scrolling extends JavaScript {

	public static void jsScrollDown(WebElement element) {
		((JavascriptExecutor) BaseClassTesting.driver).executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public static void jsScrollUp(WebElement element) {
		((JavascriptExecutor) BaseClassTesting.driver).executeScript("arguments[0].scrollIntoView(false)", element);
	}

}

class JavaScript {

	public static void sendKeysUsingJS(WebElement element, String value) {

		((JavascriptExecutor) BaseClassTesting.driver).executeScript("arguments[0].value='" + value + "';", element);

	}

	public static Object getTextJs(WebElement element, String value) {
		/*
		 * this method for pass argument values only in innerText and textContent
		 */
		Object executeScript = null;

		if (value.equals("innerText") || value.equals("textContent")) {
			try {
				executeScript = ((JavascriptExecutor) BaseClassTesting.driver)
						.executeScript("return arguments[0]." + value + ";", element);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new IllegalArgumentException(
					"Unsupported property: " + value + ". Expected 'innerText' or 'TextContent'.");
		}
		return executeScript;
	}

	public static Object getAttributeJs(WebElement element, String value) {
		Object executeScript = ((JavascriptExecutor) BaseClassTesting.driver)
				.executeScript("return arguments[0]." + value + ";", element);
		if (executeScript == null) {
			throw new IllegalArgumentException("Your Attribute '" + value + "' is not available...");
		}
		return executeScript;
	}
}
