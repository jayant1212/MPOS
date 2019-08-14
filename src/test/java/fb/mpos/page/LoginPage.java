/*
'################################################################################################
'Class Name			   : LoginPage
'Description           : LoginPage
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

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.testng.Reporter;

import fb.mpos.driver.BaseDriver;
import fb.mpos.utility.ExcelUtil;

public class LoginPage extends BaseDriver {
	
	private HomePage homePage;

	public LoginPage(String string) {

		PageFactory.initElements(driver, this);
		this.homePage = new HomePage(filePath);

	}

	public Pattern username = new Pattern(filePath + "Id.PNG");
	public Pattern userpassword = new Pattern(filePath + "Password.PNG");
	public Pattern signIn = new Pattern(filePath + "SignIn.PNG");
	public Pattern shiftNotOpen = new Pattern(filePath + "ShiftNotOpen.PNG");
	public Pattern nonDrawerOperation = new Pattern(filePath + "NonDrawerOperation.PNG");
	public Pattern openNewShift = new Pattern(filePath + "OpenNewShift.PNG");
	public Pattern drawer1 = new Pattern(filePath + "Drawer1.PNG");
	public Pattern drawer2 = new Pattern(filePath + "Drawer2.PNG");

	@FindBy(xpath = "//div[@id = 'otherTileText']")
	public WebElement useAnotherAccount; // Use Another Account

	@FindBy(xpath = "//input[@type='email']")
	public WebElement userid; // Username placeholder

	@FindBy(xpath = "//input[@type='password']")
	public WebElement passwd; // Password placeholder

	@FindBy(xpath = "//input[@type='submit']")
	public WebElement SignInButton; // Login button

	/* Login to Cloud POS (web Application) */
	public void loginToCPOS(String operatorid) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			if (driver.getPageSource().contains("Use Another Account")) {
				wait.until(ExpectedConditions.visibilityOf(useAnotherAccount));
				useAnotherAccount.click();
			}
			wait.until(ExpectedConditions.visibilityOf(userid));
			userid.clear();
			userid.sendKeys(ExcelUtil.readColumnDataByOperatorid("Data", operatorid, "userid"));
			wait.until(ExpectedConditions.elementToBeClickable(SignInButton));
			SignInButton.click();
			wait.until(ExpectedConditions.visibilityOf(passwd));
			passwd.clear();
			passwd.sendKeys(ExcelUtil.readColumnDataByOperatorid("Data", operatorid, "passwd"));
			SignInButton.click();
			if (driver.getPageSource().contains("Stay signed in?")) {
				SignInButton.click();
			}
			Reporter.log("Successfully logged into CPOS application", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Enter userid and password in Modern POS (Desktop Application) */
	public void enterUserIdPassowrd(String operatorid, String password) {
		try {
			screen.wait(username, 20);
			screen.click(username);
			screen.type(username, operatorid);
			screen.wait(userpassword, 20);
			screen.click(userpassword);
			screen.type(userpassword, password);
			clickSignIn();
			shiftOpenration(operatorid);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	/* Sign In to Modern POS */
	public void clickSignIn() {
		try {
			sleepWait(1000);
			screen.wait(signIn, 20);
			screen.click(signIn);
			Reporter.log("Successfully logged into MPOS application", true);
		} catch (FindFailed e) {
			e.printStackTrace();
		}

	}

	/* New Shift Operation */
	public void shiftOpenration(String operatorid) {
		try {
			if (screen.find(homePage.ok) != null) {
				screen.wait(homePage.ok, 20);
				screen.click(homePage.ok);
			}
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}
}
