package pageUIs.nopcommerce.admin;

public class ProductSearchPageUIs {
	public static final String PRODUCT_TEXTBOX = "//input[@id='SearchProductName']";
	public static final String SEARCH_BUTTON = "//button[@id='search-products']";
	public static final String EDIT_BUTTON_BY_PRODUCT_NAME = "//td[text()='%s']//following-sibling::td[contains(@class,'button-column')]/a";
	public static final String PICTURE_BY_PRODUCT_AND_SRC = "//td[text()='%s']//preceding-sibling::td//img[contains(@src, '%s')]";
	public static final String SUCCESS_MESSAGE_NAME = "//div[contains(@class,'alert-success') and contains(string(),'%s')]";
	
}
