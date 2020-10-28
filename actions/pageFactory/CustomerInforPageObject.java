package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInforPageObject extends AbstractPage {
	WebDriver driver;

	// Hàm khởi tạo(contructor)
	public CustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "gender-male")
	WebElement genderMaleRadio;

	@FindBy(id = "FirstName")
	WebElement firstNameTextbox;

	@FindBy(id = "LastName")
	WebElement lastNameTextbox;

	@FindBy(name = "DateOfBirthDay")
	WebElement dayDropdown;

	@FindBy(name = "DateOfBirthMonth")
	WebElement monthDropdown;

	@FindBy(name = "DateOfBirthYear")
	WebElement yearDropdown;

	@FindBy(id = "Email")
	WebElement emailTextbox;

	@FindBy(id = "Company")
	WebElement companyTextbox;

	@FindBy(id = "Newsletter")
	WebElement newsLetterTextbox;

	public boolean isGenderMaleRadioButtonSelected() {
		waitToElementVisible(driver, genderMaleRadio);
		return isElementSelected(driver, genderMaleRadio);
	}

	public String getFirstNameTextboxValue() {
		waitToElementVisible(driver, firstNameTextbox);
		return getElementAttribute(driver, firstNameTextbox, "value");
	}

	public String getLastNameTextboxValue() {
		waitToElementVisible(driver, lastNameTextbox);
		return getElementAttribute(driver, lastNameTextbox, "value");

	}

	public String getSelectedTextInDayDropdown() {
		waitToElementVisible(driver, dayDropdown);
		return getFirstSelectedItemInDropdown(driver, dayDropdown);
	}

	public String getSelectedTextInMonthDropdown() {
		waitToElementVisible(driver, monthDropdown);
		return getFirstSelectedItemInDropdown(driver, monthDropdown);
	}

	public String getSelectedTextInYearDropdown() {
		waitToElementVisible(driver, yearDropdown);
		return getFirstSelectedItemInDropdown(driver, yearDropdown);
	}

	public String getEmailTextboxValue() {
		waitToElementVisible(driver, emailTextbox);
		return getElementAttribute(driver, emailTextbox, "value");
	}

	public String getCompanyTextboxValue() {
		waitToElementVisible(driver, companyTextbox);
		return getElementAttribute(driver, companyTextbox, "value");
	}

	public boolean isNewsletterCheckboxSelected() {
		waitToElementVisible(driver, newsLetterTextbox);
		return isElementSelected(driver, newsLetterTextbox);
	}

}
