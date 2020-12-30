package com.nopcommerce.users;


import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;
import commons.AbstractTest;
import pageObjects.nopCommerce.PageGeneratorManagerNopCommerce;
import pageObjects.nopCommerce.UserHomePO;
import pageObjects.nopCommerce.UserLoginPO;

public class Level_16_Register_Login_Close_Browser extends AbstractTest {

	WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		// LOGIN
		log.info("Precondition - Step 01 : Open Login Page");
		homePage = PageGeneratorManagerNopCommerce.getUserHomePage(driver);
		loginPage = homePage.clickToLoginLink();

		log.info("Precondition - Step 02 : Input to Email textbox with value : " + Common_01_Register.email);
		loginPage.inputToEmailTextbox(Common_01_Register.email);

		log.info("Precondition - Step 03 : Input to Password textbox with value : " + Common_01_Register.password);
		loginPage.inputToPasswordTextbox(Common_01_Register.password);

		log.info("Precondition - Step 04 : Click to Login button at Login Page");
		homePage = loginPage.clickToLoginButton();

		log.info("Precondition - Step 05 : Verigy My account link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void TC_01_Sort_Name_Ascendingr() {

	}

	@Test
	public void TC_02_Sort_Name_Descending() {

	}

	@Test
	public void TC_03_Sort_Price_Ascending() {

	}

	@Test
	public void TC_04_Sort_Price_Descending() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

	UserHomePO homePage;

	UserLoginPO loginPage;

}