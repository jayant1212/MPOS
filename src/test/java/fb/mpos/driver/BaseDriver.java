/*
'################################################################################################
'Class Name			   : BaseDriver
'Description           : BaseDriver
'Author                : Pranali Dharme
'Date Created          : 06/25/2019
'################################################################################################
'            Change History
'Date Changed:        Name:                Reason:
'================================================================================================
'  
'================================================================================================
*/

package fb.mpos.driver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.winium.WiniumDriver;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterTest;

public class BaseDriver {

	public final static String filePath = "src/test/java/resources/images/";
	public WebDriver driver;
	//public WiniumDriver driver;
	public Robot robot;
	public Screen screen;

	public BaseDriver() {
		driver = WebDriverSetup.getInstance().getDriver();
		//driver = WiniumDriverSetup.getInstance().getDriver();
		this.screen = new Screen();
		try {
			this.robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	public void sleepWait(long miliSec) {
		try {
			Thread.sleep(miliSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenshot(String testName, String operatorid) {

		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int millisecond = calendar.get(Calendar.MILLISECOND);

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("src/screenshots/" + "/" + operatorid + "/" + testName + "_" + hour
					+ "_" + minute + "_" + second + "_" + millisecond + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void applicationLaunch() {

		robot.keyPress(KeyEvent.VK_WINDOWS);
		robot.keyRelease(KeyEvent.VK_WINDOWS);
		sleepWait(500);
		robot.keyPress(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_P);
		sleepWait(500);
		robot.keyPress(KeyEvent.VK_O);
		robot.keyRelease(KeyEvent.VK_O);
		sleepWait(500);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		sleepWait(500);
		keyEnter();

	}

	public void keyEnter() {
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void keyDown() {
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}

	public void keyUp() {
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
	}

	public void keyRight() {
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
	}

	public void keyLeft() {
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.keyRelease(KeyEvent.VK_LEFT);
	}

	public void keyAltTab() {
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_ALT);
	}

	/*
	 * @AfterTest(alwaysRun = true)
	 * 
	 * public void tearDown() throws IOException { driver.quit(); }
	 */

}
