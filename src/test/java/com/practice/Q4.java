package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q4 {
	@Test
	public void f() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		Select dropDowns=new Select(driver.findElement(By.name("my-select")));
		dropDowns.selectByValue("2");
		String selectedOption=dropDowns.getFirstSelectedOption().getText();
		Assert.assertEquals(selectedOption, "Two");
	}
}
