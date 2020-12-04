package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.liveGuru.AdminDashboardPageUI;

public class UserMyDashboardPO extends AbstractPage{
	WebDriver driver;
    
	public UserMyDashboardPO(WebDriver driver) {
		this.driver = driver;
	}
//chua edit
	public AdminProductPO openProductPage() {
		waitToElementClickAble(driver, AdminDashboardPageUI.CATALOG_TEXT_AT_SIDEBAR);
		clickToElement(driver, AdminDashboardPageUI.CATALOG_TEXT_AT_SIDEBAR);
		waitToElementClickAble(driver, AdminDashboardPageUI.PRODUCT_LINK_AT_SIDEBAR);
		clickToElement(driver, AdminDashboardPageUI.PRODUCT_LINK_AT_SIDEBAR);
		
		
		//1 cach
		//waitToJQueryAndJSLoadedSuccess(driver);
		//cach 2:
		waitAjaxLoadingInvisible(driver);
		return PageGeneratorManager.getAdminProductPage(driver);
	}
}
