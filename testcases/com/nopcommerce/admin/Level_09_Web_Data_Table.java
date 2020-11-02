package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.AdminLoginPO;
import pageObjects.PageGeneratorManager;

public class Level_09_Web_Data_Table extends AbstractTest {

	WebDriver driver;
	AdminLoginPO loginPage;
	
	@Parameters(value = {"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName ,String urlValue) {
		driver=getBrowserDriver(browserName, urlValue);
		loginPage=PageGeneratorManager.getAdminLoginPage(driver);
		
		loginPage.inputToEmailTextbox("");
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
	}

	@Test
	public void TC_01_Register() {

	}

	@Test
	public void TC_02_Login() {

	}

	@Test
	public void TC_03_View_My_Account() {

	}

	@Test
	public void TC_04_Rest_Parameter_01() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}