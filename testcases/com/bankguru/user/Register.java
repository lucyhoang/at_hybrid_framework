package com.bankguru.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Register {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
	}

	@Test
	public void Register_01_Empty() {
		System.out.println("Register_01_Empty");
		System.out.println("Register_01_Empty");
		System.out.println("Register_01_Empty");
		System.out.println("Register_01_Empty");
		System.out.println("Register_01_Empty");
		System.out.println("Register_01_Empty");
		System.out.println("Register_01_Empty");
		System.out.println("Register_01_Empty");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
	
	public void test() {
		System.out.println();
	}

}
