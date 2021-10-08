package commons;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	protected final Log log;
	
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	
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
		
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
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
	
	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return this.driver;
	}
	
	@BeforeSuite
	public void deleteAllFilesInReportNGScreenshot() {
		System.out.println("---------- START delete file in folder ----------");
		deleteAllFileInFolder();
		System.out.println("---------- END delete file in folder ----------");
	}

	public void deleteAllFileInFolder() {
		try {
			String workingDir = System.getProperty("user.dir");
			String pathFolderDownload = workingDir + "/ReportNGScreenShots";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					System.out.println(listOfFiles[i].getName());
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
}
