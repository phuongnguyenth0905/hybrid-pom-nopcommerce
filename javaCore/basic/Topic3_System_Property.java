package basic;

public class Topic3_System_Property {

	public static void main(String[] args) {
		String osNameString = System.getProperty("os.name");
		String projectFolder = System.getProperty("user.dir");

		System.out.println(osNameString);
		System.out.println(projectFolder);
	}

}
