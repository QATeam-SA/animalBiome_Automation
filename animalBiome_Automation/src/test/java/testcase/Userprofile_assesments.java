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

public class Userprofile_assesments {
	Logger logger = LogManager.getLogger(Userprofile_assesments.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Userprofile_assesments.properties");
	
	@Test(priority=14,enabled=true)
	public void userprofile_cat() throws InterruptedException {
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		driver.findElement(By.xpath(prop.getProperty("j_myacnt_userprofile"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_userprofile"))).click();
		Thread.sleep(2000); 
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_editprofile"))).click();
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath(prop.getProperty("j_radiobutton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_updatebtn"))).click();
		Thread.sleep(2000);
		logger.info("Assesements by default is updated");
		
		
		
	}
}
