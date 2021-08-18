package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class SearchPageObject extends BasePage {

	private WebDriver driver;
	
	public SearchPageObject() {
		
	}
	
	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
}
