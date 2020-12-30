package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.nopCommerce.AdminDashboardPageUI;

public class AdminDashboardPO extends AbstractPage{
	WebDriver driver;
    
	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminProductPO openProductPage() {
		waitToElementClickAble(driver, AdminDashboardPageUI.CATALOG_TEXT_AT_SIDEBAR);
		clickToElement(driver, AdminDashboardPageUI.CATALOG_TEXT_AT_SIDEBAR);
		waitToElementClickAble(driver, AdminDashboardPageUI.PRODUCT_LINK_AT_SIDEBAR);
		clickToElement(driver, AdminDashboardPageUI.PRODUCT_LINK_AT_SIDEBAR);
		//1 cach
		//waitToJQueryAndJSLoadedSuccess(driver);
		//cach 2:
		waitAjaxLoadingInvisible(driver);
		return PageGeneratorManagerNopCommerce.getAdminProductPage(driver);
	}
}
