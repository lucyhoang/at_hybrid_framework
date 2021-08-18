package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class MyAccountPageObject extends BasePage {

	private WebDriver driver;
	
	public MyAccountPageObject() {
		
	}
	
	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
}
