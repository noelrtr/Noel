package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyBookingPage extends BaseClass {
	public MyBookingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Edit']")
	private WebElement btnEdit;
	@FindBy(name = "check_in")
	private WebElement txtChangeCkeckInDate;
	@FindBy(xpath = "//button[text()='Confirm']")
	private WebElement btnConfirm;
	@FindBy(xpath = "//li[text()='Booking updated successfully']")
	private WebElement txtUpdatedSuccessMessage;
	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElement btnCancel;
	@FindBy(xpath = "//li[text()='Your booking cancelled successfully']")
	private WebElement txtCancelledSuccessMessage;

	public WebElement getBtnEdit() {
		return btnEdit;
	}

	public WebElement getTxtChangeCkeckInDate() {
		return txtChangeCkeckInDate;
	}

	public WebElement getBtnConfirm() {
		return btnConfirm;
	}

	public WebElement getTxtUpdatedSuccessMessage() {
		return txtUpdatedSuccessMessage;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}

	public WebElement getTxtCancelledSuccessMessage() {
		return txtCancelledSuccessMessage;
	}

	// 1.Change Booking
	public void changeBooking(String checkIn) {
		jsClickBtn(getBtnEdit());
		jsSetAttributeValue(getTxtChangeCkeckInDate(), checkIn);
		clickBtn(getBtnConfirm());
	}

	// 2.Cancel Booking
	public void cancelBooking() {
		jsClickBtn(getBtnCancel());
		acceptAlert();
	}

	// 3.Change and Cancel Booking
	public void cancelBookingE2E(String checkIn) {
		changeBooking(checkIn);
		cancelBooking();
	}
}
