package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.report.Report;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features", glue = "com\\stepdefinition", dryRun = false, monochrome = true, snippets = SnippetType.CAMELCASE, plugin = "json:target\\report.json")
public class TestRunnerClass {
	@AfterClass
	public static void afterClass() {
		Report.generateJVMReports(System.getProperty("user.dir") + "\\target\\report.json");

	}
}
