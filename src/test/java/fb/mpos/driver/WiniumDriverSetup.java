/*
'################################################################################################
'Class Name			   : WiniumDriverSetup
'Description           : WiniumDriverSetup
'Author                : Pranali Dharme
'Date Created          : 6/25/2019
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
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class WiniumDriverSetup {

	private static WiniumDriverSetup instance;
	private WiniumDriver driver;

	private WiniumDriverSetup() throws IOException {

		/*try {

			DesktopOptions option = new DesktopOptions();

			Runtime.getRuntime()
					.exec("C:\\Users\\p.prakash.dharme\\Downloads\\Winium.Desktop.Driver\\Winium.Desktop.Driver.exe");

			option.setApplicationPath(
					"C:\\Program Files (x86)\\Microsoft Dynamics 365\\70\\Retail Modern POS\\Tools\\ProvisionRetailModernPos.bat");

			option.setApplicationPath(
					"C:\\Users\\p.prakash.dharme\\Downloads\\Winium.Desktop.Driver\\Winium.Desktop.Driver.exe");

			driver = new WiniumDriver(new URL("http://localhost:9999"), option);

		} catch (IOException e) {
			e.printStackTrace();
		}*/

	}

	public static WiniumDriverSetup getInstance() {
		if (instance == null) {
			try {
				instance = new WiniumDriverSetup();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	public WiniumDriver getDriver() {
		return this.driver;
	}

}
