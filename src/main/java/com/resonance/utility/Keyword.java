package com.resonance.utility;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Sarasvati
 *
 */

public class Keyword {
	 public static RemoteWebDriver driver;
	private static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	private static final Logger LOG = Logger.getLogger(Keyword.class);

	/**
	 * This method will launch browser in maximized mode
	 * 
	 * @param browserName must be one of the following :
	 *                    <ul>
	 *                    <li>Chrome</li>
	 *                    <li>Firefox</li>
	 *                    <li>Safari</li>
	 *                    </ul>
	 */

	public static void openBrowser(String browserName) {
		if (browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();

		} else {
		LOG.error("Invalid browserName: " + browserName);

		}

		LOG.error(browserName + "is launched Successfully ");

	}

	/**
	 * This method will launch the specified url in currently opened window
	 * 
	 * @param url
	 */

	public static void launchUrl(String url) {
		driver.get(url);
	}

	/**
	 * This method will click on element described by {@code locatorType} and
	 * {@code locatorValue}
	 * 
	 * @param locatorType  must be one of the following :
	 *                     <ul>
	 *                     <li>xpath</li>
	 *                     <li>CSS</li>
	 *                     <li>name</li>
	 *                     <li>id</li>
	 *                     <li>class</li>
	 * 
	 *                     </ul>
	 * @param locatorValue
	 */
	public static void click(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector(locatorValue)).click();

		} else {
			LOG.error("Invalid locator type: " + locatorType);
		}

	}

	public static void waitFor(long duration) throws InterruptedException {
		try {
			wait.wait(duration);
		} catch (InterruptedException e) {
			LOG.info("wait is interupted ");
			e.printStackTrace();
		}

	}
}
