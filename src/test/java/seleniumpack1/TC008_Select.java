package seleniumpack1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC008_Select {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://tutorialsninja.com/demo/index.php?");
		
		driver.findElement(By.linkText("Desktops")).click();
		driver.findElement(By.linkText("Mac (1)")).click();
		
		WebElement sort=driver.findElement(By.id("input-sort"));
		
		Select sl=new Select(sort);
		
//		sl.selectByIndex(5);
		
		List<WebElement> eleCount=sl.getOptions();
		
		for(int i=0;i<eleCount.size();i++) {
			System.out.println("The values : "+eleCount.get(i).getText());
		}
		
		

	}

}
