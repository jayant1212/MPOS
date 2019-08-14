/*
'################################################################################################
'Class Name			   : TC703
'Description           : Search products by item number ***
'Author                : Muskan Sharma
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

public class TC703 extends BaseDriver {
	private LoginPage loginPage;
	private HomePage homePage;
	private StartPage startPage;

	public TC703() {
		this.loginPage = new LoginPage(filePath);
		this.homePage = new HomePage(filePath);
		this.startPage = new StartPage(filePath);
	}

	@Test(priority = 1, dataProvider = "credentialData", dataProviderClass = CredentialProvider.class, description = "Login")
	public void tc703(String operatorid, String password) {
		applicationLaunch();
		sleepWait(5000);
		loginPage.enterUserIdPassowrd(operatorid, password);
		Assert.assertEquals(startPage.searchProductByItemNumber(operatorid), true);
		homePage.userLogout();
	}
}
