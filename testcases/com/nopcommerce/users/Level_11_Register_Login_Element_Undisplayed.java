package com.nopcommerce.users;

import java.util.Random;


import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.UserAddressesPO;
import pageObjects.UserCustomerInforPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserMyproductReviewsPO;
import pageObjects.UserOrdersPO;
import pageObjects.PageGeneratorManager;
import pageObjects.UserRegisterPO;

public class Level_11_Register_Login_Element_Undisplayed extends AbstractTest {

	WebDriver driver;
	// tạo bộ DL
	String firtName, lastName, email, companyName, password, day, month, year;
	boolean status;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

//		System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
//		driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver", projectFolder + "\\browserDriver\\chromedriver.exe");
//		driver=new ChromeDriver();

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

		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		//verify register link displaed
		Assert.assertTrue(homePage.isRegisterLinkDisplayed());
		//verify login link displaed
		Assert.assertTrue(homePage.isLoginLinkDisplayed());
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
		// sleepInSecond(1);
		registerPage.clickToRegisterButton();
		// cach1
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		// cach2
		// Assert.assertTrue(registerPage.isRegisterSuccessMessageDisplayed());

		homePage =registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_02_Login() {
		//4
		//homePage.clickToLoginLink();
		loginPage=homePage.clickToLoginLink();
		

		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		//5.
		homePage=loginPage.clickToLoginButton();
		
		// verify my account link displayed
		status=homePage.isMyAccountLinkDisplayed();
		System.out.println("My Account Link status = "+status);
		Assert.assertTrue(status);
		
		// verify logout link displayed
		status=homePage.isLogoutLinkDisplayed();
		System.out.println("Logout Link status = "+status);
		Assert.assertTrue(status);
		
		//verify tooltip item undisplayed
		status=homePage.isShoppingCartNoItemTooltipUndisplayed();
		System.out.println("Shopping cart item status = "+status);
		Assert.assertTrue(status);
		
		//verify register link undisplayed
		status=homePage.isRegisterLinkUndisplayed();
		System.out.println("Register Link status = "+status);
		Assert.assertTrue(status);
		
		//verify login link undisplayed
		status=homePage.isLoginLinkUndisplayed();
		System.out.println("Logout Link status = "+status);
		Assert.assertTrue(status);
	}

	@Test
	public void TC_03_View_My_Account() {

		//homePage.clickToMyAccountLink();
		customerInforPage=homePage.clickToMyAccountLink();
		
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
	//cách 1:dùng cho page nhỏ (ít page)
	@Test
	public void TC_04_Rest_Parameter_01() {
		
		adressesPage=(UserAddressesPO) customerInforPage.openLinkByPageName(driver, "Addresses");
		
		customerInforPage=(UserCustomerInforPO) adressesPage.openLinkByPageName(driver, "Customer info");
		
		myProductPage=(UserMyproductReviewsPO) customerInforPage.openLinkByPageName(driver, "My product reviews");
		customerInforPage=(UserCustomerInforPO) myProductPage.openLinkByPageName(driver, "Customer info");
		adressesPage=(UserAddressesPO) customerInforPage.openLinkByPageName(driver, "Addresses");
		//Addresses->My product reviews
		myProductPage=(UserMyproductReviewsPO) adressesPage.openLinkByPageName(driver, "My product reviews");
		//My product reviews->Orders
		oderPage=(UserOrdersPO) myProductPage.openLinkByPageName(driver, "Orders");
		//Orders ->Addresses
		adressesPage=(UserAddressesPO) oderPage.openLinkByPageName(driver, "Addresses");
		//Addresses->Customer info
		customerInforPage=(UserCustomerInforPO) adressesPage.openLinkByPageName(driver,"Customer info");
	}
	//cách 2:
	@Test
	public void TC_05_Rest_Parameter_02() {
		customerInforPage.openLinkWithPageName(driver, "Addresses");
		adressesPage=PageGeneratorManager.getUserAddressesPage(driver);
		
		adressesPage.openLinkWithPageName(driver, "Customer info");
		customerInforPage=PageGeneratorManager.getUserCustomerInforPage(driver);
		
		customerInforPage.openLinkWithPageName(driver, "My product reviews");
		myProductPage=PageGeneratorManager.getUserMyproductReviewsPage(driver);
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