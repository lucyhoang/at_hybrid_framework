package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	
	private Alert alert;
	private WebDriverWait explicitWait;
	private long timeout = 30;
	private Select select;
	private JavascriptExecutor jsExecutor;
	private Actions action;
	
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();

	}
	
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public Alert waitForAlertPresent(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, timeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert(WebDriver driver) {
		alert = waitForAlertPresent(driver);
		alert.accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		alert = waitForAlertPresent(driver);
		alert.dismiss();
	}
	
	public void sendKeyToAlert(WebDriver driver, String value) {
		alert = waitForAlertPresent(driver);
		alert.sendKeys(value);
	}
	
	public String getAlertText(WebDriver driver) {
		alert = waitForAlertPresent(driver);
		return alert.getText();
	}
	
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void switchWindowByTitle(WebDriver driver, String title) {
		Set<String> allIds = driver.getWindowHandles();
		for (String id : allIds) {
			driver.switchTo().window(id);
			if (driver.getTitle() == title) {
				break;
			}
		}
	}
	
	public void switchToAnotherWindow(WebDriver driver, String parentId) {
		Set<String> allIds = driver.getWindowHandles();
		for (String id : allIds) {
			driver.switchTo().window(id);
			if (driver.getWindowHandle() != parentId) {
				break;
			}
		}
	}
	
	public void closeAllWindowWithoutParent(WebDriver driver, String parentId) {
		Set<String> allIds = driver.getWindowHandles();
		for (String id : allIds) {
			if (id != parentId) {
				driver.switchTo().window(id);
				driver.close();
				sleepInSecond(1);
			}
		}
		driver.switchTo().window(parentId);
	}
	
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	
	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	
	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}
	
	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}
	
	public void sendKeyToElement(WebDriver driver, WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	
	public int getElementSizes(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}
	
	public void selectDropdownByText(WebDriver driver, String locator, String itemText) {
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(itemText);
	}
	
	public String getSelectedItemDropdown(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.isMultiple();
	}
	
	public void selectItemInCustomDropDown(WebDriver driver, String parentLocator, String itemLocator, String expectedItem) {
		getElement(driver, parentLocator).click();
		sleepInSecond(1);
		
		explicitWait = new WebDriverWait(driver, timeout);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(itemLocator)));
				
		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor)driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				
				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}
	
	public String getElementAttributeValue(WebDriver driver, String locator, String attributeName) {
		return getElement(driver, locator).getAttribute(attributeName);
	}
	
	public String getElementAttributeText(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}
	
	public void checkToCheckboxOrRadio(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}
	}
	
	public void unCheckToCheckboxOrRadio(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}
	
	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}
	
	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}
	
	public WebDriver switchToIFrameByElement(WebDriver driver, String locator) {
		return driver.switchTo().frame(getElement(driver, locator));
	}
	
	public WebDriver switchToDefaultContent(WebDriver driver) {
		return driver.switchTo().defaultContent();
	}
	
	//User interaction
	
	public void hoverToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}
	
	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
	}
	
	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
	}
	
	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}
	
	//Javascript Executor
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor)driver;
		return jsExecutor.executeScript(javaScript);
	}
	
	public String getInnerText(WebDriver driver) {
		jsExecutor = (JavascriptExecutor)driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText");
	}
	
	public boolean areExpectedTextInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor)driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText");
		return textActual.equals(textExpected);
	}
	
	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("window.scrollBy(0, document.body.scrollHeight");
	}
	
	public void navigateToUrlByJs(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript(String.format("window.location = '%s'", url));
	}
	
	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor)driver;
		WebElement element = getElement(driver, locator);
		String originalStyle = getElement(driver, locator).getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}
	
	public void clickToElementByJs(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
	}
	
	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}
	
	//Chu y: han che dung. Do ko tuong thich voi hanh vi cua user
	public void sendKeyToElementByJs(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript(String.format("arguments[0].setAttribute('value', '%s');", value), getElement(driver, locator));
	}
	
	public void removeAttruteInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript(String.format("arguments[0].removeAttribute('%s');", attributeRemove), getElement(driver, locator));
	}
	
	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, 30);
		jsExecutor = (JavascriptExecutor)driver;
		
		ExpectedCondition<Boolean> jQueryLoaded = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver arg0) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoaded = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver arg0) {
				try {
					return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
				} catch (Exception e) {
					return true;
				}
			}
		};
		
		return explicitWait.until(jQueryLoaded) && explicitWait.until(jsLoaded);

	}
	
	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor)driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage", getElement(driver, locator));
	}
	
	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor)driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, locator));
		return status;
	}
	
	public void waitForElementVisible(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForAllElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	
}
