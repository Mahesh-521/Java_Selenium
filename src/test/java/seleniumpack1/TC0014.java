package seleniumpack1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC0014 {
	WebDriver driver;
	@Parameters("browser")
	@Test
	public void test1(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.out.println("Chrome browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.flipkart.com/");
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.out.println("Firefox browser");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get("https://www.flipkart.com/");
		}else {
			System.out.println("Edge browser");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get("https://www.flipkart.com/");

		}
	}

}
