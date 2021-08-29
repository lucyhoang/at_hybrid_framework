package pageObjects.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import pageUIs.nopcommerce.admin.BasePageUIs;

public class BasePageAdmin extends BasePage {
	
	public void openSubMenuByName(WebDriver driver, String menu, String subMenu) {
		waitForElementVisible(driver, BasePageUIs.MENU_LINK_BY_NAME , menu);
		clickToElement(driver, BasePageUIs.MENU_LINK_BY_NAME, menu);
		
		waitForElementVisible(driver, BasePageUIs.SUB_MENU_LINK_BY_NAME , menu, subMenu);
		clickToElement(driver, BasePageUIs.SUB_MENU_LINK_BY_NAME , menu, subMenu);		
	}
	
	public ProductSearchPageObject openProductList(WebDriver driver) {
		openSubMenuByName(driver, "Catalog", "Products");
		return PageGeneratorManager.getProductSearchPage(driver);
	}
	
	public void uploadMultipleFiles (WebDriver driver,String cardName, String...fileNames) {
		String filePath = GlobalConstants.UPLOAD_FOLDER_PATH;
		String fullFileNames = "";
		for (String file: fileNames) {
			fullFileNames = fullFileNames + filePath + file + "\n";
		}
		fullFileNames = fullFileNames.trim();
		
		getElement(driver, BasePageUIs.UPLOAD_FILE_BY_CARD_NAME, cardName).sendKeys(fullFileNames);
	}
}
