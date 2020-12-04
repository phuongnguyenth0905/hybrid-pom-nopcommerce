package com.nopcommerce.users;

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

public class Level_17_Register_Login_Pattern_Object extends AbstractTest {

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
	public void TC_01_Validate_At_Register_Form() {
		log.info("Validate - Step 01 : Open Home Page");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Validate - Step 02 : Click To Register Link at Home Page");
		registerPage = homePage.clickToRegisterLink();
	
		log.info("Validate - Step 03 : Click To Register Button");
		registerPage.clickToButtonByValue(driver, "Register");
		
		log.info("Validate - Step 04 : Verify error message displayed at FirstName textbox");
		verifyEquals(registerPage.getErrorMesageAtMandantoryFieldByID(driver, "FirstName"), "First name is required.");
		
		log.info("Validate - Step 05 : Verify error message displayed at LastName textbox");
		verifyEquals(registerPage.getErrorMesageAtMandantoryFieldByID(driver, "LastName"), "Last name is required.");
		
		log.info("Validate - Step 06 : Verify error message displayed at Email textbox");
		verifyEquals(registerPage.getErrorMesageAtMandantoryFieldByID(driver, "Email"), "Email is required.");
		
		log.info("Validate - Step 07 : Verify error message displayed at Password textbox");
		verifyEquals(registerPage.getErrorMesageAtMandantoryFieldByID(driver, "Password"), "Password is required.");
		
		log.info("Validate - Step 08 : Verify error message displayed at ConfirmPassword textbox");
		verifyEquals(registerPage.getErrorMesageAtMandantoryFieldByID(driver, "ConfirmPassword"), "Password is required.");
		
		
		
	}

	@Test
	public void TC_02_Register_Success() {
		log.info("Register - Step 01 : Open Home Page");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Register - Step 02 : Click To Register Link at Home Page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 03 : Click To Gender Male Radio Button");
		//registerPage.clickToGenderMaleRadioButton();
		registerPage.clickToRadioButtonByID(driver, "gender-male");

		log.info("Register - Step 04 : Input To First Name textbox with value: " + firtName);
		registerPage.inputToTextboxByID(driver, "FirstName", firtName);
		
		log.info("Register - Step 05 : Input To Last Name textbox with value: " + lastName);
		registerPage.inputToTextboxByID(driver, "LastName", lastName);

		log.info("Register - Step 06 : Select Day Dropdown with value: "+day);
		registerPage.selectDropdownByName(driver, "DateOfBirthDay", day);

		log.info("Register - Step 07 : Select Month Dropdown with value: "+month);
		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", month);

		log.info("Register - Step 08 : Select Year Dropdown with value: "+year);
		registerPage.selectDropdownByName(driver, "DateOfBirthYear", year);

		log.info("Register - Step 09 : Input To Email textbox with value: " + email);
		registerPage.inputToTextboxByID(driver, "Email", email);

		log.info("Register - Step 10 : Input To Company Name textbox ");
		registerPage.inputToTextboxByID(driver, "Company", companyName);

		log.info("Register - Step 11 : Input To Password textbox with value: " + password);
		registerPage.inputToTextboxByID(driver, "Password", password);
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", password);

		log.info("Register - Step 12 : Click to Register Button at Register Page");
		registerPage.clickToButtonByValue(driver, "Register");

		log.info("Register - Step 13 : Verify success message displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Register - Step 14 : Click To Logout Link and navigate to home page");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_03_Login() {
		log.info("Login - Step 01 : Open Login Page");
		loginPage = homePage.clickToLoginLink();

		log.info("Login - Step 02 : Input to Email textbox with value : " + email);
		loginPage.inputToTextboxByID(driver, "Email", email);

		log.info("Login - Step 03 : Input to Password textbox with value : " + password);
		loginPage.inputToTextboxByID(driver, "Password", password);

		log.info("Login - Step 04 : Click to Login button at Login Page");
		loginPage.clickToButtonByValue(driver, "Log in");
		homePage=PageGeneratorManager.getUserHomePage(driver);

//		log.info("Login - Step 05 : Verigy My account link displayed");
//		verifyTrue(homePage.isMyAccountLinkDisplayed());

//		log.info("Login - Step 06 : Verify Shopping cart item undisplayed");
//		verifyTrue(homePage.isShoppingCartNoItemTooltipUndisplayed());
//
//		log.info("Login - Step 07 : Verify Logout Link Displayed");
//		verifyTrue(homePage.isLogoutLinkDisplayed());
//
//		log.info("Login - Step 08 : Verify Register Link Undisplayed");
//		verifyTrue(homePage.isRegisterLinkUndisplayed());
//
//		log.info("Login - Step 09 : Verify Login Link Undisplayed");
//		verifyFalse(homePage.isLoginLinkUndisplayed());
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


	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
	UserCustomerInforPO customerInforPage;
	UserAddressesPO adressesPage;
	UserOrdersPO oderPage;
	UserMyproductReviewsPO myProductPage;

}