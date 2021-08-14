package pageObjectsFactory.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {
	
	private WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//input[@id='Email']")
	private WebElement emailTextbox;
	
	@FindBy(how = How.XPATH, using = "//input[@id='Password']")
	private WebElement passwordTextbox;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Log in']")
	private WebElement loginButton;
	
	public LoginPageObject() {
	}
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendKeyToElement(driver, emailTextbox, email);	
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendKeyToElement(driver, passwordTextbox, password);	
	}

	public void enterToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);	
	}

}
