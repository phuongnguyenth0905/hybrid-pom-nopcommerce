package pageUI;

public class AbstractPageUI {
	public static final String ADDRESSES_LINK="//div[@class='listbox']//a[text()='Addresses']";
	public static final String MY_PRODUCT_REVIEW_LINK = "//a[text()='My product reviews']";
	public static final String CUSTOMER_INFO_LINK = "//a[contains(text(),'Customer info')]";
	public static final String ORDER_LINK="//div[@class='listbox']//a[text()='Orders']";
	
	//dynamic link
	public static final String DYNAMIC_LINK="//div[@class='listbox']//a[text()='%s']";
	public static final String LOADING_ICON = "//div[@id='ajaxBusy']/span";
	public static final String UPLOAD_FILE_BY_PANEL = "//div[@id='%s']//input[@type='file']";
	public static final String PLUS_ICON_BY_PANEL = "//div[@id='%s']//i[contains(@class,'toggle-icon')]";
	
}
