package seleniumpack1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab11_2_3 {
	WebDriver driver;

	@Test
	public void f() {
		Lab11_2_Locators_POM2 lp=PageFactory.initElements(driver, Lab11_2_Locators_POM2.class);
		lp.clickDesktop();
		lp.clickMac();
		lp.selectDropDown();
		lp.addCart();
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
