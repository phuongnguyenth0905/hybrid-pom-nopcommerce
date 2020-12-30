package pageUI.liveGuru;

public class UserCheckoutPageUI {
	public static final String DISCOUNT_CODE_TEXTBOX = "//input[@id='coupon_code']";
	public static final String APPLY_BUTTON = "//button[@title='Apply']";
	public static final String REMOVE_ITEM_PRODUCT_LINK = "//td[@class='a-center product-cart-remove last']/a[text()='Remove Item']";
	public static final String QTY_TEXTBOX_BY_PRODUCT_NAME = "//a[text()='%s']/ancestor::td[@class='product-cart-info']/following-sibling::td[@class='product-cart-actions']/input";
	public static final String UPDATE_BUTTON_BY_PRODUCT_NAME = "//a[text()='%s']/ancestor::td[@class='product-cart-info']/following-sibling::td[@class='product-cart-actions']/button[@title='Update']";
	public static final String QUANTITY_MAXIMUM_MESSAGE_BY_PRODUCT_NAME = "//a[text()='%s']/parent::h2/following-sibling::p[@class='item-msg error']";
	
	public static final String COUNTRY_DROPDOWN_AT_SHOPPING_CART = "//select[@id='country']";
	public static final String STATE_DROPDOWN_AT_SHOPPING_CART = "//select[@id='region_id']";
	public static final String ZIP_CODE_TEXTBOX_AT_SHOPPING_CAT = "//input[@id='postcode']";
	public static final String ESTIMATE_BUTTON = "//button[@title='Estimate']";
	public static final String FLAT_RATE_TEXT = "//label[contains(string(),'Fixed')]/span";
	public static final String FLAT_RATE_RADIO_BUTTON = "//input[@name='estimate_method']";
	public static final String UPDATE_TOTAL_BUTTON = "//button[@title='Update total']";
	public static final String PROCEED_CHECKOUT_BUTTON = "//button[@title='Proceed to Checkout']";
	public static final String ADDRESS_TEXTBOX_AT_BILLING_FORM = "//input[@id='billing:street1']";
	public static final String CITY_TEXTBOX_AT_BILLING_FORM ="//input[@id='billing:city']";
	public static final String COUNTRY_DROPDOWN_AT_BILLING_FORM = "//select[@id='billing:country_id']";
	public static final String STATE_DROPDOWN_AT_BILLING_FORM = "//input[@id='billing:region']";
	public static final String ZIP_CODE_TEXTBOX_AT_BILLING_FORM = "//input[@id='billing:postcode']";
	public static final String PHONE_TEXTBOX_AT_BILLING_FORM = "//input[@id='billing:telephone']";
	public static final String CONTIUNE_BUTTON_BY_TITLE_NAME = "//h2[text()='%s']/parent::div/following-sibling::div//button[@title='Continue']";
	public static final String CREDIT_CART_RADIO_BUTTON = "//input[@id='p_method_ccsave']";
	public static final String CARD_NAME_TEXTBOX = "//input[@id='ccsave_cc_owner']";
	public static final String CARD_TYPE_TEXTBOX = "//select[@id='ccsave_cc_type']";
	public static final String CARD_NUMBER_TEXTBOX = "//input[@id='ccsave_cc_number']";
	public static final String MONTH_EXPIRATION_DROPDOWN = "//select[@id='ccsave_expiration']";
	public static final String YEAR_EXPIRATION_DROPDOWN = "//select[@id='ccsave_expiration_yr']";
	public static final String CARD_VERIFICATION_NUMBER_TEXTBOX = "//input[@id='ccsave_cc_cid']";
	public static final String PRODUCT_DETAIL_BY_NAME_PRICE_QTY_SUBTOTAL = "//h3[text()='%s']/parent::td/following-sibling::td[@data-rwd-label='Price']//span[@class='price' and text()='%s']/ancestor::td/following-sibling::td[@data-rwd-label='Qty' and text()='%s']/following-sibling::td[@data-rwd-label='Subtotal']//span[@class='price' and text()='%s']";
	public static final String PLACE_ORDER_BUTTON = "//button[@title='Place Order']";
	public static final String PRODUCT_ORDER_SUCCESS_BY_MESSAGE_NAME = "(//h1|//h2)[text()='%s']";
	public static final String ORDER_ID = "//p[contains(string(),'Your order # is:')]/a";

}
