package testcase;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class View_Horse_Listview_DP {

	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("View_Horse_Listview_DP.properties");
	Logger logger = LogManager.getLogger(View_Horse_Listview_DP.class);
	@Test(enabled = true)
	public void ViewingDeactivatedHorseFromListView() throws InterruptedException {
		Thread.sleep(4000);
		logger.info("***** Started viewing the deactivated Horse from list view *******");
		driver.findElement(By.xpath(prop.getProperty("Nmyaccount"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("Nuserprofile"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Nlv"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Nlviewb"))).click();
		logger.info("***** Viewed the deactivated Horse succesfully from list view *******");

	}
}