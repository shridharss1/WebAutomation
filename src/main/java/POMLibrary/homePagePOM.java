package POMLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CoreUtils.BaseClass;

public class homePagePOM {

	By txtProductSearch=By.xpath("//input[@id='twotabsearchtextbox']");
	By lblObronicProduct = By.xpath("//span[contains(text(),'CrossBeats PULSE IPX5 Bluetooth In-Ear Sports CVC')]");
	By lblJBLProduct = By.xpath("//span[contains(text(),'JBL Bluetooth In-Ear Sports CVC')]");
	By btn_Search=By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']");
	public static WebDriver driver;
	
	public homePagePOM(WebDriver driver){
		this.driver=driver;
	}	
	public void setProductSearch (String strProductName) {	
		
		driver.findElement(txtProductSearch).sendKeys(strProductName);	
	}
	public void clickSearchButton() {
		driver.findElement(btn_Search).click();
	}
	public boolean verifyObronicProductExists() {
		return driver.findElement(lblObronicProduct).isDisplayed();
	}
	public boolean verifyJBLProductExists() {
		return driver.findElement(lblJBLProduct).isDisplayed();
	}
}
