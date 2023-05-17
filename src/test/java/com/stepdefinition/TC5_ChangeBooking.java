package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import com.pagemanager.PageObjectManager;
import com.pages.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC5_ChangeBooking extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Then("User should verify success message after booking hotel {string} and save the order id")
	public void userShouldVerifySuccessMessageAfterBookingHotelAndSaveTheOrderId(String expBookingConfirmMsg) {
		WebElement txtBookingConfirmMsg = pom.getBookHotelPage().getTxtBookingConfirmMsg();
		String actBookingConfirmMsg = getTextValue(txtBookingConfirmMsg);
		Assert.assertTrue("Verify booking confirmation msg", actBookingConfirmMsg.contains(expBookingConfirmMsg));
	}

	@When("User navigates to My booking page and enter order id")
	public void userNavigatesToMyBookingPageAndEnterOrderId() throws InterruptedException {
		pom.getBookingConfirmPage().orderIdSearch();
	}

	@Then("User should verify order id and hotel name are same")
	public void userShouldVerifyOrderIdAndHotelNameAreSame() {
	}

	@When("User edit the order id {string}")
	public void userEditTheOrderId(String checkIn) {
		pom.getMyBookingPage().changeBooking(checkIn);
	}

	@Then("User should verify success message after editing the order id {string}")
	public void userShouldVerifySuccessMessageAfterEditingTheOrderId(String expUpdatedSuccessMsg) {
		WebElement txtUpdatedSuccessMessage = pom.getMyBookingPage().getTxtUpdatedSuccessMessage();
		String actUpdatedSuccessMsg = getTextValue(txtUpdatedSuccessMessage);
		Assert.assertTrue("Verify Booking updated successfully msg",
				actUpdatedSuccessMsg.contains(expUpdatedSuccessMsg));
	}
}
