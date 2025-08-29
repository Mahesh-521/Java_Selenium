package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q6 {
	@Test
	public void f() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		List<WebElement> checkboxs=driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(WebElement check:checkboxs) {
			if(!check.isSelected()) {
				check.click();
			}
		}
		
		for(int i=0;i<checkboxs.size();i++) {
			Assert.assertTrue(checkboxs.get(i).isSelected());
		}
	}
}
