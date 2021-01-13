package com.nopcommerce.users;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;

public class Level_02_Register_Login_Abstract_Page_01 {
	String projectFolder = System.getProperty("user.dir");
	WebDriver driver;
	AbstractPage abstractPage;

	// tạo bộ DL
	String firtName, lastName, email, companyName, password;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
		// System.setProperty("webdriver.chrome.driver", projectFolder + "\\browserDriver\\chromedriver.exe");
		driver = new FirefoxDriver();
		// driver=new ChromeDriver();
		//abstractPage = new AbstractPage();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		abstractPage.openPageUrl(driver, "https://demo.nopcommerce.com/");
		firtName = "Hoang Anh";
		lastName = "Nam";
		email = "hoanganh" + getRandomNumber() + "@gmail.com";
		companyName = "Digital Tech";
		password = "123456";
	}

	@Test
	public void TC_01_Register() {
		abstractPage.clickToElement(driver, "//a[@class='ico-register']");
		abstractPage.clickToElement(driver, "//input[@id='gender-male']");
		abstractPage.sendkeyToElement(driver, "//input[@id='FirstName']", firtName);
		abstractPage.sendkeyToElement(driver, "//input[@id='LastName']", lastName);

		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "11");
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "September");
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1989");

		abstractPage.sendkeyToElement(driver, "//input[@id='Email']", email);
		abstractPage.sendkeyToElement(driver, "//input[@id='Company']", companyName);
		abstractPage.sendkeyToElement(driver, "//input[@id='Password']", password);
		abstractPage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", password);

		abstractPage.clickToElement(driver, "//input[@id='register-button']");
		Assert.assertEquals(abstractPage.getElementText(driver, "//div[text()='Your registration completed']"), "Your registration completed");
		abstractPage.clickToElement(driver, "//a[@class='ico-logout']");
	}

	@Test
	public void TC_02_Login() {
		abstractPage.clickToElement(driver, "//a[@class='ico-login']");
		abstractPage.sendkeyToElementByJS(driver, "//input[@id='Email']", email);
		abstractPage.sendkeyToElementByJS(driver, "//input[@id='Password']", password);
		abstractPage.clickToElement(driver, "//input[@value='Log in']");

		Assert.assertTrue(abstractPage.isElementDisplayed(driver, "//a[@class='ico-account']"));
		Assert.assertTrue(abstractPage.isElementDisplayed(driver, "//a[@class='ico-logout']"));
	}

	@Test
	public void TC_03_View_My_Account() {
		abstractPage.clickToElement(driver, "//a[@class='ico-account']");

		Assert.assertTrue(abstractPage.isElementSelected(driver, "//input[@id='gender-male']"));

		Assert.assertEquals(abstractPage.getElementAttribute(driver, "//input[@id='FirstName']", "value"), firtName);
		Assert.assertEquals(abstractPage.getElementAttribute(driver, "//input[@id='LastName']", "value"), lastName);

		Assert.assertEquals(abstractPage.getFirstSelectedItemInDropdown(driver, "//select[@name='DateOfBirthDay']"), "11");
		Assert.assertEquals(abstractPage.getFirstSelectedItemInDropdown(driver, "//select[@name='DateOfBirthMonth']"), "September");
		Assert.assertEquals(abstractPage.getFirstSelectedItemInDropdown(driver, "//select[@name='DateOfBirthYear']"), "1989");

		Assert.assertEquals(abstractPage.getElementAttribute(driver, "//input[@id='Email']", "value"), email);
		Assert.assertEquals(abstractPage.getElementAttribute(driver, "//input[@id='Company']", "value"), companyName);

		Assert.assertTrue(abstractPage.isElementSelected(driver, "//input[@id='Newsletter']"));
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
