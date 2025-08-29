package com.orangehrm.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Login_PageFactory {
//	WebDriver driver;

	// By uname=By.name("username");
	@FindBy(name = "username")
	WebElement uname;
	// By pword=By.name("password");
	@FindBy(name = "password")
	WebElement pword;
	// By loginbutton=By.xpath("//button[@type='submit']");
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginbutton;

	// Question 2
	@FindBy(id = "flash")
	public WebElement loginmessage;

	public void enterusername(String username) {
		uname.sendKeys(username);
	}

	public void enterpassword(String password) {
		pword.sendKeys(password);
	}

	public void clickonlogin() {
		loginbutton.click();
	}

	// question 3
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchinput;

	@FindBy(id = "nav-search-submit-button")
	WebElement searchButton;

	@FindBy(xpath = "//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']/span")
	List<WebElement> productNames;

	public void searchProduct(String product) {
		searchinput.sendKeys(product);
		searchButton.click();
	}

	public boolean top5Products() {
		for (int i = 0; i < 5 && i < productNames.size(); i++) {
			System.out.println("Product " + (i + 1) + " Name is : " + productNames.get(i).getText());
		}
		if (productNames.size() >= 5) {
			return true;
		}
		return false;
	}

	// question 4

	@FindBy(name = "my-select")
	WebElement dropdown;

	public String selectDropdown() {
		Select dropDowns = new Select(dropdown);
		dropDowns.selectByValue("2");
		return dropDowns.getFirstSelectedOption().getText();
	}

	// question 5
	@FindBy(xpath = "//button[@onClick='jsAlert()']")
	WebElement alert;

	@FindBy(id = "result")
	WebElement alertsuccessmessage;

	public void clickOnAlertButtonANDAccept(WebDriver driver) {
		alert.click();
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	public String getSuccessMessage() {
		return alertsuccessmessage.getText();
	}

	// question 6
	@FindBy(xpath = "//input[@type='checkbox']")
	List<WebElement> checkboxs;

	public void clickAllCheckBoxes() {
		for (WebElement check : checkboxs) {
			if (!check.isSelected()) {
				check.click();
			}
		}
	}

	public boolean verifyAllCheckBoxes() {
		for (int i = 0; i < checkboxs.size(); i++) {
			if (!checkboxs.get(i).isSelected()) {
				return false;
			}
		}
		return true;
	}

	// question 7

	@FindBy(xpath = "//table[@id='table1']//tbody/tr")
	List<WebElement> allRows;

	public void getAllRows() {
		for (WebElement row : allRows) {
			String lastName = row.findElement(By.xpath("./td[1]")).getText();
			String firstName = row.findElement(By.xpath("./td[2]")).getText();
			System.out.println(lastName + " " + firstName);
		}
	}

	public String findJasonEmail() {
		for (WebElement row : allRows) {
			if (row.findElement(By.xpath("./td[2]")).getText().equalsIgnoreCase("jason")) {
				System.out.println("Jason Email : " + row.findElement(By.xpath("./td[3]")).getText());
				return row.findElement(By.xpath("./td[3]")).getText();
			}
		}
		return null;
	}

	// question 8
	@FindBy(linkText = "Click Here")
	WebElement clickHereLink;

	public String switchToNewWindow(WebDriver driver) {
		String parentWindow = driver.getWindowHandle();
		clickHereLink.click();

		Set<String> allWindows = driver.getWindowHandles();
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				return parentWindow;
			}
		}
		return parentWindow;
	}
	
	public String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public void switchToParent(String parentWindow,WebDriver driver) {
        driver.switchTo().window(parentWindow);
    }

}
