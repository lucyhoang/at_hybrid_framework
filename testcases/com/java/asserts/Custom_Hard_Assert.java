package com.java.asserts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BaseTest;

public class Custom_Hard_Assert extends BaseTest {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		driver = getBrowserDriver("firefox", "http://live.demoguru99.com/index.php/customer/account/login/");
	}

	@Test
	public void TC_01_Login_Empty_Email_Password() {
		log.info("Step 01 - Input to email textbox");
		driver.findElement(By.id("email")).sendKeys("");

		log.info("Step 02 - Input to password textbox");
		driver.findElement(By.id("pass")).sendKeys("");
		
		log.info("Step 03 - Click to Login button");
		driver.findElement(By.id("send2")).click();

		// First Pass (5)
		log.info("Step 05 - Verify error message displayed");
		verifyEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");

		// Second Fail (10)
		log.info("Step 10 - Verify error message displayed");
		verifyEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field");

		// Pass (45)
		log.info("Step 45 - Verify .....");
		verifyTrue(driver.findElement(By.xpath("//button[@id='send2']")).isDisplayed());

		// Third Fail (50)
		log.info("Step 50 - Verify .....");
		verifyTrue(false);

		// Pass (65)
		log.info("Step 65 - Verify .....");
		verifyTrue(false);

		// Fourth Fail (76)
		log.info("Step 76 - Verify .....");
		verifyFalse(true);
	}

	@Test
	public void TC_02_Test() {
		log.info("One");
		verifyTrue(true);
		
		log.info("Two");
		verifyTrue(false);
		
		log.info("Three");
		verifyTrue(false);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}