package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.admin.nopcommerce.DashboardPageObject;
import pageObjects.admin.nopcommerce.LoginPageObject;
import pageObjects.admin.nopcommerce.PageGeneratorManager;
import pageObjects.admin.nopcommerce.ProductDetailPageObject;
import pageObjects.admin.nopcommerce.ProductSearchPageObject;

public class Level_10_Admin_Upload_File extends BaseTest {

	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	ProductSearchPageObject productSearch;
	ProductDetailPageObject productDetail;

	String email = "admin@yourstore.com";
	String password = "admin";
	String productName = "Build your own computer";
	String projectLocation = System.getProperty("user.dir");
	String productAvatarImg = "hoa_dong_noi.jpeg";
	String productAvatarAlt = "hoa dong noi";
	String productAvatarTitle = "hoa dong noi";
	String productAvatarOrder = "0";

	@Parameters({ "browser", "appUrl" })
	@BeforeClass
	public void beforeClass(String browser, String appUrl) throws Exception {
		driver = getMultiBrowser(browser, appUrl);

		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToEmailTextBox(email);
		loginPage.enterToPasswordTextBox(password);

		dashboardPage = loginPage.clickToLoginButton();

		productSearch = dashboardPage.openProductList(driver);
		productSearch.enterProductNameTextBox(productName);
		productSearch.clickSearchButton();

		productDetail = productSearch.clickToEditButtonByProductName(productName);
	}

	@Test
	public void Level10_Admin_Upload_File() {
		productDetail.clickToExpandPanelByName("Picture");
		productDetail.deleteAllImages();
		productDetail.uploadPictureByFileName(productAvatarImg);

		Assert.assertTrue(productDetail.isPictureIsUploadSuccessByFileName(productAvatarImg));

		productDetail.enterToAltTextBox(productAvatarAlt);
		productDetail.enterToTitleTextBox(productAvatarTitle);
		//productDetail.enterToDisplayOrderTextBox(productAvatarOrder);

		productDetail.clickToAddPictureButton();

		Assert.assertTrue(productDetail.isPictureImageDisplayed(productName, productAvatarOrder, productAvatarAlt,productAvatarTitle));

		productSearch = productDetail.clickToSaveButton();

		Assert.assertTrue(productSearch.isSuccessMessageDisplay("The product has been updated successfully."));

		productSearch.enterProductNameTextBox(productName);
		productSearch.clickSearchButton();
		Assert.assertTrue(productSearch.isPictureImageUpdated(productName, productName));

		productDetail = productSearch.clickToEditButtonByProductName(productName);
		productDetail.clickToExpandPanelByName("Picture");
		productDetail.clickToDeleteImageByTitle(productAvatarTitle);
		productDetail.clickToSaveButton();

		productSearch.enterProductNameTextBox(productName);
		productSearch.clickSearchButton();
		Assert.assertTrue(productSearch.isPictureImageUpdated("default-image", productName));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
