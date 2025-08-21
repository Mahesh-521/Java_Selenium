package seleniumpack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Lab11_2_Locators_POM2 {

	

//	By desktopLink = By.linkText("Desktops");
	@FindBy(linkText = "Desktops")
	WebElement desktopLink;
	
//	By MacLink = By.linkText("Mac (1)");
	@FindBy(linkText = "Mac (1)")
	WebElement MacLink;
	
//	By sortDropDown = By.id("input-sort");
	@FindBy(id  = "input-sort")
	WebElement sortDropDown;
	
//	By addToCart = By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]/span");
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]/span")
	WebElement addToCart;
	
	
	

//	By macHeading = By.xpath("//*[@id=\"content\"]/h2");
	@FindBy(xpath = "//*[@id=\"content\"]/h2")
	WebElement macHeading;
	
//	By searchBox = By.name("search");
	@FindBy(name  = "search")
	WebElement searchBox;
	
//	By searchButton = By.xpath("//*[@id=\"search\"]/span");
	@FindBy(xpath = "//*[@id=\"search\"]/span")
	WebElement searchButton;
	
//	By descriptionCheckbox = By.id("description");
	@FindBy(id  = "description")
	WebElement descriptionCheckbox;
	
//	By finalSearchButton = By.id("button-search");
	@FindBy(id  = "button-search")
	WebElement finalSearchButton;

	public void clickDesktop() {
		desktopLink.click();
	}

	public void clickMac() {
		MacLink.click();
	}

	public void selectDropDown() {
		Select sort = new Select(sortDropDown);
		sort.selectByVisibleText("Name (A - Z)");
	}

	public void addCart() {
		addToCart.click();
	}

	public String getMacHeading() {
		return macHeading.getText();
	}

	public void searchProduct(String product) {
		searchBox.sendKeys(product);
		searchButton.click();
	}

	public void clickCheckBox() {
		descriptionCheckbox.click();
	}
	
	public void finalSearch() {
        finalSearchButton.click();
    }

}
