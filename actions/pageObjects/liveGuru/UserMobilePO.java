package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.liveGuru.UserHomePageUI;
import pageUI.liveGuru.UserMobilePageUI;

public class UserMobilePO extends AbstractPage{
	WebDriver driver;
    
	public UserMobilePO(WebDriver driver) {
		this.driver = driver;
	}

	public String getProdcutPriceAtListPage() {
		waitToElementVisible(driver, UserMobilePageUI.SONY_XPERIA_PRICE_BY_PRODUCT_NAME_AT_LIST);
		return getElementText(driver, UserMobilePageUI.SONY_XPERIA_PRICE_BY_PRODUCT_NAME_AT_LIST);
	}

	public void clickToSonyXperiaProductName() {
		waitToElementClickAble(driver, UserMobilePageUI.SONY_XPERIA_PRODUCT_NAME);
		clickToElement(driver, UserMobilePageUI.SONY_XPERIA_PRODUCT_NAME);
	}

	public String getProductPriceAtDetailPage() {
		waitToElementVisible(driver, UserMobilePageUI.SONY_XPERIA_PRICE_BY_PRODUCT_NAME_AT_DETAIL);
		return getElementText(driver, UserMobilePageUI.SONY_XPERIA_PRICE_BY_PRODUCT_NAME_AT_DETAIL);
	}
	
	public UserCompareProductPO clickCompareButton() {
		waitToElementClickAble(driver, UserMobilePageUI.COMPARE_TO_BUTTON);
		clickToElement(driver, UserMobilePageUI.COMPARE_TO_BUTTON);
		switchToWindowByTitle(driver, UserMobilePageUI.TITLE_COMPARE_PRODUCTS);
		return PageGeneratorManagerliveGuru.getCompareProductPage(driver);
	}

		
}
