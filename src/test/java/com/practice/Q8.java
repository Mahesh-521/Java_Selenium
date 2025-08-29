package com.practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q8 {
	@Test
	public void f() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String pwindow=driver.getWindowHandle();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> allWindows = driver.getWindowHandles();
		for (String windowHandle : allWindows) {
            if (!windowHandle.equals(pwindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
		System.out.println("New Window : "+driver.getTitle());
		driver.switchTo().window(pwindow);
		System.out.println("Parent Window : "+driver.getTitle());
	}
}
