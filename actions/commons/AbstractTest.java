package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.Collections;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {

	private WebDriver driver;
	private String projectFolder = System.getProperty("user.dir");
	private String osName = System.getProperty("os.name");

	protected WebDriver getBrowserDriver(String browserName) {
		///setBrowserDriver();
		if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			// System.setProperty("webdriver.chrome.driver", projectFolder + "\\browserDriver\\chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("useAutomationExtension", false);
			chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			driver = new ChromeDriver(chromeOptions);
		} else if (browserName.equals("firefox_headless")) {
			WebDriverManager.firefoxdriver().setup();
			// System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
			FirefoxOptions ffOptions = new FirefoxOptions();
			ffOptions.setHeadless(true);
			driver = new FirefoxDriver(ffOptions);
		} else if (browserName.equals("chrome_headless")) {
			WebDriverManager.chromedriver().setup();
			// System.setProperty("webdriver.chrome.driver", projectFolder + "\\browserDriver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("edge_chromium")) {
			WebDriverManager.edgedriver().setup();
			// System.setProperty("webdriver.edge.driver", projectFolder + "\\browserDriver\\msedgedriver.exe");
			driver = new EdgeDriver();
		} 
		else if (browserName.equals("safari")) {
			
			driver=new SafariDriver();
		}
		else if (browserName.equals("ie")) {
			WebDriverManager.iedriver().arch32().setup();
			driver=new InternetExplorerDriver();
		}else {
			throw new RuntimeException("Please input valid browser name value ! ");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com");
		
		return driver;
	}
	protected WebDriver getBrowserDriver(String browserName ,String url) {
		///setBrowserDriver();
		if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			// System.setProperty("webdriver.chrome.driver", projectFolder + "\\browserDriver\\chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("useAutomationExtension", false);
			chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			driver = new ChromeDriver(chromeOptions);
		} else if (browserName.equals("firefox_headless")) {
			WebDriverManager.firefoxdriver().setup();
			// System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
			FirefoxOptions ffOptions = new FirefoxOptions();
			ffOptions.setHeadless(true);
			driver = new FirefoxDriver(ffOptions);
		} else if (browserName.equals("chrome_headless")) {
			WebDriverManager.chromedriver().setup();
			// System.setProperty("webdriver.chrome.driver", projectFolder + "\\browserDriver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("edge_chromium")) {
			WebDriverManager.edgedriver().setup();
			// System.setProperty("webdriver.edge.driver", projectFolder + "\\browserDriver\\msedgedriver.exe");
			driver = new EdgeDriver();
		} 
		else if (browserName.equals("safari")) {
			
			driver=new SafariDriver();
		}
		else if (browserName.equals("ie")) {
			WebDriverManager.iedriver().arch32().setup();
			driver=new InternetExplorerDriver();
		}else {
			throw new RuntimeException("Please input valid browser name value ! ");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	protected int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(999);

	}

	// Webdriver Manager
	private void setBrowserDriver() {
		if (isWindows()) {
			System.setProperty("webdriver.chrome.driver", projectFolder + getDirectorySlash("browserDriver") + "chromedriver.exe");
			System.setProperty("webdriver.gecko.driver", projectFolder + getDirectorySlash("browserDriver") + "geckodriver.exe");
			System.setProperty("webdriver.edge.driver", projectFolder + getDirectorySlash("browserDriver") + "msedgedriver.exe");
		} else if (isMac()) {
			System.setProperty("webdriver.chrome.driver", projectFolder + getDirectorySlash("browserDriver") + "chromedriver_mac");
			System.setProperty("webdriver.gecko.driver", projectFolder + getDirectorySlash("browserDriver") + "geckodriver_mac");
			System.setProperty("webdriver.edge.driver", projectFolder + getDirectorySlash("browserDriver") + "msedgedriver_mac");
		} else {
			System.setProperty("webdriver.chrome.driver", projectFolder + getDirectorySlash("browserDriver") + "chromedriver_linux");
			System.setProperty("webdriver.gecko.driver", projectFolder + getDirectorySlash("browserDriver") + "geckodriver_linux");
		}
	}

	// Webdriver Manager
	private String getDirectorySlash(String folderName) {
		if (isMac() || isUnix() || isSolaris()) {
			folderName = "/" + folderName + "/";
		} else {
			folderName = "\\" + folderName + "\\";
		}
		return folderName;
	}

	private boolean isWindows() {
		return (osName.toLowerCase().indexOf("win") >= 0);
	}

	private boolean isMac() {
		return (osName.toLowerCase().indexOf("mac") >= 0);
	}

	private boolean isUnix() {
		return (osName.toLowerCase().indexOf("nix") >= 0 || osName.toLowerCase().indexOf("nux") >= 0 || osName.toLowerCase().indexOf("aix") > 0);
	}

	public boolean isSolaris() {
		return (osName.toLowerCase().indexOf("sunos") >= 0);
	}
}
