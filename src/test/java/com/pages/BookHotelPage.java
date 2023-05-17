package com.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.datatable.DataTable;

public class BookHotelPage extends BaseClass {
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value='own']")
	private WebElement radioBtnMySelf;
	@FindBy(id = "user_title")
	private WebElement ddnUserTitle;
	@FindBy(id = "first_name")
	private WebElement txtFirstName;
	@FindBy(id = "last_name")
	private WebElement txtLastName;
	@FindBy(id = "user_phone")
	private WebElement txtPhone;
	@FindBy(id = "user_email")
	private WebElement txtEmail;
	@FindBy(id = "step1next")
	private WebElement btnNextBtn1;
	@FindBy(id = "step2next")
	private WebElement btnNextBtn2;

	@FindBy(xpath = "//div[@class='credit-card pm']")
	private WebElement linkSelectCardPayment;
	@FindBy(id = "payment_type")
	private WebElement ddnPaymentCardType;
	@FindBy(id = "card_type")
	private WebElement ddnSelectcardType;
	@FindBy(id = "card_no")
	private WebElement txtCardNumber;
	@FindBy(id = "card_name")
	private WebElement txtNameOnCard;
	@FindBy(id = "card_month")
	private WebElement ddnCardMonth;
	@FindBy(id = "card_year")
	private WebElement ddnCardYear;
	@FindBy(id = "cvv")
	private WebElement txtCVV;
	@FindBy(id = "submitBtn")
	private WebElement btnSubmitCardPayment;
	@FindBy(id = "invalid-card_no")
	private WebElement txtInvalidCardNumber;

	@FindBy(xpath = "//h5[text()='UPI']")
	private WebElement linkUPI;
	@FindBy(id = "upi_id")
	private WebElement txtUpiId;
	@FindBy(id = "submitBtn")
	private WebElement btnSubmitUpiPayment;
	@FindBy(id = "invalid-upi")
	private WebElement txtInvalidUpiId;

	@FindBy(xpath = "//h2[text()=' Booking is Confirmed ']")
	private WebElement txtBookingConfirmMsg;

	public WebElement getRadioBtnMySelf() {
		return radioBtnMySelf;
	}

	public WebElement getDdnUserTitle() {
		return ddnUserTitle;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtPhone() {
		return txtPhone;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getBtnNextBtn1() {
		return btnNextBtn1;
	}

	public WebElement getBtnNextBtn2() {
		return btnNextBtn2;
	}

	public WebElement getLinkSelectCardPayment() {
		return linkSelectCardPayment;
	}

	public WebElement getDdnPaymentCardType() {
		return ddnPaymentCardType;
	}

	public WebElement getDdnSelectcardType() {
		return ddnSelectcardType;
	}

	public WebElement getTxtCardNumber() {
		return txtCardNumber;
	}

	public WebElement getTxtNameOnCard() {
		return txtNameOnCard;
	}

	public WebElement getDdnCardMonth() {
		return ddnCardMonth;
	}

	public WebElement getDdnCardYear() {
		return ddnCardYear;
	}

	public WebElement getTxtCVV() {
		return txtCVV;
	}

	public WebElement getBtnSubmitCardPayment() {
		return btnSubmitCardPayment;
	}

	public WebElement getTxtInvalidCardNumber() {
		return txtInvalidCardNumber;
	}

	public WebElement getLinkUPI() {
		return linkUPI;
	}

	public WebElement getTxtUpiId() {
		return txtUpiId;
	}

	public WebElement getBtnSubmitUpiPayment() {
		return btnSubmitUpiPayment;
	}

	public WebElement getTxtInvalidUpiId() {
		return txtInvalidUpiId;
	}

	public WebElement getTxtBookingConfirmMsg() {
		return txtBookingConfirmMsg;
	}

	// 1.Book hotel without including GST-Card(Credit-card-VISA)-without special
	// request
	// 3.Enter invalid card details and verify error message
	public void bookHotel(String userTitle, String firstName, String lastName, String phone, String email,
			String paymentCardType, String cardType, String cardNumber, String nameOnCard, String cardMonth,
			String cardYear, String CVV) throws InterruptedException {
		Thread.sleep(2000);
		addGuestDetails(userTitle, firstName, lastName, phone, email);
		addPaymentDetails(paymentCardType, cardType, cardNumber, nameOnCard, cardMonth, cardYear, CVV);

	}

	// 2.Enter invalid UPI id and verify error message
	public void bookHotelwithUPI(String userTitle, String firstName, String lastName, String phone, String email,
			String upiId) throws InterruptedException {
		addGuestDetails(userTitle, firstName, lastName, phone, email);
		Thread.sleep(2000);
		clickBtn(getLinkUPI());
		sendValues(getTxtUpiId(), upiId);
		clickBtn(getBtnSubmitUpiPayment());
	}

	public void addGuestDetails(String userTitle, String firstName, String lastName, String phone, String email)
			throws InterruptedException {
		Thread.sleep(2000);
		jsClickBtn(getRadioBtnMySelf());
		selectbyVisibleText(getDdnUserTitle(), userTitle);
		sendValues(getTxtFirstName(), firstName);
		sendValues(getTxtLastName(), lastName);
		sendValues(getTxtPhone(), phone);
		sendValues(getTxtEmail(), email);
		clickBtn(getBtnNextBtn1());
		clickBtn(getBtnNextBtn2());
	}

	public void addPaymentDetails(String paymentCardType, String cardType, String cardNumber, String nameOnCard,
			String cardMonth, String cardYear, String CVV) throws InterruptedException {
		Thread.sleep(2000);
		clickBtn(getLinkSelectCardPayment());
		selectbyVisibleText(getDdnPaymentCardType(), paymentCardType);
		selectbyVisibleText(getDdnSelectcardType(), cardType);
		sendValues(getTxtCardNumber(), cardNumber);
		sendValues(getTxtNameOnCard(), nameOnCard);
		selectbyVisibleText(getDdnCardMonth(), cardMonth);
		selectbyVisibleText(getDdnCardYear(), cardYear);
		sendValues(getTxtCVV(), CVV);
		clickBtn(getBtnSubmitCardPayment());
	}

	public void paymentCardType(String paymentCardType, DataTable cardDetails) {
		clickBtn(getLinkSelectCardPayment());
		selectbyVisibleText(getDdnPaymentCardType(), paymentCardType);
		List<Map<String, String>> data = cardDetails.asMaps();
		Map<String, String> value = data.get(0);
		String cardType = value.get("Select Card");
		String cardNumber = value.get("Card Number");
		String nameOnCard = value.get("Name On Card");
		String month = value.get("Month");
		String year = value.get("Year");
		String cvv = value.get("CVV");
		sendValues(getDdnSelectcardType(), cardType);
		sendValues(getTxtCardNumber(), cardNumber);
		sendValues(getTxtNameOnCard(), nameOnCard);
		sendValues(getDdnCardMonth(), month);
		sendValues(getDdnCardYear(), year);
		sendValues(getTxtCVV(), cvv);
		clickBtn(getBtnSubmitCardPayment());
	}

	public void upiPayment(String upiId) {
		clickBtn(getLinkUPI());
		sendValues(getTxtUpiId(), upiId);
		clickBtn(getBtnSubmitUpiPayment());
	}
}
