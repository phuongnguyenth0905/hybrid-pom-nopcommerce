 package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.liveGuru.UserMyAccountInformationPageUI;

public class UserMyAccountInformationPO extends AbstractPage{
	WebDriver driver;
    
	public UserMyAccountInformationPO(WebDriver driver) {
		this.driver = driver;
	}

	public String getFirstnameTextboxValue() {
		waitToElementVisible(driver, UserMyAccountInformationPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, UserMyAccountInformationPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastnameTextboxValue() {
		waitToElementVisible(driver, UserMyAccountInformationPageUI.LASTNAME_TEXBOX);
		return getElementAttribute(driver, UserMyAccountInformationPageUI.LASTNAME_TEXBOX, "value");
	}

	public String getEmailTextboxValue() {
		waitToElementVisible(driver, UserMyAccountInformationPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, UserMyAccountInformationPageUI.EMAIL_TEXTBOX, "value");
	}

	
}
