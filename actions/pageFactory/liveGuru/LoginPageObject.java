package pageFactory.liveGuru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LoginPageObject extends AbstractPage {
	WebDriver driver;

	// Hàm khởi tạo(contructor)
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//I-định nghĩa elements
	//cach1 1:
	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailTextbox;
	
	//cách 2:
	@FindBy(how = How.XPATH,using = "//input[@id='Email']")
	WebElement email_Textbox;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement passwordTextbox;
	
	@FindBy(xpath = "//input[@value='Log in']")
	WebElement loginbutton;
	
	//II- Actions
	public void inputToEmailTextbox(String email) {

		waitToElementVisible(driver, emailTextbox);
		senkeyToElement(driver, emailTextbox, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, passwordTextbox);
		senkeyToElement(driver, passwordTextbox, password);
	}

	public void clickToLoginButton() {
		waitToElementClickAble(driver, loginbutton);
		clickToElement(driver, loginbutton);

	}
}
