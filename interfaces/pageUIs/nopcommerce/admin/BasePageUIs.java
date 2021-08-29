package pageUIs.nopcommerce.admin;

public class BasePageUIs {
	public static final String MENU_LINK_BY_NAME = "//ul[@role='menu']/li/a/p[contains(text(),'%s')]";
	public static final String SUB_MENU_LINK_BY_NAME = "//ul[@role='menu']/li/a/p[contains(text(),'%s')]/ancestor::li/ul//p[contains(text(),'%s')]";
	public static final String UPLOAD_FILE_BY_CARD_NAME = "//div[@id='product-%s']//input[@type='file']";
}
