package commons;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.nopCommerce.PageGeneratorManagerNopCommerce;
import pageObjects.nopCommerce.UserAddressesPO;
import pageObjects.nopCommerce.UserCustomerInforPO;
import pageObjects.nopCommerce.UserMyproductReviewsPO;
import pageObjects.nopCommerce.UserOrdersPO;
import pageUI.nopCommerce.NopCommerceAbstractPageUI;

import pageObjects.liveGuru.UserCheckoutPO;
import pageObjects.liveGuru.UserMobilePO;
import pageObjects.liveGuru.UserTVPO;
import pageObjects.liveGuru.PageGeneratorManagerliveGuru;
import pageObjects.liveGuru.UserAdvancedSearchPO;
import pageUI.liveGuru.LiveGuruAbstractPageUI;

public class AbstractPage {
	// WebDriver driver;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
	private List<WebElement> elements;
	private Actions action;
	private WebElement element;
	protected final Log log;

	protected AbstractPage() {
		log = LogFactory.getLog(getClass());
	}

	public void openPageUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getCurrentPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelptAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void getTextAlert(WebDriver driver) {
		driver.switchTo().alert().getText();
	}

	public void sendkeyTotAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public void waitAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.alertIsPresent());

	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	public WebElement getElement(WebDriver driver, String locator) {
		
		return driver.findElement(getByXpath(locator));
	}

	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public String getDynamicLocator(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return locator;
	}

	public void clickToElement(WebDriver driver, String locator) {
		highlightElement(driver, locator);
		try {
			if (driver.toString().toLowerCase().contains("edge")) {
				sleepInMilisecond(500);
			} else if (driver.toString().contains("internet explorer")) {
				clickToElementByJS(driver, locator);
				sleepInSecond(3);
			} else {
				element = getElement(driver, locator);
				element.click();
			}
		} catch (Exception e) {
			log.debug("Element is not clickable " + e.getMessage());
		}

	}

	public void clickToElement(WebDriver driver, String locator, String... values) {
		highlightElement(driver, getDynamicLocator(locator, values));
		try {
			if (driver.toString().toLowerCase().contains("edge")) {
				sleepInMilisecond(500);
			} else if (driver.toString().contains("internet explorer")) {
				clickToElementByJS(driver, getDynamicLocator(locator, values));
				sleepInSecond(3);
			} else {
				element = getElement(driver, getDynamicLocator(locator, values));
				element.click();
			}
		} catch (Exception e) {
			log.debug("Element is not clickable " + e.getMessage());
		}

	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		highlightElement(driver, locator);
		element = getElement(driver, locator);
		element.clear();
		if (driver.toString().toLowerCase().contains("chrome") || driver.toString().toLowerCase().contains("edge")) {
			sleepInMilisecond(500);
		}
		element.sendKeys(value);
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value, String... values) {
		highlightElement(driver, getDynamicLocator(locator, values));
		element = getElement(driver, getDynamicLocator(locator, values));
		element.clear();
		if (driver.toString().toLowerCase().contains("chrome") || driver.toString().toLowerCase().contains("edge")) {
			sleepInMilisecond(500);
		}
		element.sendKeys(value);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String itemValue) {
		highlightElement(driver, locator);
		element = getElement(driver, locator);
		Select select = new Select(element);
		select.selectByVisibleText(itemValue);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String itemValue, String... values) {
		highlightElement(driver, getDynamicLocator(locator, values));
		element = getElement(driver, getDynamicLocator(locator, values));
		Select select = new Select(element);
		select.selectByVisibleText(itemValue);
	}

	public String getFirstSelectedItemInDropdown(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		
		element = getElement(driver, locator);
		Select select = new Select(element);
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
		getElement(driver, parentLocator).click();

		sleepInSecond(1);

		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		elements = getElements(driver, childItemLocator);

		for (WebElement item : elements) {

			if (item.getText().equals(expectedItem)) {

				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void sleepInMilisecond(long milisecond) {
		try {
			Thread.sleep(milisecond);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		element = getElement(driver, locator);
		return element.getAttribute(attributeName);
	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeName, String... values) {
		element = getElement(driver, getDynamicLocator(locator, values));
		return element.getAttribute(attributeName);
	}

	public String getElementText(WebDriver driver, String locator) {
		
		element = getElement(driver, locator);
		return element.getText().trim();
	}

	public String getElementText(WebDriver driver, String locator, String... values) {
		
		element = getElement(driver, getDynamicLocator(locator, values));
		return element.getText().trim();
	}

	public int countElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}

	public int countElementSize(WebDriver driver, String locator, String... values) {
		return getElements(driver, getDynamicLocator(locator, values)).size();
	}

	public void checkToCheckbox(WebDriver driver, String locator) {
		highlightElement(driver, locator);
		element = getElement(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void checkToCheckbox(WebDriver driver, String locator, String... values) {
		highlightElement(driver, getDynamicLocator(locator, values));
		element = getElement(driver, getDynamicLocator(locator, values));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		try {
			return getElement(driver, locator).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
		return getElement(driver, getDynamicLocator(locator, values)).isDisplayed();
	}

//////
	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}

	public boolean isEnabled(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}

	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getElement(driver, locator));
	}

	public void switchToDefaultContent(WebDriver driver, String locator) {
		driver.switchTo().defaultContent();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
	}

	public void hoveMouseToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}

	public void clickAndHoveToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.clickAndHold(getElement(driver, locator)).perform();
	}

	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
	}

	public void sendkeyBoardToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInMilisecond(300);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		sleepInSecond(1);
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}

	public boolean waitToJQueryAndJSLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public void waitToElementVisible(WebDriver driver, String locator) {
		try {
			explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
		} catch (Exception e) {
			log.debug("Wait for element visible with error: " + e.getMessage());
		}
	}

	public void waitToElementVisible(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
	}

	public void waitAllElementVisible(WebDriver driver, String locator) {
		try {
			explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
			explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
		} catch (Exception e) {
			log.debug("Wait for elements visible with error: " + e.getMessage());
		}
	}

	public void waitAllElementVisible(WebDriver driver, String locator, String... values) {
		try {
			explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
			explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(getDynamicLocator(locator, values))));
		} catch (Exception e) {
			log.debug("Wait for elements visible with error: " + e.getMessage());
		}
	}

	public void waitToElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.SHORT_TIMEOUT);
		overideImplicitWait(driver, GlobalConstans.SHORT_TIMEOUT);

		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
		overideImplicitWait(driver, GlobalConstans.LONG_TIMEOUT);
	}

	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		overideImplicitWait(driver, GlobalConstans.SHORT_TIMEOUT);
		elements = getElements(driver, locator);
		overideImplicitWait(driver, GlobalConstans.LONG_TIMEOUT);
		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {

			return true;
		} else {

			return false;
		}
	}

	public void overideImplicitWait(WebDriver driver, long timeInSecond) {
		driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.SECONDS);
	}

	public void waitToElementInvisible(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
	}

	public void waitToElementClickAble(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, values))));
	}

	public void waitToElementClickAble(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}

	public void waitAjaxLoadingInvisible(WebDriver driver) {
		waitToElementInvisible(driver, NopCommerceAbstractPageUI.LOADING_ICON);
	}

	public void uploadFileByPanelD(WebDriver driver, String panelID, String... fileNames) {
		String filePath = GlobalConstans.UPLOAD_FOLDER;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		// Dùng cho chrome
		// senkeyToElement(driver, AbstractPageUI.UPLOAD_FILE_BY_PANEL, fullFileName, panelID);

		// Dùng cho firefox
		getElement(driver, getDynamicLocator(NopCommerceAbstractPageUI.UPLOAD_FILE_BY_PANEL, panelID)).sendKeys(fullFileName);
	}

	public void clickToPlusIconByPanelID(WebDriver driver, String panelID) {
		waitToElementClickAble(driver, NopCommerceAbstractPageUI.PLUS_ICON_BY_PANEL, panelID);
		String iconAttibuteValue = getElementAttribute(driver, NopCommerceAbstractPageUI.PLUS_ICON_BY_PANEL, "class", panelID);

		if (iconAttibuteValue.contains("fa-plus")) {
			clickToElement(driver, NopCommerceAbstractPageUI.PLUS_ICON_BY_PANEL, panelID);
			sleepInMilisecond(500);
		}
	}

	// 4 hàm mở page
	public UserAddressesPO openAddressesPage(WebDriver driver) {
		waitToElementClickAble(driver, NopCommerceAbstractPageUI.ADDRESSES_LINK);
		clickToElement(driver, NopCommerceAbstractPageUI.ADDRESSES_LINK);
		return PageGeneratorManagerNopCommerce.getUserAddressesPage(driver);
	}

	public UserMyproductReviewsPO openMyProductReviewPage(WebDriver driver) {
		waitToElementClickAble(driver, NopCommerceAbstractPageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, NopCommerceAbstractPageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManagerNopCommerce.getUserMyproductReviewsPage(driver);
	}

	public UserCustomerInforPO openCustomerInforPage(WebDriver driver) {
		waitToElementClickAble(driver, NopCommerceAbstractPageUI.CUSTOMER_INFO_LINK);
		clickToElement(driver, NopCommerceAbstractPageUI.CUSTOMER_INFO_LINK);
		return PageGeneratorManagerNopCommerce.getUserCustomerInforPage(driver);
	}

	public UserOrdersPO openOrderPage(WebDriver driver) {
		waitToElementClickAble(driver, NopCommerceAbstractPageUI.ORDER_LINK);
		clickToElement(driver, NopCommerceAbstractPageUI.ORDER_LINK);
		return PageGeneratorManagerNopCommerce.getUserOrdersPage(driver);
	}

	// cach1: dùng cho page nhỏ:10-15 page
	public AbstractPage openLinkByPageName(WebDriver driver, String pageName) {
		waitToElementClickAble(driver, NopCommerceAbstractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, NopCommerceAbstractPageUI.DYNAMIC_LINK, pageName);

		switch (pageName) {
		case "Addresses":
			return PageGeneratorManagerNopCommerce.getUserAddressesPage(driver);
		case "My product reviews":
			return PageGeneratorManagerNopCommerce.getUserMyproductReviewsPage(driver);
		case "Customer info":
			return PageGeneratorManagerNopCommerce.getUserCustomerInforPage(driver);
		default:
			return PageGeneratorManagerNopCommerce.getUserOrdersPage(driver);
		}
	}

	// cách 2:
	public void openLinkWithPageName(WebDriver driver, String pageName) {
		waitToElementClickAble(driver, NopCommerceAbstractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, NopCommerceAbstractPageUI.DYNAMIC_LINK, pageName);
	}

	public void clickToRadioButtonByID(WebDriver driver, String radioButtonID) {
		waitToElementClickAble(driver, NopCommerceAbstractPageUI.DYNAMIC_RADIO_BUTTON_BY_ID, radioButtonID);
		clickToElement(driver, NopCommerceAbstractPageUI.DYNAMIC_RADIO_BUTTON_BY_ID, radioButtonID);
	}

	public void inputToTextboxByID(WebDriver driver, String textboxID, String value) {
		waitToElementVisible(driver, NopCommerceAbstractPageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, NopCommerceAbstractPageUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
	}

	public void clickToButtonByValue(WebDriver driver, String buttonValue) {
		waitToElementClickAble(driver, NopCommerceAbstractPageUI.DYNAMIC_BUTTON_BY_VALUE, buttonValue);
		clickToElement(driver, NopCommerceAbstractPageUI.DYNAMIC_BUTTON_BY_VALUE, buttonValue);
	}

	public void selectDropdownByName(WebDriver driver, String dropdownName, String itemValue) {
		waitToElementVisible(driver, NopCommerceAbstractPageUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownName);
		selectItemInDropdown(driver, NopCommerceAbstractPageUI.DYNAMIC_DROPDOWN_BY_NAME, itemValue, dropdownName);
	}

	public String getErrorMesageAtMandantoryFieldByID(WebDriver driver, String fieldID) {
		waitToElementVisible(driver, NopCommerceAbstractPageUI.DYNAMIC_ERROR_MESSAGE_BY_ID, fieldID);
		return getElementText(driver, NopCommerceAbstractPageUI.DYNAMIC_ERROR_MESSAGE_BY_ID, fieldID);
	}

//liveGuru
	public void checkToRadioOrCheckboxLabel(WebDriver driver, String radioOrCheckboxLabel) {
		waitToElementClickAble(driver, LiveGuruAbstractPageUI.DYNAMIC_RADIO_OR_CHECKBOX_BY_LABEL, radioOrCheckboxLabel);
		checkToCheckbox(driver, LiveGuruAbstractPageUI.DYNAMIC_RADIO_OR_CHECKBOX_BY_LABEL, radioOrCheckboxLabel);
	}

	public UserAdvancedSearchPO openAdvancedSearchPage(WebDriver driver) {
		waitToElementClickAble(driver, LiveGuruAbstractPageUI.ADVANCED_SEARCH_LINK);
		clickToElement(driver, LiveGuruAbstractPageUI.ADVANCED_SEARCH_LINK);
		return PageGeneratorManagerliveGuru.getAdvancedSearchPage(driver);
	}

	public UserMobilePO openMobilePage(WebDriver driver) {
		waitToElementClickAble(driver, LiveGuruAbstractPageUI.MOBILE_MENU_LINK);
		clickToElement(driver, LiveGuruAbstractPageUI.MOBILE_MENU_LINK);
		return PageGeneratorManagerliveGuru.getMobilePage(driver);

	}

	public UserTVPO openTVPage(WebDriver driver) {
		waitToElementClickAble(driver, LiveGuruAbstractPageUI.TV_MENU_LINK);
		clickToElement(driver, LiveGuruAbstractPageUI.TV_MENU_LINK);
		return PageGeneratorManagerliveGuru.getTVPage(driver);

	}

	public UserCheckoutPO clickAddToCardButtonAProductName(WebDriver driver, String productName) {
		waitToElementClickAble(driver, LiveGuruAbstractPageUI.ADD_TO_CART_BUTTON_BY_PRODUCT_NAME, productName);
		clickToElement(driver, LiveGuruAbstractPageUI.ADD_TO_CART_BUTTON_BY_PRODUCT_NAME, productName);
		return PageGeneratorManagerliveGuru.getCheckoutPage(driver);
	}

	public UserMobilePO clickAddToCompareName(WebDriver driver, String productName) {
		waitToElementClickAble(driver, LiveGuruAbstractPageUI.ADD_TO_COMPARE_LINK_BY_PRODUCT_NAME, productName);
		clickToElement(driver, LiveGuruAbstractPageUI.ADD_TO_COMPARE_LINK_BY_PRODUCT_NAME, productName);
		return PageGeneratorManagerliveGuru.getMobilePage(driver);
	}

	public String getSuccessMessage(WebDriver driver) {
		waitToElementVisible(driver, LiveGuruAbstractPageUI.SUCCESS_MESSAGE);
		return getElementText(driver, LiveGuruAbstractPageUI.SUCCESS_MESSAGE);

	}

	public String getErrorMessage(WebDriver driver) {
		waitToElementVisible(driver, LiveGuruAbstractPageUI.ERROR_MESSAGE);
		return getElementText(driver, LiveGuruAbstractPageUI.ERROR_MESSAGE);

	}

	public String getPriceAtShoppingCartTable(WebDriver driver, String title) {
		waitToElementVisible(driver, LiveGuruAbstractPageUI.PRICE_VALUE_SHOPPING_CART_TABLE, title);
		return getElementText(driver, LiveGuruAbstractPageUI.PRICE_VALUE_SHOPPING_CART_TABLE, title);
	}

//ap dung cho page it or nhieu deu dc
	public void openFooterByName(WebDriver driver, String pageName) {
		waitToElementClickAble(driver, LiveGuruAbstractPageUI.DYNAMIC_FOOTER_PAGE, pageName);
		clickToElement(driver, LiveGuruAbstractPageUI.DYNAMIC_FOOTER_PAGE, pageName);
	}

//Sort theo string (alpha)
	public boolean isDataStringSortedAscending(WebDriver driver, String locator) {
		// Khai báo 1 Array List
		ArrayList<String> arrayList = new ArrayList<String>();
		// Tìm tất cả các element matching với điều kiện (Name,Price,...)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		// Lấy text của từng element add vào Array List
		for (WebElement element : elementList) {
			arrayList.add(element.getText());
		}
		System.out.println("----------- Dữ Liệu Trên UI -----------");
		for (String name : arrayList) {
			System.out.println(name);
		}
		// Copy qua 1 Array List mới để SORT trong code
		ArrayList<String> sortedList = new ArrayList<String>();
		for (String child : arrayList) {
			sortedList.add(child);
		}
		// Thực hiện SORT ASC
		Collections.sort(sortedList);
		System.out.println("----------- Dữ Liệu Đã SORT ASC Trong Code -----------");
		for (String name : sortedList) {
			System.out.println(name);
		}
		// Verify 2 Array bằng nhau- nếu DL sort trên UI không chính xác thì KQ trả về sai
		return sortedList.equals(arrayList);
	}

	public boolean isDataStringSortedDescending(WebDriver driver, String locator) {
		// Khai báo 1 Array List
		ArrayList<String> arrayList = new ArrayList<String>();
		// Tìm tất cả các element matching với điều kiện (Name,Price,...)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		// Lấy text của từng element add vào Array List
		for (WebElement element : elementList) {
			arrayList.add(element.getText());
		}
		System.out.println("----------- Dữ Liệu Trên UI -----------");
		for (String name : arrayList) {
			System.out.println(name);
		}
		// Copy qua 1 Array List mới để SORT trong code
		ArrayList<String> sortedList = new ArrayList<String>();
		for (String child : arrayList) {
			sortedList.add(child);
		}
		// Thực hiện SORT ASC
		Collections.sort(sortedList);
		System.out.println("----------- Dữ Liệu Đã SORT DESC Trong Code -----------");
		for (String name : sortedList) {
			System.out.println(name);
		}
		// Reverse data để sort DESC(1 trong 2 cách)
		Collections.reverse(sortedList);
		// Collections.sort(arrayList,Collections.reverseOrder());
		// Verify 2 Array bằng nhau- nếu DL sort trên UI không chính xác thì KQ trả về sai
		return sortedList.equals(arrayList);
	}

//Sort theo số(price)
	public boolean isDataFloatSortedAscending(WebDriver driver, String locator) {
		// Khai báo 1 Array List
		ArrayList<Float> arrayList = new ArrayList<Float>();
		// Tìm tất cả các element matching với điều kiện (Name,Price,...)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		// Lấy text của từng element add vào Array List
		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
		}
		System.out.println("----------- Dữ Liệu Trên UI -----------");
		for (Float name : arrayList) {
			System.out.println(name);
		}
		// Copy qua 1 Array List mới để SORT trong code
		ArrayList<Float> sortedList = new ArrayList<Float>();
		for (Float child : arrayList) {
			sortedList.add(child);
		}
		// Thực hiện SORT ASC
		Collections.sort(sortedList);
		System.out.println("----------- Dữ Liệu Đã SORT ASC Trong Code -----------");
		for (Float name : sortedList) {
			System.out.println(name);
		}

		// Verify 2 Array bằng nhau- nếu DL sort trên UI không chính xác thì KQ trả về sai
		return sortedList.equals(arrayList);

	}

	public boolean isDataFloatSortedDescending(WebDriver driver, String locator) {
		// Khai báo 1 Array List
		ArrayList<Float> arrayList = new ArrayList<Float>();
		// Tìm tất cả các element matching với điều kiện (Name,Price,...)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		// Lấy text của từng element add vào Array List
		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
		}
		System.out.println("----------- Dữ Liệu Trên UI -----------");
		for (Float name : arrayList) {
			System.out.println(name);
		}
		// Copy qua 1 Array List mới để SORT trong code
		ArrayList<Float> sortedList = new ArrayList<Float>();
		for (Float child : arrayList) {
			sortedList.add(child);
		}
		// Thực hiện SORT ASC
		Collections.sort(sortedList);
		System.out.println("----------- Dữ Liệu Đã SORT DESC Trong Code -----------");
		for (Float name : sortedList) {
			System.out.println(name);
		}
		// Reverse data để sort DESC(1 trong 2 cách)
		Collections.reverse(sortedList);
		// Collections.sort(arrayList,Collections.reverseOrder());
		// Verify 2 Array bằng nhau- nếu DL sort trên UI không chính xác thì KQ trả về sai
		return sortedList.equals(arrayList);

	}

//sort date
	public boolean isDataDateSortedAscending(WebDriver driver, String locator) {
		// Khai báo 1 Array List
		ArrayList<Date> arrayList = new ArrayList<Date>();
		// Tìm tất cả các element matching với điều kiện (Name,Price,...)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		// Lấy text của từng element add vào Array List
		for (WebElement element : elementList) {
			arrayList.add(convertStringToDate(element.getText()));
		}
		System.out.println("----------- Dữ Liệu Trên UI -----------");
		for (Date name : arrayList) {
			System.out.println(name);
		}
		// Copy qua 1 Array List mới để SORT trong code
		ArrayList<Date> sortedList = new ArrayList<Date>();
		for (Date child : arrayList) {
			sortedList.add(child);
		}
		// Thực hiện SORT ASC
		Collections.sort(sortedList);
		System.out.println("----------- Dữ Liệu Đã SORT ASC Trong Code -----------");
		for (Date name : sortedList) {
			System.out.println(name);
		}
		// Verify 2 Array bằng nhau- nếu DL sort trên UI không chính xác thì KQ trả về sai
		return sortedList.equals(arrayList);

	}

	public boolean isDataDateSortedDescending(WebDriver driver, String locator) {
		// Khai báo 1 Array List
		ArrayList<Date> arrayList = new ArrayList<Date>();
		// Tìm tất cả các element matching với điều kiện (Name,Price,...)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		// Lấy text của từng element add vào Array List
		for (WebElement element : elementList) {
			arrayList.add(convertStringToDate(element.getText()));
		}
		System.out.println("----------- Dữ Liệu Trên UI -----------");
		for (Date name : arrayList) {
			System.out.println(name);
		}
		// Copy qua 1 Array List mới để SORT trong code
		ArrayList<Date> sortedList = new ArrayList<Date>();
		for (Date child : arrayList) {
			sortedList.add(child);
		}
		// Thực hiện SORT ASC
		Collections.sort(sortedList);
		System.out.println("----------- Dữ Liệu Đã SORT DESC Trong Code -----------");
		for (Date name : sortedList) {
			System.out.println(name);
		}
		// Reverse data để sort DESC(1 trong 2 cách)
		Collections.reverse(sortedList);
		// Collections.sort(arrayList,Collections.reverseOrder());
		// Verify 2 Array bằng nhau- nếu DL sort trên UI không chính xác thì KQ trả về sai
		return sortedList.equals(arrayList);

	}

	public Date convertStringToDate(String dateInString) {
		dateInString = dateInString.replace(",", "");
		SimpleDateFormat formatDate = new SimpleDateFormat("MMM dd yyyy");
		Date date = null;
		try {
			date = formatDate.parse(dateInString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
}
