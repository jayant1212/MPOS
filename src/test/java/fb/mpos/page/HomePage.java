/*
'################################################################################################
'Class Name			   : HomePage
'Description           : HomePage
'Author                : Pranali Dharme
'Date Created          : 6/25/2019
'################################################################################################
'            Change History
'Date Changed:        Name:                Reason:
'================================================================================================
'  
'================================================================================================
*/

package fb.mpos.page;

import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.testng.Reporter;

import fb.mpos.driver.BaseDriver;

public class HomePage extends BaseDriver {

	public HomePage(String string) {

		PageFactory.initElements(driver, this);

	}

	public Pattern ok = new Pattern(filePath + "Ok.PNG");
	public Pattern startExploring = new Pattern(filePath + "StartExploring.PNG");
	public Pattern closeWalkThrough = new Pattern(filePath + "CloseWalkThrough.PNG");
	public Pattern blankScreen = new Pattern(filePath + "BlankScreen.PNG");
	public Pattern homeButton = new Pattern(filePath + "HomeButton.PNG");
	public Pattern profile = new Pattern(filePath + "Profile.PNG");
	public Pattern loggOff = new Pattern(filePath + "LoggOff.PNG");
	public Pattern closeMPOS = new Pattern(filePath + "CloseMPOS.PNG");

	/* Click close application */
	public void closeApplication() {
		try {
			screen.wait(closeMPOS, 20);
			screen.click(closeMPOS);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	/* Click OK popup */
	public void clickOK() {
		try {
			screen.wait(ok, 20);
			screen.click(ok);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	/* Home Button Click */
	public void clickHomeButton() {
		try {
			screen.wait(homeButton, 20);
			screen.click(homeButton);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	/* Application demo actions */
	public void beforeActions() {
		try {
			screen.wait(ok, 20);
			screen.click(ok);
			screen.wait(startExploring, 20);
			screen.click(startExploring);
			screen.wait(closeWalkThrough, 20);
			screen.click(closeWalkThrough);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	/* Robot scroll forward */
	public void scrollForward() {
		try {
			sleepWait(2000);
			screen.wait(blankScreen, 20);
			screen.click(blankScreen);
			for (int i = 1; i <= 7; i++) {
				keyRight();
			}
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	/* Robot scroll back */
	public void scrollBack() {
		try {
			sleepWait(2000);
			screen.wait(blankScreen, 20);
			screen.click(blankScreen);
			for (int i = 1; i <= 7; i++) {
				keyLeft();
			}
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	/* User logout */
	public void userLogout() {
		try {
			screen.wait(profile, 20);
			screen.click(profile);
			screen.wait(loggOff, 20);
			screen.click(loggOff);
			sleepWait(2000);
			Reporter.log("Successfully logged out from MPOS application", true);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

}
