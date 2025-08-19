package seleniumpack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab6 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/account");
		driver.manage().window().maximize();

		driver.findElement(By.id("input-email")).sendKeys("aseieend@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("abcdss");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		driver.findElement(By.linkText("Components")).click();
		driver.findElement(By.linkText("Monitors (2)")).click();

		Select show = new Select(driver.findElement(By.id("input-limit")));
		show.selectByVisibleText("25");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Specification")).click();

		WebElement specifications = driver.findElement(By.id("tab-specification"));
		if (specifications.isDisplayed()) {
			System.out.println("Details present on specification");
		} else {
			System.out.println("Details not present on specification");
		}

		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[1]")).click();

		Thread.sleep(3000);

		WebElement successMsg = driver.findElement(By.xpath("//div[contains(@class,'alert-success')]"));
		if (successMsg.getText().contains("Success: You have added Apple Cinema 30\" to your wish list!")) {
			System.out.println("Verified message");
		} else {
			System.out.println("Not verified");
		}

		driver.findElement(By.name("search")).sendKeys("Mobile");
		driver.findElement(By.className("input-group-btn")).click();
		driver.findElement(By.id("description")).click();
		driver.findElement(By.id("button-search")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("HTC Touch HD")).click();
		Thread.sleep(3000);
		WebElement quantity = driver.findElement(By.id("input-quantity"));
		quantity.clear();
		quantity.sendKeys("3");
		Thread.sleep(3000);
		driver.findElement(By.id("button-cart")).click();
		Thread.sleep(3000);

//		WebElement successMsg1 = driver.findElement(By.xpath("//div[contains(@class,'alert-success')]"));
//		Thread.sleep(3000);
//		if (successMsg1.getText().contains("Success: You have added Apple Cinema 30\" to your wish list!")) {
//			System.out.println("Verified message Add to cart");
//		} else {
//			System.out.println("Not verified");
//		}
		
		driver.findElement(By.xpath("//*[@id=\"cart\"]/button")).click();
		WebElement mobileName=driver.findElement(By.linkText("HTC Touch HD"));
		if(mobileName.getText().equals("HTC Touch HD")) {
			System.out.println("Mobile name is verified");
		}else {
			System.out.println("Mobile name is not verified");
		}
		
		driver.findElement(By.linkText("Checkout")).click();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Logout")).click();
		
		WebElement logout=driver.findElement(By.id("content"));
		if(logout.getText().contains("Account Logout")) {
			System.out.println("Logout is verifed");
		}else {
			System.out.println("Logout is not verifed");
		}
		
		driver.findElement(By.linkText("Continue")).click();
	}

}
