package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testpage {

	public WebDriver driver;
	public WebDriverWait wait;

	@FindBy(id = "username")
	private WebElement user;

	@FindBy(id="Password")
    private WebElement pass;

	public testpage(WebDriver driver) {
		this.driver = driver;
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void usernamee() {
		user.sendKeys("Srinu");
		
	}
	
	public void passworddd() {
		wait.until(ExpectedConditions.visibilityOf(pass));
		pass.sendKeys("Test@123");
	}

}
