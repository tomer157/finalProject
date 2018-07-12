package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import Core.*;

public class Map {
	// find header
	@FindBy(xpath = "/html/body/div[1]/header")
	public static WebElement mainheader;
	// home page view
	@FindBy(xpath = "//section[@class='home-page clearfix']")
	public static WebElement homepage;
	// home side bar
	@FindBy(xpath = "//*[@id='homeAside']")
	public static WebElement homeAside;

	// region rest search
	@FindBy(xpath = "//div[@class='container']/div[@class='region-rest-search-hp']")
	public static WebElement regionSearch;

	// logo
	@FindBy(xpath = "//a[@class='logo-link logo-link-text']")
	public static WebElement Logo;
	// login email/username
	@FindBy(xpath = "//*[@id='loginEmail']")
	public static WebElement loginEmail;
	// password login
	// tomer157@gmail.com ->tomer157
	@FindBy(xpath = "//*[@id='loginPassword']")
	public static WebElement loginPassword;
	// login button
	@FindBy(xpath = "(//button[@class='ma-btn-primary ma-btn-str ma-btn ma-btn'][text()='כניסה'])[1]")
	public static WebElement loginButton;
	@FindBy(xpath = "/html/body/div[1]/header/div[1]/section/div[4]/div[2]/button/span[4]")

	public static WebElement login;

	@FindBy(xpath = "//*[@id='close-location-modal']")
	public static WebElement popup;

	@FindBy(xpath = "//a[@class='heading category-link'][@data-type-id='5']")
	public static WebElement italian;

	@FindBy(xpath = "//img[@title='פיצה דומינו תל אביב אבן גבירול']")
	public static WebElement pizzaDomino;

	@FindBy(xpath = "//*[@id='dishkey']")
	public static WebElement searchBar;

	@FindBy(xpath = "//button[@data-role='search-by-key-form']")
	public static WebElement searchBtn;

	@FindBy(xpath = "//button[text()='הוסף להזמנה']")
	public static WebElement addTocart;

	@FindBy(xpath = "//*[@id='dishkey']")
	public static WebElement searchkey;

	@FindBy(xpath = "//button[@data-role='search-by-key-form']")
	public static WebElement searchKeybtn;

	@FindBy(xpath = "//a[@title='פיצה דומינוס רחובות']")
	public static WebElement dominosRehovot;

	@FindBy(xpath = "//*[@id='restaurantRightSection']/header/div[2]/p/a")
	public static WebElement tzhuma;

	@FindBy(xpath = "//img[@alt='עסקית כרעיים עוף צלוי']")
	public static WebElement Iskit;

}
