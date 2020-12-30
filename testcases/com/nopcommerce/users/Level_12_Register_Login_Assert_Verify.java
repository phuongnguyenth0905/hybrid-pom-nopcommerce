package com.nopcommerce.users;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.nopCommerce.PageGeneratorManagerNopCommerce;
import pageObjects.nopCommerce.UserAddressesPO;
import pageObjects.nopCommerce.UserCustomerInforPO;
import pageObjects.nopCommerce.UserHomePO;
import pageObjects.nopCommerce.UserLoginPO;
import pageObjects.nopCommerce.UserMyproductReviewsPO;
import pageObjects.nopCommerce.UserOrdersPO;
import pageObjects.nopCommerce.UserRegisterPO;

public class Level_12_Register_Login_Assert_Verify extends AbstractTest {

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

		homePage = PageGeneratorManagerNopCommerce.getUserHomePage(driver);

		// verify register link displaed-> failed
		verifyFalse(homePage.isRegisterLinkDisplayed());
		// verify login link displaed->failed
		verifyFalse(homePage.isLoginLinkDisplayed());
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPO(driver);
		// sleepInSecond(1);
		registerPage.clickToGenderMaleRadioButton();
		registerPage.clickToGenderMaleRadioButton();

		registerPage.inputToFirstNameTextbox(firtName);
		registerPage.inputToLastNameTextbox(lastName);

		registerPage.selectDayDropdown(day);
		registerPage.selectMonthDropdown(month);
		registerPage.selectYearDropdown(year);

		registerPage.inputToEmailTexbox(email);
		registerPage.inputToCompanyTexbox(companyName);
		registerPage.inputToPasswordTexbox(password);
		registerPage.inputToConfirmPasswordTexbox(password);

		registerPage.clickToRegisterButton();

		registerPage.clickToRegisterButton();
		// Failed
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed......");

		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_02_Login() {
		// 4
		// homePage.clickToLoginLink();
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		// 5.
		homePage = loginPage.clickToLoginButton();

		// verify my account link displayed->Failed
		verifyFalse(homePage.isMyAccountLinkDisplayed());

		// verify tooltip item undisplayed
		verifyFalse(homePage.isShoppingCartNoItemTooltipUndisplayed());

		// verify logout link displayed->Failed
		verifyTrue(homePage.isLogoutLinkDisplayed());

		// verify register link undisplayed->Pass
		verifyTrue(homePage.isRegisterLinkUndisplayed());

		// verify login link undisplayed->Failed
		verifyFalse(homePage.isLoginLinkUndisplayed());
	}

	//@Test
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
	//@Test
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
	//@Test
	public void TC_05_Rest_Parameter_02() {
		customerInforPage.openLinkWithPageName(driver, "Addresses");
		adressesPage = PageGeneratorManagerNopCommerce.getUserAddressesPage(driver);

		adressesPage.openLinkWithPageName(driver, "Customer info");
		customerInforPage = PageGeneratorManagerNopCommerce.getUserCustomerInforPage(driver);

		customerInforPage.openLinkWithPageName(driver, "My product reviews");
		myProductPage = PageGeneratorManagerNopCommerce.getUserMyproductReviewsPage(driver);
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