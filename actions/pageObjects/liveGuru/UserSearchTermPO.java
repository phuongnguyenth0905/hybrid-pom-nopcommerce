package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class UserSearchTermPO extends AbstractPage{
	WebDriver driver;
    
	public UserSearchTermPO(WebDriver driver) {
		this.driver = driver;
	}

}
