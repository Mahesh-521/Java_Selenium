package seleniumpack1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC005 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		
		List<WebElement> alllinks=driver.findElements(By.tagName("a"));
		
		System.out.println("Total links : "+alllinks.size());
		
		for(WebElement link:alllinks) {
			System.out.println("The link is "+link.getAttribute("href"));
			System.out.println("The Text is "+link.getText());
		}

	}

}
