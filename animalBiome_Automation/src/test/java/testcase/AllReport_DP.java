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

public class AllReport_DP {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("AllReport_DP.properties");
	Logger logger = LogManager.getLogger(AllReport_DP.class);
	@Test(priority = 7, enabled = true)
	public void ViewingTheAllReportsForADeactivatedDog() throws InterruptedException {
		Thread.sleep(8000);
		logger.info("***** Started vieing report by clicking all report for deactivated pet*******");
		driver.findElement(By.xpath(prop.getProperty("Nmyaccount"))).click();
		driver.findElement(By.xpath(prop.getProperty("Nuserprofile"))).click();
		Thread.sleep(2000);
		WebElement sr = driver.findElement(By.xpath(prop.getProperty("Nsearchbox")));
		sr.click();
		sr.sendKeys(prop.getProperty("Ntext"));
		Thread.sleep(1000);
		WebElement d=driver.findElement(By.xpath(prop.getProperty("Nsearchbt")));
		Thread.sleep(2000);
		d.click();
		Thread.sleep(2000);
		d.click();
		Thread.sleep(4000);

		Actions mv = new Actions(driver);
		mv.moveToElement(driver.findElement(By.xpath(prop.getProperty("Nfb")))).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("Nv"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Nallreport"))).click();
		logger.info("All report button clicked successfully for deactivated pet");
		Thread.sleep(500);
		WebElement s = driver.findElement(By.xpath(prop.getProperty("Nsr")));
		s.click();
		s.sendKeys(prop.getProperty("Nsrb"));
		Thread.sleep(500);
		driver.findElement(By.xpath(prop.getProperty("Nsrch"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("Nvw"))).click();
		logger.info("***** Viewed the report successfully for deactivated pet*******");

	}
}
