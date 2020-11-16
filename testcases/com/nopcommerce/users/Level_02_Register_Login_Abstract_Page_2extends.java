package com.nopcommerce.users;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;

public class Level_02_Register_Login_Abstract_Page_2extends extends AbstractPage {
	String projectFolder = System.getProperty("user.dir");
	WebDriver driver;
	Select select;

	// tạo bộ DL
	String firtName, lastName, email, companyName, password;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
		// System.setProperty("webdriver.chrome.driver", projectFolder + "\\browserDriver\\chromedriver.exe");
		driver = new FirefoxDriver();
		// driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

		firtName = "Hoang Anh";
		lastName = "Nam";
		email = "hoanganh" + getRandomNumber() + "@gmail.com";
		companyName = "Digital Tech";
		password = "123456";
	}

	@Test
	public void TC_01_Register() {
		clickToElement(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//input[@id='gender-male']");
		sendkeyToElement(driver, "//input[@id='FirstName']", firtName);
		sendkeyToElement(driver, "//input[@id='LastName']", lastName);

		selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "11");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "September");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1989");

		sendkeyToElement(driver, "//input[@id='Email']", email);
		sendkeyToElement(driver, "//input[@id='Company']", companyName);
		sendkeyToElement(driver, "//input[@id='Password']", password);
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", password);

		clickToElement(driver, "//input[@id='register-button']");
		Assert.assertEquals(getElementText(driver, "//div[text()='Your registration completed']"), "Your registration completed");
		clickToElement(driver, "//a[@class='ico-logout']");
	}

	@Test
	public void TC_02_Login() {
		clickToElement(driver, "//a[@class='ico-login']");
		sendkeyToElementByJS(driver, "//input[@id='Email']", email);
		sendkeyToElementByJS(driver, "//input[@id='Password']", password);
		clickToElement(driver, "//input[@value='Log in']");

		Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account']"));
		Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-logout']"));
	}

	@Test
	public void TC_03_View_My_Account() {
		clickToElement(driver, "//a[@class='ico-account']");

		Assert.assertTrue(isElementSelected(driver, "//input[@id='gender-male']"));

		Assert.assertEquals(getElementAttribute(driver, "//input[@id='FirstName']", "value"), firtName);
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='LastName']", "value"), lastName);

		Assert.assertEquals(getFirstSelectedItemInDropdown(driver, "//select[@name='DateOfBirthDay']"), "11");
		Assert.assertEquals(getFirstSelectedItemInDropdown(driver, "//select[@name='DateOfBirthMonth']"), "September");
		Assert.assertEquals(getFirstSelectedItemInDropdown(driver, "//select[@name='DateOfBirthYear']"), "1989");

		Assert.assertEquals(getElementAttribute(driver, "//input[@id='Email']", "value"), email);
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='Company']", "value"), companyName);

		Assert.assertTrue(isElementSelected(driver, "//input[@id='Newsletter']"));

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
