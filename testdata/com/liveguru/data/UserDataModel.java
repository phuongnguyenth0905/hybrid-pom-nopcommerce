package com.liveguru.data;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserDataModel {
	public static UserDataModel getValue(String filename) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(filename), UserDataModel.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@JsonProperty("firstname")
	private String firstname;

	@JsonProperty("lastname")
	private String lastname;

	@JsonProperty("email")
	private String email;

	@JsonProperty("password")
	private String password;

	static class Payment {
		@JsonProperty("cardType")
		private String cadrType;

		@JsonProperty("cardNumber")
		private String cardNumber;

	}
	@JsonProperty("payment")
	Payment payment;
	public String getCardType() {
		return payment.cadrType;
	}
	public String getCardNumber() {
		return payment.cardNumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
