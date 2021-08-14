package pageObjectsFactory.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

/*
 * Sử dụng mô hình Page Factory thay cho POM (Page Object Manager)
 * Nhiều nhược điểm hơn là ưu điểm, phù hợp các dự án nhỏ hơn, ko cơ độn như POM
 * */

public class HomePageObject extends BasePageFactory{
	private WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//div[@id='nivo-slider']")
	private WebElement slider;
	
	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	private WebElement registerLink;
	
	@FindBy(how = How.XPATH, using = "//a[@class='ico-login']")
	private WebElement loginLink;
	
	public HomePageObject() {
		
	}
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isHomePageLogoDisplayed() {
		waitForElementVisible(driver, slider);
		return isElementDisplayed(driver, slider);
	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
		
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

}
