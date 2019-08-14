/*
'################################################################################################
'Class Name			   : ProductPage
'Description           : ProductPage
'Author                : Pranali Dharme
'Date Created          : 6/25/2019
'################################################################################################
'            Change History
'Date Changed:        Name:                Reason:
'================================================================================================
'  
'================================================================================================
*/

package fb.mpos.page;

import org.openqa.selenium.support.PageFactory;
import fb.mpos.driver.BaseDriver;

public class ProductPage extends BaseDriver {


	public ProductPage(String string) {
		PageFactory.initElements(driver, this);
	}

}
