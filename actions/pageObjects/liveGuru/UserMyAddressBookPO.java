package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.liveGuru.UserMyAddressBookPageUI;

public class UserMyAddressBookPO extends AbstractPage {
	WebDriver driver;

	public UserMyAddressBookPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToTelephoneTextbox(String telephoneValue) {
		waitToElementVisible(driver, UserMyAddressBookPageUI.TELEPHONE_TEXTBOX);
		sendkeyToElement(driver, UserMyAddressBookPageUI.TELEPHONE_TEXTBOX, telephoneValue);
	}

	public void inputToStreetAddressTextbox(String streetAddressValue) {
		waitToElementVisible(driver, UserMyAddressBookPageUI.STREET_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, UserMyAddressBookPageUI.STREET_ADDRESS_TEXTBOX, streetAddressValue);
	}

	public void inputToCityTextbox(String cityValue) {
		waitToElementVisible(driver, UserMyAddressBookPageUI.CITY_TEXTBOX);
		sendkeyToElement(driver, UserMyAddressBookPageUI.CITY_TEXTBOX, cityValue);
	}

	public void inputToZipTextbox(String zipValue) {
		waitToElementVisible(driver, UserMyAddressBookPageUI.ZIP_TEXTBOX);
		sendkeyToElement(driver, UserMyAddressBookPageUI.ZIP_TEXTBOX, zipValue);
	}

	public void inputToCountryDropdown(String countryValue) {
		waitToElementVisible(driver, UserMyAddressBookPageUI.COUNTRY_DROPDOWN);
		selectItemInDropdown(driver, UserMyAddressBookPageUI.ZIP_TEXTBOX, countryValue);
	}

	public void clickToSaveAddreesButton() {
		waitToElementClickAble(driver, UserMyAddressBookPageUI.SAVE_ADDRESS_BUTTON);
		clickToElement(driver, UserMyAddressBookPageUI.SAVE_ADDRESS_BUTTON);
	}
	public boolean isAddAddressSuccessMessageDisplayed() {
		waitToElementVisible(driver, UserMyAddressBookPageUI.ADDRESS_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, UserMyAddressBookPageUI.ADDRESS_SUCCESS_MESSAGE);
		
	}
}
