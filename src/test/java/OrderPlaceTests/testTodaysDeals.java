package OrderPlaceTests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import CoreUtils.BaseClass;
import CoreUtils.ExtentTestManager;
import POMLibrary.todaysDealsPOM;

public class testTodaysDeals extends BaseClass {

	@Test
	public void testTodatsDeals(Method method) {
		SoftAssert sa = new SoftAssert();
		ExtentTestManager.startTest(method.getName(), "Test to Search Obronics Products");
		BaseClass.LaunchApp();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Application Launched");
		todaysDealsPOM tdpage=new todaysDealsPOM(BaseClass.driver);
		tdpage.clickTodaysDeals();
		sa.assertTrue(tdpage.verifyTodaysDealsText());
		BaseClass.CloseApp();
		sa.assertAll();
	}
}
