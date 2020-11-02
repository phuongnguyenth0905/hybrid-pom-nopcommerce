package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.UserMyproductReviewsPageUI;
import pageUI.UserOrdersPageUI;

public class UserMyproductReviewsPO extends AbstractPage{
	WebDriver driver;
    
	public UserMyproductReviewsPO(WebDriver driver) {
		this.driver = driver;
	}
	
}
