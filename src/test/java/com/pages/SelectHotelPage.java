package com.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage extends BaseClass {
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[text()='Continue'])[1]")
	private WebElement selectFirstHotel;
	@FindBy(xpath = "//h5[text()='Elite Grand Hotel Luxury']")
	private WebElement txtFirstHotelName;
	@FindBy(xpath = "//h2[contains(text(),'Book Hotel ')]")
	private WebElement txtBookHotelSuccessMessage;
	@FindBy(id = "value_nasc")
	private WebElement radioBtnNameAscending;
	@FindBy(id = "Luxury")
	private WebElement checkBoxLuxury;
	@FindBy(xpath = "//div[@id='hotellist']//h5")
	private List<WebElement> listOfHotelNames;

	public WebElement getSelectFirstHotel() {
		return selectFirstHotel;
	}

	public WebElement getTxtFirstHotelName() {
		return txtFirstHotelName;
	}

	public WebElement getTxtBookHotelSuccessMessage() {
		return txtBookHotelSuccessMessage;
	}

	public WebElement getRadioBtnNameAscending() {
		return radioBtnNameAscending;
	}

	public WebElement getCheckBoxLuxury() {
		return checkBoxLuxury;
	}

	public List<WebElement> getListOfHotelNames() {
		return listOfHotelNames;
	}

	// 1.Select hotel and verify navigate to book hotel upon accepting the alert
	public void selectHotelWithOk() {
		clickBtn(getSelectFirstHotel());
		acceptAlert();
	}

	// 2.Select hotel and verify navigating in the same page upon dismiss the alert
	public void selectHotelWithCancel() {
		clickBtn(getSelectFirstHotel());
		dismissAlert();
	}

	// 3.Sort name Ascending
	public boolean sortNameAscending() throws InterruptedException {
		Thread.sleep(2000);
		List<String> listHotelNameBeforeSort = new ArrayList<String>();
		List<WebElement> hotelNameElements = getListOfHotelNames();
		for (WebElement eachHotelElement : hotelNameElements) {
			String eachHotelName = getTextValue(eachHotelElement);
			listHotelNameBeforeSort.add(eachHotelName);
		}
		List<String> listHotelNameAfterSort = new ArrayList<String>();
		listHotelNameAfterSort.addAll(listHotelNameBeforeSort);
		Collections.sort(listHotelNameAfterSort);
		boolean isHotelNameAsc = listHotelNameBeforeSort.equals(listHotelNameAfterSort);
		return isHotelNameAsc;
	}

	// 4.Unselecting room type and verify listing all hotels
	public boolean unselectingRoomType() throws InterruptedException {
		Thread.sleep(2000);
		boolean isRoomTypeCount = false;
		List<WebElement> listHotelElementBeforeUnselect = getListOfHotelNames();
		int beforeCount = listHotelElementBeforeUnselect.size();
		List<WebElement> listHotelElementAfterUnselect = getListOfHotelNames();
		int afterCount = listHotelElementAfterUnselect.size();
		if (beforeCount == afterCount) {
			isRoomTypeCount = true;
		}
		return isRoomTypeCount;
	}

	public void sortNameascending() throws InterruptedException {
		Thread.sleep(2000);
		jsClickBtn(getRadioBtnNameAscending());
	}

	public void unSelectingRoomType() throws InterruptedException {
		Thread.sleep(2000);
		jsClickBtn(getCheckBoxLuxury());
	}
}