package POMLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class todaysDealsPOM {

	WebDriver driver;
	
	public todaysDealsPOM(WebDriver driver){
		this.driver=driver;
	}
	
	By lnkTodaysDeals=By.xpath("//a[@tabindex=21]");
	By lblTodayDeals=By.xpath("//h1[contains(text(),'Deal of the day')]");
	
	public void clickTodaysDeals() {
		driver.findElement(lnkTodaysDeals).click();
	}
	public boolean verifyTodaysDealsText() {
		return driver.findElement(lblTodayDeals).isDisplayed();
	}
}
