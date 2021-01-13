package com.saucelab;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.AbstractTest;
import pageObjects.sauLab.PageGeneratorManagerSauceLab;
import pageObjects.sauLab.productPO;

public class Level_20_Sort_ASC_DESC extends AbstractTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {

		driver = getBrowserDriver(browserName, url);
		productPage=PageGeneratorManagerSauceLab.getProductPage(driver);
	}

	@Test
	public void TC_01_Sort_Product_Name() {
		log.info("TC_01_Sort_Product_Name: Name (A to Z)");
		productPage.selectItemInProductSortDropdown("Name (A to Z)");
		productPage.sleepInSecond(5);
		verifyTrue(productPage.areProductNameSortedByAscending());
		
		log.info("TC_01_Sort_Product_Name: Name (Z to A)");
		productPage.selectItemInProductSortDropdown("Name (Z to A)");
		productPage.sleepInSecond(5);
		verifyTrue(productPage.areProductNameSortedByDescending());
		
	}

	@Test
	public void TC_02_Sort_Product_Price() {
		log.info("TC_02_Sort_Product_Price: Price (low to high)");
		productPage.selectItemInProductSortDropdown("Price (low to high)");
		productPage.sleepInSecond(5);
		verifyTrue(productPage.areProductPriceSortedByAscending());
		
		
		log.info("TC_02_Sort_Product_Price: Price (high to low)");
		productPage.selectItemInProductSortDropdown("Price (high to low)");
		productPage.sleepInSecond(5);
		verifyTrue(productPage.areProductPriceSortedByDescending());
	}

	@Test
	public void TC_03_Account_Information() {

	}

	@Test
	public void TC_11_Search_Product() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	productPO productPage;
}