package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	private static HomePageObject homePageObject;
	private static LoginPageObject loginPageObject;
	private static RegisterPageObject registerPageObject;
	
	private PageGeneratorManager() {
		
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		if (homePageObject == null) {
			homePageObject = new HomePageObject(driver);
		}
		return homePageObject;
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		if (loginPageObject == null) {
			loginPageObject = new LoginPageObject(driver);
		}
		return loginPageObject;
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		if (registerPageObject == null) {
			registerPageObject = new RegisterPageObject(driver);
		}
		return registerPageObject;
	}
	
	
}
