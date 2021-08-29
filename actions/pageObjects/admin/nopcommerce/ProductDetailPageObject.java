package pageObjects.admin.nopcommerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageUIs.nopcommerce.admin.ProductDetailPageUIs;

public class ProductDetailPageObject extends BasePageAdmin {

	private WebDriver driver;
	
	public ProductDetailPageObject() {
		
	}
	
	public ProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToExpandPanelByName(String panelName) {
		waitForElementVisible(driver, ProductDetailPageUIs.TOGGLE_ICON_BY_CARD_NAME, panelName);
		String toogleIconStatus = getElementAttributeValue(driver, ProductDetailPageUIs.TOGGLE_ICON_BY_CARD_NAME, "class", panelName);
		if (toogleIconStatus.contains("fa-plus")) {
			waitForElementClickable(driver, ProductDetailPageUIs.TOGGLE_ICON_BY_CARD_NAME, panelName);
			clickToElement(driver, ProductDetailPageUIs.TOGGLE_ICON_BY_CARD_NAME, panelName);
		}
	}

	public void uploadPictureByFileName(String fileName) {
		uploadMultipleFiles(driver, "pictures", fileName);
	}

	public boolean isPictureIsUploadSuccessByFileName(String fileName) {
		fileName = fileName.split("\\.")[0];
		waitForElementVisible(driver, ProductDetailPageUIs.PRODUCT_PICTURE_BLOCK_BY_FILE_NAME, fileName);
		return isElementDisplayed(driver, ProductDetailPageUIs.PRODUCT_PICTURE_BLOCK_BY_FILE_NAME, fileName);
	}

	public void enterToAltTextBox(String value) {
		waitForElementVisible(driver, ProductDetailPageUIs.ALT_NEW_PRODUCT_PICTURE_TEXTBOX);
		sendKeyToElement(driver, ProductDetailPageUIs.ALT_NEW_PRODUCT_PICTURE_TEXTBOX, value);
	}

	public void enterToTitleTextBox(String value) {
		waitForElementVisible(driver, ProductDetailPageUIs.TITLE_NEW_PRODUCT_PICTURE_TEXTBOX);
		sendKeyToElement(driver, ProductDetailPageUIs.TITLE_NEW_PRODUCT_PICTURE_TEXTBOX, value);
		
	}

	public void enterToDisplayOrderTextBox(String value) {
		waitForElementVisible(driver, ProductDetailPageUIs.DISPLAY_ORDER_NEW_PRODUCT_PICTURE_TEXTBOX);
		sendKeyToElement(driver, ProductDetailPageUIs.DISPLAY_ORDER_NEW_PRODUCT_PICTURE_TEXTBOX, value);
	}

	public void clickToAddPictureButton() {
		waitForElementClickable(driver, ProductDetailPageUIs.ADD_PRODUCT_PICTURE_BUTTON);
		clickToElement(driver, ProductDetailPageUIs.ADD_PRODUCT_PICTURE_BUTTON);
	}

	public boolean isPictureImageDisplayed(String productName, String order, String alt, String title) {
		productName = productName.replace(" ", "-").toLowerCase();
		waitForElementVisible(driver, ProductDetailPageUIs.PRODUCT_PICTURE_BY_ALT_TITLE_ORDER_SRC, alt, title, order, productName);
		return isElementDisplayed(driver, ProductDetailPageUIs.PRODUCT_PICTURE_BY_ALT_TITLE_ORDER_SRC, alt, title, order, productName);
	}

	public ProductSearchPageObject clickToSaveButton() {
		waitForElementClickable(driver, ProductDetailPageUIs.SAVE_BUTTON);
		clickToElement(driver, ProductDetailPageUIs.SAVE_BUTTON);
		return PageGeneratorManager.getProductSearchPage(driver);
	}

	public void clickToDeleteImageByTitle(String title) {
		waitForElementVisible(driver, ProductDetailPageUIs.DELETE_PICTURE_BUTTON_BY_TITLE, title);
		clickToElement(driver, ProductDetailPageUIs.DELETE_PICTURE_BUTTON_BY_TITLE, title);
		acceptAlert(driver);
	}
	
	public void deleteAllImages() {
		List<WebElement> deleteButtons = getElements(driver, ProductDetailPageUIs.DELETE_PICTURE_BUTTONS);
		
		for (WebElement deleteBtn : deleteButtons) {
			deleteBtn.click();
			acceptAlert(driver);
		}

	}


}
