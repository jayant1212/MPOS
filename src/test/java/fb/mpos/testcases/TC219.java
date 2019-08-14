/*
'################################################################################################
'Class Name			   : TC219
'Description           : Declare Start Amount
'Author                : Jayant Nagar
'Date Created          : 6/28/2019
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

public class TC219 extends BaseDriver {

	private LoginPage loginPage;
	private ShiftAndDrawerPage shiftAndDrawerPage;
	private HomePage homePage;

	public TC219() {
		this.loginPage = new LoginPage(filePath);
		this.shiftAndDrawerPage = new ShiftAndDrawerPage(filePath);
		this.homePage = new HomePage(filePath);
	}

	@Test(priority = 1, dataProvider = "credentialData", dataProviderClass = CredentialProvider.class, description = "Login")
	public void tc219(String operatorid, String password) {
		applicationLaunch();
		sleepWait(5000);
		loginPage.enterUserIdPassowrd(operatorid, password);
		shiftAndDrawerPage.declareSA();
		sleepWait(1000);
		homePage.closeApplication();
	}
}