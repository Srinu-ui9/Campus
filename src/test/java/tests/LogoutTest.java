package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.LoginPage;
import setup.DriverInitiliazation;

public class LogoutTest extends DriverInitiliazation {
	@Test(priority = 2)
	public void Logoutpage() throws InterruptedException {
		test = extent.createTest("Starting Logout Test");

		LoginPage login = new LoginPage(driver);

		login.Logout();

		test.log(Status.INFO, "Logout submitted Successfully");
	}

}