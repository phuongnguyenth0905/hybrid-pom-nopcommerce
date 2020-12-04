package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	private WebDriverWait explicitWait;
	private Select select;
	
	public void waitToElementVisible(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	public void senkeyToElement(WebDriver driver, WebElement element, String value) {
		
		element.clear();
		if(driver.toString().toLowerCase().contains("chrome")||driver.toString().toLowerCase().contains("edge")) {
			sleepInMilisecond(500);
		}
		element.sendKeys(value);
	}
	public void sleepInMilisecond(long milisecond) {
		try {
			Thread.sleep(milisecond);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	public void clickToElement(WebDriver driver, WebElement element) {
		if (driver.toString().toLowerCase().contains("edge")) {
			sleepInMilisecond(500);
		}
		element.click();
	}
	public void waitToElementClickAble(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}
	//
	public void selectItemInDropdown(WebDriver driver, WebElement element, String itemValue) {
		
		Select select = new Select(element);
		select.selectByVisibleText(itemValue);
	}
	//
	public String getElementText(WebDriver driver, WebElement element) {
		
		return element.getText();
	}
	public boolean isElementSelected(WebDriver driver, WebElement element) {
		return element.isSelected();
	}
	public String getElementAttribute(WebDriver driver, WebElement element, String attributeName) {
		
		return element.getAttribute(attributeName);
	}
	public String getFirstSelectedItemInDropdown(WebDriver driver, WebElement element) {
		
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
}
