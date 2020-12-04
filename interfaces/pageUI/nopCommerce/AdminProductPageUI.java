package pageUI.nopCommerce;

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
	public static final String PRODUCT_NAME_TEXTBOX = "//input[@id='SearchProductName']";
	public static final String SEARCH_BUTTON = "//button[@id='search-products']";
	public static final String PICTURE_PANEL = "//div[@id='product-pictures']";
	
	public static final String SPINNER_UPLOAD = "//span[contains(@class,'qq-upload-spinner')]";
	
	////span[contains(@class,'qq-upload-file') and @title='hinh5.jpg']
	public static final String UPLOAD_FILE_NAME = "//span[contains(text(),'%s')]";
	
	public static final String ALT_TEXTBOX = "//input[@id='AddPictureModel_OverrideAltAttribute']";
	public static final String TITLE_TEXTBOX = "//input[@id='AddPictureModel_OverrideTitleAttribute']";
	public static final String ICON_VALUE_AT_ORDER_TEXTBOX = "//input[@id='AddPictureModel_DisplayOrder']/following-sibling::span/span[@title='%s value']";
	public static final String ADD_PRODUCT_PICTURE_BUTTON = "//button[@id='addProductPicture']";
	public static final String IMAGE_UPLOAD_DETAIL = "//td[@data-columnname='PictureUrl']/a[contains(@href,'%s')]/parent::td/following-sibling::td[@data-columnname='DisplayOrder'and text()='%s']/following-sibling::td[@data-columnname='OverrideAltAttribute'and text()='%s']/following-sibling::td[@data-columnname='OverrideTitleAttribute'and text()='%s']";
	
	public static final String SAVE_BUTTON = "//button[@name='save']";
	public static final String DELETE_BUTTON_BY_PRODUCT_TITLE = "//td[@data-columnname='OverrideTitleAttribute' and text()='%s']/following-sibling::td//i[contains(@class,'fa-remove')]";
	
	public static final String PRODUCT_DETAIL="//td/img[contains(@src,'%s')]/parent::td/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/i[contains(@class,'%s-icon')]";
}
