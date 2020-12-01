package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import commons.AbstractTest;

import pageObjects.UserHomePO;

import pageObjects.PageGeneratorManager;
import pageObjects.UserRegisterPO;

public class Common_02_Cookie extends AbstractTest {

	WebDriver driver;
	

	String firtName, lastName, companyName, day, month, year;
	public static String email, password;
	public static Set<Cookie> allCookies; 

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {

		driver = getBrowserDriver(browserName);

		firtName = "Hoang Anh";
		lastName = "Nguyen";
		email = "hoanganh" + getRandomNumber() + "@gmail.com";

		companyName = "Digital Tech";
		password = "123456";
		day = "11";
		month = "September";
		year = "1989";

		log.info("Register - Step 01 : Open Home Page");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Register - Step 02 : Verify Register Link Displayed");
		verifyTrue(homePage.isRegisterLinkDisplayed());

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
		
		allCookies = driver.manage().getCookies();
		
		driver.quit();
	}

	UserHomePO homePage;
	UserRegisterPO registerPage;

}