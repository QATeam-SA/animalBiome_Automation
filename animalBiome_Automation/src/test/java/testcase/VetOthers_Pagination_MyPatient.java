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

public class VetOthers_Pagination_MyPatient {
	Logger logger = LogManager.getLogger(VetOthers_Pagination_MyPatient.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("VetOthers_Pagination_MyPatient.properties");
	
	@Test(priority=16,enabled=true)
	public void ClickingOnPaginationFromHomepage() throws InterruptedException {
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(2000); 
		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("j_pagination_Fwd"))).click();
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_pagination_Dfwd"))).click();
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_pagination_Bckwd"))).click();
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_pagination_Dbckwd"))).click();
		Thread.sleep(5000);
		logger.info("My Patient paginations are clicked successfully");
	}
}
