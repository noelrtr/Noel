package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmPage extends BaseClass {

	public BookingConfirmPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-testid='username']")
	private WebElement linkWelcomeMsg;
	@FindBy(xpath = "//a[text()='My Account']")
	private WebElement linkMyAccount;
	@FindBy(xpath = "//input[@name='search']")
	private WebElement txtSearchBox;
	@FindBy(xpath = "//h2[text()=' Booking is Confirmed ']")
	private WebElement txtBookingConfirmMsg;

	public WebElement getLinkWelcomeMsg() {
		return linkWelcomeMsg;
	}

	public WebElement getLinkMyAccount() {
		return linkMyAccount;
	}

	public WebElement getTxtSearchBox() {
		return txtSearchBox;
	}

	public WebElement getTxtBookingConfirmMsg() {
		return txtBookingConfirmMsg;
	}

	public String orderId;

	public void orderId() {
		String Id = getTxtBookingConfirmMsg().getText();
		String[] split = Id.split(" ");
		String id = split[0];
		orderId = id.substring(1);
	}

	public void orderIdSearch() throws InterruptedException {
		Thread.sleep(2000);
		jsClickBtn(getLinkWelcomeMsg());
		jsClickBtn(getLinkMyAccount());
		jsSetAttributeValue(getTxtSearchBox(), orderId);
	}
}
