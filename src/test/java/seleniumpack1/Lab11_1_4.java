package seleniumpack1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Lab11_1_4 {
	WebDriver driver;

	@Test
	public void f() throws InterruptedException {
		Lab11_1_Locators_POM lp=new Lab11_1_Locators_POM(driver);
		lp.clickDesktop();
		lp.clickMac();
		Assert.assertEquals(lp.getMacHeading(), "Mac");
		lp.selectDropDown();
		lp.addCart();
		lp.searchProduct("Mobile");
		lp.clickCheckBox();
		lp.finalSearch();
		
	}

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}


}
