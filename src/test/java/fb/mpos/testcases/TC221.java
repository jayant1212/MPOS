/*
'################################################################################################
'Class Name			   : TC221
'Description           : Sales transaction with payment method Cash
'Author                : Pranali Dharme
'Date Created          : 06/28/2019
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
import fb.mpos.page.StartPage;
import fb.mpos.test.data.CredentialProvider;

public class TC221 extends BaseDriver {

	private LoginPage loginPage;
	private HomePage homePage;
	private StartPage startPage;

	public TC221() {
		this.loginPage = new LoginPage(filePath);
		this.homePage = new HomePage(filePath);
		this.startPage = new StartPage(filePath);
	}

	@Test(priority = 1, dataProvider = "credentialData", dataProviderClass = CredentialProvider.class, description = "Login")
	public void tc221(String operatorid, String password) {

		applicationLaunch();
		sleepWait(5000);
		loginPage.enterUserIdPassowrd(operatorid, password);
		Assert.assertEquals(startPage.salesTransactionWithCash(operatorid), true);
		homePage.userLogout();

	}
}
