/*
'Class Name			   : TC497
'Description           : Login POS, and verify the TRIP, TRAIN, CAR information at POS
'Author                : Pranali Dharme
'Date Created          : 07/03/2019
'################################################################################################
'            Change History
'Date Changed:        Name:                Reason:
'================================================================================================
'  
'================================================================================================
*/

//Note: Partial verification is done (some data is not available).

package fb.mpos.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import fb.mpos.driver.BaseDriver;
import fb.mpos.page.HomePage;
import fb.mpos.page.LoginPage;
import fb.mpos.page.ShiftAndDrawerPage;
import fb.mpos.test.data.CredentialProvider;

public class TC497 extends BaseDriver {

	private LoginPage loginPage;
	private HomePage homePage;
	private ShiftAndDrawerPage shiftAndDrawerPage;

	public TC497() {
		this.loginPage = new LoginPage(filePath);
		this.homePage = new HomePage(filePath);
		this.shiftAndDrawerPage = new ShiftAndDrawerPage(filePath);
	}

	@Test(priority = 1, dataProvider = "credentialData", dataProviderClass = CredentialProvider.class, description = "Login")
	public void tc497(String operatorid, String password) {

		applicationLaunch();
		sleepWait(5000);
		loginPage.enterUserIdPassowrd(operatorid, password);
		Assert.assertEquals(shiftAndDrawerPage.verifyTrainInfo(), true);
		homePage.userLogout();
	}
}
