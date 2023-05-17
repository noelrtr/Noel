package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	private WebElement txtUsername;
	@FindBy(id = "pass")
	private WebElement txtPassword;
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement btnLogin;
	@FindBy(xpath = "//a[contains(text(),'Vaijeyanthi')]")
	private WebElement txtLoginSuccessMessage;
	@FindBy(xpath = "//b[text()='Invalid Login details or Your Password might have expired. ']")
	private WebElement txtLoginErrorMessage;

	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getTxtLoginSuccessMessage() {
		return txtLoginSuccessMessage;
	}

	public WebElement getTxtLoginErrorMessage() {
		return txtLoginErrorMessage;
	}

	// 1.Valid data login
	// 3.Invalid data login
	public void login(String username, String password) {
		sendValues(getTxtUsername(), username);
		sendValues(getTxtPassword(), password);
		clickBtn(getBtnLogin());
	}

	// 2.Login with Robot- with help of keyboard actions
	public void loginWithRobotClass(String username, String password) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		sendValues(getTxtUsername(), username);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		sendValues(getTxtPassword(), password);
		for (int i = 0; i < 2; i++) {
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
		}
		clickBtn(getBtnLogin());
	}
}