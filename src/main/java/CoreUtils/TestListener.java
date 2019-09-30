package CoreUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

public class TestListener extends BaseClass implements ITestListener{

	private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
	
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("I am in onTestStart method " + getTestMethodName(result) + " start");
	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		 System.out.println("I am in onTestSuccess method " + getTestMethodName(result) + " succeed");
	        //ExtentReports log operation for passed tests.
	        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
		
	}

	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("I am in onTestFailure method " + getTestMethodName(result) + " failed");
		 
        //Get driver from BaseTest and assign to local webDriver variable.
        Object testClass = result.getInstance();
		WebDriver webDriver = BaseClass.driver;
 
        //Take base64Screenshot screenshot.
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);
 
        //ExtentReports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed", ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
		
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		 System.out.println("I am in onTestSkipped method " + getTestMethodName(result) + " skipped");
	        //ExtentReports log operation for skipped tests.
	        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(result));
		
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("I am in onStart method " + context.getName());
		context.setAttribute("WebDriver", this.driver);
		
	}

	
	public void onFinish(ITestContext context) {
		System.out.println("I am in onFinish method " + context.getName());
        //Do tier down operations for extentreports reporting!
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
		
	}

}
