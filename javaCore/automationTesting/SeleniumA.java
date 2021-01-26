package automationTesting;

public class SeleniumA {
	// thuộc tính
	private String name = "Selenium Webdriver";

	// default
	String organization = "Selenium HQ";

	// protected
	protected String sponsor = "Spon Test Selenium";

	// phương thức
	private String getName() {
		return name;
	}

	private void setName(String nameNew) {
		this.name = nameNew;
	}

	String getOrganization() {
		return this.organization;
	}

	String getSponsor() {
		return this.sponsor;
	}

	public static void main(String[] args) {
		SeleniumA selenium = new SeleniumA();

		// private
		System.out.println(selenium.name);
		System.out.println(selenium.getName());
		selenium.setName("Hello Selenium");

		// default
		System.out.println(selenium.organization);
		System.out.println(selenium.getOrganization());

		//protected
		System.out.println(selenium.sponsor);
		System.out.println(selenium.getSponsor());

	}
}
