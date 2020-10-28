package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageUI.HomePageUI;

public class HomePageObject extends AbstractPage {
	WebDriver driver;

	// Hàm khởi tạo(contructor)
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "ico-register")
	WebElement registerLink;
	@FindBy(className = "ico-login")
	WebElement loginLink;
	@FindBy(className = "ico-account")
	WebElement myAccountLink;
	@FindBy(className = "ico-logout")
	WebElement logoutLink;

	public void clickToRegisterLink() {
		waitToElementClickAble(driver, registerLink);
		clickToElement(driver, registerLink );
	}

	public void clickToLoginLink() {
		waitToElementClickAble(driver, loginLink);
		clickToElement(driver, loginLink);

	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisible(driver, myAccountLink);
		return isElementDisplayed(driver, myAccountLink);
	}

	public boolean isLogoutLinkDisplayed() {
		waitToElementVisible(driver, logoutLink);
		return isElementDisplayed(driver, logoutLink);
	}

	public void clickToMyAccountLink() {
		waitToElementClickAble(driver, myAccountLink);
		clickToElement(driver, myAccountLink);

	}

}
