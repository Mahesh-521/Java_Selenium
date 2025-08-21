package seleniumpack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Lab11_1_Locators_POM {

	WebDriver driver;

	public Lab11_1_Locators_POM(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By desktopLink = By.linkText("Desktops");
	By MacLink = By.linkText("Mac (1)");
	By sortDropDown = By.id("input-sort");
	By addToCart = By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]/span");

	By macHeading = By.xpath("//*[@id=\"content\"]/h2");
	By searchBox = By.name("search");
	By searchButton = By.xpath("//*[@id=\"search\"]/span");
	By descriptionCheckbox = By.id("description");
	By finalSearchButton = By.id("button-search");

	public void clickDesktop() {
		driver.findElement(desktopLink).click();
	}

	public void clickMac() {
		driver.findElement(MacLink).click();
	}

	public void selectDropDown() {
		Select sort = new Select(driver.findElement(sortDropDown));
		sort.selectByVisibleText("Name (A - Z)");
	}

	public void addCart() {
		driver.findElement(addToCart).click();
	}

	public String getMacHeading() {
		return driver.findElement(macHeading).getText();
	}

	public void searchProduct(String product) {
		driver.findElement(searchBox).sendKeys(product);
		driver.findElement(searchButton).click();
	}

	public void clickCheckBox() {
		driver.findElement(descriptionCheckbox).click();
	}
	
	public void finalSearch() {
        driver.findElement(finalSearchButton).click();
    }

}
