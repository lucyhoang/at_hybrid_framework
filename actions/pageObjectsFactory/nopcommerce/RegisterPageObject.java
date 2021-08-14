package pageObjectsFactory.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {

	private WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//input[@id='gender-male']")
	private WebElement genderMaleRadio;
	
	@FindBy(how = How.XPATH, using = "//input[@id='FirstName']")
	private WebElement firstNameTextbox;
	
	@FindBy(how = How.XPATH, using = "//input[@id='LastName']")
	private WebElement lastNameTextbox;
	
	@FindBy(how = How.XPATH, using = "//input[@id='Email']")
	private WebElement emailTextbox;
	
	@FindBy(how = How.XPATH, using = "//input[@id='Password']")
	private WebElement passwordTextbox;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(how = How.XPATH, using = "//button[@id='register-button']")
	private WebElement registerButton;
	
	@FindBy(how = How.XPATH, using = "//div[@class='result' and text() = 'Your registration completed']")
	private WebElement successMsg;
	
	@FindBy(how = How.XPATH, using = "//a[@class='ico-logout']")
	private WebElement logoutLink;
	
	
	public RegisterPageObject() {
	}
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickToGenderMaleRadioButton() {
		waitForElementClickable(driver, genderMaleRadio);
		clickToElement(driver, genderMaleRadio);
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendKeyToElement(driver, firstNameTextbox, firstName);
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		sendKeyToElement(driver, lastNameTextbox, lastName);		
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendKeyToElement(driver, emailTextbox, email);		
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendKeyToElement(driver, passwordTextbox, password);		
	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendKeyToElement(driver, confirmPasswordTextbox, confirmPassword);		
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);		
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, successMsg);
		return isElementDisplayed(driver, successMsg);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);	
	}

}
