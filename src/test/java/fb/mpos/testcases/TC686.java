/*
'################################################################################################
'Class Name			   : TC686
'Description           : Fresh Foods - Verify ,Fresh Food Button are available on M-POS 
'Author                : Pranali Dharme
'Date Created          : 06/26/2019
'################################################################################################
'            Change History
'Date Changed:        Name:                Reason:
'================================================================================================
'  
'================================================================================================
*/

package fb.mpos.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import fb.mpos.driver.BaseDriver;
import fb.mpos.page.HomePage;
import fb.mpos.page.LoginPage;
import fb.mpos.page.ShiftAndDrawerPage;
import fb.mpos.test.data.CredentialProvider;

public class TC686 extends BaseDriver {

	private LoginPage loginPage;
	private ShiftAndDrawerPage shiftAndDrawerPage;
	private HomePage homePage;

	public TC686() {
		this.loginPage = new LoginPage(filePath);
		this.shiftAndDrawerPage = new ShiftAndDrawerPage(filePath);
		this.homePage = new HomePage(filePath);
	}

	@Test(priority = 1, dataProvider = "credentialData", dataProviderClass = CredentialProvider.class, description = "Login")
	public void tc686(String operatorid, String password) {

		applicationLaunch();
		sleepWait(5000);
		loginPage.enterUserIdPassowrd(operatorid, password);
		Assert.assertEquals(shiftAndDrawerPage.verifyFreshFoodOrdersButton(), true);
		homePage.userLogout();

	}
}
