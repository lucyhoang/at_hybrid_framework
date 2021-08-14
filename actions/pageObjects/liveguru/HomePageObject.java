package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveguru.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToMyAccountFooterLink() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_FOOTER);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_FOOTER);
	}
}
