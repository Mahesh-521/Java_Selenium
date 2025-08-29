package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q7 {
	@Test
	public void f() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/tables");
		WebElement table1=driver.findElement(By.id("table1"));
		List<WebElement> rows=table1.findElements(By.xpath(".//tbody/tr "));
		for(WebElement row:rows) {
			String lastName=row.findElement(By.xpath("./td[1]")).getText();
			String firstName=row.findElement(By.xpath("./td[2]")).getText();
			System.out.println(lastName+" "+firstName);
		}
		for(WebElement row:rows) {
			if(row.findElement(By.xpath("./td[2]")).getText().equalsIgnoreCase("jason")) {
				System.out.println("Jason Email : "+row.findElement(By.xpath("./td[3]")).getText());
			}
		}
	}
}
