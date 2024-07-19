package Generic_Utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class list implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result)
	{
		test=report.createTest(result.getName());	
	}

	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	public void onTestFailure(ITestResult result) {

		System.out.println("<--------I am Listening----------->");
        System.out.println("<--------I am Listening----------->");
        
		TakesScreenshot takesSceenShot = (TakesScreenshot)BaseClass.sDriver;
		File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
		LocalDateTime dateTime = LocalDateTime.now();
		String currentDateTime = dateTime.toString().replace(":", "_").replace(" ", "_");
		File dst = new File("./ScreenShots/" +"screenShotName"+currentDateTime+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result)
	{
		test.log(Status.SKIP,result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onStart(ITestContext context) {
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNumber();
		
ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/Report.html"+ranNum);
spark.config().setTheme(Theme.DARK);
spark.config().setDocumentTitle("Testing");
spark.config().setReportName("Shobha");

//system configuration
report=new ExtentReports();
	
report.attachReporter(spark);
report.setSystemInfo("platform", "windows10");
report.setSystemInfo("executed by", "shobha");
report.setSystemInfo("reviewed by", "rathin");
	}

	public void onFinish(ITestContext context)
	{
		report.flush();
	}

	
}
