package com.nopcommerce.login;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.RegisterPageObject;

public class Level_04_Register_Login_Multi_Browser extends BaseTest {
		
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	String email, password;
	String projectLocation = System.getProperty("user.dir");

	@Parameters({"browser", "appUrl"})
	@BeforeClass
	public void beforeClass(String browser,String appUrl) throws Exception {
		System.out.println("browser:" + browser + "-appUrl:" + appUrl);
		//driver = getBrowserDriver(browser, appUrl);
		driver = getMultiBrowser(browser, appUrl);
		email = genRandomEmail();
		password = "123456";
	}

	@Test
	public void Login_01_Register_To_System() {
		//Step 1. Open URL
		driver.get("https://demo.nopcommerce.com/");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		//Step 2. Verify logo of homepage displayed
		Assert.assertTrue(homePage.isHomePageLogoDisplayed());
				
		//Step 3. Click Register link --> Register page
		registerPage = homePage.clickToRegisterLink();
		
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
		homePage = registerPage.clickToLogoutLink();
	}
	
	@Test
	public void Login_02_Login() {
		//Step 1. Click to login link
		loginPage = homePage.clickToLoginLink();
		
		//Step 2. Input to email textbox
		loginPage.enterToEmailTextbox(email);
		
		//Step 2. Input to password textbox
		loginPage.enterToPasswordTextbox(password);
		
		System.out.println("email:" + email);
		System.out.println("password:" + password);
		
		//Step 3. click login
		loginPage.enterToLoginButton();
		loginPage.sleepInSecond(5);
		
		//Step 4. Verify login well
		Assert.assertTrue(homePage.isLoggedIn());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
		
	public String genRandomEmail() {
		return String.format("test_%s@gmail.com", (new Date()).getTime());
	}
	
}
