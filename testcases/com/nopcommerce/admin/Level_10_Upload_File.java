package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.nopCommerce.AdminDashboardPO;
import pageObjects.nopCommerce.AdminLoginPO;
import pageObjects.nopCommerce.AdminProductPO;
import pageObjects.nopCommerce.PageGeneratorManagerNopCommerce;

public class Level_10_Upload_File extends AbstractTest {

	WebDriver driver;
	String fileName="hinh3.jpg";
	String pictureAlt="Description";
	String pictureTitle="Title";
	String pictureOrder="1";
	String productName="Adobe Photoshop CS4";
	
	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {

		driver = getBrowserDriver(browserName, urlValue);
		loginPage = PageGeneratorManagerNopCommerce.getAdminLoginPage(driver);

		dashboardPage = loginPage.loginToSystem("admin@yourstore.com", "admin");
		productPage = dashboardPage.openProductPage();
	}

	@Test
	public void TC_01_UploadFile() {
		// Search name
		productPage.inputToProductNameTextbox(productName);

		productPage.clickToSearchButton();

		// Go to edit
		productPage.clickToEditIconDetailByName(productName);

		// scroll upload function
		productPage.scrollToPicturePanel();
		//click to Plus icon
		productPage.clickToPlusIconByPanelID(driver,"product-pictures");
		
		// upload 1 file(file name,title,alt,order)
		productPage.uploadFileByPanelD(driver, "product-pictures", fileName);
		
		
		//verify file name upload seccess
		Assert.assertTrue(productPage.isNewPictureUploadedSuccess(fileName));
		productPage.inputToAltTextbox(pictureAlt);
		productPage.inputToTitleTextbox(pictureTitle);
		productPage.clickToIconAtOrderTextbox("Increase");

		// Add to product picture
		productPage.clickToAddProductPictureButton();

		// verify on picture table
		Assert.assertTrue(productPage.areImageDetailDisplayed(productName, pictureOrder, pictureAlt, pictureTitle));

		// save=> go to product page
		productPage.clickToSaveButton();
		
		// Search Adobe Photoshop4
		productPage.inputToProductNameTextbox(productName);

		productPage.clickToSearchButton();

		// verify (name, image name)-> found
		Assert.assertTrue(productPage.areProductDisplayed(productName, productName, "AD_CS4_PH", "75", "10000", "Simple", "true"));

		productPage.clickToEditIconDetailByName(productName);

		// scroll upload function
		productPage.scrollToPicturePanel();
		
		// delete image
		productPage.clickToDeleteButtonByPictureTitle(pictureTitle);

		// save-> go to product page
		productPage.clickToSaveButton();

		// Search Adobe Photoshop4
		productPage.inputToProductNameTextbox(productName);

		productPage.clickToSearchButton();

		// verify (name, image name)-> not found
		Assert.assertTrue(productPage.areProductDisplayed("default-image", productName, "AD_CS4_PH", "75", "10000", "Simple", "true"));

	}

	// @Test
	public void TC_02_Select_Deselect_All() {

	}

	// 3.Check Displayed
	// @Test
	public void TC_03_Displayed_All() {

	}

	// 4.Edit
	// @Test
	public void TC_04_() {

	}

	// @Test
	public void TC_05_Position() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	AdminLoginPO loginPage;
	AdminDashboardPO dashboardPage;
	AdminProductPO productPage;
}