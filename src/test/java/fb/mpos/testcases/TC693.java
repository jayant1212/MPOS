/*
'################################################################################################
'Class Name			   : TC693
'Description           : Declare Start Amount
'Author                : Pranali Dharme
'Date Created          : 07/03/2019
'################################################################################################
'            Change History
'Date Changed:        Name:                Reason:
'================================================================================================
'  
'================================================================================================
*/

//Pre-requisites: Dependency of CPOS for further functionality.

package fb.mpos.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import fb.mpos.driver.BaseDriver;
import fb.mpos.page.CPOS;
import fb.mpos.page.HomePage;
import fb.mpos.page.LoginPage;
import fb.mpos.page.ShiftAndDrawerPage;
import fb.mpos.test.data.CredentialProvider;

public class TC693 extends BaseDriver {

	private LoginPage loginPage;
	private ShiftAndDrawerPage shiftAndDrawerPage;
	private HomePage homePage;
	private CPOS cpos;

	public TC693() {
		this.loginPage = new LoginPage(filePath);
		this.shiftAndDrawerPage = new ShiftAndDrawerPage(filePath);
		this.homePage = new HomePage(filePath);
		this.cpos = new CPOS(filePath);
	}

	@Test(priority = 1, dataProvider = "credentialData", dataProviderClass = CredentialProvider.class, description = "Login")
	public void tc693(String operatorid, String password) {
	/*	sleepWait(5000);
		applicationLaunch();
		loginPage.enterUserIdPassowrd(operatorid, password);
		Assert.assertEquals(shiftAndDrawerPage.createFFO(), true);
		keyAltTab();*/
		loginPage.loginToCPOS(operatorid);
		cpos.runFreshFoodJob(operatorid);
		keyAltTab();
		Assert.assertEquals(shiftAndDrawerPage.createFFO(), true);
		homePage.userLogout();
	}
}
