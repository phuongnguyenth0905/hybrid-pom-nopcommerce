package pageUI.liveGuru;

public class LiveGuruAbstractPageUI {
	public static final String ABOUT_US_LINK_LINK="//a[contains(text(),'About Us')]";
	public static final String ADVANCED_SEARCH_LINK = "//a[contains(text(),'Advanced Search')]";
	public static final String SEARCH_TEARM_LINK = "//a[contains(text(),'Search Terms')]";
	public static final String CUSTOMER_SERVICE_LINK="//a[contains(text(),'Customer Service')]";
	public static final String MOBILE_MENU_LINK="//div[@id='header-nav']//a[contains(text(),'Mobile')]";
	public static final String TV_MENU_LINK="//div[@id='header-nav']//a[contains(text(),'TV')]";
	public static final String UPLOAD_FILE_TYPE="//input[@type='file']";
	
	//dynamic link
	public static final String DYNAMIC_FOOTER_PAGE="//div[@class='footer']//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TITLE = "//*[@class='button' and @title='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_TITLE = "//select[@title='%s']";
	public static final String DYNAMIC_RADIO_OR_CHECKBOX_BY_LABEL = "//label[text()='%s']/preceding-sibling::input";

	public static final String DYNAMIC_ERROR_MESSAGE_BY_LABEL = "//label[@for='%s']/following-sibling::span[@class='field-validation-error']/span";//
	
	public static final String ADD_TO_CART_BUTTON_BY_PRODUCT_NAME = "//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']/button";
	public static final String SUCCESS_MESSAGE = "//li[@class='success-msg']//span";
	public static final String ERROR_MESSAGE = "//li[@class='error-msg']//span";
	public static final String PRICE_VALUE_SHOPPING_CART_TABLE = "//td[contains(string(),'%s')]/following-sibling::td//span[@class='price']";
	
}
