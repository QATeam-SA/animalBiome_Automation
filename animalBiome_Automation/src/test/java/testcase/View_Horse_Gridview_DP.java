package testcase;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class View_Horse_Gridview_DP {

	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("View_Horse_Gridview_DP.properties");
	Logger logger = LogManager.getLogger(View_Horse_Gridview_DP.class);
	@Test(enabled = true)
	public void ViewingDeactivatedHorseFromGridView() throws InterruptedException {
		Thread.sleep(4000);
		logger.info("***** Started viewing the deactivated Horse from grid view *******");
		driver.findElement(By.xpath(prop.getProperty("Nmyaccount"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("Nuserprofile"))).click();
		Thread.sleep(2000);
		Actions mv = new Actions(driver);
		mv.moveToElement(driver.findElement(By.xpath(prop.getProperty("Nfb")))).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("Nv"))).click();
		logger.info("***** Viewed the deactivated Horse succesfully from grid view *******");

	}
}