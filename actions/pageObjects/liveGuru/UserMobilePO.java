package pageObjects.liveGuru;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import jdbcConnection.SQLJTDSConnUtils;
import pageUI.liveGuru.UserHomePageUI;
import pageUI.liveGuru.UserMobilePageUI;

public class UserMobilePO extends AbstractPage {
	WebDriver driver;

	public UserMobilePO(WebDriver driver) {
		this.driver = driver;
	}

	public String getProdcutPriceAtListPage() {
		waitToElementVisible(driver, UserMobilePageUI.SONY_XPERIA_PRICE_BY_PRODUCT_NAME_AT_LIST);
		return getElementText(driver, UserMobilePageUI.SONY_XPERIA_PRICE_BY_PRODUCT_NAME_AT_LIST);
	}

	public void clickToSonyXperiaProductName() {
		waitToElementClickAble(driver, UserMobilePageUI.SONY_XPERIA_PRODUCT_NAME);
		clickToElement(driver, UserMobilePageUI.SONY_XPERIA_PRODUCT_NAME);
	}

	public String getProductPriceAtDetailPage() {
		waitToElementVisible(driver, UserMobilePageUI.SONY_XPERIA_PRICE_BY_PRODUCT_NAME_AT_DETAIL);
		return getElementText(driver, UserMobilePageUI.SONY_XPERIA_PRICE_BY_PRODUCT_NAME_AT_DETAIL);
	}

	public UserCompareProductPO clickCompareButton() {
		waitToElementClickAble(driver, UserMobilePageUI.COMPARE_TO_BUTTON);
		clickToElement(driver, UserMobilePageUI.COMPARE_TO_BUTTON);
		switchToWindowByTitle(driver, UserMobilePageUI.TITLE_COMPARE_PRODUCTS);
		return PageGeneratorManagerliveGuru.getCompareProductPage(driver);
	}

	public int getProductMobileNumberOnUI() {
		waitToElementVisible(driver, UserMobilePageUI.PRODUCT_NAME_NUMBER);
		return countElementSize(driver, UserMobilePageUI.PRODUCT_NAME_NUMBER);
	}

	public int getProductMobileNumberInDB()  {
		ArrayList<String> listProduct=new ArrayList<>();
		Connection conn=null;
		try {
			 conn=SQLJTDSConnUtils.getSQLServerConnection();
			String querySql="SELECT*FROM [autotest].[dbo].[PRODUCT]";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(querySql);
			while(result.next()) {
				listProduct.add(result.getString("NAME"));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listProduct.size();
	}

}
