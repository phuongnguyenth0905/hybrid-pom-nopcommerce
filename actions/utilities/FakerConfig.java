package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class FakerConfig {
	private Locale locale=new Locale("en");
	private Faker faker=new Faker(locale);
	public static FakerConfig getFakerData() {
		return new FakerConfig();
	}
	public String getEmailAddress() {
		return faker.internet().emailAddress();
	}
	public String getFirstName() {
		return faker.address().firstName();
	}
	public String getLastName() {
		return faker.address().lastName();
	}
	public String getPassword() {
		return faker.internet().password(8, 10);
	}
	public String getStreetAddress() {
		return faker.address().streetAddress();
	}
	public String getCity() {
		return faker.address().city();
	}
	public String getPhone() {
		return faker.phoneNumber().cellPhone();
	}
	public String getCardNumber() {
		return faker.business().creditCardNumber().replace("-", "");
	}
	
}
