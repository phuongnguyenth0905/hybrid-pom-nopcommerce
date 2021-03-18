package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.AbstractTest;
import pageObjects.liveGuru.PageGeneratorManagerliveGuru;
import pageObjects.liveGuru.UserHomePO;
import pageObjects.liveGuru.UserMobilePO;

public class Level_24_Database_Testing extends AbstractTest {

	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {

		driver = getBrowserDriver(browserName, url);

	}

	@Test
	public void TC_01_Register_To_System() {
		log.info("Register - Step 01 : Open Home Page");
		homePage = PageGeneratorManagerliveGuru.getUserHomePage(driver);

		log.info("Register - Step 02 : Open Mobile Page");
		mobilePage = homePage.openMobilePage(driver);

		log.info("Register - Step 03 : Get Mobile Product Number On Mobile Page( UI)");
		int productSizeUI = mobilePage.getProductMobileNumberOnUI();
		System.out.println(productSizeUI);

		log.info("Register - Step 04 : Get Mobile Product Number In Database");
		int productSizeDB = mobilePage.getProductMobileNumberInDB();
		System.out.println(productSizeDB);

		verifyEquals(productSizeUI, productSizeDB);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	UserHomePO homePage;
	UserMobilePO mobilePage;
}