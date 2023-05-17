package com.stepdefinition;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import com.pagemanager.PageObjectManager;
import com.pages.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC2_ExploreHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@When("User search hotels {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userSearchHotelsAnd(String state, String city, String roomType, String checkInDate, String checkOutDate,
			String noOfRooms, String adultsPerRoom, String childrenPerRoom) {
		pom.getExploreHotelPage().exploreHotels(state, city, roomType, checkInDate, checkOutDate, noOfRooms,
				adultsPerRoom, childrenPerRoom);
	}

	@Then("User should verify success message after search hotels {string}")
	public void userShouldVerifySuccessMessageAfterSearchHotels(String expSelectHotelSuccessMsg) {
		WebElement txtSelectHotelSuccessMessage = pom.getExploreHotelPage().getTxtSelectHotelSuccessMessage();
		String actSelectHotelSuccessMsg = getTextValue(txtSelectHotelSuccessMessage);
		Assert.assertEquals("Verify success message select hotel", expSelectHotelSuccessMsg, actSelectHotelSuccessMsg);
	}

	@Then("User should verify selected room types are present in header {string}")
	public void userShouldVerifySelectedRoomTypesArePresentInHeader(String expRoomTypeHeader) {
		WebElement txtRoomTypeHeader = pom.getExploreHotelPage().getTxtRoomTypeHeader();
		String actRoomTypeHeader = getTextValue(txtRoomTypeHeader);
		Assert.assertEquals("Verify room type header", expRoomTypeHeader, actRoomTypeHeader);
	}

	@Then("User should verify listed hotel names are ends with same as room type {string}")
	public void userShouldVerifyListedHotelNamesAreEndsWithSameAsRoomType(String roomType) {
		List<Boolean> verifyHotelNameEndsWithRoomType = pom.getExploreHotelPage()
				.verifyHotelNameEndsWithRoomType(roomType);
		// true--invalid room type false--->valid room type
		boolean isRoomType = verifyHotelNameEndsWithRoomType.contains(false);
		Assert.assertFalse("Verify room type endswith", isRoomType);
	}

	@When("User search hotels without enter any values and click search button")
	public void userSearchHotelsWithoutEnterAnyValuesAndClickSearchButton() {
		pom.getExploreHotelPage().exploreHotelsWithoutEnterValues();
	}

	@Then("User should verify all {int} error message {string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyAllErrorMessageAnd(Integer count, String expInvalidState, String expInvalidCity,
			String expInvalidCheckIn, String expInvalidCheckOut, String expInvalidNoOfRooms,
			String expInvalidNoOfAdults) {
		WebElement invalidState = pom.getExploreHotelPage().getInvalidState();
		String actInvalidState = getTextValue(invalidState);
		Assert.assertEquals("Verify invalid state", expInvalidState, actInvalidState);
		WebElement invalidCity = pom.getExploreHotelPage().getInvalidCity();
		String actInvalidCity = getTextValue(invalidCity);
		Assert.assertEquals("Verify invalid city", expInvalidCity, actInvalidCity);
		WebElement invalidCheckIn = pom.getExploreHotelPage().getInvalidCheckIn();
		String actInvalidCheckIn = getTextValue(invalidCheckIn);
		Assert.assertEquals("Verify invalid checkIn", expInvalidCheckIn, actInvalidCheckIn);
		WebElement invalidCheckOut = pom.getExploreHotelPage().getInvalidCheckOut();
		String actInvalidCheckOut = getTextValue(invalidCheckOut);
		Assert.assertEquals("Verify invalid checkOut", expInvalidCheckOut, actInvalidCheckOut);
		WebElement invalidNoOfRooms = pom.getExploreHotelPage().getInvalidNoOfRooms();
		String actInvalidNoOfRooms = getTextValue(invalidNoOfRooms);
		Assert.assertEquals("Verify invalid noOfRooms", expInvalidNoOfRooms, actInvalidNoOfRooms);
		WebElement invalidNoOfAdults = pom.getExploreHotelPage().getInvalidNoOfAdults();
		String actInvalidNoOfAdults = getTextValue(invalidNoOfAdults);
		Assert.assertEquals("Verify invalid noOfAdults", expInvalidNoOfAdults, actInvalidNoOfAdults);
	}

}
