package tomer.com;
//import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;	
public class firstTest {
	
	public static void main(String[] args) {
	WebDriver driver = 	new FirefoxDriver();
	driver.get("https://www.mishloha.co.il/");
	driver.quit();
	}
}
