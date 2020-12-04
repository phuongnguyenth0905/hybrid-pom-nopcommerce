package pageFactory.liveGuru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends AbstractPage {
	WebDriver driver;

	// Hàm khởi tạo(contructor)
	public RegisterPageObject(WebDriver driver) {
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
	
	@FindBy(id = "Password")
	WebElement passwordTextbox;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTextbox;
	
	@FindBy(id = "register-button")
	WebElement registerButton;
	
	@FindBy(className = "result")
	WebElement registerSuccessMessage;
	
	@FindBy(className = "ico-logout")
	WebElement logoutLink;
	
	public void clickToGenderMaleRadioButton() {
		waitToElementClickAble(driver, genderMaleRadio);
		clickToElement(driver, genderMaleRadio);
	}

	public void inputToFirstNameTextbox(String firtName) {
		waitToElementVisible(driver, firstNameTextbox);
		senkeyToElement(driver, firstNameTextbox, firtName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitToElementVisible(driver, lastNameTextbox);
		senkeyToElement(driver, lastNameTextbox, lastName);

	}

	public void selectDayDropdown(String day) {
		waitToElementClickAble(driver, dayDropdown);
		selectItemInDropdown(driver, dayDropdown, day);
	}

	public void selectMonthDropdown(String month) {
		waitToElementClickAble(driver, monthDropdown);
		selectItemInDropdown(driver, monthDropdown, month);

	}

	public void selectYearDropdown(String year) {
		waitToElementClickAble(driver, yearDropdown);
		selectItemInDropdown(driver, yearDropdown, year);

	}

	public void inputToEmailTexbox(String email) {
		waitToElementVisible(driver, emailTextbox);
		senkeyToElement(driver, emailTextbox, email);

	}

	public void inputToCompanyTexbox(String companyName) {
		waitToElementVisible(driver, companyTextbox);
		senkeyToElement(driver, companyTextbox, companyName);

	}

	public void inputToConfirmPasswordTexbox(String password) {
		waitToElementVisible(driver, passwordTextbox);
		senkeyToElement(driver, passwordTextbox, password);

	}

	public void inputToPasswordTexbox(String password) {
		waitToElementVisible(driver, confirmPasswordTextbox);
		senkeyToElement(driver, confirmPasswordTextbox, password);

	}

	public void clickToRegisterButton() {
		waitToElementClickAble(driver, registerButton);
		clickToElement(driver, registerButton);

	}

	public void clickToLogoutLink() {
		waitToElementClickAble(driver, logoutLink);
		clickToElement(driver, logoutLink);

	}

	public String getRegisterSuccessMessage() {
		waitToElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}

	public boolean isRegisterSuccessMessageDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
