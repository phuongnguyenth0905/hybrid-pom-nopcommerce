package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.liveGuru.UserMyDashboardPageUI;

public class AdminDashboardPO extends AbstractPage{
	WebDriver driver;
    
	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminProductPO openProductPage() {
//		waitToElementClickAble(driver, UserMyDashboardPageUI.CATALOG_TEXT_AT_SIDEBAR);
//		clickToElement(driver, UserMyDashboardPageUI.CATALOG_TEXT_AT_SIDEBAR);
//		waitToElementClickAble(driver, UserMyDashboardPageUI.PRODUCT_LINK_AT_SIDEBAR);
//		clickToElement(driver, UserMyDashboardPageUI.PRODUCT_LINK_AT_SIDEBAR);
//		//1 cach
//		//waitToJQueryAndJSLoadedSuccess(driver);
//		//cach 2:
//		waitAjaxLoadingInvisible(driver);
		return PageGeneratorManagerliveGuru.getAdminProductPage(driver);
	}
}
