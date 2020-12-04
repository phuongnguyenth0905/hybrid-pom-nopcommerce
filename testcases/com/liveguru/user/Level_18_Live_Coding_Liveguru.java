package com.liveguru.user;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.liveGuru.PageGeneratorManager;
import pageObjects.liveGuru.UserAddressesPO;
import pageObjects.liveGuru.UserCustomerInforPO;
import pageObjects.liveGuru.UserHomePO;
import pageObjects.liveGuru.UserLoginPO;
import pageObjects.liveGuru.UserMyproductReviewsPO;
import pageObjects.liveGuru.UserOrdersPO;
import pageObjects.liveGuru.UserRegisterPO;
import pageObjects.liveGuru.UserMyDashboardPO;

public class Level_18_Live_Coding_Liveguru extends AbstractTest {

	WebDriver driver;
	// tạo bộ DL
	String firtName, lastName, email, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {

		driver = getBrowserDriver(browserName, url);

		firtName = "Hoang Anh";
		lastName = "Nam";
		email = "hoanganh" + getRandomNumber() + "@gmail.com";
		password = "123456";

	}

	@Test
	public void TC_01_Register_To_System() {
		log.info("Register - Step 01 : Open Home Page");
		homePage=PageGeneratorManager.getUserHomePage(driver);
		
		//error
		log.info("Register - Step 02 : Click To My Account Link at Home Page");
		loginPage=homePage.clickToMyAccountLink();
		
		// Từ login click Register button mới chuyển qua trang Register
		log.info("Register - Step 03 : Click To Create An Account Button");
		registerPage = loginPage.clickToCreateAnAccountButton();
		
		log.info("Register - Step 04 : Input To First Name textbox with value: " + firtName);
		registerPage.inputToFirstNameTextbox(firtName);
		
		log.info("Register - Step 05 : Input To Last Name textbox with value: " + lastName);
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("Register - Step 06 : Input To Email textbox with value: " + email);
		registerPage.inputToEmailTexbox(email);
		
		log.info("Register - Step 07 : Input To Password textbox with value: " + password);
		registerPage.inputToPasswordTexbox(password);
		registerPage.inputToConfirmPasswordTexbox(password);
		
		log.info("Register - Step 08 : Click to Register Button at Register Page");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 09 : Verify success message displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
		
		homePage=registerPage.clickHeadAcountLink();
		log.info("Register - Step 10 : Click To Logout Link and navigate to home page");
		//homePage=myDashboardPage.openProductPage();
		homePage=registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_02_Login() {

	}

	@Test
	public void TC_03_() {

	}

	@Test
	public void TC_04_() {

	}

	@Test
	public void TC_05_() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
	UserMyDashboardPO myDashboardPage;
	// UserCustomerInforPO customerInforPage;
	UserAddressesPO adressesPage;
//	UserOrdersPO oderPage;
//	UserMyproductReviewsPO myProductPage;
	// UserAboutUsPO aboutUsPage;
	// UserSearchTermPO searchTermPage;
	// UserCustomerServicePO customerServicePage;
	// UserAdvancedSearchPO advancedSearchPage;

}