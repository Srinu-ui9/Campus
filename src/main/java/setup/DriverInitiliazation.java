package setup;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInitiliazation {

	public static WebDriver driver;
	private String URL = "http://192.168.37.83:9095/";
	
	
	public static ExtentReports extent;
	public static ExtentSparkReporter report;
	public static ExtentTest test;

	@BeforeSuite
	public void initializeReports() {
		extent = ExtentReportManager.createInstance();
	}

	@Parameters("browser")
	@BeforeTest
	public void launchapp(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println(" Executing on FireFox");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("chrome")) {
			System.out.println(" Executing on CHROME");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			System.out.println("Executing on EdgeDriver");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}

		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	

	@AfterTest
	public void teardown() {
		driver.quit();
		System.out.println("close the Browser");

	}

	@AfterSuite
	public void close() {
		extent.flush();

	}

}
