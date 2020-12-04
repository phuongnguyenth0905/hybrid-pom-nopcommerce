package pageObjects.liveGuru;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.AbstractPage;
import pageUI.liveGuru.AdminProductPageUI;

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
		int columnNameIndex = countElementSize(driver, AdminProductPageUI.COLUMN_NAME_SIBLING, columnName) + 1;
		String actualValue = getElementText(driver, AdminProductPageUI.CELL_VALUE_MIX_BY_COLUMN_AND_ROW_INDEX, rowIndex, String.valueOf(columnNameIndex));
		return actualValue.equals(expectedValue);
	}

	public boolean isPublishStatusAtColumnNameAnRowNumber(String columnName, String rowIndex, String publishStatus) {
		int columnNameIndex = countElementSize(driver, AdminProductPageUI.COLUMN_NAME_SIBLING, columnName) + 1;
		return isElementDisplayed(driver, AdminProductPageUI.PUBLISH_STATUS_MIX_COLUMN_AND_ROW_INDEX, rowIndex, String.valueOf(columnNameIndex), publishStatus);
	}

	public void clickToEditIconDetailByName(String productName) {
		waitToElementClickAble(driver, AdminProductPageUI.EDIT_ICON_BY_PRODUCT_NAME, productName);
		clickToElement(driver, AdminProductPageUI.EDIT_ICON_BY_PRODUCT_NAME, productName);
		waitAjaxLoadingInvisible(driver);
	}

	public void inputToProductNameTextbox(String productName) {
		waitToElementVisible(driver, AdminProductPageUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminProductPageUI.PRODUCT_NAME_TEXTBOX, productName);

	}

	public void clickToSearchButton() {
		waitToElementClickAble(driver, AdminProductPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminProductPageUI.SEARCH_BUTTON);
		waitAjaxLoadingInvisible(driver);
	}

	public void scrollToPicturePanel() {
		scrollToElement(driver, AdminProductPageUI.PICTURE_PANEL);

	}

	public void inputToAltTextbox(String imageDecscription) {
		waitToElementVisible(driver, AdminProductPageUI.ALT_TEXTBOX);
		sendkeyToElement(driver, AdminProductPageUI.ALT_TEXTBOX, imageDecscription);
	}

	public void inputToTitleTextbox(String imageTitle) {
		waitToElementVisible(driver, AdminProductPageUI.TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminProductPageUI.TITLE_TEXTBOX, imageTitle);

	}

	public void clickToIconAtOrderTextbox(String iconValue) {
		waitToElementClickAble(driver, AdminProductPageUI.ICON_VALUE_AT_ORDER_TEXTBOX, iconValue);
		clickToElement(driver, AdminProductPageUI.ICON_VALUE_AT_ORDER_TEXTBOX, iconValue);

	}

	public void clickToAddProductPictureButton() {
		waitToElementClickAble(driver, AdminProductPageUI.ADD_PRODUCT_PICTURE_BUTTON);
		clickToElement(driver, AdminProductPageUI.ADD_PRODUCT_PICTURE_BUTTON);
		waitAjaxLoadingInvisible(driver);
	}

	public boolean areImageDetailDisplayed(String productName, String pictureOrder, String pictureAlt, String pictureTitle) {
		waitToElementVisible(driver, AdminProductPageUI.IMAGE_UPLOAD_DETAIL, productName, pictureOrder, pictureAlt, pictureTitle);
		return isElementDisplayed(driver, AdminProductPageUI.IMAGE_UPLOAD_DETAIL, productName, pictureOrder, pictureAlt, pictureTitle);
	}

	public void clickToSaveButton() {
		waitToElementClickAble(driver, AdminProductPageUI.SAVE_BUTTON);
		clickToElement(driver, AdminProductPageUI.SAVE_BUTTON);
		waitAjaxLoadingInvisible(driver);
	}

	public void clickToDeleteButtonByPictureTitle(String pictureTitle) {
		waitToElementClickAble(driver, AdminProductPageUI.DELETE_BUTTON_BY_PRODUCT_TITLE, pictureTitle);
		clickToElement(driver, AdminProductPageUI.DELETE_BUTTON_BY_PRODUCT_TITLE, pictureTitle);
		waitAlertPresence(driver);
		sleepInSecond(2);
		acceptAlert(driver);
		waitAjaxLoadingInvisible(driver);

	}

	public boolean areProductDisplayed(String productPicture, String productName, String productSku, String productPrice, String productQuantity, String productSimple, String productState) {
		waitToElementVisible(driver, AdminProductPageUI.PRODUCT_DETAIL, productPicture.toLowerCase().replace("", "-"), productName, productSku, productPrice, productQuantity, productSimple, productState);
		return isElementDisplayed(driver, AdminProductPageUI.PRODUCT_DETAIL, productPicture.toLowerCase().replace("", "-"), productName, productSku, productPrice, productQuantity, productSimple, productState);
	}

	public boolean isNewPictureUploadedSuccess(String fileName) {
		waitToElementInvisible(driver, AdminProductPageUI.SPINNER_UPLOAD);
		return isElementDisplayed(driver, AdminProductPageUI.UPLOAD_FILE_NAME, fileName);
	}

}
