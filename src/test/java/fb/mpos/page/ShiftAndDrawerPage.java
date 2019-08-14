/*
'################################################################################################
'Class Name			   : ShiftAndDrawerPage
'Description           : ShiftAndDrawerPage
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
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.testng.Reporter;

import fb.mpos.driver.BaseDriver;

public class ShiftAndDrawerPage extends BaseDriver {

	private HomePage homePage;
	private LoginPage loginPage;

	public ShiftAndDrawerPage(String string) {

		PageFactory.initElements(driver, this);
		this.homePage = new HomePage(filePath);
		this.loginPage = new LoginPage(filePath);
	}

	public Pattern freshFoodOrders = new Pattern(filePath + "FreshFoodOrders.PNG");
	public Pattern fFOTest1 = new Pattern(filePath + "FFOTest1.PNG");
	public Pattern fFOTest2 = new Pattern(filePath + "FFOTest2.PNG");
	public Pattern digit5 = new Pattern(filePath + "Digit5.PNG");
	public Pattern digit8 = new Pattern(filePath + "Digit8.PNG");
	public Pattern digit00 = new Pattern(filePath + "Digit00.PNG");
	public Pattern enter = new Pattern(filePath + "Enter.PNG");
	public Pattern save = new Pattern(filePath + "Save.PNG");
	public Pattern fFOConfirmationMsg = new Pattern(filePath + "FFOConfirmationMsg.PNG");
	public Pattern showJournal = new Pattern(filePath + "ShowJournal.PNG");
	public Pattern showReceipt = new Pattern(filePath + "ShowReceipt.PNG");
	public Pattern productReceipt = new Pattern(filePath + "ProductReceipt.PNG");
	public Pattern declarestartamount = new Pattern(filePath + "DeclareStartAmount.PNG");
	public Pattern sAdigit8 = new Pattern(filePath + "SADigit8.PNG");
	public Pattern sAdigit00 = new Pattern(filePath + "SADigit00.PNG");
	public Pattern sAEnterbutton = new Pattern(filePath + "SAEnterbutton.PNG");
	public Pattern dSAMessage = new Pattern(filePath + "SAMessage.PNG");
	public Pattern dSAYesBuuton = new Pattern(filePath + "SAYesButton.PNG");
	public Pattern bankdropbutton = new Pattern(filePath + "BankDropButton.PNG");
	public Pattern bDCashmethod = new Pattern(filePath + "CashMethodSelect.PNG");
	public Pattern bDEnter = new Pattern(filePath + "BDEnter.PNG");
	public Pattern bDbagnumber = new Pattern(filePath + "BDBagNumber.PNG");
	public Pattern bDokbutton = new Pattern(filePath + "BDOKbutton.PNG");
	public Pattern wMbutton = new Pattern(filePath + "WMbutton.PNG");
	public Pattern wMSelectItem = new Pattern(filePath + "WMitem1.PNG");
	public Pattern wMSelectReason = new Pattern(filePath + "WMClickReason.PNG");
	public Pattern wMReason = new Pattern(filePath + "WMExpired.PNG");
	public Pattern wMSelectButton = new Pattern(filePath + "WMSelect.PNG");
	public Pattern wMitemdetails = new Pattern(filePath + "WMDetails.PNG");
	public Pattern wMConfirmation = new Pattern(filePath + "WMConfimationMsg.PNG");
	public Pattern eotbutton = new Pattern(filePath + "EOTButton.PNG");
	public Pattern oboOrderbutton = new Pattern(filePath + "Obo Orders.PNG");
	public Pattern oboStatusbutton = new Pattern(filePath + "OBO Status.PNG");
	public Pattern roundTripButton = new Pattern(filePath + "RoundTripButton.PNG");
	public Pattern returnButton = new Pattern(filePath + "ReturnButton.PNG");
	public Pattern checkedProductToReturn = new Pattern(filePath + "CheckedProductToReturn.PNG");
	public Pattern defectReason = new Pattern(filePath + "DefectReason.PNG");
	public Pattern outdatedDefectReason = new Pattern(filePath + "OutdatedDefectReason.PNG");
	public Pattern rOk = new Pattern(filePath + "ROk.PNG");
	public Pattern trainInfo = new Pattern(filePath + "TrainInfo.PNG");
	public Pattern trainDetails = new Pattern(filePath + "TrainDetails.PNG");
	public Pattern manageInventoryMessage = new Pattern(filePath + "ManageInventoryMessage.PNG");
	public Pattern transferButton = new Pattern(filePath + "TransferButton.PNG");
	public Pattern inventoryTransferInfo = new Pattern(filePath + "InventoryTransferInfo.PNG");
	public Pattern eOTSuccessMsg = new Pattern(filePath + "EOTSuccessMsg.PNG");
	public Pattern selectCheckBox = new Pattern(filePath + "SelectCheckBox.PNG");
	public Pattern noButton = new Pattern(filePath + "NoButton.PNG");

	/*
	 * Application need to block end of trip when the POS is in “Non-Drawer” mode
	 * (no open shift exists)
	 */
	public void nonDrawerCheck() {
		try {
			screen.wait(loginPage.nonDrawerOperation, 20);
			screen.click(loginPage.nonDrawerOperation);
			homePage.scrollForward();
			screen.wait(eotbutton, 20);
			screen.click(eotbutton);
			homePage.clickOK();
			sleepWait(1000);
			screen.wait(roundTripButton, 20);
			screen.click(roundTripButton);
			homePage.clickOK();
			sleepWait(1000);
			screen.wait(oboStatusbutton, 20);
			screen.click(oboStatusbutton);
			homePage.clickOK();
			sleepWait(1000);
			screen.wait(oboOrderbutton, 20);
			screen.click(oboOrderbutton);
			homePage.clickOK();
			sleepWait(1000);
			screen.wait(wMbutton, 20);
			screen.click(wMbutton);
			homePage.clickOK();
			sleepWait(1000);
			screen.wait(freshFoodOrders, 20);
			screen.click(freshFoodOrders);
			homePage.clickOK();
			Reporter.log("Non drawer functionality verified", true);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	/* Fresh Foods - Verify ,Fresh Food Button are available on M-POS */
	public boolean verifyFreshFoodOrdersButton() {
		boolean isButtonPresent = false;
		homePage.scrollForward();
		if (screen.exists(freshFoodOrders) != null) {
			isButtonPresent = true;
			Reporter.log("FreshFoodOrders button is present");
		} else {
			Reporter.log("FreshFoodOrders button is not present");
		}
		return isButtonPresent;
	}

	/* Enter button */
	public void enter() {
		try {
			screen.wait(enter, 20);
			screen.click(enter);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	/* Save button */
	public void save() {
		try {
			screen.wait(save, 20);
			screen.click(save);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	/*
	 * Fresh Foods - Verify, Item displayed on the Fresh food page on M-POS aren't
	 * displayed on the beginning inv transfer order for the trip.
	 */
	public boolean createFFO() {
		boolean isConfirmationMsg = false;
		try {
			verifyFreshFoodOrdersButton();
			screen.click(freshFoodOrders);
			sleepWait(3000);
			screen.wait(fFOTest1, 20);
			screen.click(fFOTest1);
			sleepWait(3000);
			screen.wait(digit5, 20);
			screen.click(digit5);
			sleepWait(3000);
			screen.wait(enter, 20);
			screen.click(enter);
			sleepWait(3000);
			screen.wait(fFOTest2, 20);
			screen.click(fFOTest2);
			sleepWait(3000);
			screen.wait(digit8, 20);
			screen.click(digit8);
			sleepWait(3000);
			enter();
			sleepWait(3000);
			save();
			save();
			sleepWait(3000);
			if (screen.find(fFOConfirmationMsg) != null) {
				isConfirmationMsg = true;
				sleepWait(3000);
				homePage.clickOK();
				Reporter.log("FreshFoodOrders created successfully");
			} else {
				Reporter.log("FreshFoodOrders not created successfully");
			}

		} catch (FindFailed e) {
			e.printStackTrace();
		}
		return isConfirmationMsg;
	}

	/* Declare Start Amount Flow */
	public void declareSA() {
		try {
			homePage.scrollForward();
			if (screen.exists(declarestartamount) != null) {
				screen.click(declarestartamount);
				screen.wait(sAdigit8, 20);
				screen.click(sAdigit8);
				screen.wait(sAdigit00, 20);
				screen.click(sAdigit00);
				screen.wait(sAEnterbutton, 20);
				screen.click(sAEnterbutton);
				sleepWait(2000);
				if (screen.find(dSAMessage) != null) {
					screen.wait(dSAYesBuuton, 20);
					screen.click(dSAYesBuuton);
				} else if (screen.exists(homePage.ok) != null) {
					homePage.clickOK();
				}
				save();
				Reporter.log("Start ammount is declared successfully.", true);
			} else {
				Reporter.log("DeclareAmount button is not present");
			}
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	/* Bank Drop Flow */
	public void BankDrop() {
		try {
			homePage.scrollForward();
			if (screen.exists(bankdropbutton) != null) {
				screen.click(bankdropbutton);
				screen.wait(bDCashmethod, 20);
				screen.click(bDCashmethod);
				screen.wait(digit5, 20);
				screen.click(digit5);
				screen.wait(digit00, 20);
				screen.click(digit00);
				screen.wait(bDEnter, 20);
				screen.click(bDEnter);
				save();
				screen.wait(bDbagnumber, 20);
				screen.type(bDbagnumber, "1234");
				screen.wait(bDokbutton, 20);
				screen.click(bDokbutton);
				Reporter.log("Bank drop functionality is accessed successfully", true);
			} else {
				Reporter.log("BankDrop button is not present");
			}
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	/* Waste Management Flow ...... */
	public boolean WManage() {
		boolean isConfirmationMsg = false;
		try {
			homePage.scrollForward();
			if (screen.exists(wMbutton) != null) {
				screen.click(wMbutton);
				screen.wait(wMSelectItem, 20);
				screen.click(wMSelectItem);
				screen.wait(digit5, 20);
				screen.click(digit5);
				screen.wait(bDEnter, 20);
				screen.click(bDEnter);
				screen.wait(wMSelectReason, 20);
				screen.click(wMSelectReason);
				sleepWait(2000);
				screen.wait(wMReason, 20);
				screen.click(wMReason);
				screen.wait(wMSelectButton, 20);
				screen.click(wMSelectButton);
				save();
				sleepWait(3000);
				if (screen.find(wMitemdetails) != null) {
					Reporter.log("Waste item details are displayed");
				} else {
					Reporter.log("Waste item details are not displayed");
				}
				save();
				sleepWait(3000);
				if (screen.find(wMConfirmation) != null) {
					isConfirmationMsg = true;
					Reporter.log("Spoiled Data saved successfully");
				} else {
					Reporter.log("Spoiled data are not saved successfully");
				}
				homePage.clickOK();
			} else {
				Reporter.log("Waste Management button is not present");
			}
		} catch (FindFailed e) {
			e.printStackTrace();
		}
		return isConfirmationMsg;
	}

	/* Login POS, and verify the TRIP, TRAIN, CAR information at POS */
	public boolean verifyTrainInfo() {
		boolean isTrainInfo = false;
		homePage.scrollForward();
		try {
			sleepWait(2000);
			screen.wait(trainInfo, 20);
			screen.click(trainInfo);
			sleepWait(2000);
			if (screen.find(trainDetails) != null) {
				isTrainInfo = true;
				Reporter.log("Train data is available", true);
			} else {
				Reporter.log("Train data is not available", true);
			}
		} catch (FindFailed e) {
			e.printStackTrace();
		}
		return isTrainInfo;
	}

	/* End of Trip & Close shift */
	public boolean eOTProcess() {
		boolean isEOTCompleted = false;
		homePage.scrollForward();
		try {
			screen.wait(eotbutton, 20);
			screen.click(eotbutton);
			screen.wait(noButton, 20);
			screen.click(noButton);
			if (screen.find(manageInventoryMessage) != null) {
				screen.wait(transferButton, 20);
				screen.click(transferButton);
				if (screen.find(inventoryTransferInfo) != null) {
					screen.wait(selectCheckBox, 20);
					screen.click(selectCheckBox);
					save();
					if (screen.find(eOTSuccessMsg) != null) {
						isEOTCompleted = true;
						homePage.clickOK();
						Reporter.log("EOT completed successfully for the store", true);
					} else {
						Reporter.log("EOT not completed successfully for the store", true);
					}
				}
			}
		} catch (FindFailed e) {
			e.printStackTrace();
		}
		return isEOTCompleted;
	}

}
