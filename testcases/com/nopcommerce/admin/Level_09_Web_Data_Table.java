package com.nopcommerce.admin;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.AdminDashboardPO;
import pageObjects.AdminLoginPO;
import pageObjects.AdminProductPO;
import pageObjects.PageGeneratorManager;

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

	//@Test
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
	@Test
	public void TC_02_Select_Deselect_All() {
		productPage.checkToSelectAllCheckbox();
		
		productPage.allProductCheckboxChecked();
		// deselect all
		productPage.unCheckToSelectAllCheckbox();
		productPage.allProductCheckboxUnChecked();
		
		//chỉ chọn 1 element-spacial check
		//productPage.checkToProductCheckboxByName("Adobe Photoshop CS4");
		productPage.sleepInSecond(2);

		productPage.checkToProductCheckboxByName("Adobe Photoshop CS4");
		productPage.checkToProductCheckboxByName("Custom T-Shirt");
		productPage.sleepInSecond(2);
		productPage.checkToProductCheckboxByName("Apple iCam");
		productPage.sleepInSecond(2);
		productPage.checkToProductCheckboxByName("First Prize Pies");
		productPage.sleepInSecond(2);
	}

	// 3.Check Displayed
	@Test
	public void TC_03_() {

	}

	// 4.Edit
	@Test
	public void TC_04_() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	AdminLoginPO loginPage;
	AdminDashboardPO dashboardPage;
	AdminProductPO productPage;
}