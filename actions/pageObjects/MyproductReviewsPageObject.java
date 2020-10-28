package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.MyproductReviewsPageUI;
import pageUI.OrdersPageUI;

public class MyproductReviewsPageObject extends AbstractPage{
	WebDriver driver;
    
	public MyproductReviewsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
}
