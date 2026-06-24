package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Util;

public class LoginPage {
	private static WebDriverWait wait;
	
	public WebDriver driver;
	
	// Elements
	@FindBy(id = "Email")
	private WebElement username;

	@FindBy(id = "Password")
	private WebElement password;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement LoginBTN;

	@FindBy(xpath = "//a[@class='main_logo_text']")
	private WebElement DashBoardLogo;

	@FindBy(id = ("MainHeaderUsername"))
	private WebElement Logoutoptions;

	@FindBy(xpath = ("//button[normalize-space()='Logout']"))
	private WebElement logout;

	@FindBy(xpath = ("(//*[text()='Yes'])[1]"))
	private WebElement yesbutton;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		PageFactory.initElements(driver, this);
	}

	// Create object for Above Elements
	public void User(String user) throws InterruptedException {
		Util.waitinseconds(3);
		username.clear();
		username.sendKeys(user);
	}

	public void Pass(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}

	public void submit() {
		LoginBTN.click();
	}

	public String DashboardLogo() {
		String LogoText = DashBoardLogo.getText();
		System.out.println("DashBoard : " + LogoText);
		return LogoText;
	}

	public void Logout() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(Logoutoptions));
		Logoutoptions.click();
		wait.until(ExpectedConditions.visibilityOf(logout));
		logout.click();
		wait.until(ExpectedConditions.visibilityOf(yesbutton));
		yesbutton.click();
	}

}
