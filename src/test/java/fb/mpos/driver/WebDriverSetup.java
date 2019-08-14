/*
'################################################################################################
'Class Name			   : Driver
'Description           : Driver
'Author                : Pranali Dharme
'Date Created          : 07/03/2018
'################################################################################################
'            Change History
'Date Changed:        Name:                Reason:
'================================================================================================
'         
'================================================================================================
 */

package fb.mpos.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import fb.mpos.utility.PropertyFileReader;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSetup {

	private static WebDriverSetup instance;
	private PropertyFileReader prop;
	private WebDriver webDriver;

	private WebDriverSetup() throws IOException {
		prop = new PropertyFileReader();

		if (prop.getProperty("browser").equals("firefox")) {
			FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
			webDriver = new FirefoxDriver();
			Reporter.log("Running test on Firefox browser");
		} else if (prop.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().version("75");
			ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
			webDriver = new ChromeDriver();
			//			webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			Reporter.log("Running test on chrome browser");
		} else if (prop.getProperty("browser").equals("ie")) {
			DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
			capability.setCapability("ignoreZoomSetting", true);
			// capability.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.introduceFlakinessByIgnoringSecurityDomains();
			options.requireWindowFocus();
			WebDriverManager.iedriver().setup();
			webDriver = new InternetExplorerDriver(options);
			Reporter.log("Running test on IE browser");
		}

		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		webDriver.get(prop.getProperty("fb.cpos.url"));
	}

	public PropertyFileReader getProperty() {
		return this.prop;
	}

	public static WebDriverSetup getInstance() {
		if (instance == null) {
			try {
				instance = new WebDriverSetup();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	public WebDriver getDriver() {
		return this.webDriver;
	}
}
