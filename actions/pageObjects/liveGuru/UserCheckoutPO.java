package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.liveGuru.UserCheckoutPageUI;

public class UserCheckoutPO extends AbstractPage {
	WebDriver driver;

	public UserCheckoutPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputDiscountValueToDiscountTexbox(String discountCode) {
		waitToElementVisible(driver, UserCheckoutPageUI.DISCOUNT_CODE_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.DISCOUNT_CODE_TEXTBOX, discountCode);
	}

	public void clickToApplyButton() {
		waitToElementClickAble(driver, UserCheckoutPageUI.APPLY_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.APPLY_BUTTON);
	}

	public void removeItemProduct() {
		waitToElementClickAble(driver, UserCheckoutPageUI.REMOVE_ITEM_PRODUCT_LINK);
		clickToElement(driver, UserCheckoutPageUI.REMOVE_ITEM_PRODUCT_LINK);
	}

	public void inputToQTYTexboxByProductName(String productName, String qtyNumber) {
		waitToElementVisible(driver, UserCheckoutPageUI.QTY_TEXTBOX_BY_PRODUCT_NAME, productName);
		sendkeyToElement(driver, UserCheckoutPageUI.QTY_TEXTBOX_BY_PRODUCT_NAME, qtyNumber, productName);
	}

	public void clickToUpdateButtonProductName(String productName) {
		waitToElementClickAble(driver, UserCheckoutPageUI.UPDATE_BUTTON_BY_PRODUCT_NAME, productName);
		clickToElement(driver, UserCheckoutPageUI.UPDATE_BUTTON_BY_PRODUCT_NAME, productName);
	}

	public String getMaximumQuantityErrorMessageAtProductName(String productName) {
		waitToElementVisible(driver, UserCheckoutPageUI.QUANTITY_MAXIMUM_MESSAGE_BY_PRODUCT_NAME, productName);
		return getElementText(driver, UserCheckoutPageUI.QUANTITY_MAXIMUM_MESSAGE_BY_PRODUCT_NAME, productName);
	}

	public void selectValueInCountryDropdownAtShoppingCart(String countryName) {
		waitToElementClickAble(driver, UserCheckoutPageUI.COUNTRY_DROPDOWN_AT_SHOPPING_CART, countryName);
		selectItemInDropdown(driver, UserCheckoutPageUI.COUNTRY_DROPDOWN_AT_SHOPPING_CART, countryName);

	}

	public void selectValueInStateDropdownAtShoppingCart(String stateName) {
		waitToElementClickAble(driver, UserCheckoutPageUI.STATE_DROPDOWN_AT_SHOPPING_CART, stateName);
		selectItemInDropdown(driver, UserCheckoutPageUI.STATE_DROPDOWN_AT_SHOPPING_CART, stateName);
	}

	public void inputToZipCodeTextboxAtShoppingCart(String zipCode) {
		waitToElementVisible(driver, UserCheckoutPageUI.ZIP_CODE_TEXTBOX_AT_SHOPPING_CAT, zipCode);
		sendkeyToElement(driver, UserCheckoutPageUI.ZIP_CODE_TEXTBOX_AT_SHOPPING_CAT, zipCode);

	}

	public void clickToEstimateButton() {
		waitToElementClickAble(driver, UserCheckoutPageUI.ESTIMATE_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.ESTIMATE_BUTTON);
	}

	public String getFlateRateValue() {
		waitToElementVisible(driver, UserCheckoutPageUI.FLAT_RATE_TEXT);
		return getElementText(driver, UserCheckoutPageUI.FLAT_RATE_TEXT);
	}

	public void clickToFlateRateRadio() {
		waitToElementClickAble(driver, UserCheckoutPageUI.FLAT_RATE_RADIO_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.FLAT_RATE_RADIO_BUTTON);
	}

	public void clickToUpdateTotalButton() {
		waitToElementClickAble(driver, UserCheckoutPageUI.UPDATE_TOTAL_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.UPDATE_TOTAL_BUTTON);
	}

	public void clickToProceedCheckoutButton() {
		waitToElementClickAble(driver, UserCheckoutPageUI.PROCEED_CHECKOUT_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.PROCEED_CHECKOUT_BUTTON);
	}

	public void inputToAddressTextboxAtBillingForm(String address) {
		waitToElementVisible(driver, UserCheckoutPageUI.ADDRESS_TEXTBOX_AT_BILLING_FORM, address);
		sendkeyToElement(driver, UserCheckoutPageUI.ADDRESS_TEXTBOX_AT_BILLING_FORM, address);
	}

/// chu y dang error
	public void inputToCityTextboxAtBillingForm(String city) {
		waitToElementVisible(driver, UserCheckoutPageUI.CITY_TEXTBOX_AT_BILLING_FORM, city);
		sendkeyToElement(driver, UserCheckoutPageUI.CITY_TEXTBOX_AT_BILLING_FORM, city);

	}

	public void selectValueInCountryDropdownAtBillingForm(String countryName) {
		waitToElementClickAble(driver, UserCheckoutPageUI.COUNTRY_DROPDOWN_AT_BILLING_FORM, countryName);
		selectItemInDropdown(driver, UserCheckoutPageUI.COUNTRY_DROPDOWN_AT_BILLING_FORM, countryName);
	}

//textbox
	public void selectValueInStateDropdownAtBillingForm(String stateName) {
		waitToElementClickAble(driver, UserCheckoutPageUI.STATE_DROPDOWN_AT_BILLING_FORM, stateName);
		selectItemInDropdown(driver, UserCheckoutPageUI.STATE_DROPDOWN_AT_BILLING_FORM, stateName);
	}

	public void inputToZipCodeTextboxAtBillingForm(String zipCode) {
		waitToElementVisible(driver, UserCheckoutPageUI.ZIP_CODE_TEXTBOX_AT_BILLING_FORM, zipCode);
		sendkeyToElement(driver, UserCheckoutPageUI.ZIP_CODE_TEXTBOX_AT_BILLING_FORM, zipCode);
	}

	public void inputToPhoneTextbox(String phoneNumber) {
		waitToElementVisible(driver, UserCheckoutPageUI.PHONE_TEXTBOX_AT_BILLING_FORM, phoneNumber);
		sendkeyToElement(driver, UserCheckoutPageUI.PHONE_TEXTBOX_AT_BILLING_FORM, phoneNumber);

	}

	public void clickToContinueButtonByTitleName(String titleName) {
		waitToElementClickAble(driver, UserCheckoutPageUI.CONTIUNE_BUTTON_BY_TITLE_NAME,titleName);
		clickToElement(driver, UserCheckoutPageUI.CONTIUNE_BUTTON_BY_TITLE_NAME, titleName);

	}

	public void clickToCreaditCardRadio() {
		waitToElementClickAble(driver, UserCheckoutPageUI.CREDIT_CART_RADIO_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.CREDIT_CART_RADIO_BUTTON);

	}

	public void inputToCardNameTextbox(String cardName) {
		waitToElementVisible(driver, UserCheckoutPageUI.CARD_NAME_TEXTBOX, cardName);
		sendkeyToElement(driver, UserCheckoutPageUI.CARD_NAME_TEXTBOX, cardName);

	}

	public void selectToCartTypeDropdown(String cardType) {
		waitToElementClickAble(driver, UserCheckoutPageUI.CARD_TYPE_TEXTBOX, cardType);
		selectItemInDropdown(driver, UserCheckoutPageUI.CARD_TYPE_TEXTBOX, cardType);

	}

	public void inputToCardNumberTextbox(String cardNumber) {
		waitToElementVisible(driver, UserCheckoutPageUI.CARD_NUMBER_TEXTBOX, cardNumber);
		sendkeyToElement(driver, UserCheckoutPageUI.CARD_NUMBER_TEXTBOX, cardNumber);

	}

	public void selectToMonthExpiretionDropdown(String cardMonthExpire) {
		waitToElementClickAble(driver, UserCheckoutPageUI.MONTH_EXPIRATION_DROPDOWN, cardMonthExpire);
		selectItemInDropdown(driver, UserCheckoutPageUI.MONTH_EXPIRATION_DROPDOWN, cardMonthExpire);

	}

	public void selectToYearExpiretionDropdown(String cardYearExpire) {
		waitToElementClickAble(driver, UserCheckoutPageUI.YEAR_EXPIRATION_DROPDOWN, cardYearExpire);
		selectItemInDropdown(driver, UserCheckoutPageUI.YEAR_EXPIRATION_DROPDOWN, cardYearExpire);
	}

	public void inputToCardVerificationNumberTextbox(String cardVerificationNumber) {
		waitToElementVisible(driver, UserCheckoutPageUI.CARD_VERIFICATION_NUMBER_TEXTBOX, cardVerificationNumber);
		sendkeyToElement(driver, UserCheckoutPageUI.CARD_VERIFICATION_NUMBER_TEXTBOX, cardVerificationNumber);

	}

//
	public boolean isProductInformationDisplayed(String productName, String productPrice, String productQTY, String subTotalPrice) {
		waitToElementVisible(driver, UserCheckoutPageUI.PRODUCT_DETAIL_BY_NAME_PRICE_QTY_SUBTOTAL, productName, productPrice, productQTY, subTotalPrice);
		return isElementDisplayed(driver, UserCheckoutPageUI.PRODUCT_DETAIL_BY_NAME_PRICE_QTY_SUBTOTAL, productName, productPrice, productQTY, subTotalPrice);
	}

	public void clickToPlaceOrderButton() {
		waitToElementClickAble(driver, UserCheckoutPageUI.PLACE_ORDER_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.PLACE_ORDER_BUTTON);
	}

	public boolean isProductOrderSuccessMessageDisplayed(String succesMessage) {
		waitToElementVisible(driver, UserCheckoutPageUI.PRODUCT_ORDER_SUCCESS_BY_MESSAGE_NAME,succesMessage);
		return isElementDisplayed(driver, UserCheckoutPageUI.PRODUCT_ORDER_SUCCESS_BY_MESSAGE_NAME, succesMessage);
	}

	public String getOrderID() {
		waitToElementVisible(driver, UserCheckoutPageUI.ORDER_ID);
		return getElementText(driver, UserCheckoutPageUI.ORDER_ID);
	}

}
