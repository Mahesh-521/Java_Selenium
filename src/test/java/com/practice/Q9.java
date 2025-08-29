package com.practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q9 {
	@Test
	public void f() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org/");
		File src= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String projectpath = System.getProperty("user.dir");
		File destfile=new File(projectpath+"\\homepage.png");
		FileUtils.copyFile(src, destfile);
	}
}
