package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;
	public  ExtentReports extent;
	public ExtentTest test;
	String repname;
public void onStart(ITestContext context) {
		String timestamp=new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		repname="Test-report-"+timestamp+".html";
		sparkReporter=new ExtentSparkReporter(".\\reports"+repname);
		sparkReporter.config().setDocumentTitle("RestAssuredAutomation Project");
		sparkReporter.config().setReportName("PetStore users Api");
		sparkReporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Pet store users Api");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Vinita");
		
		
		
	}
public void onTestSuccess(ITestResult result) {
	test=extent.createTest(result.getName());
	test.assignCategory(result.getMethod().getGroups());
	test.createNode(result.getName());
	test.log(Status.PASS, "Passed");
}
public void onTestFailure(ITestResult result) {
	test=extent.createTest(result.getName());
	test.assignCategory(result.getMethod().getGroups());
	test.createNode(result.getName());
	test.log(Status.FAIL, "Failed");
	test.log(Status.FAIL, result.getThrowable().getMessage());
}

public void onTestSkipped(ITestResult result) {
	test=extent.createTest(result.getName());
	test.assignCategory(result.getMethod().getGroups());
	test.createNode(result.getName());
	test.log(Status.SKIP, "Skipped");
	test.log(Status.SKIP, result.getThrowable().getMessage());
}
	public void onTestStart(ITestResult result) {
		
	}

	



	

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
