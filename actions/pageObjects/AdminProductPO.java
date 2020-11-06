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
		waitAjaxLoadingInvisible(driver);
	}

	public void unCheckToSelectAllCheckbox() {
		waitToElementClickAble(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		uncheckToCheckbox(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		waitAjaxLoadingInvisible(driver);
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
		waitAjaxLoadingInvisible(driver);
	}

	public boolean areProductDetailDisplayed(String productName, String sKUID, String price, String quantity, String productType, String publicStatus) {
		waitToElementVisible(driver, AdminProductPageUI.PRODUCT_DETAIL_IN_TABLE, productName, sKUID, price, quantity, productType, publicStatus);
		return isElementDisplayed(driver, AdminProductPageUI.PRODUCT_DETAIL_IN_TABLE, productName, sKUID, price, quantity, productType, publicStatus);
	}

	public void selectShowItemDropdown(String itemNumber) {
		waitToElementClickAble(driver, AdminProductPageUI.SHOW_NUMBER_ITEM_DROPDOWN);
		selectItemInDropdown(driver, AdminProductPageUI.SHOW_NUMBER_ITEM_DROPDOWN, itemNumber);
		waitAjaxLoadingInvisible(driver);
	}

	public boolean isInformationDisplayedAtColumnNameRowNumber(String columnName, String rowIndex, String expectedValue) {
		int columnNameIndex= countElementSize(driver, AdminProductPageUI.COLUMN_NAME_SIBLING,columnName)+1;
		String actualValue=getElementText(driver, AdminProductPageUI.CELL_VALUE_MIX_BY_COLUMN_AND_ROW_INDEX, rowIndex,String.valueOf(columnNameIndex));
		return actualValue.equals(expectedValue);
	}

	public boolean isPublishStatusAtColumnNameAnRowNumber(String columnName, String rowIndex, String publishStatus) {
		int columnNameIndex= countElementSize(driver, AdminProductPageUI.COLUMN_NAME_SIBLING,columnName)+1;
		return isElementDisplayed(driver, AdminProductPageUI.PUBLISH_STATUS_MIX_COLUMN_AND_ROW_INDEX, rowIndex,String.valueOf(columnNameIndex),publishStatus);
	}

	public void clickToEditIcontDetailByName(String productName) {
		waitToElementClickAble(driver, AdminProductPageUI.EDIT_ICON_BY_PRODUCT_NAME,productName);
		clickToElement(driver, AdminProductPageUI.EDIT_ICON_BY_PRODUCT_NAME,productName);
		waitAjaxLoadingInvisible(driver);
	}
	
}
