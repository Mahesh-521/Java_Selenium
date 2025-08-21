package seleniumpack1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab14 {
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
		WebElement successmessage = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
		if (successmessage.isDisplayed()) {
			System.out.println("Success message is displayed : " + successmessage.getText());
		} else {
			System.out.println("Success message is not displayed");
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
	public Object[][] dp() throws IOException {
		
		File file1 = new File(projectpath + "\\userdetails.xlsx");
		FileInputStream fs = new FileInputStream(file1);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet worksheet = workbook.getSheetAt(0);
		int rows = worksheet.getPhysicalNumberOfRows();
		int col = worksheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Num of rows : " + rows);
		String[][] data = new String[rows][6];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				data[i][j] = worksheet.getRow(i).getCell(j).toString();
			}
		}
		return data;
	}

}
