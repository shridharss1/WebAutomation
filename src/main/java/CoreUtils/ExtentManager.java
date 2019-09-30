package CoreUtils;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;
	 
    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            String fileName = new SimpleDateFormat("yyyyMMddHHmm'.html'").format(new Date());
            extent = new ExtentReports(workingDir + "\\ExtentReports\\AmazonTests_RegressionResults_"+fileName, true);
        }
        return extent;
    }
}
