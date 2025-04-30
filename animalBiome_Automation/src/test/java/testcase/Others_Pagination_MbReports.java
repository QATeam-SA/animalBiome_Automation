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

public class Others_Pagination_MbReports {
	Logger logger = LogManager.getLogger(Others_Pagination_MbReports.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Others_Pagination_MbReports.properties");
	
	@Test(priority=18,enabled=true)
	public void ClickingOnPaginationFromMicrobiomeReports() throws InterruptedException {
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(2000); 
		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(7000);
		driver.findElement(By.xpath(prop.getProperty("j_mbrpagination_Fwd"))).click();
		Thread.sleep(7000);
		jse.executeScript("window.scrollBy(0,-300)");
		driver.findElement(By.xpath(prop.getProperty("j_mbrpagination_Dfwd"))).click();
		Thread.sleep(7000);
		jse.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath(prop.getProperty("j_mbrpagination_Bckwd"))).click();
		Thread.sleep(7000);
		jse.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath(prop.getProperty("j_mbrpagination_Dbckwd"))).click();
		Thread.sleep(4000);
		logger.info("Microbiome Reports paginations are clicked successfully");
	}
}
