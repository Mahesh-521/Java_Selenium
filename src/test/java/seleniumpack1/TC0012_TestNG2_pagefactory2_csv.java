package seleniumpack1;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC0012_TestNG2_pagefactory2_csv {
	WebDriver driver;
	String projectpath = System.getProperty("user.dir");

	@Test(dataProvider = "dp")
	public void f(String username, String password) throws InterruptedException {
		String title = driver.getTitle();
		System.out.println("The Title is:" + title);
		Thread.sleep(3000);
		Login_pagefactory obj = PageFactory.initElements(driver, Login_pagefactory.class);
		obj.enterusername(username);
		obj.enterpassword(password);
		obj.clickonlogin();
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After method");
		driver.quit();
	}

	@DataProvider
	public Object[][] dp() throws IOException, CsvException {
		String[][] data1 = new String[3][2];
		String csvFile = projectpath + "\\data2.csv"; // Path to your CSV file
		CSVReader csvReader = new CSVReader(new FileReader(csvFile));
		List<String[]> data = csvReader.readAll(); // Read all rows

		// Iterate over CSV data (skipping header)
		for (int i = 0; i < data.size(); i++) { // Start from 1 to skip header
			data1[i][0] = data.get(i)[0]; // Get username from the CSV
			data1[i][1] = data.get(i)[1]; // Get password from the CSV

		}
		return data1;
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class");
	}

	
}
