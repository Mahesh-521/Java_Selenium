package seleniumpack1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_Selenium {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com/");
		System.out.println("Title : "+driver.getTitle());
		
		WebElement search=driver.findElement(By.id("APjFqb"));
		search.sendKeys("Automation testing tools");
//		search.submit();
		
		search.sendKeys(Keys.ENTER);
		
//		Thread.sleep(3000);
//		driver.findElement(By.className("YrSbJc")).click();
//		driver.findElement(By.name("btnK")).click();
		
		System.out.println("Title : "+driver.getTitle());
		
		//driver.quit();

	}

}
