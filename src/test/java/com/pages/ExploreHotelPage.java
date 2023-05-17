package com.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExploreHotelPage extends BaseClass {
	public ExploreHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h3[text()='Hotel Booking']")
	private WebElement linkHotelBooking;
	@FindBy(id = "state")
	private WebElement ddnState;
	@FindBy(id = "city")
	private WebElement ddnCity;
	@FindBy(id = "room_type")
	private WebElement ddnRoomType;
	@FindBy(name = "check_in")
	private WebElement jsCheckInDate;
	@FindBy(name = "check_out")
	private WebElement jsCheckOutDate;
	@FindBy(id = "no_rooms")
	private WebElement ddnNoOfRooms;
	@FindBy(id = "no_adults")
	private WebElement ddnAdultsPerRoom;
	@FindBy(id = "no_child")
	private WebElement txtChildrenPerRoom;
	@FindBy(id = "hotelsearch_iframe")
	private WebElement frame;
	@FindBy(xpath = "//button[text()='Search']")
	private WebElement btnSearch;
	@FindBy(id = "invalid-state")
	private WebElement invalidState;
	@FindBy(id = "invalid-city")
	private WebElement invalidCity;
	@FindBy(id = "invalid-check_in")
	private WebElement invalidCheckIn;
	@FindBy(id = "invalid-check_out")
	private WebElement invalidCheckOut;
	@FindBy(id = "invalid-no_rooms")
	private WebElement invalidNoOfRooms;
	@FindBy(id = "invalid-no_adults")
	private WebElement invalidNoOfAdults;
	@FindBy(xpath = "//div[@id='hotellist']//h5")
	private List<WebElement> listRoomType;
	@FindBy(xpath = "//h5[text()='Select Hotel']")
	private WebElement txtSelectHotelSuccessMessage;
	@FindBy(xpath = "//a[@id='room_type']")
	private WebElement txtRoomTypeHeader;

	public WebElement getLinkHotelBooking() {
		return linkHotelBooking;
	}

	public WebElement getDdnState() {
		return ddnState;
	}

	public WebElement getDdnCity() {
		return ddnCity;
	}

	public WebElement getDdnRoomType() {
		return ddnRoomType;
	}

	public WebElement getJsCheckInDate() {
		return jsCheckInDate;
	}

	public WebElement getJsCheckOutDate() {
		return jsCheckOutDate;
	}

	public WebElement getDdnNoOfRooms() {
		return ddnNoOfRooms;
	}

	public WebElement getDdnAdultsPerRoom() {
		return ddnAdultsPerRoom;
	}

	public WebElement getTxtChildrenPerRoom() {
		return txtChildrenPerRoom;
	}

	public WebElement getFrame() {
		return frame;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public List<WebElement> getListRoomType() {
		return listRoomType;
	}

	public WebElement getTxtSelectHotelSuccessMessage() {
		return txtSelectHotelSuccessMessage;
	}

	public WebElement getTxtRoomTypeHeader() {
		return txtRoomTypeHeader;
	}

	public WebElement getInvalidState() {
		return invalidState;
	}

	public WebElement getInvalidCity() {
		return invalidCity;
	}

	public WebElement getInvalidCheckIn() {
		return invalidCheckIn;
	}

	public WebElement getInvalidCheckOut() {
		return invalidCheckOut;
	}

	public WebElement getInvalidNoOfRooms() {
		return invalidNoOfRooms;
	}

	public WebElement getInvalidNoOfAdults() {
		return invalidNoOfAdults;
	}

	// 1.Enter all fields and verify select hotel(including options)
	// 2.Select multiple room type and verify same filters in header
	public void exploreHotels(String state, String city, String roomType, String checkInDate, String checkOutDate,
			String noOfRooms, String adultsPerRoom, String childrenPerRoom) {
		clickBtn(getLinkHotelBooking());
		selectbyVisibleText(getDdnState(), state);
		selectbyVisibleText(getDdnCity(), city);
		boolean b = roomType.contains("/");
		if (b) {
			String[] split = roomType.split("/");
			for (int i = 0; i < split.length; i++) {
				selectbyVisibleText(getDdnRoomType(), split[i]);
			}
		} else {
			selectbyVisibleText(getDdnRoomType(), roomType);
		}
		jsSetAttributeValue(getJsCheckInDate(), checkInDate);
		jsSetAttributeValue(getJsCheckOutDate(), checkOutDate);
		selectbyVisibleText(getDdnNoOfRooms(), noOfRooms);
		selectbyVisibleText(getDdnAdultsPerRoom(), adultsPerRoom);
		sendValues(getTxtChildrenPerRoom(), childrenPerRoom);
		switchToFrameId(getFrame());
		clickBtn(getBtnSearch());
	}

	// 3.passing room type and verify filter is listed
	public List<Boolean> verifyHotelNameEndsWithRoomType(String roomType) {
		List<Boolean> listHotel = new ArrayList<Boolean>();
		List<WebElement> listRoomTypeHotel = getListRoomType();
		for (WebElement eachHotelElement : listRoomTypeHotel) {
			String eachHotelName = getTextValue(eachHotelElement);
			boolean isHotelEndsWith = eachHotelName.contains(roomType);
			listHotel.add(isHotelEndsWith);
		}
		return listHotel;
	}

	// 4.Without enter any field click search and verify all 6 error message
	public void exploreHotelsWithoutEnterValues() {
		clickBtn(getLinkHotelBooking());
		switchToFrame(getFrame());
		clickBtn(getBtnSearch());
		switchToDefaultContent();
	}
}
