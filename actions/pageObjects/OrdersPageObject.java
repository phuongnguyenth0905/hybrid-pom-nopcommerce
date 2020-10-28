package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.OrdersPageUI;

public class OrdersPageObject extends AbstractPage{
	WebDriver driver;
    
	public OrdersPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
}
