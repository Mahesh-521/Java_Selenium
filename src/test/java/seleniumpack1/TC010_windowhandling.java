package seleniumpack1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC010_windowhandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://letcode.in/window");
		
		driver.findElement(By.id("home")).click();
		String pwindow=driver.getWindowHandle();
		System.out.println("Parent Window "+pwindow);
		System.out.println("Url is "+driver.getCurrentUrl());
		
		driver.findElement(By.id("multi")).click();
		Set<String> mwindow=driver.getWindowHandles();
		
		for(String cwindow:mwindow) {
			driver.switchTo().window(cwindow);
			System.out.println("Url is : "+driver.getCurrentUrl());
		}

	}

}
