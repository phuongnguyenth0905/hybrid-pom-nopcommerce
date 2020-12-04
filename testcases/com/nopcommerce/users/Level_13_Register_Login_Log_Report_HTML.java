package com.nopcommerce.users;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.UserAddressesPO;
import pageObjects.nopCommerce.UserCustomerInforPO;
import pageObjects.nopCommerce.UserHomePO;
import pageObjects.nopCommerce.UserLoginPO;
import pageObjects.nopCommerce.UserMyproductReviewsPO;
import pageObjects.nopCommerce.UserOrdersPO;
import pageObjects.nopCommerce.UserRegisterPO;

public class Level_13_Register_Login_Log_Report_HTML extends AbstractTest {

	WebDriver driver;
	// tạo bộ DL
	String firtName, lastName, email, companyName, password, day, month, year;
	boolean status;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		firtName = "Hoang Anh";
		lastName = "Nguyen";
		email = "hoanganh" + getRandomNumber() + "@gmail.com";

		companyName = "Digital Tech";
		password = "123456";
		day = "11";
		month = "September";
		year = "1989";

	}

	@Test
	public void TC_01_Register() {
		log.info("Register - Step 01 : Open Home Page");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		// verify register link displaed-> failed
		log.info("Register - Step 02 : Verify Register Link Displayed");
		verifyTrue(homePage.isRegisterLinkDisplayed());

		// verify login link displaed->failed
		log.info("Register - Step 03 : Verify Login Link Displayed");
		verifyTrue(homePage.isLoginLinkDisplayed());

		log.info("Register - Step 04 : Click To Register Link at Home Page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 05 : Click To Gender Male Radio Button");
		registerPage.clickToGenderMaleRadioButton();

		log.info("Register - Step 06 : Input To First Name textbox with value: " + firtName);
		registerPage.inputToFirstNameTextbox(firtName);

		log.info("Register - Step 07 : Input To Last Name textbox with value: " + lastName);
		registerPage.inputToLastNameTextbox(lastName);

		log.info("Register - Step 08 : Select Day Dropdown");
		registerPage.selectDayDropdown(day);

		log.info("Register - Step 09 : Select Month Dropdown");
		registerPage.selectMonthDropdown(month);

		log.info("Register - Step 10 : Select Year Dropdown");
		registerPage.selectYearDropdown(year);

		log.info("Register - Step 11 : Input To Email textbox with value: " + email);
		registerPage.inputToEmailTexbox(email);

		log.info("Register - Step 12 : Input To Company Name textbox ");
		registerPage.inputToCompanyTexbox(companyName);

		log.info("Register - Step 13 : Input To Password textbox with value: " + password);
		registerPage.inputToPasswordTexbox(password);
		registerPage.inputToConfirmPasswordTexbox(password);

		log.info("Register - Step 14 : Click to Register Button at Register Page");
		registerPage.clickToRegisterButton();
		registerPage.clickToRegisterButton();

		log.info("Register - Step 15 : Verify success message displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Register - Step 16 : Click To Logout Link and navigate to home page");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_02_Login() {
		log.info("Login - Step 01 : Open Login Page");
		loginPage = homePage.clickToLoginLink();

		log.info("Login - Step 02 : Input to Email textbox with value : " + email);
		loginPage.inputToEmailTextbox(email);

		log.info("Login - Step 03 : Input to Password textbox with value : " + password);
		loginPage.inputToPasswordTextbox(password);

		log.info("Login - Step 04 : Click to Login button at Login Page");
		homePage = loginPage.clickToLoginButton();

		log.info("Login - Step 05 : Verigy My account link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

		log.info("Login - Step 06 : Verify Shopping cart item undisplayed");
		verifyTrue(homePage.isShoppingCartNoItemTooltipUndisplayed());

		log.info("Login - Step 07 : Verify Logout Link Displayed");
		verifyTrue(homePage.isLogoutLinkDisplayed());

		log.info("Login - Step 08 : Verify Register Link Undisplayed");
		verifyTrue(homePage.isRegisterLinkUndisplayed());

		log.info("Login - Step 09 : Verify Login Link Undisplayed");
		verifyFalse(homePage.isLoginLinkUndisplayed());
	}

	// @Test
	public void TC_03_View_My_Account() {

		// homePage.clickToMyAccountLink();
		customerInforPage = homePage.clickToMyAccountLink();

		Assert.assertTrue(customerInforPage.isGenderMaleRadioButtonSelected());
		Assert.assertEquals(customerInforPage.getFirstNameTextboxValue(), firtName);
		Assert.assertEquals(customerInforPage.getLastNameTextboxValue(), lastName);

		Assert.assertEquals(customerInforPage.getSelectedTextInDayDropdown(), day);
		Assert.assertEquals(customerInforPage.getSelectedTextInMonthDropdown(), month);
		Assert.assertEquals(customerInforPage.getSelectedTextInYearDropdown(), year);

		Assert.assertEquals(customerInforPage.getEmailTextboxValue(), email);
		Assert.assertEquals(customerInforPage.getCompanyTextboxValue(), companyName);
		Assert.assertTrue(customerInforPage.isNewsletterCheckboxSelected());
	}

	// cách 1:dùng cho page nhỏ (ít page)
	// @Test
	public void TC_04_Rest_Parameter_01() {

		adressesPage = (UserAddressesPO) customerInforPage.openLinkByPageName(driver, "Addresses");

		customerInforPage = (UserCustomerInforPO) adressesPage.openLinkByPageName(driver, "Customer info");

		myProductPage = (UserMyproductReviewsPO) customerInforPage.openLinkByPageName(driver, "My product reviews");
		customerInforPage = (UserCustomerInforPO) myProductPage.openLinkByPageName(driver, "Customer info");
		adressesPage = (UserAddressesPO) customerInforPage.openLinkByPageName(driver, "Addresses");
		// Addresses->My product reviews
		myProductPage = (UserMyproductReviewsPO) adressesPage.openLinkByPageName(driver, "My product reviews");
		// My product reviews->Orders
		oderPage = (UserOrdersPO) myProductPage.openLinkByPageName(driver, "Orders");
		// Orders ->Addresses
		adressesPage = (UserAddressesPO) oderPage.openLinkByPageName(driver, "Addresses");
		// Addresses->Customer info
		customerInforPage = (UserCustomerInforPO) adressesPage.openLinkByPageName(driver, "Customer info");
	}

	// cách 2:
	// @Test
	public void TC_05_Rest_Parameter_02() {
		customerInforPage.openLinkWithPageName(driver, "Addresses");
		adressesPage = PageGeneratorManager.getUserAddressesPage(driver);

		adressesPage.openLinkWithPageName(driver, "Customer info");
		customerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);

		customerInforPage.openLinkWithPageName(driver, "My product reviews");
		myProductPage = PageGeneratorManager.getUserMyproductReviewsPage(driver);
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
	UserCustomerInforPO customerInforPage;
	UserAddressesPO adressesPage;
	UserOrdersPO oderPage;
	UserMyproductReviewsPO myProductPage;

}