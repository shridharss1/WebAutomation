package CoreUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
public static WebDriver driver;	
	
	
public static void LaunchApp()
	{
				
		System.setProperty("webdriver.chrome.driver", "C:\\Shridhar\\Learnings\\Eclipse_Workspace\\AutoFramework\\src\\main\\java\\CoreUtils\\chromedriver.exe");
		driver=new ChromeDriver();
        		
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in");	
		
	}
	

	public static void CloseApp()
	{
		driver.quit();		
		
	}

	public static void gotoBaseURL() {
		driver.navigate().to("https://www.amazon.in");
	}
}
