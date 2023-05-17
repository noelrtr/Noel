package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import com.pagemanager.PageObjectManager;
import com.pages.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC6_CancelBooking extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@When("User cancel the order id")
	public void userCancelTheOrderId() {
		pom.getMyBookingPage().cancelBooking();
	}

	@Then("User should verify success message after cancel the order id {string}")
	public void userShouldVerifySuccessMessageAfterCancelTheOrderId(String expCancelledMsg) {
		WebElement txtCancelledSuccessMessage = pom.getMyBookingPage().getTxtCancelledSuccessMessage();
		String actCancelledMsg = getTextValue(txtCancelledSuccessMessage);
		Assert.assertTrue("Verify Booking cancelled successfully msg", actCancelledMsg.contains(expCancelledMsg));
	}

}
