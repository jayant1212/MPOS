/*
'################################################################################################
'Class Name			   : TC381
'Description           : Sales transaction with credit card payment
'Author                : Pranali Dharme
'Date Created          : 07/15/2019
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

public class TC381_PartialPayment extends BaseDriver {

	private LoginPage loginPage;
	private HomePage homePage;
	private StartPage startPage;

	public TC381_PartialPayment() {
		this.loginPage = new LoginPage(filePath);
		this.homePage = new HomePage(filePath);
		this.startPage = new StartPage(filePath);
	}

	@Test(priority = 1, dataProvider = "credentialData", dataProviderClass = CredentialProvider.class, description = "Login")
	public void tc381(String operatorid, String password) {
		applicationLaunch();
		loginPage.enterUserIdPassowrd(operatorid, password);
		Assert.assertEquals(startPage.salesTransactionWithCashAndCard(operatorid), true);
		homePage.userLogout();
	}
}
