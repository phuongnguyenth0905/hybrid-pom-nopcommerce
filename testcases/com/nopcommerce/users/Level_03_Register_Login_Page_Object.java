package com.nopcommerce.users;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;
import pageObjects.UserCustomerInforPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserRegisterPO;

public class Level_03_Register_Login_Page_Object extends AbstractPage {
	String projectFolder = System.getProperty("user.dir");
	WebDriver driver;
	// tạo bộ DL
	String firtName, lastName, email, companyName, password,day,month,year;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver", projectFolder + "\\browserDriver\\chromedriver.exe");
//		driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");

		firtName = "Hoang Anh";
		lastName = "Nam";
		email = "hoanganh" + getRandomNumber() + "@gmail.com";
		System.out.println(email);
		companyName = "Digital Tech";
		password = "123456";
		day="11";
		month="September";
		year="1989";
		
		
	}

	@Test
	public void TC_01_Register() {
		homePage = new UserHomePO(driver);
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPO(driver);
		sleepInSecond(1);
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
		sleepInSecond(1);
		registerPage.clickToRegisterButton();
		//cach1
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
		
		//cach2
		//Assert.assertTrue(registerPage.isRegisterSuccessMessageDisplayed());
		
		registerPage.clickToLogoutLink();
	
		sleepInSecond(1);
		homePage = new UserHomePO(driver);
	}

	@Test
	public void TC_02_Login() {
		//homePage.clickToLoginLink();
		homePage.clickToLoginLink();
		loginPage = new UserLoginPO(driver);

		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();

		homePage = new UserHomePO(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	}

	@Test
	public void TC_03_View_My_Account() {

		//homePage.clickToMyAccountLink();
		homePage.clickToMyAccountLink();
		customerInforPage = new UserCustomerInforPO(driver);
		Assert.assertTrue(customerInforPage.isGenderMaleRadioButtonSelected());
		Assert.assertEquals(customerInforPage.getFirstNameTextboxValue(), firtName);
		Assert.assertEquals(customerInforPage.getLastNameTextboxValue(), lastName);

		Assert.assertEquals(customerInforPage.getSelectedTextInDayDropdown(), day);
		Assert.assertEquals(customerInforPage.getSelectedTextInMonthDropdown(),month);
		Assert.assertEquals(customerInforPage.getSelectedTextInYearDropdown(), year	);

		Assert.assertEquals(customerInforPage.getEmailTextboxValue(), email);
		Assert.assertEquals(customerInforPage.getCompanyTextboxValue(), companyName);
		Assert.assertTrue(customerInforPage.isNewsletterCheckboxSelected());
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

}