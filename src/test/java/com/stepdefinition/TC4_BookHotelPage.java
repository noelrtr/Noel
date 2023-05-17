package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import com.pagemanager.PageObjectManager;
import com.pages.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC4_BookHotelPage extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Then("User add guest details without enter GST details and special request {string},{string},{string},{string} and {string}")
	public void userAddGuestDetailsWithoutEnterGSTDetailsAndSpecialRequestAnd(String salutation, String firstname,
			String lastname, String mobile, String email) throws InterruptedException {
		pom.getBookHotelPage().addGuestDetails(salutation, firstname, lastname, mobile, email);
	}

	@When("User enter payment details,proceed with card type {string}")
	public void userEnterPaymentDetailsProceedWithCardType(String paymentCardType,
			io.cucumber.datatable.DataTable cardDetails) {
		pom.getBookHotelPage().paymentCardType(paymentCardType, cardDetails);
	}

	@Then("User should verify success message after booking hotel {string}")
	public void userShouldVerifySuccessMessageAfterBookingHotel(String expBookingConfirmMsg) {
		WebElement txtBookingConfirmMsg = pom.getBookHotelPage().getTxtBookingConfirmMsg();
		String actBookingConfirmMsg = getTextValue(txtBookingConfirmMsg);
		Assert.assertTrue("Verify booking confirmation msg", actBookingConfirmMsg.contains(expBookingConfirmMsg));
	}

	@Then("User should verify Booked hotel name is same as the saved hotel name")
	public void userShouldVerifyBookedHotelNameIsSameAsTheSavedHotelName() {
	}

	@When("User select UPI payment and enter payment details {string}")
	public void userSelectUPIPaymentAndEnterPaymentDetails(String upiId) {
		pom.getBookHotelPage().upiPayment(upiId);
	}

	@Then("User should verify error message after upiPayment {string}")
	public void userShouldVerifyErrorMessageAfterUpiPayment(String expInvalidUPIPayment) {
		WebElement txtInvalidUpiId = pom.getBookHotelPage().getTxtInvalidUpiId();
		String actInvalidUPIPayment = getTextValue(txtInvalidUpiId);
		Assert.assertTrue("Verify Invalid UPI Payment Msg", actInvalidUPIPayment.contains(expInvalidUPIPayment));
	}

	@Then("User should verify error message after cardPayment {string}")
	public void userShouldVerifyErrorMessageAfterCardPayment(String expInvalidCardPayment) {
		WebElement txtInvalidCardNumber = pom.getBookHotelPage().getTxtInvalidCardNumber();
		String actInvalidCardPayment = getTextValue(txtInvalidCardNumber);
		Assert.assertTrue("Verify Invalid Card Payment Msg", actInvalidCardPayment.contains(expInvalidCardPayment));
	}
}
