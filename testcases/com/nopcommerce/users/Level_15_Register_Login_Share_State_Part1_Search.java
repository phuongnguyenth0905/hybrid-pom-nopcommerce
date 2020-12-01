package com.nopcommerce.users;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;
import commons.AbstractTest;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.PageGeneratorManager;


public class Level_15_Register_Login_Share_State_Part1_Search extends AbstractTest {

	WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		// LOGIN
		log.info("Precondition - Step 01 : Open Login Page");
		homePage = PageGeneratorManager.getUserHomePage(driver);
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
	public void TC_01_Search_Product_With_Namer() {

	}

	@Test
	public void TC_02_Search_Product_With_Category() {
//		log.info("Login - Step 01 : Open Login Page");
//		loginPage = homePage.clickToLoginLink();
//
//		log.info("Login - Step 02 : Input to Email textbox with value : " + email);
//		loginPage.inputToEmailTextbox(email);
//
//		log.info("Login - Step 03 : Input to Password textbox with value : " + password);
//		loginPage.inputToPasswordTextbox(password);
//
//		log.info("Login - Step 04 : Click to Login button at Login Page");
//		homePage = loginPage.clickToLoginButton();
//
//		log.info("Login - Step 05 : Verigy My account link displayed");
//		verifyTrue(homePage.isMyAccountLinkDisplayed());
//
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

	@Test
	public void TC_03_Search_Product_With_Sub_Category() {

//		// homePage.clickToMyAccountLink();
//		customerInforPage = homePage.clickToMyAccountLink();
//
//		Assert.assertTrue(customerInforPage.isGenderMaleRadioButtonSelected());
//		Assert.assertEquals(customerInforPage.getFirstNameTextboxValue(), firtName);
//		Assert.assertEquals(customerInforPage.getLastNameTextboxValue(), lastName);
//
//		Assert.assertEquals(customerInforPage.getSelectedTextInDayDropdown(), day);
//		Assert.assertEquals(customerInforPage.getSelectedTextInMonthDropdown(), month);
//		Assert.assertEquals(customerInforPage.getSelectedTextInYearDropdown(), year);
//
//		Assert.assertEquals(customerInforPage.getEmailTextboxValue(), email);
//		Assert.assertEquals(customerInforPage.getCompanyTextboxValue(), companyName);
//		Assert.assertTrue(customerInforPage.isNewsletterCheckboxSelected());
	}

	@Test
	public void TC_04_Search_Product_With_Price() {
//
//		adressesPage = (UserAddressesPO) customerInforPage.openLinkByPageName(driver, "Addresses");
//
//		customerInforPage = (UserCustomerInforPO) adressesPage.openLinkByPageName(driver, "Customer info");
//
//		myProductPage = (UserMyproductReviewsPO) customerInforPage.openLinkByPageName(driver, "My product reviews");
//		customerInforPage = (UserCustomerInforPO) myProductPage.openLinkByPageName(driver, "Customer info");
//		adressesPage = (UserAddressesPO) customerInforPage.openLinkByPageName(driver, "Addresses");
//		// Addresses->My product reviews
//		myProductPage = (UserMyproductReviewsPO) adressesPage.openLinkByPageName(driver, "My product reviews");
//		// My product reviews->Orders
//		oderPage = (UserOrdersPO) myProductPage.openLinkByPageName(driver, "Orders");
//		// Orders ->Addresses
//		adressesPage = (UserAddressesPO) oderPage.openLinkByPageName(driver, "Addresses");
//		// Addresses->Customer info
//		customerInforPage = (UserCustomerInforPO) adressesPage.openLinkByPageName(driver, "Customer info");
	}

	@Test
	public void TC_05_Search_Product_With_Manufacturer() {
//		customerInforPage.openLinkWithPageName(driver, "Addresses");
//		adressesPage = PageGeneratorManager.getUserAddressesPage(driver);
//
//		adressesPage.openLinkWithPageName(driver, "Customer info");
//		customerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);
//
//		customerInforPage.openLinkWithPageName(driver, "My product reviews");
//		myProductPage = PageGeneratorManager.getUserMyproductReviewsPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	UserHomePO homePage;
	UserLoginPO loginPage;

}