package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	String separator = System.getProperty("file.separator");
	String osName = System.getProperty("os.name");
	
	private enum BROWSER {
		CHROME, FIREFOX, EDGE_CHROME, EDGE_LEGACY, CHEADLESS, FHEADLESS
	}
	
	//Note. GetBrowserDriver có thể coi như một thể hiện của Factory Pattern 
	//Việc sử dụng getBrowserDriver kết hợp getDriverPath cho phép chạy ứng dụng trên nhiều trình duyệt và 
	//nhiều hệ điều hành khác nhau.
	//Tuy nhiên cách làm này có thể vẫn vướng một vấn đề về version của trình duyệt 
	//Nếu version của trình duyệt thay đổi thường xuyên, tương ứng sẽ là các driver cần thay đổi 
	//Như vậy vẫn phải download manual các driver này về. Giải pháp là dùng webDriverManager.
	//Check function getMultiBrowser
	protected WebDriver getBrowserDriver(String browser, String appUrl) throws Exception {
		System.out.println("osName:" + osName);
		if (browser.equalsIgnoreCase(BROWSER.FIREFOX.toString())) {
			System.setProperty("webdriver.gecko.driver", getDriverPath(browser));
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase(BROWSER.CHROME.toString())) {
			System.setProperty("webdriver.chrome.driver", getDriverPath(browser));
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase(BROWSER.EDGE_CHROME.toString())) {
			System.setProperty("webdriver.edge.driver", getDriverPath(browser));
			driver = new EdgeDriver();
		}
		else {
			throw new Exception("Please enter correct browsername");
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		
		return driver;
	}
	
	protected WebDriver getMultiBrowser(String browser, String appUrl) throws Exception {
		if (browser.equalsIgnoreCase(BROWSER.FIREFOX.toString())) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase(BROWSER.CHROME.toString())) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase(BROWSER.EDGE_CHROME.toString())) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			throw new Exception("Please enter correct browsername");
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		
		return driver;
	}
	
	private String getDriverPath(String browserName) {
		String driverName = "";
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		Boolean isMacOS = osName.toLowerCase().contains("mac");
		
		if (browser == BROWSER.FIREFOX) {
			driverName = isMacOS ? "geckodriver" : "geckodriver.exe";
		}
		else if (browser == BROWSER.CHROME) {
			driverName = isMacOS ? "chromedriver" : "chromedriver.exe";
		}
		else if (browser == BROWSER.EDGE_CHROME) {
			driverName = isMacOS ? "msedgedriver" : "msedgedriver.exe";
		}
		
		return String.format("%s%sbrowserDrivers%s%s", projectLocation, separator, separator, driverName);
	}
	
}
