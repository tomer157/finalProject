package test;

import Core.BaseDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.lang.Thread;
import java.util.ArrayList;

import javax.swing.Popup;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabSelectionHandler;

import Pages.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Core.BaseDriver;

public class test extends BaseDriver {

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		// get the url of mishloha

		startSession();
		PageFactory.initElements(driver, Pages.Map.class);
		// test case 1 row 20
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (driver.findElement(By.id("close-location-modal")).isDisplayed())
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		driver.findElement(By.id("close-location-modal")).click();
	}

	// Referace to manual test case number : 1
	@Test(priority = 1, groups = "sanity")
	public void f() throws InterruptedException {
		// driver.get("https://www.mishloha.co.il");
		// driver.manage().window().maximize();
		// String url = driver.getCurrentUrl();
		System.out.println("url");

		// to do : look for how to element below an overlay!
		// and map the initial login button 1
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Pages.Map.login.click();
		Pages.Map.loginEmail.sendKeys("tomer157@gmail.com");
		Pages.Map.loginPassword.sendKeys("tomer157");
		Pages.Map.loginButton.click();
		// code below shows how to delay before element appears
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// WebElement element = wait.until(ExpectedConditions.visibilityOf());
		Thread.sleep(2000);

	}

	// reffernce to manual test case 2
	@Test(priority = 2, groups = "sanity")
	public void italianCousine() throws InterruptedException {
		Thread.sleep(2000);
		Pages.Map.italian.click();
		Thread.sleep(1500);
		// Pages.Map.pizzaDomino.click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "פיצה ואיטלקי משלוחים: הזמנת משלוחי פיצה ואיטלקי בעיר שלך! - משלוחה";
		assertEquals(actualTitle, expectedTitle);

	}

	// reffernce to manual test case 3
	@Test(priority = 3, groups = "sanity")

	public void lookFordom() throws InterruptedException {
		Thread.sleep(2000);
		Pages.Map.searchkey.sendKeys("ãåîéðåñ øçåáåú");
		Pages.Map.searchKeybtn.click();
		Thread.sleep(1000);
		Pages.Map.dominosRehovot.click();

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		String actualTitle = driver.getTitle();
		String expectedTtile = "ôéöä ãåîéðåñ øçåáåú îùìåçéí, îáöòéí, ÷åôåðéí, äèáåú îéåçãåú åòåã, ëðñ òëùéå.";
		assertEquals(actualTitle, expectedTtile);

	}
	// reffernce to manual testcase 4

	@Test(priority = 4, groups = "sanity")

	public void order1() throws InterruptedException {
		Thread.sleep(2000);
		Pages.Map.searchkey.sendKeys("ö'åîä úì àáéá");
		Pages.Map.searchKeybtn.click();
		Thread.sleep(2500);
		Pages.Map.tzhuma.click();

	}

	// reffernce to testcase 5 :

	@Test(priority = 5, groups = "sanity")

	public void order2() throws InterruptedException {
		Thread.sleep(2000);
		Pages.Map.searchkey.sendKeys("ö'åîä úì àáéá");
		Pages.Map.searchKeybtn.click();
		Thread.sleep(2500);
		Pages.Map.tzhuma.click();
		Thread.sleep(3000);
		Pages.Map.Iskit.click();

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(4500);
		driver.quit();
		// Pages.Map.popup.click();

	}

}
