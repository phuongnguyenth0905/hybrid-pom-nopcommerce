package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.liveGuru.ManageCustomerPageUI;

public class ManageCustomerPO extends AbstractPage {
	WebDriver driver;

	public ManageCustomerPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToIncomingMessageCloseButton() {
		waitToElementClickAble(driver, ManageCustomerPageUI.INCOMING_MESSAGE_CLOSE_ICON);
		clickToElement(driver, ManageCustomerPageUI.INCOMING_MESSAGE_CLOSE_ICON);
	}
	
	public void inputToCustomerTableTextboxByColumnName(String columnName,String value) {
		waitToElementVisible(driver, ManageCustomerPageUI.DYNAMIC_COLUMN_NAME,columnName);
		//
		String columnNameIndex=String.valueOf(countElementSize(driver,ManageCustomerPageUI.DYNAMIC_COLUMN_NAME,columnName));
		//
		waitToElementVisible(driver, ManageCustomerPageUI.DYNAMIC_TEXTBOX_BY_INDEX,columnNameIndex);
		clickToElement(driver, ManageCustomerPageUI.DYNAMIC_TEXTBOX_BY_INDEX,value,columnNameIndex);
	}
	public void clickToButtonByTitleName(String titleName) {
		waitToElementClickAble(driver, ManageCustomerPageUI.DYNAMIC_BUTTON_BY_TITLE);
		clickToElement(driver, ManageCustomerPageUI.DYNAMIC_BUTTON_BY_TITLE);
	}
	//
	public boolean isValueDisplayedAtColumnNameByRowNumber(String columnName,String rowName,String value) {
		waitToElementVisible(driver, ManageCustomerPageUI.DYNAMIC_COLUMN_NAME,columnName);
		String columnNameIndex=String.valueOf(countElementSize(driver,ManageCustomerPageUI.DYNAMIC_COLUMN_NAME,columnName));
waitToElementVisible(driver, ManageCustomerPageUI.DYNAMIC_VALUE_AT_COLUMN_NAME_AND_ROW_NUMBER,rowName,columnNameIndex);
		return isElementDisplayed(driver, ManageCustomerPageUI.DYNAMIC_VALUE_AT_COLUMN_NAME_AND_ROW_NUMBER,rowName,columnNameIndex);
		
	}
}
