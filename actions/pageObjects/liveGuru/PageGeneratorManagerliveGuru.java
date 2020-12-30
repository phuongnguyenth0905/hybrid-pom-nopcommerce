package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;
		
		//khi tạo 1 Page Object mới thì tạo 1 hàm mở Page tại đây
public class PageGeneratorManagerliveGuru {
	public static UserLoginPO getUserLoginPage(WebDriver driver) {
		return new UserLoginPO(driver);
	}
	public static UserHomePO getUserHomePage(WebDriver driver) {
		return new UserHomePO(driver);
	}
	public static UserRegisterPO getUserRegistePage(WebDriver driver) {
		return new UserRegisterPO(driver);
	}
	public static UserCustomerServicePO getUserCustomerInforPage(WebDriver driver) {
		return new UserCustomerServicePO(driver);
	}
	public static UserAddressesPO getUserAddressesPage(WebDriver driver) {
		return new UserAddressesPO(driver);
	}
	public static UserSearchTermPO getSearchTermPage(WebDriver driver) {
		return new UserSearchTermPO(driver);
	}
	public static UserAboutUsPO getAboutUsPage(WebDriver driver) {
		return new UserAboutUsPO(driver);
	}
	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}
	public static AdminDashboardPO getAdminDashboardPO(WebDriver driver) {
		return new AdminDashboardPO(driver);
	}
	public static AdminProductPO getAdminProductPage(WebDriver driver) {
		return new AdminProductPO(driver);
	}
	public static UserCheckoutPO getCheckoutPage(WebDriver driver) {
		return new UserCheckoutPO(driver);
	}
	public static UserMyAccountInformationPO getMyAccountInfomationPO(WebDriver driver) {
		return new UserMyAccountInformationPO(driver);
	}
	public static UserMyDashboardPO getMyDasboardPage(WebDriver driver) {
		return new UserMyDashboardPO(driver);
	}
	public static UserAdvancedSearchPO getAdvancedSearchPage(WebDriver driver) {
		return new UserAdvancedSearchPO(driver);
	}
	public static UserMyAddressBookPO getMyAddressBookPage(WebDriver driver) {
		return new UserMyAddressBookPO(driver);
	}
	public static ManageCustomerPO getManageCustomerPage(WebDriver driver) {
		return new ManageCustomerPO(driver);
	}
	public static UserCustomerServicePO getCustomerServicePage(WebDriver driver) {
		return new UserCustomerServicePO(driver);
	}
	public static UserMobilePO getMobilePage(WebDriver driver) {
		return new UserMobilePO(driver);
	}
	public static UserTVPO getTVPage(WebDriver driver) {
		return new UserTVPO(driver);
	}
	
	
}
