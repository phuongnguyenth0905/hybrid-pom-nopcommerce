package pageUI;

public class AdminProductPageUI {
	public static final String PAGING_AT_TABLE_BY_INDEX = "//li[@class='paginate_button ']/a[text()='%s']";
	public static final String PAGING_AT_TABLE_ACTIVE_BY_INDEX = "//li[@class='paginate_button active']/a[text()='%s']";
	public static final String SELECT_ALL_CHECKBOX = "//th/input[@id='mastercheckbox']";
	public static final String UNSELECT_ALL_CHECKBOX = "//th/input[@id='mastercheckbox']";
	public static final String ALL_PRODUCT_CHECKBOX = "//input[@name='checkbox_products']";
	public static final String PRODUCT_CHECKBOX_BY_NAME = "//td[text()='%s']/preceding-sibling::td/input";
	
	public static final String PRODUCT_DETAIL_IN_TABLE = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/i[contains(@class,'%s-icon')]";
	public static final String SHOW_NUMBER_ITEM_DROPDOWN = "//select[@name='products-grid_length']";
	
	public static final String COLUMN_NAME_SIBLING = "//th[text()='%s']/preceding-sibling::th";
	public static final String CELL_VALUE_MIX_BY_COLUMN_AND_ROW_INDEX = "//tr[%s]/td[%s]";
	
	public static final String PUBLISH_STATUS_MIX_COLUMN_AND_ROW_INDEX = "//tr[%s]/td[%s]/i[contains(@class,'%s-icon')]";
	public static final String EDIT_ICON_BY_PRODUCT_NAME = "//td[text()='%s']/following-sibling::td/a";
	
	
}
