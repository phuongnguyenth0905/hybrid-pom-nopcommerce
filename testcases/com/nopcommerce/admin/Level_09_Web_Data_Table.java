package com.nopcommerce.admin;

import static org.testng.Assert.assertTrue;

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
import pageObjects.nopCommerce.PageGeneratorManager;

public class Level_09_Web_Data_Table extends AbstractTest {

	WebDriver driver;

	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {

		driver = getBrowserDriver(browserName, urlValue);
		loginPage = PageGeneratorManager.getAdminLoginPage(driver);

//		loginPage.inputToEmailTextbox("");
//		loginPage.inputToPasswordTextbox("");
//		loginPage.clickToLoginButton();

		dashboardPage = loginPage.loginToSystem("admin@yourstore.com", "admin");
		productPage = dashboardPage.openProductPage();
	}

	// @Test
	public void TC_01_Paging() {
		// 1. test phan trang: Paging
		productPage.goToPageAtTableByIndex("2");
		assertTrue(productPage.isPageActivedAtTableByIndex("2"));
		productPage.goToPageAtTableByIndex("1");
		assertTrue(productPage.isPageActivedAtTableByIndex("1"));
		productPage.goToPageAtTableByIndex("3");
		assertTrue(productPage.isPageActivedAtTableByIndex("3"));
		productPage.goToPageAtTableByIndex("2");
		assertTrue(productPage.isPageActivedAtTableByIndex("2"));

	}

	// 2:Check select all
	// @Test
	public void TC_02_Select_Deselect_All() {

		productPage.checkToSelectAllCheckbox();

		productPage.allProductCheckboxChecked();

		// deselect all
		productPage.unCheckToSelectAllCheckbox();
		productPage.allProductCheckboxUnChecked();

		// chỉ chọn 1 element-spacial check

		productPage.checkToProductCheckboxByName("$100 Physical Gift Card");

		productPage.checkToProductCheckboxByName("Adobe Photoshop CS4");
		productPage.checkToProductCheckboxByName("Custom T-Shirt");

		productPage.checkToProductCheckboxByName("Apple iCam");

		productPage.checkToProductCheckboxByName("First Prize Pies");

	}

	// 3.Check Displayed
	// @Test
	public void TC_03_Displayed_All() {
		Assert.assertTrue(productPage.areProductDetailDisplayed("Adobe Photoshop CS4", "AD_CS4_PH", "75", "10000", "Simple", "true"));
		Assert.assertTrue(productPage.areProductDetailDisplayed("Custom T-Shirt", "CS_TSHIRT", "15", "10000", "Simple", "true"));
		Assert.assertTrue(productPage.areProductDetailDisplayed("Fahrenheit 451 by Ray Bradbury", "FR_451_RB", "27", "10000", "Simple", "false"));

		productPage.selectShowItemDropdown("50");

	}

	// 4.Edit
	//@Test
	public void TC_04_() {
		productPage.clickToEditIconDetailByName("$50 Physical Gift Card");
		productPage.backToPage(driver);

		productPage.clickToEditIconDetailByName("Adobe Photoshop CS4");
		productPage.backToPage(driver);

		productPage.clickToEditIconDetailByName("Apple MacBook Pro 13-inch");
		productPage.backToPage(driver);
	}

	@Test
	public void TC_05_Position() {
		productPage.selectShowItemDropdown("50");
		productPage.sleepInSecond(2);
		Assert.assertTrue(productPage.isInformationDisplayedAtColumnNameRowNumber("Product name", "2", "$25 Virtual Gift Card"));
		Assert.assertTrue(productPage.isInformationDisplayedAtColumnNameRowNumber("SKU", "2", "VG_CR_025"));
		Assert.assertTrue(productPage.isInformationDisplayedAtColumnNameRowNumber("Price", "2", "25"));
		Assert.assertTrue(productPage.isInformationDisplayedAtColumnNameRowNumber("Stock quantity", "2", ""));
		Assert.assertTrue(productPage.isInformationDisplayedAtColumnNameRowNumber("Product type", "2", "Simple"));

		Assert.assertTrue(productPage.isPublishStatusAtColumnNameAnRowNumber("Published", "2", "true"));
		Assert.assertTrue(productPage.isPublishStatusAtColumnNameAnRowNumber("Published", "14", "false"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	AdminLoginPO loginPage;
	AdminDashboardPO dashboardPage;
	AdminProductPO productPage;
}