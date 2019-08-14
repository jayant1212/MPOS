/*
'################################################################################################
'Class Name			   : TC691
'Description           : Sales return transaction at MPOS
'Author                : Muskan Sharma
'Date Created          : 07/01/2019
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
import fb.mpos.page.HomePage;
import fb.mpos.page.LoginPage;
import fb.mpos.page.StartPage;
import fb.mpos.test.data.CredentialProvider;

public class TC691 extends BaseDriver {
	private LoginPage loginPage;
	private HomePage homePage;
	private StartPage startPage;

	public TC691() {
		this.loginPage = new LoginPage(filePath);
		this.homePage = new HomePage(filePath);
		this.startPage = new StartPage(filePath);
	}

	@Test(priority = 1, dataProvider = "credentialData", dataProviderClass = CredentialProvider.class, description = "Login")

	public void tc691(String operatorid, String password) {
		applicationLaunch();
		loginPage.enterUserIdPassowrd(operatorid, password);
		startPage.salesReturnTransaction(operatorid);
		homePage.userLogout();
	}

}
