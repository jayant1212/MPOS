/*
'################################################################################################
'Class Name			   : LoginTest
'Description           : LoginTest
'Author                : Pranali Dharme
'Date Created          : 6/25/2019
'################################################################################################
'            Change History
'Date Changed:        Name:                Reason:
'================================================================================================
'  
'================================================================================================
*/

package fb.mpos.testcases;

import org.testng.annotations.Test;

import fb.mpos.driver.BaseDriver;
import fb.mpos.page.LoginPage;
import fb.mpos.test.data.CredentialProvider;

public class LoginTest extends BaseDriver {

	private LoginPage loginPage;

	public LoginTest() {
		this.loginPage = new LoginPage(filePath);
	}

	@Test(priority = 1, dataProvider = "credentialData", dataProviderClass = CredentialProvider.class, description = "Login")
	public void login(String operatorid, String password) {

		applicationLaunch();
		sleepWait(5000);
		loginPage.enterUserIdPassowrd(operatorid, password);
		loginPage.clickSignIn();
		
		

	}
}
