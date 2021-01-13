package pageUI.liveGuru;

public class UserMyDashboardPageUI {
	public static final String 	WELCOME_MESSAGE_TEXT = "//li[@class='success-msg']//span";
	public static final String MANAGE_ADDRESS_LINK= "//a[text()='Manage Addresses']";
	public static final String HEAD_ACCOUNT_LINK= "//header[@id='header']//span[text()='Account']";
	public static final String LOGOUT_LINK= "//a[contains(text(),'Log Out')]";
	
	public static final String MY_DASHBOARD_HEADER= "//div[@class='page-title']/h1[text()='My Dashboard']";
	public static final String MY_ACCOUNT_INFORMATION= "//a[text()='Account Information']";
	
	public static final String ORDER_DETAIL_BY_ID_DATE_NAME_PRICE_STATUS = "//td[@class='number' and text()='%s']/following-sibling::td[@class='date' and string()='%s']/following-sibling::td[@class='ship' and string()='%s']/following-sibling::td[@class='total' and string()='%s']/following-sibling::td[@class='status' and string()='%s']";

}
