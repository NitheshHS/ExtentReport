package com.sdet.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ListnerIMP implements ITestListener{
	private ExtentReports reports;
	private ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		 test = reports.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" is passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
		test.log(Status.FAIL, result.getThrowable());
		Object obj = result.getInstance();
		WebDriver driver=null;
		
			try {
				driver = (WebDriver)result.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver").get(obj);
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+result.getMethod().getMethodName()+".PNG");
		test.addScreenCaptureFromPath(dest.getAbsolutePath());
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		//step1: Extent report configuration
		ExtentSparkReporter htmlReporter=new ExtentSparkReporter("./extentReport.html");
		htmlReporter.config().setDocumentTitle("Vtiger");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("SmokeTest");
		
		 reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		//write system info: osname, platform, reportername, testing url, 
		reports.setSystemInfo("OS", System.getProperty("os.name"));
		reports.setSystemInfo("Browser", "chrome");
		reports.setSystemInfo("Reporter Name", "Nithesh");
		
	}

	@Override
	public void onFinish(ITestContext context) {//step2
		reports.flush();
		
	}

}
