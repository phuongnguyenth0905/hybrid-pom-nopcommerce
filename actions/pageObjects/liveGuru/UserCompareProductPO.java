package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.liveGuru.UserCompareProductUI;
import pageUI.liveGuru.UserMobilePageUI;

public class UserCompareProductPO extends AbstractPage {
	WebDriver driver;

	public UserCompareProductPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCompareProductWithProductInIt(String productImageSonyXperia, String productNameSonyXperia, String productPriceSonyXperia, String productSKUSonyXperia) {
		waitToElementVisible(driver, UserCompareProductUI.COMPARE_PRODUCT, productImageSonyXperia, productNameSonyXperia, productPriceSonyXperia, productSKUSonyXperia);
		return isElementDisplayed(driver, UserCompareProductUI.COMPARE_PRODUCT, productImageSonyXperia, productNameSonyXperia, productPriceSonyXperia, productSKUSonyXperia);
	}

	public void clickClosePopupWindownsCompareProduct() {
		waitToElementClickAble(driver, UserCompareProductUI.CLOSE_COMPARE_PRODUCT_BUTTON);
		clickToElement(driver, UserCompareProductUI.CLOSE_COMPARE_PRODUCT_BUTTON);
		switchToWindowByTitle(driver, UserCompareProductUI.TITLE_MOBILE_PAGE);
	}

}
