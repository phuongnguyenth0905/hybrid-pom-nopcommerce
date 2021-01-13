package pageObjects.sauLab;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManagerSauceLab {
	public static productPO getProductPage(WebDriver driver) {
		return new productPO(driver);
	}

}
