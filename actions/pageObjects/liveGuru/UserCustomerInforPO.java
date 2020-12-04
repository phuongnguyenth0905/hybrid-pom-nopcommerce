package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.liveGuru.UserCustomerInforPageUI;

public class UserCustomerInforPO extends AbstractPage{
	WebDriver driver;
    //Hàm khởi tạo(contructor)
	public UserCustomerInforPO(WebDriver driver) {
		this.driver = driver;
	}
	
//	public boolean isGenderMaleRadioButtonSelected() {
//		waitToElementVisible(driver, UserCustomerInforPageUI.GENDER_MALE_RADIO);
//		return isElementSelected(driver, UserCustomerInforPageUI.GENDER_MALE_RADIO);
//	}

	public String getFirstNameTextboxValue() {
		waitToElementVisible(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameTextboxValue() {
		waitToElementVisible(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX, "value");
		
	}

//	public String getSelectedTextInDayDropdown() {
//		waitToElementVisible(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
//		return getFirstSelectedItemInDropdown(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
//	}
//
//	public String getSelectedTextInMonthDropdown() {
//		waitToElementVisible(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
//		return getFirstSelectedItemInDropdown(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
//	}
//
//	public String getSelectedTextInYearDropdown() {
//		waitToElementVisible(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
//		return getFirstSelectedItemInDropdown(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
//	}
	public String getEmailTextboxValue() {
		waitToElementVisible(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCurrentPasswordTextboxValue() {
		waitToElementVisible(driver, UserCustomerInforPageUI.CURRENT_PASSWORD_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.CURRENT_PASSWORD_TEXTBOX, "value");
	}

	public boolean isChangePasswordCheckboxSelected() {
		waitToElementVisible(driver, UserCustomerInforPageUI.CHANGE_PASSWORD_CHECKBOX);
		return isElementSelected(driver, UserCustomerInforPageUI.CHANGE_PASSWORD_CHECKBOX);
	}

}
