package test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BaseTest;

//@Listeners(GenerateReport.class)
public class TestSomething extends BaseTest {
    WebDriver driver;
	String email, password;
	
	By emailTextboxBy = By.name("Email");
	By passwordTextboxBy = By.name("Password");
	
	@BeforeClass
	public void beforeClass() throws Exception {
		driver = getBrowserDriver("FIREFOX", "https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		email = "nguyenhoan1" + generateEmail();
		password = "12345678";
	}

	@Test
	public void TC_01_Login() {
		driver.get("https://demo.nopcommerce.com/");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public String generateEmail() {
		Random rand = new Random();
		return rand.nextInt(9999) + "@email.net";
	}

	public void sleepInSecond(long timeoutInSecond) {
		try {
			Thread.sleep(timeoutInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	}