package pageObjects.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import pageUIs.nopcommerce.admin.LoginPageUIs;

public class LoginPageObject extends BasePageAdmin {

	private WebDriver driver;
	
	public LoginPageObject() {
		
	}
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToEmailTextBox(String email) {
		waitForElementVisible(driver, LoginPageUIs.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUIs.EMAIL_TEXTBOX, email);
	}
	
	public void enterToPasswordTextBox(String password) {
		waitForElementVisible(driver, LoginPageUIs.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUIs.PASSWORD_TEXTBOX, password);
	}

	public DashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUIs.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUIs.LOGIN_BUTTON);
		DashboardPageObject dashboardPage = PageGeneratorManager.getDashboardPage(driver);
		return dashboardPage;
	}
	
}
