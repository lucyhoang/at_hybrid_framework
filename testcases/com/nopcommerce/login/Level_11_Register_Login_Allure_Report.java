package com.nopcommerce.login;

import java.lang.reflect.Method;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.MyAccountPageObject;
import pageObjects.nopcommerce.OrderPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;
import pageObjects.nopcommerce.SearchPageObject;
import pageUIs.nopcommerce.BasePageUI;
import reportConfig.ExtentTestManager;

@Epic("Regression Test")
@Feature("Login-Register")
public class Level_11_Register_Login_Allure_Report extends BaseTest {
		
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	SearchPageObject searchPage;
	MyAccountPageObject myAccountPage;
	OrderPageObject orderPage;
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

	@Description("Login_01_Register_To_System")
	@Story("Login")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void Login_01_Register_To_System(Method method) {
		//Step 1. Open URL
		ExtentTestManager.startTest(method.getName(), "TC_01_NewCustomer");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1. Open URL");
		driver.get("https://demo.nopcommerce.com/");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		//Step 2. Verify logo of homepage displayed
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 2. Verify logo of homepage displayed");
		//Assert.assertTrue(homePage.isHomePageLogoDisplayed());
		verifyFalse(homePage.isHomePageLogoDisplayed());
				
		//Step 3. Click Register link --> Register page
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 3. Click Register link --> Register page");
		registerPage = homePage.clickToRegisterLink();
		
		//Step 4. Click to gender male radio
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 4. Click to gender male radio");
		registerPage.clickToGenderMaleRadioButton();
		
		//Step 5. Input to FirstName textbox
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 5. Input to FirstName textbox");
		registerPage.enterToFirstNameTextbox("Lucy");
		
		//Step 6. Input to LastName textbox
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 6. Input to LastName textbox");
		registerPage.enterToLastNameTextbox("Hoang");
		
		//Step 7. Input to Email textbox
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 7. Input to Email textbox");
		registerPage.enterToEmailTextbox(email);
		
		//Step 8. Input to Password textbox
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 8. Input to Password textbox");
		registerPage.enterToPasswordTextbox(password);
		
		//Step 9. Input to ConfirmPassword textbox
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 9. Input to ConfirmPassword textbox");
		registerPage.enterToConfirmPasswordTextbox(password);
		
		//Step 10. Click to Register button
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 10. Click to Register button");
		registerPage.clickToRegisterButton();
		
		//Step 11. Verify message success displayed
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 11. Verify message success displayed");
		//Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		verifyFalse(registerPage.isSuccessMessageDisplayed());
		
		//Step 12. Logout to HomePage
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 12. Logout to HomePage");
		homePage = registerPage.clickToLogoutLink();
		
		ExtentTestManager.endTest();
	}
	
	@Description("Login_02_Login")
	@Story("Login")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void Login_02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login_02_Login");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1. Click to login link");
		loginPage = homePage.clickToLoginLink();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 2. Input to email textbox");
		loginPage.enterToEmailTextbox(email);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 2. Input to password textbox");
		loginPage.enterToPasswordTextbox(password);
		
		System.out.println("email:" + email);
		System.out.println("password:" + password);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 3. click login");
		loginPage.enterToLoginButton();
		loginPage.sleepInSecond(5);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 4. Verify login well");
		Assert.assertTrue(homePage.isLoggedIn());
		
		ExtentTestManager.endTest();
	}

	@Description("Login_03_Switch_At_Footer_Dynamic_Page")
	@Story("Login")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Login_03_Switch_At_Footer_Dynamic_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login_03_Switch_At_Footer_Dynamic_Page");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Home page -> Search page");
		searchPage = (SearchPageObject)homePage.openPageByNameFromFooter(driver, BasePageUI.PAGE_NAME.SEARCH);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Search page -> My Account");
		myAccountPage = (MyAccountPageObject)searchPage.openPageByNameFromFooter(driver, BasePageUI.PAGE_NAME.MYACCOUNT);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account -> Order Page");
		orderPage = (OrderPageObject)myAccountPage.openPageByNameFromFooter(driver, BasePageUI.PAGE_NAME.ORDERS);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Order -> My Account");
		myAccountPage = (MyAccountPageObject)orderPage.openPageByNameFromFooter(driver, BasePageUI.PAGE_NAME.MYACCOUNT);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account -> Search Page");
		searchPage = (SearchPageObject)myAccountPage.openPageByNameFromFooter(driver, BasePageUI.PAGE_NAME.SEARCH);
		
		ExtentTestManager.endTest();
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
		
	public String genRandomEmail() {
		return String.format("test_%s@gmail.com", (new Date()).getTime());
	}
	
}
