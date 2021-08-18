package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class OrderPageObject extends BasePage {

	private WebDriver driver;
	
	public OrderPageObject() {
		
	}
	
	public OrderPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
}
