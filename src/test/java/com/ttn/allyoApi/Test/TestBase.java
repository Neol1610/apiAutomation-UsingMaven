package com.ttn.allyoApi.Test;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ttn.allyoApi.Utilities.GlobalVars;
import com.ttn.allyoApi.Utilities.Keywords;
import com.ttn.allyoApi.Utilities.Reporter;

public class TestBase {

	public static String Access_Token;
	public static Reporter reporter;
	public static String env = System.getProperty("env");
	public static String ver = System.getProperty("ver");

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		System.out.println("--------------@BeforeSuite--------------");
		Keywords.setURL(env);
		// System.out.println(GlobalVars.POST_URL);

		// Report Environment Directory
		try {
			GlobalVars.reportsDirEnv = Reporter.createResultFolderStructure();
			System.out.println(">>>>>>>>" + GlobalVars.reportsDirEnv);
			// String filPath = "API_Execution_Report" +".html";
			String filPath = GlobalVars.reportsDirEnv + "_API_Execution_Report" + ".html";
			reporter = new Reporter(filPath, true);
			System.out.println("FilePath ::" + filPath);

			File f = new File(filPath);

			System.out.println(f.exists() && !f.isDirectory());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {

	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) {

		System.out.println("Currently Executing API is :: " + method.getName());
		reporter.startTest((this.getClass().getSimpleName() + " :: " + method.getName()), method.getName());
		// reporter.assignCategory("QA","v15");
		reporter.assignCategory("", this.getClass().getSimpleName());

	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		reporter.endTest();
	}

	@AfterTest
	public void afterTest() {
	}

	@AfterSuite
	public void afterSuite() {
		reporter.close();

		String filPath = GlobalVars.reportsDirEnv + "_API_Execution_Report" + ".html";
		System.out.println("FilePath ::" + filPath);
		File f = new File(filPath);

		System.out.println(f.exists() && !f.isDirectory());

	}

}