package test;


import java.util.List;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Core.BaseDriver;

import org.openqa.selenium.*;

public class Dropdown {
	public static void main(String[] args) throws InterruptedException, IOException {
		// Telling the system where to find the Chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Open google.com
		driver.get("http://demo.guru99.com/test/newtours/register.php");

		Select drpCountry = new Select(driver.findElement(By.name("country")));
		// Select from dropdown by visibel test
		drpCountry.selectByVisibleText("ISRAEL");

		// Select from dropdown by the value tag from list
		// drpCountry.selectByValue("ISRAEL");

		driver.quit();
	}
}
