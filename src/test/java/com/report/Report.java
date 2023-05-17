package com.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Report {

	public static void generateJVMReports(String jsonFile) {
		File reportLoc = new File(System.getProperty("user.dir") + "\\target");
		Configuration configuration = new Configuration(reportLoc, "OMRBranchGroceryAPIAutomation");
		configuration.addClassifications("Platform", "Windows10");
		configuration.addClassifications("Author", "Vaijeyanthi");
		List<String> list = new ArrayList<>();
		list.add(jsonFile);
		ReportBuilder reportBuilder = new ReportBuilder(list, configuration);
		reportBuilder.generateReports();
	}
}
