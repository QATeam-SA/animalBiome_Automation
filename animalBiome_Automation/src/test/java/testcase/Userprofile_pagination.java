package testcase;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class Userprofile_pagination {
	Logger logger = LogManager.getLogger(Userprofile_pagination.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Userprofile_pagination.properties");
	
	@Test(priority=16,enabled=true)
	public void ClickingOnPaginationFromUserpofile() throws InterruptedException {
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		driver.findElement(By.xpath(prop.getProperty("j_myacnt_userprofile"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_userprofile"))).click();
		Thread.sleep(2000); 
		jse.executeScript("window.scrollBy(0,900)");
		Thread.sleep(7000);
		driver.findElement(By.xpath(prop.getProperty("j_pagination_fwd"))).click();
		Thread.sleep(4000);
		jse.executeScript("window.scrollBy(0,700)");
		driver.findElement(By.xpath(prop.getProperty("j_pagination_dfwd"))).click();
		Thread.sleep(4000);
		jse.executeScript("window.scrollBy(0,700)");
		driver.findElement(By.xpath(prop.getProperty("j_pagination_bckwd"))).click();
		Thread.sleep(4000);
		jse.executeScript("window.scrollBy(0,700)");
		driver.findElement(By.xpath(prop.getProperty("j_pagination_dbckwd"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_petportlhome"))).click();
		logger.info("paginations are clicked successfully");
	}
}
