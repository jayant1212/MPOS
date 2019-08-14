/*
'################################################################################################
'Class Name			   : TC500
'Description           : MPOS Bank Drop Functionality
'Author                : Jayant Nagar
'Date Created          : 07/01/2019
'################################################################################################
'            Change History
'Date Changed:        Name:                Reason:
'================================================================================================
'  
'================================================================================================
*/

//Note: cash Drawer opens after declaring start amount.

package fb.mpos.testcases;

import org.testng.annotations.Test;

import fb.mpos.driver.BaseDriver;
import fb.mpos.page.HomePage;
import fb.mpos.page.LoginPage;
import fb.mpos.page.ShiftAndDrawerPage;
import fb.mpos.test.data.CredentialProvider;

public class TC500 extends BaseDriver {

	private LoginPage loginPage;
	private ShiftAndDrawerPage shiftAndDrawerPage;
	private HomePage homePage;

	public TC500() {
		this.loginPage = new LoginPage(filePath);
		this.shiftAndDrawerPage = new ShiftAndDrawerPage(filePath);
		this.homePage = new HomePage(filePath);
	}

	@Test(priority = 1, dataProvider = "credentialData", dataProviderClass = CredentialProvider.class, description = "Login")
	public void tc500(String operatorid, String password) {
		applicationLaunch();
		sleepWait(5000);
		loginPage.enterUserIdPassowrd(operatorid, password);
		homePage.clickOK();
		shiftAndDrawerPage.BankDrop();
		homePage.closeApplication();
	}
}
