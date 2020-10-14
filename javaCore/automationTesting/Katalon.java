package automationTesting;

public class Katalon {

	public static void main(String[] args) {
		SeleniumA seleniumCon = new SeleniumA();
		seleniumCon.organization = "Test New KTL";
		System.out.println(seleniumCon.getOrganization());
	}

}
