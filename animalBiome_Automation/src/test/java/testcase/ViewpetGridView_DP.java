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

public class ViewpetGridView_DP {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("ViewpetGridView_DP.properties");
	Logger logger = LogManager.getLogger(ViewpetGridView_DP.class);
	@Test(priority = 5, enabled = true)
	public void ViewingDeactivatedPetFromGridView() throws InterruptedException {
		Thread.sleep(8000);
		logger.info("***** Started viewing the deactivated pet from grid view *******");
		driver.findElement(By.xpath(prop.getProperty("Nmyaccount"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("Nuserprofile"))).click();
		Thread.sleep(2000);
		WebElement sr = driver.findElement(By.xpath(prop.getProperty("Nsearchbox")));
		sr.click();
		sr.sendKeys(prop.getProperty("Ntext"));
		Thread.sleep(1000);
		WebElement e = driver.findElement(By.xpath(prop.getProperty("Nsearchbt")));
		Thread.sleep(2000);
		e.click();
		Thread.sleep(4000);
		e.click();
		Thread.sleep(2000);

		Actions mv = new Actions(driver);
		mv.moveToElement(driver.findElement(By.xpath(prop.getProperty("Nfb")))).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("Nv"))).click();
		logger.info("***** Viewed the deactivated pet succesfully from grid view *******");

	}
}