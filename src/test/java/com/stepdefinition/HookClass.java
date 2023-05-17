package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.pages.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HookClass extends BaseClass {
	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browser"));
		browserLaunch(getPropertyFileValue("url"));
		implicitWait();
	}

	@After
	public void afterScenario(Scenario scenario) {
		scenario.attach(screenshot(), "image/png", "Every Scenario");
		quitBrowser();
	}

}
