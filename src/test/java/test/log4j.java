package test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class log4j {

	private static WebDriver driver;

	private static Logger Log = Logger.getLogger(log4j.class.getName());

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
		DOMConfigurator.configure("log4j.xml");
		ChromeDriver driver = new ChromeDriver ();
		Log.info("New driver instantiated");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Implicit wait applied on the driver for 10 seconds");
		driver.get("https://insights.controlup.com/auth");
		Log.info("Web application launched");
		driver.findElement(By.id("SignInUserName")).sendKeys("dudiv");
		Log.info("Username entered in the Username text box");
		driver.findElement(By.id("SignInPassword")).sendKeys("1qaz@WSX");
		Log.info("Password entered in the Password text box");
		driver.findElement(By.id("SignInButton")).click();
		Log.info("Click action performed on Submit button");
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
		String URL = driver.getCurrentUrl();
		TimeUnit.SECONDS.sleep(7);
		Assert.assertTrue(URL.equals("https://insights.controlup.com/auth"));
		Log.info("Assert Passed");
		driver.quit();

		Log.info("Browser closed");

	}

}