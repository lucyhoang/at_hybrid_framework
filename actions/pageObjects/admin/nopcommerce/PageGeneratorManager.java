package pageObjects.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	private static LoginPageObject loginPageObject;
	private static DashboardPageObject dashboardPageObject;
	private static ProductSearchPageObject productSearchPageObject;
	private static ProductDetailPageObject productDetailPageObject;
	
	
	private PageGeneratorManager() {
		
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		if (loginPageObject == null) {
			loginPageObject = new LoginPageObject(driver);
		}
		return loginPageObject;
	}
	
	public static DashboardPageObject getDashboardPage(WebDriver driver) {
		if (dashboardPageObject == null) {
			dashboardPageObject = new DashboardPageObject(driver);
		}
		return dashboardPageObject;
	}
	
	public static ProductSearchPageObject getProductSearchPage(WebDriver driver) {
		if (productSearchPageObject == null) {
			productSearchPageObject = new ProductSearchPageObject(driver);
		}
		return productSearchPageObject;
	}
	
	public static ProductDetailPageObject getProductDetailPage(WebDriver driver) {
		if (productDetailPageObject == null) {
			productDetailPageObject = new ProductDetailPageObject(driver);
		}
		return productDetailPageObject;
	}
	
	
}
