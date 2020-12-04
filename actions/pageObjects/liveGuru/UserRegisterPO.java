package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import io.qameta.allure.Step;
import pageUI.liveGuru.UserRegisterPageUI;

public class UserRegisterPO extends AbstractPage {
	WebDriver driver;

	// Hàm khởi tạo(contructor)
	public UserRegisterPO(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Input to firstname textbox with value{0}")
	public void inputToFirstNameTextbox(String firtName) {
		waitToElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firtName);
	}
	@Step("Input to lastName textbox with value{0}")
	public void inputToLastNameTextbox(String lastName) {
		waitToElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastName);

	}

//	public void selectDayDropdown(String day) {
//		waitToElementClickAble(driver, UserRegisterPageUI.DAY_DROPDOWN);
//		selectItemInDropdown(driver, UserRegisterPageUI.DAY_DROPDOWN, day);
//	}
//
//	public void selectMonthDropdown(String month) {
//		waitToElementClickAble(driver, UserRegisterPageUI.MONTH_DROPDOWN);
//		selectItemInDropdown(driver, UserRegisterPageUI.MONTH_DROPDOWN, month);
//
//	}
//
//	public void selectYearDropdown(String year) {
//		waitToElementClickAble(driver, UserRegisterPageUI.YEAR_DROPDOWN);
//		selectItemInDropdown(driver, UserRegisterPageUI.YEAR_DROPDOWN, year);
//
//	}

	public void inputToEmailTexbox(String email) {
		waitToElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);

	}


	public void inputToConfirmPasswordTexbox(String password) {
		waitToElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);

	}

	public void inputToPasswordTexbox(String password) {
		waitToElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);

	}

	public void clickToRegisterButton() {
		waitToElementClickAble(driver, UserRegisterPageUI.CLICK_TO_REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.CLICK_TO_REGISTER_BUTTON);

	}

	public UserHomePO clickToLogoutLink() {
		waitToElementClickAble(driver, UserRegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getRegisterSuccessMessage() {
		waitToElementVisible(driver, UserRegisterPageUI.REGISTERED_SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTERED_SUCCESS_MESSAGE);
	}

	public boolean isRegisterSuccessMessageDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public UserHomePO clickHeadAcountLink() {
		waitToElementClickAble(driver, UserRegisterPageUI.HEAD_ACCOUNT);
		clickToElement(driver, UserRegisterPageUI.HEAD_ACCOUNT);
		return PageGeneratorManager.getUserHomePage(driver);
	}

}
