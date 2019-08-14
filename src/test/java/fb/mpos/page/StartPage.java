/*
'################################################################################################
'Class Name			   : StartPage
'Description           : StartPage
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
import org.sikuli.script.Pattern;
import org.testng.Reporter;

import fb.mpos.driver.BaseDriver;
import fb.mpos.utility.ExcelUtil;

public class StartPage extends BaseDriver {

	private HomePage homePage;
	private ShiftAndDrawerPage shiftAndDrawerPage;

	public StartPage(String string) {

		PageFactory.initElements(driver, this);
		this.homePage = new HomePage(filePath);
		this.shiftAndDrawerPage = new ShiftAndDrawerPage(filePath);

	}

	public Pattern currentTransaction = new Pattern(filePath + "CurrentTransaction.PNG");
	public Pattern searchBar = new Pattern(filePath + "SearchBar.PNG");
	public Pattern sellNow = new Pattern(filePath + "SellNow.PNG");
	public Pattern addCustomer = new Pattern(filePath + "AddCustomer.PNG");
	public Pattern addToSell = new Pattern(filePath + "AddToSell.PNG");
	public Pattern clickOrderTotal = new Pattern(filePath + "ClickOrderTotal.PNG");
	public Pattern cashPaymentMode = new Pattern(filePath + "CashPaymentMode.PNG");
	public Pattern donePayment = new Pattern(filePath + "DonePayment.PNG");
	public Pattern changeDue = new Pattern(filePath + "changeDue.PNG");
	public Pattern close = new Pattern(filePath + "Close.PNG");
	public Pattern printGiftReceipt = new Pattern(filePath + "PrintGiftReceipt.PNG");
	public Pattern cancelButton = new Pattern(filePath + "CancelButton.PNG");
	public Pattern productPrice = new Pattern(filePath + "ProductPrice.PNG");
	public Pattern cardPaymentMode = new Pattern(filePath + "CardPaymentMode.PNG");
	public Pattern cardOption = new Pattern(filePath + "CardOption.PNG");
	public Pattern enterManuallyOption = new Pattern(filePath + "EnterManuallyOption.PNG");
	public Pattern cardNumber = new Pattern(filePath + "CardNumber.PNG");
	public Pattern expirationDate = new Pattern(filePath + "ExpirationDate.PNG");
	public Pattern expirationYear = new Pattern(filePath + "ExpirationYear.PNG");
	public Pattern securityCode = new Pattern(filePath + "SecurityCode.PNG");
	public Pattern zipCode = new Pattern(filePath + "ZipCode.PNG");
	public Pattern enterPartialCashAmount = new Pattern(filePath + "EnterPartialCashAmount.PNG");

	/* Sales transaction with payment method Cash */
	public boolean salesTransactionWithCash(String operatorid) {
		boolean isReceptGenerated = false;
		try {
			sleepWait(3000);
			screen.wait(currentTransaction, 20);
			screen.click(currentTransaction);
			sleepWait(3000);
			screen.wait(searchBar, 20);
			screen.click(searchBar);
			screen.type(searchBar, ExcelUtil.readColumnDataByOperatorid("Data", operatorid, "product.id"));
			sleepWait(3000);
			keyEnter();
			sleepWait(2000);
			screen.wait(sellNow, 20);
			screen.click(sellNow);
			sleepWait(3000);
			screen.wait(addCustomer, 20);
			screen.click(addCustomer);
			sleepWait(3000);
			screen.wait(searchBar, 20);
			screen.click(searchBar);
			screen.type(searchBar, ExcelUtil.readColumnDataByOperatorid("Data", operatorid, "customer.name"));
			sleepWait(3000);
			keyEnter();
			sleepWait(2000);
			screen.wait(addToSell, 20);
			screen.click(addToSell);
			sleepWait(3000);
			screen.wait(clickOrderTotal, 20);
			screen.click(clickOrderTotal);
			sleepWait(2000);
			screen.wait(cashPaymentMode, 20);
			screen.click(cashPaymentMode);
			sleepWait(3000);
			screen.wait(donePayment, 20);
			screen.click(donePayment);
			sleepWait(3000);
			screen.wait(changeDue, 20);
			screen.find(changeDue);
			sleepWait(3000);
			screen.wait(close, 20);
			screen.click(close);
			sleepWait(3000);
			if (screen.exists(printGiftReceipt) != null) {
				screen.wait(cancelButton, 20);
				screen.click(cancelButton);
			} else {
				homePage.clickOK();
			}
			homePage.clickHomeButton();
			homePage.scrollForward();
			screen.wait(shiftAndDrawerPage.showJournal, 20);
			screen.click(shiftAndDrawerPage.showJournal);
			sleepWait(3000);
			screen.wait(shiftAndDrawerPage.showReceipt, 20);
			screen.click(shiftAndDrawerPage.showReceipt);
			sleepWait(2000);
			keyDown();
			keyEnter();
			sleepWait(3000);
			if (screen.find(shiftAndDrawerPage.productReceipt) != null) {
				isReceptGenerated = true;

				Reporter.log("Product selling to customer receipt is generated.");
			} else {
				Reporter.log("Product selling to customer receipt is not generated.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isReceptGenerated;
	}

	/* Sales return transaction at MPOS */
	public void salesReturnTransaction(String operatorid) {
		try {
			screen.wait(currentTransaction, 20);
			screen.click(currentTransaction);
			sleepWait(2000);
			screen.wait(searchBar, 20);
			screen.click(searchBar);
			screen.type(searchBar, ExcelUtil.readColumnDataByOperatorid("Data", operatorid, "product.id"));
			keyEnter();
			sleepWait(2000);
			screen.wait(sellNow, 20);
			screen.click(sellNow);
			screen.wait(clickOrderTotal, 20);
			screen.click(clickOrderTotal);
			sleepWait(2000);
			screen.wait(cashPaymentMode, 20);
			screen.click(cashPaymentMode);
			sleepWait(2000);
			screen.wait(donePayment, 20);
			screen.click(donePayment);
			sleepWait(2000);
			screen.wait(changeDue, 20);
			screen.find(changeDue);
			screen.wait(close, 20);
			screen.click(close);
			sleepWait(2000);
			if (screen.exists(printGiftReceipt) != null) {
				screen.wait(cancelButton, 20);
				screen.click(cancelButton);
			} else {
				homePage.clickOK();
			}
			homePage.clickHomeButton();
			homePage.scrollForward();
			screen.wait(shiftAndDrawerPage.showJournal, 20);
			screen.click(shiftAndDrawerPage.showJournal);
			sleepWait(1000);
			screen.wait(shiftAndDrawerPage.returnButton, 20);
			screen.click(shiftAndDrawerPage.returnButton);
			sleepWait(2000);
			screen.wait(shiftAndDrawerPage.checkedProductToReturn, 20);
			screen.click(shiftAndDrawerPage.checkedProductToReturn);
			sleepWait(2000);
			screen.wait(shiftAndDrawerPage.returnButton, 20);
			screen.click(shiftAndDrawerPage.returnButton);
			sleepWait(2000);
			screen.wait(shiftAndDrawerPage.defectReason, 20);
			screen.click(shiftAndDrawerPage.defectReason);
			sleepWait(2000);
			screen.wait(shiftAndDrawerPage.outdatedDefectReason, 20);
			screen.click(shiftAndDrawerPage.outdatedDefectReason);
			sleepWait(2000);
			screen.wait(shiftAndDrawerPage.rOk, 20);
			screen.click(shiftAndDrawerPage.rOk);
			sleepWait(2000);
			screen.wait(clickOrderTotal, 20);
			screen.click(clickOrderTotal);
			sleepWait(2000);
			screen.wait(cashPaymentMode, 20);
			screen.click(cashPaymentMode);
			sleepWait(2000);
			screen.wait(donePayment, 20);
			screen.click(donePayment);
			sleepWait(2000);
			screen.wait(changeDue, 20);
			screen.find(changeDue);
			screen.wait(close, 20);
			screen.click(close);
			Reporter.log("Product has been return successfully", true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/* Search products by item number ****/
	public boolean searchProductByItemNumber(String operatorid) {
		boolean isProdyuctPrice = false;
		try {
			screen.wait(currentTransaction, 20);
			screen.click(currentTransaction);
			sleepWait(2000);
			screen.wait(searchBar, 20);
			screen.click(searchBar);
			screen.type(searchBar, ExcelUtil.readColumnDataByOperatorid("Data", operatorid, "product.id"));
			keyEnter();
			sleepWait(2000);
			if (screen.exists(productPrice) != null) {
				isProdyuctPrice = true;
				Reporter.log("Product price is verified", true);
			} else {
				Reporter.log("Product price is not verified", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isProdyuctPrice;
	}

	/* Sales transaction with credit+cash payment */
	public boolean salesTransactionWithCashAndCard(String operatorid) {
		boolean isReceptGenerated = false;
		try {
			screen.wait(currentTransaction, 20);
			screen.click(currentTransaction);
			sleepWait(2000);
			screen.wait(searchBar, 20);
			screen.click(searchBar);
			screen.type(searchBar, ExcelUtil.readColumnDataByOperatorid("Data", operatorid, "product.id"));
			keyEnter();
			sleepWait(2000);
			screen.wait(sellNow, 20);
			screen.click(sellNow);
			sleepWait(2000);
			screen.wait(clickOrderTotal, 20);
			screen.click(clickOrderTotal);
			sleepWait(2000);
			screen.wait(cashPaymentMode, 20);
			screen.click(cashPaymentMode);
			sleepWait(2000);
			screen.wait(enterPartialCashAmount, 20);
			screen.click(enterPartialCashAmount);
			screen.type(enterPartialCashAmount,
					ExcelUtil.readColumnDataByOperatorid("Data", operatorid, "cash.amount"));
			screen.wait(donePayment, 20);
			screen.click(donePayment);
			sleepWait(2000);
			screen.wait(clickOrderTotal, 20);
			screen.click(clickOrderTotal);
			sleepWait(4000);
			screen.wait(cardPaymentMode, 20);
			screen.click(cardPaymentMode);
			sleepWait(3000);
			screen.wait(cardOption, 20);
			screen.click(cardOption);
			keyDown();
			sleepWait(2000);
			screen.wait(homePage.blankScreen, 20);
			screen.click(homePage.blankScreen);
			sleepWait(3000);
			screen.wait(cardNumber, 20);
			screen.click(cardNumber);
			screen.type(ExcelUtil.readColumnDataByOperatorid("Data", operatorid, "card.number"));
			sleepWait(3000);
			screen.wait(expirationDate, 20);
			screen.click(expirationDate);
			keyDown();
			keyDown();
			keyDown();
			keyDown();
			keyDown();
			sleepWait(2000);
			screen.wait(homePage.blankScreen, 20);
			screen.click(homePage.blankScreen);
			sleepWait(3000);
			screen.wait(expirationYear, 20);
			screen.click(expirationYear);
			keyDown();
			keyDown();
			keyDown();
			keyDown();
			keyDown();
			sleepWait(2000);
			screen.wait(homePage.blankScreen, 20);
			screen.click(homePage.blankScreen);
			sleepWait(3000);
			screen.wait(securityCode, 20);
			screen.click(securityCode);
			screen.type(ExcelUtil.readColumnDataByOperatorid("Data", operatorid, "security.code"));
			sleepWait(3000);
			screen.wait(zipCode, 20);
			screen.click(zipCode);
			screen.type(ExcelUtil.readColumnDataByOperatorid("Data", operatorid, "zip.code"));
			screen.wait(donePayment, 20);
			screen.click(donePayment);
			sleepWait(3000);
			screen.wait(changeDue, 20);
			screen.find(changeDue);
			screen.wait(close, 20);
			screen.click(close);
			sleepWait(3000);
			if (screen.exists(printGiftReceipt) != null) {
				screen.wait(cancelButton, 20);
				screen.click(cancelButton);
			} else {
				homePage.clickOK();
			}
			homePage.clickHomeButton();
			homePage.scrollForward();
			screen.wait(shiftAndDrawerPage.showJournal, 20);
			screen.click(shiftAndDrawerPage.showJournal);
			sleepWait(2000);
			screen.wait(shiftAndDrawerPage.showReceipt, 20);
			screen.click(shiftAndDrawerPage.showReceipt);
			sleepWait(2000);
			keyDown();
			keyEnter();
			sleepWait(3000);
			if (screen.find(shiftAndDrawerPage.productReceipt) != null) {
				isReceptGenerated = true;
				Reporter.log("Sales Transaction is successfully done with card payment and receipt is generated.");
			} else {
				Reporter.log("Sales Transaction is successfully done with card payment and receipt is not generated.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isReceptGenerated;
	}

	/* Sales transaction with credit card payment */
	public boolean salesTransactionWithCard(String operatorid) {
		boolean isReceptGenerated = false;
		try {
			screen.wait(currentTransaction, 20);
			screen.click(currentTransaction);
			sleepWait(2000);
			screen.wait(searchBar, 20);
			screen.click(searchBar);
			screen.type(searchBar, ExcelUtil.readColumnDataByOperatorid("Data", operatorid, "product.id"));
			keyEnter();
			sleepWait(2000);
			screen.wait(sellNow, 20);
			screen.click(sellNow);
			sleepWait(2000);
			screen.wait(clickOrderTotal, 20);
			screen.click(clickOrderTotal);
			sleepWait(4000);
			screen.wait(cardPaymentMode, 20);
			screen.click(cardPaymentMode);
			sleepWait(3000);
			screen.wait(cardOption, 20);
			screen.click(cardOption);
			keyDown();
			sleepWait(2000);
			screen.wait(homePage.blankScreen, 20);
			screen.click(homePage.blankScreen);
			sleepWait(3000);
			screen.wait(cardNumber, 20);
			screen.click(cardNumber);
			screen.type(ExcelUtil.readColumnDataByOperatorid("Data", operatorid, "card.number"));
			sleepWait(3000);
			screen.wait(expirationDate, 20);
			screen.click(expirationDate);
			keyDown();
			keyDown();
			keyDown();
			keyDown();
			sleepWait(2000);
			screen.wait(homePage.blankScreen, 20);
			screen.click(homePage.blankScreen);
			sleepWait(3000);
			screen.wait(expirationYear, 20);
			screen.click(expirationYear);
			keyDown();
			keyDown();
			keyDown();
			keyDown();
			sleepWait(2000);
			screen.wait(homePage.blankScreen, 20);
			screen.click(homePage.blankScreen);
			sleepWait(3000);
			screen.wait(securityCode, 20);
			screen.click(securityCode);
			screen.type(ExcelUtil.readColumnDataByOperatorid("Data", operatorid, "security.code"));
			sleepWait(3000);
			screen.wait(zipCode, 20);
			screen.click(zipCode);
			screen.type(ExcelUtil.readColumnDataByOperatorid("Data", operatorid, "zip.code"));
			screen.wait(donePayment, 20);
			screen.click(donePayment);
			sleepWait(3000);
			screen.wait(changeDue, 20);
			screen.find(changeDue);
			screen.wait(close, 20);
			screen.click(close);
			sleepWait(3000);
			if (screen.exists(printGiftReceipt) != null) {
				screen.wait(cancelButton, 20);
				screen.click(cancelButton);
			} else {
				homePage.clickOK();
			}
			homePage.clickHomeButton();
			homePage.scrollForward();
			screen.wait(shiftAndDrawerPage.showJournal, 20);
			screen.click(shiftAndDrawerPage.showJournal);
			sleepWait(2000);
			screen.wait(shiftAndDrawerPage.showReceipt, 20);
			screen.click(shiftAndDrawerPage.showReceipt);
			sleepWait(2000);
			keyDown();
			keyEnter();
			sleepWait(3000);
			if (screen.find(shiftAndDrawerPage.productReceipt) != null) {
				isReceptGenerated = true;
				Reporter.log("Sales Transaction is successfully done with cash+card payment and receipt is generated.");
			} else {
				Reporter.log("Sales Transaction is successfully done with card payment and receipt is not generated.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isReceptGenerated;
	}
}