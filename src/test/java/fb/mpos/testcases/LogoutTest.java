/*
'################################################################################################
'Class Name			   : LogoutTest
'Description           : LogoutTest
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
import fb.mpos.page.HomePage;

public class LogoutTest extends BaseDriver {

	private HomePage homePage;

	public LogoutTest() {
		this.homePage = new HomePage(filePath);
	}

	@Test(priority = 1)
	public void logout() {
		homePage.userLogout();

	}
}
