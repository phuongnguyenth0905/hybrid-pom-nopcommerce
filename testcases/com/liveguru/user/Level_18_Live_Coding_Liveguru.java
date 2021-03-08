package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.AbstractTest;
import pageObjects.liveGuru.PageGeneratorManagerliveGuru;
import pageObjects.liveGuru.UserCheckoutPO;
import pageObjects.liveGuru.UserCompareProductPO;
import pageObjects.liveGuru.UserHomePO;
import pageObjects.liveGuru.UserLoginPO;
import pageObjects.liveGuru.UserMobilePO;
import pageObjects.liveGuru.UserMyAccountInformationPO;
import pageObjects.liveGuru.UserRegisterPO;
import pageObjects.liveGuru.UserTVPO;
import pageObjects.liveGuru.UserMyDashboardPO;

public class Level_18_Live_Coding_Liveguru extends AbstractTest {

	WebDriver driver;
	// tạo bộ DL
	String firtName, lastName, email, password, discountCode, productNameSonyXperia, today, productPriceSonyXperia, subTotalPrice, discountPrice, flatRate, grandTotal;
	String country, state, zipCode, adress, city, phone, cardName, cardType, cardNumber, cardMonth, cardYear, cardCVV;
	String productNameIphone, productPriceIphone, productImageSonyXperia, productImageIphone, productSKUSonyXperia, productSKUIphone;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {

		driver = getBrowserDriver(browserName, url);

		firtName = "Hoang Anh";
		lastName = "Nam";
		// email = "namhoang" + getRandomNumber() + "@gmail.com";
		email = "namhoang2074@gmail.com";
		password = "123456";
		discountCode = "GURU50";
		productNameSonyXperia = "Sony Xperia";
		productNameIphone = "IPhone";

		productPriceIphone = "$500.00";
		productPriceSonyXperia = "$100.00";
		subTotalPrice = "$100.00";
		discountPrice = "-$5.00";
		flatRate = "$0.00";
		grandTotal = "$95.00";
		today = getToday();
		country = "Switzerland";
		state = "Bern";

		zipCode = "625632";
		adress = "Via Pestariso 66";
		city = "Bystryanka";
		phone = "640-653-3587";
		cardName = firtName + "" + lastName;
		cardType = "Visa";
		cardNumber = "4674449087015869";
		cardMonth = "02 - February";
		cardYear = "2024";
		cardCVV = "548";

		productImageSonyXperia = "xperia.jpg";
		productImageIphone = "iphone.png";
		productSKUSonyXperia = "MOB001";
		productSKUIphone = "MOB0002";
	}

	// @Test
	public void TC_01_Register_To_System() {
		log.info("Register - Step 01 : Open Home Page");
		homePage = PageGeneratorManagerliveGuru.getUserHomePage(driver);

		log.info("Register - Step 02 : Click To My Account Link at Home Page");
		loginPage = homePage.clickToMyAccountLink();

		// Từ login click Register button mới chuyển qua trang Register
		log.info("Register - Step 03 : Click To Create An Account Button");
		registerPage = loginPage.clickToCreateAnAccountButton();

		log.info("Register - Step 04 : Input To First Name textbox with value: " + firtName);
		registerPage.inputToFirstNameTextbox(firtName);

		log.info("Register - Step 05 : Input To Last Name textbox with value: " + lastName);
		registerPage.inputToLastNameTextbox(lastName);

		log.info("Register - Step 06 : Input To Email textbox with value: " + email);
		registerPage.inputToEmailTexbox(email);

		log.info("Register - Step 07 : Input To Password textbox with value: " + password);
		registerPage.inputToPasswordTexbox(password);
		registerPage.inputToConfirmPasswordTexbox(password);

		log.info("Register - Step 08 : Click to Register Button at Register Page");
		registerPage.clickToRegisterButton();

		log.info("Register - Step 09 : Verify success message displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");

		log.info("Register - Step 10 : Click To Logout Link and navigate to home page");
		// homePage=myDashboardPage.openProductPage();
		homePage = registerPage.clickHeadAcountLink();
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void TC_02_Login_To_System() {
		log.info("Register - Step 01 : Open Home Page");
		homePage = PageGeneratorManagerliveGuru.getUserHomePage(driver);
		//
		log.info("Login - Step 01 : Click To My Account Link");
		loginPage = homePage.clickToMyAccountLink();

		log.info("Login - Step 02 : Input To Email textbox with value: " + email);
		loginPage.inputToEmailTextbox(email);

		log.info("Login - Step 03 : Input To Password textbox with value: " + password);
		loginPage.inputToPasswordTextbox(password);

		log.info("Login - Step 04 : Click To Login Button");
		myDashboardPage = loginPage.clickToLoginButton();

		log.info("Login - Step 05 : Verify Login Link");
		verifyTrue(myDashboardPage.isMyDashboardPageHeaderDisplayed());
	}

	@Test
	public void TC_03_Account_Information() {
		log.info("Account_Infor - Step 01: Open My Account Information Page");
		myAccountInformationPage = myDashboardPage.clickToMyAccountInformationLink();

		log.info("Account_Infor - Step 02: Vefify Firstname value is correct");
		verifyEquals(myAccountInformationPage.getFirstnameTextboxValue(), firtName);

		log.info("Account_Infor - Step 03: Vefify Lastname value is correct");
		verifyEquals(myAccountInformationPage.getLastnameTextboxValue(), lastName);

		log.info("Account_Infor - Step 04: Vefify Email value is correct");
		verifyEquals(myAccountInformationPage.getEmailTextboxValue(), email);
	}

	@Test
	public void TC_04_Product_Price() {
		log.info("TC_04_Product_Price - Step 01: Open Mobile Page");
		mobilePage = myAccountInformationPage.openMobilePage(driver);

		log.info("TC_04_Product_Price - Step 02: Store Product Price at list page");
		String sonyXperiaPrice = mobilePage.getProdcutPriceAtListPage();

		log.info("TC_04_Product_Price - Step 03: Click to Sony Xperia product name");
		mobilePage.clickToSonyXperiaProductName();

		log.info("TC_04_Product_Price - Step 04: Verify Product in detail equal Product Price at list page");
		verifyEquals(sonyXperiaPrice, mobilePage.getProductPriceAtDetailPage());
	}

	// @Test
	public void TC_05_Discount_Code() {
		log.info("TC_05_Discount_Code - Step 01: Open Mobile Page");
		mobilePage.openMobilePage(driver);

		log.info("TC_05_Discount_Code - Step 02: Add '" + productNameSonyXperia + "' to Cart");
		checkoutPage = mobilePage.clickAddToCardButtonAProductName(driver, productNameSonyXperia);

		log.info("TC_05_Discount_Code - Step 03: Verify " + productNameSonyXperia + "' was added to your shopping cart.' Mesage Displayed");
		verifyEquals(checkoutPage.getSuccessMessage(driver), productNameSonyXperia + " was added to your shopping cart.");

		log.info("TC_05_Discount_Code - Step 04: Verify Grand Total before apply discount code");
		verifyEquals(checkoutPage.getPriceAtShoppingCartTable(driver, "Grand Total"), "$100.00");

		log.info("TC_05_Discount_Code - Step 05: Input '" + discountCode + "' to Discount code textbox");
		checkoutPage.inputDiscountValueToDiscountTexbox(discountCode);

		log.info("TC_05_Discount_Code - Step 06:Click Apply button ");
		checkoutPage.clickToApplyButton();

		log.info("TC_05_Discount_Code - Step 07:Verify Counpon Code '" + discountCode + "' applied success ");
		verifyEquals(checkoutPage.getSuccessMessage(driver), "Coupon code \"" + discountCode + "\" was applied.");

		log.info("TC_05_Discount_Code - Step 08: Verify Subtotal displayed in Total price");
		verifyEquals(checkoutPage.getPriceAtShoppingCartTable(driver, "Subtotal"), "$100.00");

		log.info("TC_05_Discount_Code - Step 09: Verify Discount text displayed in Total price");
		verifyEquals(checkoutPage.getPriceAtShoppingCartTable(driver, "Discount (" + discountCode + ")"), "-$5.00");

		log.info("TC_05_Discount_Code - Step 10: Verify Grand Total after apply discount code");
		verifyEquals(checkoutPage.getPriceAtShoppingCartTable(driver, "Grand Total"), "$95.00");

//		log.info("TC_05_Discount_Code - Step 11: Remove Item Product");
//		checkoutPage.removeItemProduct();
	}

	// @Test
	public void TC_06_Add_Quantity() {
		log.info("TC_06_Add_Quantity - Step 01: Input value to QTY textbox at " + productNameSonyXperia);
		checkoutPage.inputToQTYTexboxByProductName(productNameSonyXperia, "600");

		log.info("TC_06_Add_Quantity - Step 02: Click Update button at " + productNameSonyXperia);
		checkoutPage.clickToUpdateButtonProductName(productNameSonyXperia);

		log.info("TC_06_Add_Quantity - Step 03: Verify error message 'Some of the products cannot be ordered in requested quantity.'");
		verifyEquals(checkoutPage.getErrorMessage(driver), "Some of the products cannot be ordered in requested quantity.");

		log.info("TC_06_Add_Quantity - Step 04: Verify error message '* The maximum quantity allowed for purchase is 500.'");
		verifyEquals(checkoutPage.getMaximumQuantityErrorMessageAtProductName(productNameSonyXperia), "* The maximum quantity allowed for purchase is 500.");

		log.info("TC_06_Add_Quantity - Step 05: Input value to QTY textbox at " + productNameSonyXperia);
		checkoutPage.inputToQTYTexboxByProductName(productNameSonyXperia, "1");

		log.info("TC_06_Add_Quantity - Step 06: Click Update button at " + productNameSonyXperia);
		checkoutPage.clickToUpdateButtonProductName(productNameSonyXperia);
	}

	@Test
	public void TC_07_Compare_Product() {
		log.info("TC_07_Compare_Product - Step 01: Open Mobile Page");
		mobilePage.openMobilePage(driver);

		log.info("TC_07_Compare_Product - Step 02: Click 'Add to Compare' link Sony Xperia");
		mobilePage.clickAddToCompareName(driver, productNameSonyXperia);

		log.info("TC_07_Compare_Product - Step 03: Verify displayed 'The product " + productNameSonyXperia + " has been added to comparison list.'");
		verifyEquals(mobilePage.getSuccessMessage(driver), "The product " + productNameSonyXperia + " has been added to comparison list.");

		log.info("TC_07_Compare_Product - Step 04: Click 'Add to Compare' link IPhone");
		mobilePage.clickAddToCompareName(driver, productNameIphone);

		log.info("TC_07_Compare_Product - Step 05: Verify displayed 'The product " + productNameIphone + " has been added to comparison list.'");
		verifyEquals(mobilePage.getSuccessMessage(driver), "The product " + productNameIphone + " has been added to comparison list.");
		System.out.println(driver.getWindowHandle());
		log.info("TC_07_Compare_Product - Step 06: Click on 'Compare' button");
		CompareProductPage = mobilePage.clickCompareButton();
		System.out.println(driver.getWindowHandle());

		log.info("TC_07_Compare_Product - Step 07: Verify " + productNameSonyXperia + " product are reflected in it heading 'COMPARE PRODUCTS'");
		verifyTrue(CompareProductPage.isCompareProductWithProductInIt(productImageSonyXperia, productNameSonyXperia, productPriceSonyXperia, productSKUSonyXperia));

		log.info("TC_07_Compare_Product - Step 08: Verify " + productNameIphone + " product are reflected in it heading 'COMPARE PRODUCTS' ");
		verifyTrue(CompareProductPage.isCompareProductWithProductInIt(productImageIphone, productNameIphone, productPriceIphone, productSKUIphone));

		log.info("TC_07_Compare_Product - Step 09: Close the Popup Windowns");
		CompareProductPage.clickClosePopupWindownsCompareProduct();
		
	}

	@Test
	public void TC_08_Share_Wishlist() {

		log.info("TC_08_Share_Wishlist - Step 01: Go to TV menu page");
		tvPage = mobilePage.openTVPage(driver);
		
		log.info("TC_08_Share_Wishlist - Step 02: Add 'LG LCD' product in wishlist");
		

		log.info("TC_08_Share_Wishlist - Step 03: Click button 'Share Wishlist'");

		// LG LCD has been added to your wishlist. Click here to continue shopping.
		log.info("TC_08_Share_Wishlist - Step 04: Verify Message 'LG LCD has been added to your wishlist. Click here to continue shopping.'displayed");

		log.info("TC_08_Share_Wishlist - Step 05: enter email and a message");

		log.info("TC_08_Share_Wishlist - Step 06: Verify massege 'Your Wishlist has been shared.' displayed");

		log.info("TC_08_Share_Wishlist - Step 07: click 'Share Wishlist' button");

		log.info("TC_08_Share_Wishlist - Step 08: verify page 'My Wishlist' have 1 item 'LG LCD'");

	}

	@Test
	public void TC_09_Add_Review() {

	}

	//@Test
	public void TC_10_Order_Product() {
		log.info("TC_10_Order_Product - Step 01: Select value in Country dropdown");
		checkoutPage.selectValueInCountryDropdownAtShoppingCart(country);

		log.info("TC_10_Order_Product - Step 02: Select value in State dropdown");
		checkoutPage.selectValueInStateDropdownAtShoppingCart(state);

		log.info("TC_10_Order_Product - Step 03: Input value to Zip code textbox");
		checkoutPage.inputToZipCodeTextboxAtShoppingCart(zipCode);

		log.info("TC_10_Order_Product - Step 04: Click to Estimate button");
		checkoutPage.clickToEstimateButton();

		log.info("TC_10_Order_Product - Step 05: Verify Flat Rate is $00.00");
		verifyEquals(checkoutPage.getFlateRateValue(), flatRate);

		log.info("TC_10_Order_Product - Step 06: Click to Flat Rate radio button");
		checkoutPage.clickToFlateRateRadio();

		log.info("TC_10_Order_Product - Step 07: Click to update Total button");
		checkoutPage.clickToUpdateTotalButton();

		log.info("TC_10_Order_Product - Step 08: Verify subtotal displayed in Total price ");
		verifyEquals(checkoutPage.getPriceAtShoppingCartTable(driver, "Subtotal"), subTotalPrice);

		log.info("TC_10_Order_Product - Step 09: Verify Discount text displayed in Total price");
		verifyEquals(checkoutPage.getPriceAtShoppingCartTable(driver, "Discount (" + discountCode + ")"), discountPrice);

		log.info("TC_10_Order_Product - Step 10: Verify Flat Rate displayed in Total price");
		verifyEquals(checkoutPage.getPriceAtShoppingCartTable(driver, "Shipping & Handling (Flat Rate - Fixed)"), flatRate);

		log.info("TC_10_Order_Product - Step 11: Verify Grand Total after apply discount code");
		verifyEquals(checkoutPage.getPriceAtShoppingCartTable(driver, "Grand Total"), grandTotal);

		log.info("TC_10_Order_Product - Step 12: Click Proceed to checkout button");
		checkoutPage.clickToProceedCheckoutButton();

		log.info("TC_10_Order_Product - Step 13: Input to Adress textbox at Billing form");
		checkoutPage.inputToAddressTextboxAtBillingForm(adress);

		log.info("TC_10_Order_Product - Step 14: Input to City textbox Billing form");
		checkoutPage.inputToCityTextboxAtBillingForm(city);

		log.info("TC_10_Order_Product - Step 17: Select value in Country dropdown Billing form");
		checkoutPage.selectValueInCountryDropdownAtBillingForm(country);

		log.info("TC_10_Order_Product - Step 15: Select value in State dropdown Billing form");
		checkoutPage.selectValueInStateDropdownAtBillingForm(state);

		log.info("TC_10_Order_Product - Step 16: Input value to Zip Code textbox Billing form");
		checkoutPage.inputToZipCodeTextboxAtBillingForm(zipCode);

		log.info("TC_10_Order_Product - Step 18: Input value to Phone textbox Billing form");
		checkoutPage.inputToPhoneTextbox(phone);

		log.info("TC_10_Order_Product - Step 19: Click to Continue At Billing Information title");
		checkoutPage.clickToContinueButtonByTitleName("Billing Information");

		log.info("TC_10_Order_Product - Step 20: Verify Flat Rate is : " + flatRate);
		verifyEquals(checkoutPage.getFlateRateValue(), flatRate);

		log.info("TC_10_Order_Product - Step 21: Click To Continue at Shipping Method title");
		checkoutPage.clickToContinueButtonByTitleName("Shipping Method");

		log.info("TC_10_Order_Product - Step 22: Click to Credit Card radio button");
		checkoutPage.clickToCreaditCardRadio();

		log.info("TC_10_Order_Product - Step 23: Input to Card Name textbox");
		checkoutPage.inputToCardNameTextbox(cardName);

		log.info("TC_10_Order_Product - Step 24: Select to Card Type dropdown");
		checkoutPage.selectToCartTypeDropdown(cardType);

		log.info("TC_10_Order_Product - Step 25: Input to Card Number textbox");
		checkoutPage.inputToCardNumberTextbox(cardNumber);

		log.info("TC_10_Order_Product - Step 26: Select to Month Expiration Date dropdown");
		checkoutPage.selectToMonthExpiretionDropdown(cardMonth);

		log.info("TC_10_Order_Product - Step 27: Select to Year Expiration Date dropdown");
		checkoutPage.selectToYearExpiretionDropdown(cardYear);

		log.info("TC_10_Order_Product - Step 28: Input to Card Verification Number textbox");
		checkoutPage.inputToCardVerificationNumberTextbox(cardCVV);

		log.info("TC_10_Order_Product - Step 29: Click to Continue at Payment Information title");
		checkoutPage.clickToContinueButtonByTitleName("Payment Information");

		log.info("TC_10_Order_Product - Step 30: Verify Prpduct/Price/QTY/Subtotal are displayed");
		verifyTrue(checkoutPage.isProductInformationDisplayed(productNameSonyXperia, productPriceSonyXperia, "1", subTotalPrice));

		log.info("TC_10_Order_Product - Step 31: Verify Subtotal displayed in Checkout table");
		verifyEquals(checkoutPage.getPriceAtShoppingCartTable(driver, "Subtotal"), subTotalPrice);

		log.info("TC_10_Order_Product - Step 32: Verify discount text displayed in Checkout table");
		verifyEquals(checkoutPage.getPriceAtShoppingCartTable(driver, "Discount (" + discountCode + ")"), discountPrice);

		log.info("TC_10_Order_Product - Step 33: Verify Flat Rate displayed in Checkoout table");
		verifyEquals(checkoutPage.getPriceAtShoppingCartTable(driver, "Shipping & Handling (Flat Rate - Fixed)"), flatRate);

		log.info("TC_10_Order_Product - Step 34: Verify Grand Total displayed in Checkout table");
		verifyEquals(checkoutPage.getPriceAtShoppingCartTable(driver, "Grand Total"), grandTotal);

		log.info("TC_10_Order_Product - Step 35: Click Place Order button");
		checkoutPage.clickToPlaceOrderButton();

		log.info("TC_10_Order_Product - Step 36: Verify Success Message displayed with value 'Your order has been received.'");
		verifyTrue(checkoutPage.isProductOrderSuccessMessageDisplayed("Your order has been received."));

		log.info("TC_10_Order_Product - Step 37: Verify Success Message displayed with value 'Thank you for your purchase!'");
		verifyTrue(checkoutPage.isProductOrderSuccessMessageDisplayed("Thank you for your purchase!"));

		log.info("TC_10_Order_Product - Step 38: Get Order ID");
		String orderID = checkoutPage.getOrderID();

		log.info("TC_10_Order_Product - Step 39: Click to My Account link in footer");
		checkoutPage.openFooterByName(driver, "My Account");
		myDashboardPage = PageGeneratorManagerliveGuru.getMyDasboardPage(driver);

		log.info("TC_10_Order_Product - Step 40: Verify Order Information displayed ");
		verifyTrue(myDashboardPage.isOrderInformationDisplayed(orderID, today, firtName + "" + lastName, grandTotal, "Pending"));
	}

	@Test
	public void TC_11_Search_Product() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
	UserMyDashboardPO myDashboardPage;
	UserMyAccountInformationPO myAccountInformationPage;
	UserMobilePO mobilePage;
	UserCheckoutPO checkoutPage;
	UserCompareProductPO CompareProductPage;
	UserTVPO tvPage;

}