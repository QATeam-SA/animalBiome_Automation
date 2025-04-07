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

public class List_Grid_views {
	Logger logger = LogManager.getLogger(List_Grid_views.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("List_Grid_views.properties");
	
	@Test(priority=15,enabled=true)
	public void list_grid_views() throws InterruptedException {
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		driver.findElement(By.xpath(prop.getProperty("j_myacnt_userprofile"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_userprofile"))).click();
		Thread.sleep(2000); 
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_listview"))).click();
		logger.info("successfully clicked on listview");
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("j_gridview"))).click();
		logger.info("successfully clicked on gridview");
	}
	
	
	
}
