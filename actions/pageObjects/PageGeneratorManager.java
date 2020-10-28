package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static RegisterPageObject getRegistePage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	public static CustomerInforPageObject getCustomerInforPage(WebDriver driver) {
		return new CustomerInforPageObject(driver);
	}
	public static AddressesPageObject getAddressesPageObject(WebDriver driver) {
		return new AddressesPageObject(driver);
	}
	public static OrdersPageObject getOrdersPageObject(WebDriver driver) {
		return new OrdersPageObject(driver);
	}
	public static MyproductReviewsPageObject getMyproductReviewsPageObject(WebDriver driver) {
		return new MyproductReviewsPageObject(driver);
	}
}
