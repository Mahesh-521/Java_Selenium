package com.orangehrm.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
	WebDriver driver;
	@Given("Launch the browser")
	public void launch_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	    
	}

	@Given("Navigate to the URL")
	public void navigate_to_the_url() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	}

	@Then("Enter the username")
	public void enter_the_username() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("username")).sendKeys("Admin");
	    
	}

	@Then("Enter the Password")
	public void enter_the_password() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("password")).sendKeys("admin123");
	    
	}

	@Then("Click on Login Button")
	public void click_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
	}

	@Then("Login should be successful")
	public void login_should_be_successful() {
	    // Write code here that turns the phrase above into concrete actions
		if(driver.getTitle().equalsIgnoreCase("OrangeHRM")) {
			System.out.println("Title is matched");
		}else {
			System.out.println("Title not matched");
		}
	    
	}
	
	@Then("Close the browser")
	public void close_the_browser() {
	    driver.quit();
	}
	
	@Then("Enter the invalid username")
	public void enter_the_invalid_username() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("username")).sendKeys("mahesh");
	}
	
	@Then("Login should be unsuccessful")
	public void login_should_be_unsuccessful() {
	    WebElement ele=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"));
	    if(ele.isDisplayed()) {
	    	System.out.println("Login unsuccessful");
	    }
	}
	

}
