package test;


import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class Iframe {
	public static void main(String[] args) throws InterruptedException, IOException {
		// Telling the system where to find the Chrome driver
		System.setProperty("webdriver.gecko.driver", "C:\\Automation\\geckodriver.exe");

		WebDriver  driver = new FirefoxDriver();

		// Open google.com
		driver.get("http://www.mishloha.co.il");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// By executing a java script
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of iframes on the page are " + numberOfFrames);

		// By finding all the web elements using iframe tag
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println("The total number of iframes are " + iframeElements.size());

		// By finding all the web elements using iframe tag name
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);

		driver.close();
		driver.quit();
	}
}