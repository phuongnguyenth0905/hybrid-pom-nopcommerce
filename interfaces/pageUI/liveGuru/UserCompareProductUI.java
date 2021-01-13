package pageUI.liveGuru;

public class UserCompareProductUI {
	//////img[contains(@src,'iphone.png')]/parent::a/following-sibling::h2[contains(.,'IPhone')]/following-sibling::div[contains(string(),'$500.00')]//ancestor::tbody/following-sibling::tbody/descendant::div[contains(.,'MOB0002')]
	public static final String COMPARE_PRODUCT="//img[contains(@src,'%s')]/parent::a/following-sibling::h2[contains(.,'%s')]/following-sibling::div[contains(string(),'%s')]//ancestor::tbody/following-sibling::tbody/descendant::div[contains(.,'%s')]";
	public static final String SKU_COMPARE_PRODUCT="//div[contains(text(),'%s')]";
	public static final String CLOSE_COMPARE_PRODUCT_BUTTON="//button[@title='Close Window']";
	public static final String TITLE_MOBILE_PAGE="//title[contains(text(),'Mobile')]";
}
