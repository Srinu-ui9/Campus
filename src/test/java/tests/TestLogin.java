package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import pages.LoginPage;
import setup.DriverInitiliazation;
import utility.Util;

public class TestLogin extends DriverInitiliazation {

	LoginPage loginpage;

	@Test(priority = 1)
	public void LogiinTest() throws Exception {
		test = extent.createTest("Login");
		loginpage = new LoginPage(driver);
		loginpage.User(Util.DataFetchFromExcel("Login", 1, 0));
		test.log(Status.INFO, "User Name Entered Successfully");
		loginpage.Pass(Util.DataFetchFromExcel("Login", 1, 1));
		test.log(Status.INFO, "Password Entered Successfully");
		loginpage.submit();

//		SoftAssert sa = new SoftAssert();
//		String Expected = "CAMPUS";
//		String Actual = loginpage.DashboardLogo();
//		sa.assertEquals(Expected, Actual);
//
//		if (Actual.equals(Expected)) {
//			test.log(Status.PASS, "Login Successfully With Valid Credentials");
//		} else {
//			test.log(Status.FAIL, "Login fail expected " + Expected + " but found " + Actual + "");
//		
//		}
//		sa.assertAll();
	}
}
