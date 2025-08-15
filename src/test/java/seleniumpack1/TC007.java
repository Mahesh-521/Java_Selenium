package seleniumpack1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC007 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationpractice.pl/index.php");

		driver.findElement(By.linkText("Sign in")).click();
		if (driver.findElement(By.id("email_create")).isDisplayed()) {
			System.out.println("Email created is displayed");
			driver.findElement(By.id("email_create")).clear();
			driver.findElement(By.id("email_create")).sendKeys("abcasabadav@gmail.com");
			driver.findElement(By.id("email_create")).sendKeys(Keys.TAB);
			driver.findElement(By.id("email_create")).sendKeys(Keys.ENTER);
		} else {
			System.out.println("Email created is not displayed");
		}
		Thread.sleep(3000);
		driver.findElement(By.id("id_gender1")).click();
		if(driver.findElement(By.id("id_gender1")).isSelected()) {
			System.out.println("Gender 1 is selected");
		}else {
			System.out.println("Gender 1 is not selected");
		}
	}

}
