package pageUI;

public class AdminProductPageUI {
	public static final String PAGING_AT_TABLE_BY_INDEX = "//li[@class='paginate_button ']/a[text()='%s']";
	public static final String PAGING_AT_TABLE_ACTIVE_BY_INDEX = "//li[@class='paginate_button active']/a[text()='%s']";
	public static final String SELECT_ALL_CHECKBOX = "//th/input[@id='mastercheckbox']";
	public static final String UNSELECT_ALL_CHECKBOX = "//th/input[@id='mastercheckbox']";
	public static final String ALL_PRODUCT_CHECKBOX = "//input[@name='checkbox_products']";
	public static final String PRODUCT_CHECKBOX_BY_NAME = "//td[text()='%s']/preceding-sibling::td/input";

}
