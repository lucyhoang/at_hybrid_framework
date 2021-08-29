package pageObjects.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

public class DashboardPageObject extends BasePageAdmin {

	private WebDriver driver;
	
	public DashboardPageObject() {
		
	}
	
	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
