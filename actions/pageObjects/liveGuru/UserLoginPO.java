package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.liveGuru.UserLoginPageUI;
import pageUI.liveGuru.UserRegisterPageUI;

public class UserLoginPO extends AbstractPage {
	WebDriver driver;

	// Hàm khởi tạo(contructor)
	public UserLoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public UserHomePO clickToLoginButton() {
		waitToElementClickAble(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public UserRegisterPO clickToCreateAnAccountButton() {
		// Viết hàm click vào Register button ở đây
		waitToElementClickAble(driver, UserRegisterPageUI.CLICK_CREATE_AN_ACCOUNT_BUTTON);
		clickToElement(driver, UserRegisterPageUI.CLICK_CREATE_AN_ACCOUNT_BUTTON);
		return PageGeneratorManager.getUserRegistePage(driver);
	}
}
