package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.AdminDashboardPageUI;

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
		waitToJQueryAndJSLoadedSuccess(driver);
		return PageGeneratorManager.getAdminProductPage(driver);
	}
}
