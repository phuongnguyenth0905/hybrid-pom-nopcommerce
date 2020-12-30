package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import io.qameta.allure.Step;
import pageUI.liveGuru.UserMyDashboardPageUI;

public class UserMyDashboardPO extends AbstractPage {
	WebDriver driver;

	public UserMyDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Get Welcome message")
	public String getWelcomeSuccessMessagee() {
		waitToElementVisible(driver, UserMyDashboardPageUI.WELCOME_MESSAGE_TEXT);
		return getElementText(driver, UserMyDashboardPageUI.WELCOME_MESSAGE_TEXT);
	}

	public UserMyAddressBookPO clickToManageAddressLink() {
		waitToElementClickAble(driver, UserMyDashboardPageUI.MANAGE_ADDRESS_LINK);
		clickToElement(driver, UserMyDashboardPageUI.MANAGE_ADDRESS_LINK);
		return PageGeneratorManagerliveGuru.getMyAddressBookPage(driver);
	}
	@Step("Click to Logout Link and navigate to home Page")
	public UserHomePO clickToLogoutLink() {
		waitToElementClickAble(driver, UserMyDashboardPageUI.HEAD_ACCOUNT_LINK);
		clickToElement(driver, UserMyDashboardPageUI.HEAD_ACCOUNT_LINK);
		waitToElementClickAble(driver, UserMyDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, UserMyDashboardPageUI.LOGOUT_LINK);
		return PageGeneratorManagerliveGuru.getUserHomePage(driver);
	}
	@Step("My Dashboard page is Displayed")
	public boolean isMyDashboardPageHeaderDisplayed() {
		waitToElementVisible(driver, UserMyDashboardPageUI.MY_DASHBOARD_HEADER);
		return isElementDisplayed(driver, UserMyDashboardPageUI.MY_DASHBOARD_HEADER);
	}

	public UserMyAccountInformationPO clickToMyAccountInformationLink() {
		waitToElementClickAble(driver, UserMyDashboardPageUI.MY_ACCOUNT_INFORMATION);
		clickToElement(driver, UserMyDashboardPageUI.MY_ACCOUNT_INFORMATION);
		return PageGeneratorManagerliveGuru.getMyAccountInfomationPO(driver);
	}

	public boolean isOrderInformationDisplayed(String orderID, String today, String string, String string2, String string3) {
		// TODO Auto-generated method stub
		return false;
	}
}
