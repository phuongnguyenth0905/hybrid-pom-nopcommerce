package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.UserAddressesPageUI;

public class UserAddressesPO extends AbstractPage{
	WebDriver driver;
    
	public UserAddressesPO(WebDriver driver) {
		this.driver = driver;
	}

	
}
