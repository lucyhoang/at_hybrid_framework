package com.nopcommerce.login;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.RegisterPageObject;

public class Level_03_Register_Login_Page_Object {
		
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	String email, password;
	String projectLocation = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		email = genRandomEmail();
		password = "123456";
	}

	@Test
	public void Login_01_Register_To_System() {
		//Step 1. Open URL
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		
		//Step 2. Verify logo of homepage displayed
		Assert.assertTrue(homePage.isHomePageLogoDisplayed());
				
		//Step 3. Click Register link --> Register page
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		
		//Step 4. Click to gender male radio
		registerPage.clickToGenderMaleRadioButton();
		
		//Step 5. Input to FirstName textbox
		registerPage.enterToFirstNameTextbox("Lucy");
		
		//Step 6. Input to LastName textbox
		registerPage.enterToLastNameTextbox("Hoang");
		
		//Step 7. Input to Email textbox
		registerPage.enterToEmailTextbox(email);
		
		//Step 8. Input to Password textbox
		registerPage.enterToPasswordTextbox(password);
		
		//Step 9. Input to ConfirmPassword textbox
		registerPage.enterToConfirmPasswordTextbox(password);
		
		//Step 10. Click to Register button
		registerPage.clickToRegisterButton();
		
		//Step 11. Verify message success displayed
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		
		//Step 12. Logout to HomePage
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);
	}
	
	@Test
	public void Login_02_Login() {
		//Step 1. Click to login link
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		//Step 2. Input to email textbox
		loginPage.enterToEmailTextbox(email);
		
		//Step 2. Input to password textbox
		loginPage.enterToPasswordTextbox(password);
		
		//Step 2. Input to login button
		loginPage.enterToLoginButton();
		
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
		
	public String genRandomEmail() {
		return String.format("test_%s@gmail.com", (new Date()).getTime());
	}
	
}
