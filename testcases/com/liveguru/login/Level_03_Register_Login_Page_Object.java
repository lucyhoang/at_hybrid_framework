package com.liveguru.login;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.liveguru.HomePageObject;
import pageObjects.liveguru.LoginPageObject;
import pageObjects.liveguru.MyDashboardPageObject;


public class Level_03_Register_Login_Page_Object {
		
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	
	String projectLocation = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void Login_01_Empty_Email_And_Password() {
		//Open url
		driver.get("http://live.demoguru99.com/");
		homePage = new HomePageObject(driver);
		
		//Click to my account at the footer to login
		homePage.clickToMyAccountFooterLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.enterToEmailTextBox("");
		loginPage.enterToPasswordTextBox("");
		loginPage.enterToLoginButton();
		
		Assert.assertEquals(loginPage.getEmptyEmailErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getEmptyPasswordErrorMessage(), "This is a required field.");
		
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		loginPage.refresh(driver);
		
		loginPage.enterToEmailTextBox("123@456.789");
		loginPage.enterToPasswordTextBox("123456");
		loginPage.enterToLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
	}
	
	@Test(description = "Password less than 6 character")
	public void Login_03_Invalid_Password() {
		loginPage.refresh(driver);
		
		loginPage.enterToEmailTextBox("lucy@gmail.com");
		loginPage.enterToPasswordTextBox("123");
		loginPage.enterToLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidPasswordErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
	}
	
	
	@Test
	public void Login_04_Incorrect_Email() {
		loginPage.refresh(driver);
		
		loginPage.enterToEmailTextBox(genRandomEmail());
		loginPage.enterToPasswordTextBox("123456");
		loginPage.enterToLoginButton();
		
		Assert.assertEquals(loginPage.getIncorrectEmailOrPasswordErrorMessage(), "Invalid login or password.");
	}
	@Test
	public void Login_05_Incorrect_Password() {
		loginPage.refresh(driver);
		
		loginPage.enterToEmailTextBox("lucy@gmail.com");
		loginPage.enterToPasswordTextBox("123123");
		loginPage.enterToLoginButton();
		
		Assert.assertEquals(loginPage.getIncorrectEmailOrPasswordErrorMessage(), "Invalid login or password.");
	}
	
	@Test
	public void Login_06_Valid_Email_Password() {
		loginPage.refresh(driver);
		
		loginPage.enterToEmailTextBox("lucy@gmail.com");
		loginPage.enterToPasswordTextBox("123456");
		loginPage.enterToLoginButton();
		
		myDashboardPage = new MyDashboardPageObject(driver);
		Assert.assertTrue(myDashboardPage.isMyDashboardHeaderDisplay());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
		
	public String genRandomEmail() {
		return String.format("test_%s@gmail.com", (new Date()).getTime());
	}
	
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
