package seleniumpack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php");
		String title=driver.getTitle();
		if(title.equals("Your Store")) {
			System.out.println("Title is matched");
		}else {
			System.out.println("Title is not matched");
		}
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
	
		WebElement heading=driver.findElement(By.xpath("//h1[text()='Register Account']"));
		if(heading.isDisplayed()) {
			System.out.println("Heading is Displayed");
		}else {
			System.out.println("Heading is not Displayed");
		}
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		WebElement warning=driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]"));
		String warningmsg=warning.getText();
		if(warningmsg.contains("Warning: You must agree to the Privacy Policy!")) {
			System.out.println("Warning message is verified");
		}else {
			System.out.println("Warning message is not verified");
		}
		String firstname="asaewe";
		driver.findElement(By.id("input-firstname")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		if(firstname.length()<=0 || firstname.length()>=33) {
			WebElement firstNameWarning=driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div"));
			if(firstNameWarning.isDisplayed()) {
				System.out.println("First name warning is displayed : "+firstNameWarning.getText());
			}else {
				System.out.println("First name warning is not displayed");
			}
		}else {
			System.out.println("First name is accepted");
		}
		Thread.sleep(3000);
		String lastname="asnasn";
		driver.findElement(By.id("input-lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		if(lastname.length()<=0 || lastname.length()>=33) {
			WebElement lastNameWarning=driver.findElement(By.xpath("//*[@id=\"account\"]/div[3]/div/div"));
			if(lastNameWarning.isDisplayed()) {
				System.out.println("Last name warning is displayed : "+lastNameWarning.getText());
			}else {
				System.out.println("Last name warning is not displayed");
			}
		}else {
			System.out.println("Last name is accepted");
		}
		
		Thread.sleep(3000);
		String email="aseieend@gmail.com";
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		if(email.length()<=0 || !email.contains("@") || !email.contains(".") || email.startsWith("@")) {
			WebElement emailWarning=driver.findElement(By.xpath("//*[@id=\"account\"]/div[4]/div/div"));
			if(emailWarning.isDisplayed()) {
				System.out.println("Email warning is displayed : "+emailWarning.getText());
				
				
			}else {
				System.out.println("Email warning is not displayed");
			}
		}else {
			System.out.println("Email is accepted");
		}
		
		Thread.sleep(3000);
		String telephone="37382222223";
		driver.findElement(By.id("input-telephone")).sendKeys(telephone);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		if(telephone.length()<3 || telephone.length()>32) {
			WebElement telephoneWarning=driver.findElement(By.xpath("//*[@id=\"account\"]/div[5]/div/div"));
			if(telephoneWarning.isDisplayed()) {
				System.out.println("telephone warning is displayed : "+telephoneWarning.getText());
			}else {
				System.out.println("telephone warning is not displayed");
			}
		}else {
			System.out.println("telephone is accepted");
		}
		
		Thread.sleep(3000);
		String password="abcdss";
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		if(password.length()<4 || password.length()>20) {
			WebElement passwordWarning=driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div"));
			if(passwordWarning.isDisplayed()) {
				System.out.println("password warning is displayed : "+passwordWarning.getText());
			}else {
				System.out.println("password warning is not displayed");
			}
		}else {
			System.out.println("password is accepted");
		}
		
		Thread.sleep(3000);
		String confirmPassword="abcdss";
		driver.findElement(By.id("input-confirm")).sendKeys(confirmPassword);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		if(!(confirmPassword.equals(password))) {
			WebElement passwordconfirmWarning=driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[2]/div/div"));
			if(passwordconfirmWarning.isDisplayed()) {
				System.out.println("Confirm password warning is displayed : "+passwordconfirmWarning.getText());
			}else {
				System.out.println("Confirm password warning is not displayed");
			}
		}else {
			System.out.println("Confirm password is accepted");
		}
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(3000);
		WebElement successmessage=driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
		if(successmessage.isDisplayed()) {
			System.out.println("Success message is displayed : "+successmessage.getText());
		}else {
			System.out.println("Success message is not displayed");
		}
		
		driver.findElement(By.linkText("Continue")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("View your order history")).click();
	}
	
}
