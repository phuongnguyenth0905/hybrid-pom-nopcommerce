package pageObjects.sauLab;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.sauceLab.ProductPageUI;


public class productPO extends AbstractPage {
	WebDriver driver;

	public productPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean areProductNameSortedByAscending() {
		waitAllElementVisible(driver, ProductPageUI.ALL_PRODUCT_NAME);
		return isDataStringSortedAscending(driver, ProductPageUI.ALL_PRODUCT_NAME);
	}

	public boolean areProductNameSortedByDescending() {
		waitAllElementVisible(driver, ProductPageUI.ALL_PRODUCT_NAME);
		return isDataStringSortedDescending(driver, ProductPageUI.ALL_PRODUCT_NAME);
	}

	public void selectItemInProductSortDropdown(String itemValue) {
		waitToElementClickAble(driver, ProductPageUI.PRODUCT_SORT_DROPDOWN_LIST);
		selectItemInDropdown(driver, ProductPageUI.PRODUCT_SORT_DROPDOWN_LIST, itemValue);
	}

	public boolean areProductPriceSortedByAscending() {
		waitAllElementVisible(driver, ProductPageUI.ALL_PRODUCT_PRICE);
		return isDataFloatSortedAscending(driver, ProductPageUI.ALL_PRODUCT_PRICE);
	}

	public boolean areProductPriceSortedByDescending() {
		waitAllElementVisible(driver, ProductPageUI.ALL_PRODUCT_PRICE);
		return isDataFloatSortedDescending(driver, ProductPageUI.ALL_PRODUCT_PRICE);
	}
}
