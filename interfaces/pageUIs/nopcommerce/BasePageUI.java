package pageUIs.nopcommerce;

public class BasePageUI {
	public static final String SEARCH_PAGE_FOOTER = "//div[@class='footer']//a[text()='Search']";
	public static final String MY_ACCOUNT_PAGE_FOOTER = "//div[@class='footer']//a[text()='My account']";
	public static final String ORDER_PAGE_FOOTER = "//div[@class='footer']//a[text()='Orders']";
	
	public static final String FOOTER_TEMPLATE = "//div[@class='footer']//a[text()='%s']";
	
	public static enum PAGE_NAME {
		SEARCH, MYACCOUNT, ORDERS
	}
	
	public static String getPageName(PAGE_NAME ePageName) {
		switch (ePageName) {
			case SEARCH:
				return "Search";
			case MYACCOUNT:
				return "My account";
			case ORDERS:
				return "Orders";
		}
		
		return "";
	}
}
