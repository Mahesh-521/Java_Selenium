package seleniumpack1;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab15 {
	WebDriver driver;
	String projectpath = System.getProperty("user.dir");

	@Test(dataProvider = "dp")
	public void f(String firstname, String lastname, String email, String telephone, String password,
			String confirmPassword) throws InterruptedException {
		String title = driver.getTitle();
		if (title.equals("Your Store")) {
			System.out.println("Title is matched");
		} else {
			System.out.println("Title is not matched");
		}
		Thread.sleep(3000);
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();

		WebElement heading = driver.findElement(By.xpath("//h1[text()='Register Account']"));
		if (heading.isDisplayed()) {
			System.out.println("Heading is Displayed");
		} else {
			System.out.println("Heading is not Displayed");
		}
		driver.findElement(By.id("input-firstname")).sendKeys(firstname);
		driver.findElement(By.id("input-lastname")).sendKeys(lastname);
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-telephone")).sendKeys(telephone);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.id("input-confirm")).sendKeys(confirmPassword);

		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(3000);
		try {
            WebElement successMessage = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
            if (successMessage.isDisplayed()) {
                System.out.println("Success: " + successMessage.getText());
                Assert.assertTrue(true);
            }
        } catch (Exception e) {
            WebElement warning = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]"));
            System.out.println("Account already exists: " + warning.getText());
            Assert.assertTrue(warning.isDisplayed(), "Warning message not displayed!");
        }
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After method");
		driver.quit();
	}

	@DataProvider
	public Object[][] dp() throws IOException, CsvException {
		
		String csvfile=projectpath+"\\userdetails.csv";
		String[][] data = new String[2][6];
		CSVReader csvReader=new CSVReader(new FileReader(csvfile));
		List<String[]> data1=csvReader.readAll();
		
		for(int i=0;i<data1.size();i++) {
			data[i][0]=data1.get(i)[0];
			data[i][1]=data1.get(i)[1];
			data[i][2]=data1.get(i)[2];
			data[i][3]=data1.get(i)[3];
			data[i][4]=data1.get(i)[4];
			data[i][5]=data1.get(i)[5];
		}
		
		return data;
	}

}
