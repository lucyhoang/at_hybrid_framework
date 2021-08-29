package pageObjects.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import pageUIs.nopcommerce.admin.ProductSearchPageUIs;

public class ProductSearchPageObject extends BasePageAdmin {

	private WebDriver driver;
	
	public ProductSearchPageObject() {
		
	}
	
	public ProductSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterProductNameTextBox(String value) {
		waitForElementVisible(driver, ProductSearchPageUIs.PRODUCT_TEXTBOX);
		sendKeyToElement(driver, ProductSearchPageUIs.PRODUCT_TEXTBOX, value);
	}

	public void clickSearchButton() {
		waitForElementClickable(driver, ProductSearchPageUIs.SEARCH_BUTTON);
		clickToElement(driver, ProductSearchPageUIs.SEARCH_BUTTON);
	}

	public ProductDetailPageObject clickToEditButtonByProductName(String productName) {
		waitForElementVisible(driver, ProductSearchPageUIs.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		clickToElement(driver, ProductSearchPageUIs.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		
		return PageGeneratorManager.getProductDetailPage(driver);
	}

	public boolean isPictureImageUpdated(String productImgName, String productName) {
		productImgName = productImgName.replace(" ", "-").toLowerCase();
		waitForElementVisible(driver, ProductSearchPageUIs.PICTURE_BY_PRODUCT_AND_SRC, productName, productImgName);
		return isElementDisplayed(driver, ProductSearchPageUIs.PICTURE_BY_PRODUCT_AND_SRC, productName, productImgName);
	}

	public boolean isSuccessMessageDisplay(String message) {
		waitForElementVisible(driver, ProductSearchPageUIs.SUCCESS_MESSAGE_NAME, message);
		return isElementDisplayed(driver, ProductSearchPageUIs.SUCCESS_MESSAGE_NAME, message);
	}

}
