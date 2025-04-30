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

public class Others_Pagination_MyPet {
	Logger logger = LogManager.getLogger(Others_Pagination_MyPet.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Others_Pagination_MyPet.properties");
	
	@Test(priority=16,enabled=true)
	public void ClickingOnPaginationFromHomepage() throws InterruptedException {
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(2000); 
		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(7000);
		driver.findElement(By.xpath(prop.getProperty("j_pagination_Fwd"))).click();
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath(prop.getProperty("j_pagination_Dfwd"))).click();
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath(prop.getProperty("j_pagination_Bckwd"))).click();
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath(prop.getProperty("j_pagination_Dbckwd"))).click();
		Thread.sleep(3000);
		logger.info("My Pet paginations are clicked successfully");
	}
}
