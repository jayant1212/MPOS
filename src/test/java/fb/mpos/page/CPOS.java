/*
'################################################################################################
'Class Name			   : CPOS
'Description           : CPOS
'Author                : Pranali Dharme
'Date Created          : 07/18/2019
'################################################################################################
'            Change History
'Date Changed:        Name:                Reason:
'================================================================================================
'  
'================================================================================================
*/

package fb.mpos.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import fb.mpos.driver.BaseDriver;
import fb.mpos.utility.ExcelUtil;

public class CPOS extends BaseDriver {

	public CPOS(String string) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='NavigationSearchExpandableControl']")
	public WebElement searchButton; // Search button

	@FindBy(xpath = "//*[@id='NavigationSearchBox_searchBoxInput_input']")
	public WebElement searchBar; // Search input box

	@FindBy(xpath = "//*[contains(@class,'dialog-caption')]")
	public WebElement jobRunHeading; // Job run heading

	@FindBy(xpath = "//*[@id='SysOperationTemplateForm_4_CommandButton']")
	public WebElement okButton; // OK button

	@FindBy(xpath = "//*[@id='inventtransferorder_11_MainGrid_AVAType']")
	public List<WebElement> orderType; // OK button

	public void runFreshFoodJob(String operatorid) {
		sleepWait(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(searchButton));
		searchButton.click();
		sleepWait(2000);
		wait.until(ExpectedConditions.visibilityOf(searchBar));
		searchBar.clear();
		searchBar.sendKeys("Fresh Food API");
		keyEnter();
		sleepWait(2000);
		wait.until(ExpectedConditions.visibilityOf(jobRunHeading));
		Reporter.log(jobRunHeading.getText(), true);
		sleepWait(2000);
		wait.until(ExpectedConditions.visibilityOf(okButton));
		okButton.click();
		sleepWait(2000);
		wait.until(ExpectedConditions.visibilityOf(searchButton));
		searchButton.click();
		sleepWait(2000);
		wait.until(ExpectedConditions.visibilityOf(searchBar));
		searchBar.clear();
		sleepWait(2000);
		searchBar.sendKeys("Transfer Order");
		keyEnter();
		sleepWait(2000);
		for (WebElement ele : orderType) {
			String type = ele.getText();
			System.out.println("date :" + type);
			if (type.equalsIgnoreCase("Fresh Food")) {
				Reporter.log(ele.getText() + " transfer order created successfully.", true);
				break;
			}
		}

	}
}
