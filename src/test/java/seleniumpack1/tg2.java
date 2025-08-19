package seleniumpack1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class tg2 {
	@Test(dataProvider = "dp")
	public void f(String username, String password) throws InterruptedException {
		System.out.println("Testing");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
		
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After method");
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { 
			new Object[] { "Admin", "admin123" }, 
			new Object[] { "Pooja", "admin123" },
			 };
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}

}
