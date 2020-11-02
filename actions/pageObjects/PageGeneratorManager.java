package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static UserLoginPO getUserLoginPage(WebDriver driver) {
		return new UserLoginPO(driver);
	}
	public static UserHomePO getUserHomePage(WebDriver driver) {
		return new UserHomePO(driver);
	}
	public static UserRegisterPO getUserRegistePage(WebDriver driver) {
		return new UserRegisterPO(driver);
	}
	public static UserCustomerInforPO getUserCustomerInforPage(WebDriver driver) {
		return new UserCustomerInforPO(driver);
	}
	public static UserAddressesPO getUserAddressesPage(WebDriver driver) {
		return new UserAddressesPO(driver);
	}
	public static UserOrdersPO getUserOrdersPage(WebDriver driver) {
		return new UserOrdersPO(driver);
	}
	public static UserMyproductReviewsPO getUserMyproductReviewsPage(WebDriver driver) {
		return new UserMyproductReviewsPO(driver);
	}
	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}
}
