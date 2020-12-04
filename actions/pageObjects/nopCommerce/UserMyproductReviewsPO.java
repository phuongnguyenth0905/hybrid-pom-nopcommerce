package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.nopCommerce.UserMyproductReviewsPageUI;
import pageUI.nopCommerce.UserOrdersPageUI;

public class UserMyproductReviewsPO extends AbstractPage{
	WebDriver driver;
    
	public UserMyproductReviewsPO(WebDriver driver) {
		this.driver = driver;
	}
	
}
