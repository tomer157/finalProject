package test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

public class Iframe2{

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_iframe.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total Frames --" + size);

		// prints the total number of frames
		WebElement iframeElement = driver.findElement(By.xpath(""));
		driver.switchTo().frame(iframeElement); // Switching the Outer Frame
		String test1 = driver.findElement(By.xpath("")).getText();
		System.out.println(test1);

		// //Printing the text in outer frame
		// size = driver.findElements(By.tagName("iframe")).size();
		// // prints the total number of frames inside outer frame
		//
		// System.out.println("Total Frames --" + size);
		// driver.switchTo().frame(0); // Switching to innerframe
		// System.out.println(driver.findElement(By.xpath("xpath of the inner
		// element ")).getText());
		//
		// //Printing the text in inner frame
		// driver.switchTo().defaultContent();
	}
}