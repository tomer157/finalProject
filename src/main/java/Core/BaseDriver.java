package Core;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utiles.PropertyUtil;

//import salesforce.util.PropertyUtil;

public class BaseDriver {

	public WebDriver driver;
	String path = System.getProperty("user.dir");

	public WebDriver getDriver() {
		return driver;
	}

	@SuppressWarnings("deprecation")
	public void startSession() {
		try {
			PropertyUtil pus = new PropertyUtil(path + "\\selenium.properties");
			String grid = pus.getProperty("grid");
			String browser = pus.getProperty("browser");
			String gridUrl = pus.getProperty("gridUrl");

			if (browser.equalsIgnoreCase("firefox")) {
				if (grid.equalsIgnoreCase("true")) {

					DesiredCapabilities cap = new DesiredCapabilities();
					cap.setBrowserName("firefox");
					cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
					driver = new RemoteWebDriver(new URL(gridUrl), cap);
					System.setProperty("webdriver.firefox.driver", "C:\\Automation\\geckdriver.exe");
				} else {
					System.setProperty("webdriver.firefox.driver", "C:\\Automation\\geckdriver.exe");

				}
			} else if (browser.equalsIgnoreCase("chrome")) {
				if (grid.contains("true")) {
					System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
					ChromeOptions options = new ChromeOptions();
					// set some options ....
					options.addArguments("Start-maximized");
					DesiredCapabilities cap = DesiredCapabilities.chrome();
					cap.setCapability(ChromeOptions.CAPABILITY, options);
					driver = new RemoteWebDriver(new URL(gridUrl), cap);
				} else {
					System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
					ChromeOptions options = new ChromeOptions();
					options.addArguments("Start-maximized");
					DesiredCapabilities cap = DesiredCapabilities.chrome();

					cap.setCapability(ChromeOptions.CAPABILITY, options);
					driver = new ChromeDriver(cap);
				}
			} else if (browser.equalsIgnoreCase("ie")) {
				if (grid.equalsIgnoreCase("true")) {
					System.setProperty("webdriver.ie.driver", "C:\\Automation\\iedriverserver.exe");

					DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
					ieCapabilities.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
					driver = new InternetExplorerDriver(ieCapabilities);

				} else {
					System.setProperty("webdriver.ie.driver", "C:\\Automation\\iedriverserver.exe");

					DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
					ieCapabilities.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
					driver = new InternetExplorerDriver(ieCapabilities);
				}

			}

			String url = pus.getProperty("url");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);

			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("close-location-modal")));
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// driver.manage().window().maximize();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void stopSeeion() {
		driver.quit();
	}

}
