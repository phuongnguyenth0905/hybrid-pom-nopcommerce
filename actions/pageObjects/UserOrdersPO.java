package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.UserOrdersPageUI;

public class UserOrdersPO extends AbstractPage{
	WebDriver driver;
    
	public UserOrdersPO(WebDriver driver) {
		this.driver = driver;
	}
	
}
