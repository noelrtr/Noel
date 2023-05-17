package com.stepdefinition;

import java.awt.AWTException;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import com.pagemanager.PageObjectManager;
import com.pages.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_LoginStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the OMR Branch hotel page")
	public void userIsOnTheOMRBranchHotelPage() {
	}

	@When("User login {string},{string}")
	public void userLogin(String username, String password) {
		pom.getLoginPage().login(username, password);
	}

	@Then("User should verify success message after login {string}")
	public void userShouldVerifySuccessMessageAfterLogin(String expLoginSuccessMsg) {
		WebElement txtLoginSuccessMessage = pom.getLoginPage().getTxtLoginSuccessMessage();
		String actLoginSuccessMsg = getTextValue(txtLoginSuccessMessage);
		Assert.assertEquals("Verify after login success msg", expLoginSuccessMsg, actLoginSuccessMsg);
	}

	@When("User login using keyboard actions {string},{string}")
	public void userLoginUsingKeyboardActions(String username, String password) throws AWTException {
		pom.getLoginPage().loginWithRobotClass(username, password);
	}

	@Then("User should verify error message after login {string}")
	public void userShouldVerifyErrorMessageAfterLogin(String expLoginErrorMsg) {
		WebElement txtLoginErrorMessage = pom.getLoginPage().getTxtLoginErrorMessage();
		String actLoginErrorMsg = getTextValue(txtLoginErrorMessage);
		Assert.assertTrue("Verify login error msg", actLoginErrorMsg.contains(expLoginErrorMsg));
	}

}
