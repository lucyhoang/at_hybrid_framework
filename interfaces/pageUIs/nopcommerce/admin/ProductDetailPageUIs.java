package pageUIs.nopcommerce.admin;

public class ProductDetailPageUIs {
	public static final String TOGGLE_ICON_BY_CARD_NAME = "//div[@class='card-title' and contains(text(),'%s')]//following-sibling::div//i";
	public static final String PRODUCT_PICTURE_BLOCK_BY_FILE_NAME = "//div[@class='upload-picture-block']//img[contains(@src,'%s')]";
	public static final String ALT_NEW_PRODUCT_PICTURE_TEXTBOX = "//input[@id='AddPictureModel_OverrideAltAttribute']";
	public static final String TITLE_NEW_PRODUCT_PICTURE_TEXTBOX = "//input[@id='AddPictureModel_OverrideTitleAttribute']";
	public static final String DISPLAY_ORDER_NEW_PRODUCT_PICTURE_TEXTBOX = "//input[@id='AddPictureModel_DisplayOrder']";
	public static final String ADD_PRODUCT_PICTURE_BUTTON = "//button[@id='addProductPicture']";
	public static final String PRODUCT_PICTURE_BY_ALT_TITLE_ORDER_SRC = "//table[@id='productpictures-grid']//td[text()='%s']//following-sibling::td[text()='%s']//preceding-sibling::td[text()='%s']//preceding-sibling::td//a[contains(@href,'%s')]";
	public static final String DELETE_PICTURE_BUTTON_BY_TITLE = "//table[@id='productpictures-grid']//td[contains(text(),'%s')]//following-sibling::td//a[contains(text(),'Delete')]";
	public static final String DELETE_PICTURE_BUTTONS = "//table[@id='productpictures-grid']//td//a[contains(text(),'Delete')]";
	public static final String EDIT_PICTURE_BUTTON_BY_TITLE = "//table[@id='productpictures-grid']//td[contains(text(),'%s')]//following-sibling::td//a[contains(text(),'Edit')]";
	public static final String SAVE_BUTTON = "//button[@name='save']";
}
