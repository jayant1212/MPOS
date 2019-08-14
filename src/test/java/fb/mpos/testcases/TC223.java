/*
'################################################################################################
'Class Name			   : TC221
'Description           : End of Trip & Close shift
'Author                : Pranali Dharme
'Date Created          : 07/10/2019
'################################################################################################
'            Change History
'Date Changed:        Name:                Reason:
'================================================================================================
'  
'================================================================================================
*/

//Pre-requisite: All shifts related to Houston store needs to be close except one.

package fb.mpos.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import fb.mpos.driver.BaseDriver;
import fb.mpos.page.LoginPage;
import fb.mpos.page.ShiftAndDrawerPage;
import fb.mpos.test.data.CredentialProvider;

public class TC223 extends BaseDriver {

	private LoginPage loginPage;
	private ShiftAndDrawerPage shiftAndDrawerPage;

	public TC223() {
		this.loginPage = new LoginPage(filePath);
		this.shiftAndDrawerPage = new ShiftAndDrawerPage(filePath);
	}

	@Test(priority = 1, dataProvider = "credentialData", dataProviderClass = CredentialProvider.class, description = "Login")
	public void tc223(String operatorid, String password) {
		applicationLaunch();
		loginPage.enterUserIdPassowrd(operatorid, password);
		Assert.assertEquals(shiftAndDrawerPage.eOTProcess(), true);
	}
}
