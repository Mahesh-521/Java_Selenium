package com.orangehrm.test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.Login_PageFactory;
import com.orangehrm.utilites.ExcelUtiles;
import com.orangehrm.utilites.ScreenShots;

public class LoginOrangeHRM extends BaseTest {
	static String projectpath = System.getProperty("user.dir");

	@Test(dataProvider = "logindata", enabled = false)
	public void verifylogin(String username, String password) throws IOException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		test = extent.createTest("Login with the user:" + username);
		Login_PageFactory obj = PageFactory.initElements(driver, Login_PageFactory.class);
		obj.enterusername(username);
		obj.enterpassword(password);
		obj.clickonlogin();

		String actualtitle = driver.getTitle();
		if (actualtitle.equalsIgnoreCase("OrangeHR")) {
			test.pass("Login Successfull and title is matched:" + actualtitle);
		} else {
			String screenpath = ScreenShots.Capture(driver, "Login_Failed:" + username);
			test.fail("Login unSuccessfull and title is not matched:" + actualtitle)
					.addScreenCaptureFromPath(screenpath);

		}
	}

	@Test(enabled = false)
	public void question1() throws IOException {
		driver.get("https://www.google.com");
		test = extent.createTest("Verify the Title of the page");
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase("Google")) {
			test.pass("Title is matched " + actualTitle);
		} else {
			String screenpath = ScreenShots.Capture(driver, "Title is not matched");
			test.fail("Title is not matched : " + actualTitle).addScreenCaptureFromPath(screenpath);
		}
	}

	@Test(dataProvider = "logindata", enabled = false)
	public void question2(String username, String password) throws IOException {
		driver.get("https://the-internet.herokuapp.com/login");
		test = extent.createTest("Verify login is successful");
		Login_PageFactory obj = PageFactory.initElements(driver, Login_PageFactory.class);
		obj.enterusername(username);
		obj.enterpassword(password);
		obj.clickonlogin();

		if (obj.loginmessage.isDisplayed()) {
			test.pass("Login is successful");
		} else {
			String screenpath = ScreenShots.Capture(driver, "Login is Failed ");
			test.fail("Login is unsuccessful : ").addScreenCaptureFromPath(screenpath);
		}
	}

	@Test(dataProvider = "logindata",enabled = false)
	public void question3(String product) throws IOException {
		driver.get("https://www.amazon.in/");
		test = extent.createTest("Getting top 5 Products");
		Login_PageFactory obj = PageFactory.initElements(driver, Login_PageFactory.class);
		obj.searchProduct(product);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		if(obj.top5Products()) {
			test.pass("top5 products is printed");
		}else {
			String screenpath = ScreenShots.Capture(driver, "top5 products is failed");
			test.fail("top5 products is not printed : ").addScreenCaptureFromPath(screenpath);
		}
	}
	
	@Test(enabled = false)
	public void question4() throws IOException {
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		test = extent.createTest("Verify Option two selected");
		Login_PageFactory obj = PageFactory.initElements(driver, Login_PageFactory.class);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		if(obj.selectDropdown().equals("Two")) {
			test.pass("Option Two is verified");
		}else {
			String screenpath = ScreenShots.Capture(driver, "Option two is failed");
			test.fail("Option Two is not verified : ").addScreenCaptureFromPath(screenpath);
		}
	}
	
	@Test(enabled = false)
	public void question5() throws IOException {
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		test = extent.createTest("Verify Alert message success");
		Login_PageFactory obj = PageFactory.initElements(driver, Login_PageFactory.class);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		obj.clickOnAlertButtonANDAccept(driver);
		if(obj.getSuccessMessage().equals("You successfully clicked an alert")) {
			test.pass("Alert success message is displayed");
		}else {
			String screenpath = ScreenShots.Capture(driver, "Alert message failed");
			test.fail("Alert success message is not displayed : ").addScreenCaptureFromPath(screenpath);
		}
	}
	
	@Test(enabled = false)
	public void question6() throws IOException {
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		test = extent.createTest("Verify All check boxes selected");
		Login_PageFactory obj = PageFactory.initElements(driver, Login_PageFactory.class);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		obj.clickAllCheckBoxes();
		if(obj.verifyAllCheckBoxes()) {
			test.pass("All checkboxes is selected");
		}else {
			String screenpath = ScreenShots.Capture(driver, "Check boxes failed");
			test.fail("All checkboxes is not selected : ").addScreenCaptureFromPath(screenpath);
		}
	}
	
	@Test(enabled = false)
	public void question7() throws IOException {
		driver.get("https://the-internet.herokuapp.com/tables");
		test = extent.createTest("Get all names and jason email");
		Login_PageFactory obj = PageFactory.initElements(driver, Login_PageFactory.class);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		obj.getAllRows();
		if(obj.findJasonEmail()!=null) {
			test.pass("Jason email is retrieved");
		}else {
			String screenpath = ScreenShots.Capture(driver, "Jason email failed");
			test.fail("Jason email is not retrieved : ").addScreenCaptureFromPath(screenpath);
		}
		
	}
	
	@Test(enabled = false)
	public void question8() throws IOException {
		driver.get("https://the-internet.herokuapp.com/windows");
		test = extent.createTest("Verify multiple window titles");
		Login_PageFactory obj = PageFactory.initElements(driver, Login_PageFactory.class);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String parentWindow = obj.switchToNewWindow(driver);
        String newTitleWindow=obj.getTitle(driver);

        obj.switchToParent(parentWindow,driver);
        String parentTitleWindow=obj.getTitle(driver);
		if(newTitleWindow.equals("New Window") && parentTitleWindow.equals("The Internet")) {
			test.pass("title is verified");
		}else {
			String screenpath = ScreenShots.Capture(driver, "title failed");
			test.fail("title is not verified : ").addScreenCaptureFromPath(screenpath);
		}
		
	}
	
	@Test
	public void question9() throws IOException {
		driver.get("https://www.wikipedia.org/");
		test = extent.createTest("Take screenshot of home page");
		Login_PageFactory obj = PageFactory.initElements(driver, Login_PageFactory.class);
		
		String screenpath = ScreenShots.Capture(driver, "home page screenshot");
		test.pass("home page screenshot : ").addScreenCaptureFromPath(screenpath);
		
	}

	@DataProvider
	public Object[][] logindata() throws IOException {

		String excelpath = projectpath + "\\src\\test\\resources\\Testdata\\data.xlsx";

//		return ExcelUtiles.getdata(excelpath, "Sheet1");
//		return ExcelUtiles.getdata(excelpath, "Sheet2");
		return ExcelUtiles.getdata(excelpath, "Sheet3");

	}
}
