package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.AbstractPage;
import pageUI.AdminProductPageUI;

public class AdminProductPO extends AbstractPage {
	WebDriver driver;

	public AdminProductPO(WebDriver driver) {
		this.driver = driver;
	}

	public void goToPageAtTableByIndex(String indexPage) {
		waitToElementClickAble(driver, AdminProductPageUI.PAGING_AT_TABLE_BY_INDEX, indexPage);
		clickToElement(driver, AdminProductPageUI.PAGING_AT_TABLE_BY_INDEX, indexPage);
	}

	public boolean isPageActivedAtTableByIndex(String indexPage) {
		waitToElementVisible(driver, AdminProductPageUI.PAGING_AT_TABLE_ACTIVE_BY_INDEX, indexPage);
		return isElementDisplayed(driver, AdminProductPageUI.PAGING_AT_TABLE_ACTIVE_BY_INDEX, indexPage);
	}

	public void checkToSelectAllCheckbox() {
		waitToElementClickAble(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		checkToCheckbox(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);

	}

	public void unCheckToSelectAllCheckbox() {
		waitToElementClickAble(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		uncheckToCheckbox(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);

	}

	public void allProductCheckboxChecked() {
		List<WebElement> allProductCheckboxes = getElements(driver, AdminProductPageUI.ALL_PRODUCT_CHECKBOX);
		for (WebElement productCheckbox : allProductCheckboxes) {
			Assert.assertTrue(productCheckbox.isSelected());
		}

	}

	public void allProductCheckboxUnChecked() {
		List<WebElement> allProductCheckboxes = getElements(driver, AdminProductPageUI.ALL_PRODUCT_CHECKBOX);
		for (WebElement productCheckbox : allProductCheckboxes) {
			Assert.assertFalse(productCheckbox.isSelected());
		}

	}

	public void checkToProductCheckboxByName(String productName) {
		waitToElementClickAble(driver, AdminProductPageUI.PRODUCT_CHECKBOX_BY_NAME, productName);
		checkToCheckbox(driver, AdminProductPageUI.PRODUCT_CHECKBOX_BY_NAME, productName);

	}
}
