package basic;

import java.util.Locale;

import com.github.javafaker.Faker;

public class Faker_Basic {

	public static void main(String[] args) {
		Faker fake=new Faker(new Locale("en"));
		
		System.out.println("Basic Personal Infor");
		System.out.println("----------");
		System.out.println("First Name: "+fake.address().firstName());
		System.out.println("Last Name : "+fake.address().lastName());
		System.out.println("full name: "+fake.name().fullName());
		System.out.println("City : "+fake.address().city());
		System.out.println("City Name: "+fake.address().cityName());
		System.out.println("Street Name: "+fake.address().streetName());
		System.out.println("Adress : "+fake.address().streetAddress());
		System.out.println("country: "+fake.address().country());
		System.out.println("Zip code: "+fake.address().countryCode());
		System.out.println("State: "+fake.address().state());
		
		System.out.println("----------");
		System.out.println("Card");
		System.out.println("Card Type: "+fake.business().creditCardType());
		System.out.println("Card Number: "+fake.business().creditCardNumber().replace("-", ""));
		System.out.println("Card Expiry: "+fake.business().creditCardExpiry());
		
		System.out.println("----------");
		System.out.println("Email/Password");
		System.out.println("Email: "+fake.internet().emailAddress());
		System.out.println("IP4: "+fake.internet().ipV4Address());
		System.out.println("IP6: "+fake.internet().ipV6Address());
		System.out.println("Password: "+fake.internet().password(6, 12));
		System.out.println("privateIpV4: "+fake.internet().privateIpV4Address());
		System.out.println("publicIpV4: "+fake.internet().publicIpV4Address());
		System.out.println("Phone: "+fake.phoneNumber().cellPhone());
		

	}

}
