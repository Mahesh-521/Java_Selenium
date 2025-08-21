package seleniumpack1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_Selenium {
	

	public static void main(String[] args) throws InterruptedException, IOException {
		String projectpath = System.getProperty("user.dir");
		
		Properties prob=new Properties();
		FileInputStream fis=new FileInputStream(projectpath+"\\login.properties");
		prob.load(fis);
		String url=prob.getProperty("url");
		String username=prob.getProperty("username");
		String password=prob.getProperty("password");
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get(url);
		Thread.sleep(3000);
		
		String title=driver.getTitle();
		
		System.out.println("The title is "+title);
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

}
