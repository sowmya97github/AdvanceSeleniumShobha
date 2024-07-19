package Generic_Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportImplementation implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result)
	{
	 test=report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS,result.getMethod().getMethodName() );
		test.log(Status.PASS,result.getThrowable() );
	}

	public void onTestFailure(ITestResult result)
	{
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
		System.out.println("<--------I am Listening----------->");
		 
		String screenShot=null;
		
			try {
screenShot = WebDriver_utility.takeScreenShot(BaseClass.sDriver, result.getMethod().getMethodName());
			} catch (Throwable e) {
				
				e.printStackTrace();
			}
	
		test.addScreenCaptureFromPath(screenShot);
	
}
	public void onTestSkipped(ITestResult result)
	{
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
		
	}

	public void onStart(ITestContext context)
	{
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReports/Report.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Testing");
		spark.config().setReportName("Shobha");
		
		report=new ExtentReports();
		
		report.attachReporter(spark);
		report.setSystemInfo("platform", "windows10");
		report.setSystemInfo("executed by", "shobha");
		report.setSystemInfo("reviewed by", "Rathin");
		
	}

	public void onFinish(ITestContext context)
	{
		report.flush();
	}

	

}
