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

public class Userprofile_searchbtn {
	Logger logger = LogManager.getLogger(Userprofile_searchbtn.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Userprofile_searchbtn.properties");
	
	@Test(priority=16,enabled=true)
	public void ClickingOnSearchBarInUserProfile() throws InterruptedException 
	{
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		driver.findElement(By.xpath(prop.getProperty("j_myacnt_userprofile"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_userprofile"))).click();
		Thread.sleep(2000); 
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_searchbar"))).sendKeys("terex");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_searchbtn"))).click();	
		Thread.sleep(6000);
		driver.findElement(By.xpath(prop.getProperty("j_clearsearch"))).click();
		Thread.sleep(6000);
		logger.info("Search button is clicked succesfully");
	}
	
}
