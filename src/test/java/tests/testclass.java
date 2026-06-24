package tests;

import pages.testpage;
import setup.DriverInitiliazation;

public class testclass extends DriverInitiliazation{
	
	public void test() {
		testpage tes = new testpage(driver);
		tes.usernamee();
		tes.passworddd();
		
	}

}


