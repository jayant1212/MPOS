/*
'################################################################################################
'Class Name			   : ResolutionSettingsPage
'Description           : ResolutionSettingsPage
'Author                : Pranali Dharme
'Date Created          : 07/16/2019
'################################################################################################
'            Change History
'Date Changed:        Name:                Reason:
'================================================================================================
'  
'================================================================================================
*/

package fb.mpos.page;

import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.testng.Reporter;

import fb.mpos.driver.BaseDriver;

public class ResolutionSettingsPage extends BaseDriver {

	public ResolutionSettingsPage(String string) {

		PageFactory.initElements(driver, this);

	}
	
	public Pattern windowSearchBar = new Pattern(filePath + "WindowSearchBar.PNG");
	public Pattern AppSize = new Pattern(filePath + "AppSize.PNG");
	public Pattern Resolution = new Pattern(filePath + "Resolution.PNG");
	
	
	
}