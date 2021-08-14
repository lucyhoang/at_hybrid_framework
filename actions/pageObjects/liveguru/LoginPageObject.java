package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveguru.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToEmailTextBox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, email);
	}

	public void enterToPasswordTextBox(String pass) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, pass);
	}

	public void enterToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public String getEmptyEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INVALID_EMPTY_EMAIL_MESSAGE);
		return getElementAttributeText(driver, LoginPageUI.INVALID_EMPTY_EMAIL_MESSAGE);
	}

	public String getEmptyPasswordErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INVALID_EMPTY_PASSWORD_MESSAGE);
		return getElementAttributeText(driver, LoginPageUI.INVALID_EMPTY_PASSWORD_MESSAGE);
	}

	public String getInvalidEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INVALID_FORMAT_EMAIL_MESSAGE);
		return getElementAttributeText(driver, LoginPageUI.INVALID_FORMAT_EMAIL_MESSAGE);
	}

	public String getInvalidPasswordErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INVALID_FORMAT_PASSWORD_MESSAGE);
		return getElementAttributeText(driver, LoginPageUI.INVALID_FORMAT_PASSWORD_MESSAGE);
	}

	public String getIncorrectEmailOrPasswordErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INVALID_LOGIN_MESSAGE);
		return getElementAttributeText(driver, LoginPageUI.INVALID_LOGIN_MESSAGE);
	}
}
