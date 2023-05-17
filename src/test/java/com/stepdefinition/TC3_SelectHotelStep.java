package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import com.pagemanager.PageObjectManager;
import com.pages.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC3_SelectHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@When("User Select first hotel name and save that hotel name")
	public void userSelectFirstHotelNameAndSaveThatHotelName() {
	}

	@Then("User handles the confirm alert by clicking OK button")
	public void userHandlesTheConfirmAlertByClickingOKButton() {
		pom.getSelectHotelPage().selectHotelWithOk();
	}

	@Then("User should verify success message after select hotels {string}")
	public void userShouldVerifySuccessMessageAfterSelectHotels(String expBookHotelSuccessMsg) {
		WebElement txtBookHotelSuccessMessage = pom.getSelectHotelPage().getTxtBookHotelSuccessMessage();
		String actBookHotelSuccessMsg = getTextValue(txtBookHotelSuccessMessage);
		Assert.assertTrue("Verify success message book hotel", actBookHotelSuccessMsg.contains(expBookHotelSuccessMsg));
	}

	@When("User handles the confirm alert by clicking cancel button")
	public void userHandlesTheConfirmAlertByClickingCancelButton() {
		pom.getSelectHotelPage().selectHotelWithCancel();
	}

	@When("User click name ascending radio button")
	public void userClickNameAscendingRadioButton() throws InterruptedException {
		pom.getSelectHotelPage().sortNameascending();
	}

	@Then("User should verify the hotel names in ascending order after clicking the name ascending radio button")
	public void userShouldVerifyTheHotelNamesInAscendingOrderAfterClickingTheNameAscendingRadioButton()
			throws InterruptedException {
		boolean sortNameAscending = pom.getSelectHotelPage().sortNameAscending();
		Assert.assertTrue("Verify Hotel name asc", sortNameAscending);
	}

	@When("User unselect the room type by clicking the room type checkbox")
	public void userUnselectTheRoomTypeByClickingTheRoomTypeCheckbox() throws InterruptedException {
		pom.getSelectHotelPage().unSelectingRoomType();
	}

	@Then("User should verify all the hotels are listed after unselect room type")
	public void userShouldVerifyAllTheHotelsAreListedAfterUnselectRoomType() throws InterruptedException {
		boolean unselectingRoomType = pom.getSelectHotelPage().unselectingRoomType();
		Assert.assertTrue("Verify unselect room type", unselectingRoomType);
	}
}
