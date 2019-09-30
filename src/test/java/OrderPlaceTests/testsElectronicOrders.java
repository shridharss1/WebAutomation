package OrderPlaceTests;

import java.lang.reflect.Method;

import org.seleniumhq.jetty9.server.HomeBaseWarning;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import CoreUtils.BaseClass;
import CoreUtils.ExtentTestManager;
import POMLibrary.homePagePOM;

public class testsElectronicOrders {

	@Test(priority=1, description="Search Obronics Products")
	public void testSearchObronic (Method method) {
		
		//ExtentTestManager.getTest().setDescription("Test to Search Obronics Products");
		SoftAssert sa = new SoftAssert();
		ExtentTestManager.startTest(method.getName(), "Test to Search Obronics Products");
		BaseClass.LaunchApp();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Application Launched");
		homePagePOM hpage = new homePagePOM(BaseClass.driver);
		hpage.setProductSearch("Bluetooth Headphones");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Search done with Text Bluetooth Headphones");
		hpage.clickSearchButton();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify wheather Obronics product Exists");
		sa.assertTrue(hpage.verifyObronicProductExists());
		sa.assertAll();
		
	}
	@Test(priority=2, description="Search JBL Products")
	public void testSearchJBL (Method method) {
		SoftAssert sa = new SoftAssert();
		ExtentTestManager.startTest(method.getName(), "Test to Search JBL Products");
		BaseClass.gotoBaseURL();
		homePagePOM hpage = new homePagePOM(BaseClass.driver);
		hpage.setProductSearch("Bluetooth Headphones");
		hpage.clickSearchButton();
		sa.assertTrue(hpage.verifyJBLProductExists());
		BaseClass.CloseApp();
		sa.assertAll();
	}
	
}
