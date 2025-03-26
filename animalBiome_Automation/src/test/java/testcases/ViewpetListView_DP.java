package testcases;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class ViewpetListView_DP {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("ViewpetListView_DP.properties");
	Logger logger = LogManager.getLogger(ViewpetListView_DP.class);
	@Test(priority = 6, enabled = true)
	public void LviewpetDp() throws InterruptedException {
		Thread.sleep(8000);
		logger.info("***** Started viewing the deactivated pet from list view *******");
		driver.findElement(By.xpath(prop.getProperty("Nmyaccount"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("Nuserprofile"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Nlv"))).click();
		WebElement w = driver.findElement(By.xpath(prop.getProperty("Nsearchbox")));
		w.click();
		w.sendKeys(prop.getProperty("Ntext"));
		Thread.sleep(1000);
		WebElement e = driver.findElement(By.xpath(prop.getProperty("Nsearchbt")));
		Thread.sleep(3000);
		e.click();
		Thread.sleep(3000);
		e.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("Nlviewb"))).click();
		logger.info("***** Viewed the deactivated pet succesfully from list view *******");

	}
}
