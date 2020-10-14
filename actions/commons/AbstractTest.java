package commons;

import java.util.Random;

public class AbstractTest {
	protected int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(999);
	}
}
