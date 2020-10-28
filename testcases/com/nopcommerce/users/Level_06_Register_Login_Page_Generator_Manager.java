package com.nopcommerce.users;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import commons.AbstractPage;
import commons.AbstractTest;
import pageObjects.CustomerInforPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class Level_06_Register_Login_Page_Generator_Manager extends AbstractTest {

	WebDriver driver;
	// tạo bộ DL
	String firtName, lastName, email, companyName, password, day, month, year;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

//		System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
//		driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver", projectFolder + "\\browserDriver\\chromedriver.exe");
//		driver=new ChromeDriver();

		driver = getBrowserDriver(browserName);

		firtName = "Hoang Anh";
		lastName = "Nam";
		email = "hoanganh" + getRandomNumber() + "@gmail.com";
		//System.out.println(email);
		companyName = "Digital Tech";
		password = "123456";
		day = "11";
		month = "September";
		year = "1989";

	}

	@Test
	public void TC_01_Register() {

		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
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

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
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

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerInforPageObject customerInforPage;

}