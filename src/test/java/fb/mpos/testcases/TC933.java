/*
'################################################################################################
'Class Name			   : TC933
'Description           : Application need to block end of trip when the POS is in “Non-Drawer” mode (no open shift exists)
'Author                : Muskan Sharma
'Date Created          : 07/03/2019
'################################################################################################
'            Change History
'Date Changed:        Name:                Reason:
'================================================================================================
'  
'================================================================================================
*/

//Pre-requisite: Shift should be closed.

package fb.mpos.testcases;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import fb.mpos.driver.BaseDriver;
import fb.mpos.page.HomePage;
import fb.mpos.page.LoginPage;
import fb.mpos.page.ShiftAndDrawerPage;
import fb.mpos.test.data.CredentialProvider;

public class TC933 extends BaseDriver {
	private LoginPage loginPage;
	private ShiftAndDrawerPage shiftAndDrawerPage;
	private HomePage homePage;

	public TC933() {
		this.loginPage = new LoginPage(filePath);
		this.shiftAndDrawerPage = new ShiftAndDrawerPage(filePath);
		this.homePage = new HomePage(filePath);
	}

	@Test(priority = 1, dataProvider = "credentialData", dataProviderClass = CredentialProvider.class, description = "Login")
	public void tc933(String operatorid, String password) throws FindFailed, Exception {
		applicationLaunch();
		sleepWait(5000);
		loginPage.enterUserIdPassowrd(operatorid, password);
		shiftAndDrawerPage.nonDrawerCheck();
		homePage.userLogout();
	}

}
