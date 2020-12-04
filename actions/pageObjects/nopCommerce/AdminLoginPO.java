package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.nopCommerce.AdminLoginPageUI;

public class AdminLoginPO extends AbstractPage{
	WebDriver driver;
    
	public AdminLoginPO(WebDriver driver) {
		this.driver = driver;
		
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public AdminDashboardPO clickToLoginButton() {
		waitToElementClickAble(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPO(driver);
	}

	public AdminDashboardPO loginToSystem(String email, String password) {
		inputToEmailTextbox(email);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}
}
