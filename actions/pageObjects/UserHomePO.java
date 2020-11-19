package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.UserHomePageUI;

public class UserHomePO extends AbstractPage {
	WebDriver driver;

	// Hàm khởi tạo(contructor)
	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPO clickToRegisterLink() {
		waitToElementClickAble(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegistePage(driver);
	}

	public UserLoginPO clickToLoginLink() {
		waitToElementClickAble(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplayed() {
		waitToElementVisible(driver, UserHomePageUI.LOGOUT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.LOGOUT_LINK);
	}

	public UserCustomerInforPO clickToMyAccountLink() {
		waitToElementClickAble(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
	}

	public boolean isRegisterLinkDisplayed() {
		//waitToElementVisible(driver, UserHomePageUI.REGISTER_LINK);
		return isElementDisplayed(driver, UserHomePageUI.REGISTER_LINK);
	}
	
	public boolean isLoginLinkDisplayed() {
		//waitToElementVisible(driver, UserHomePageUI.LOGIN_LINK);
		return isElementDisplayed(driver, UserHomePageUI.LOGIN_LINK);
	}
	
	public boolean isShoppingCartNoItemTooltipDisplayed() {
		
		return isElementDisplayed(driver, UserHomePageUI.SHOPPING_CART_NO_ITEM_TOOLTIP);
	}
	public boolean isRegisterLinkUndisplayed() {
		waitToElementInvisible(driver, UserHomePageUI.REGISTER_LINK);
		return isElementUndisplayed(driver, UserHomePageUI.REGISTER_LINK);
	}

	public boolean isLoginLinkUndisplayed() {
		waitToElementInvisible(driver, UserHomePageUI.LOGIN_LINK);
		return isElementUndisplayed(driver, UserHomePageUI.LOGIN_LINK);
	}

	public boolean isShoppingCartNoItemTooltipUndisplayed() {
		waitToElementInvisible(driver, UserHomePageUI.SHOPPING_CART_NO_ITEM_TOOLTIP);
		return isElementUndisplayed(driver, UserHomePageUI.SHOPPING_CART_NO_ITEM_TOOLTIP);
	}

}
