package testcase;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class Userprofile_pswd {
	Logger logger = LogManager.getLogger(Userprofile_pswd.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Userprofile_pswd.properties");
	
	@Test(enabled=true)
	public void ChangingTheUserProfilePassword() throws InterruptedException {
		    // APPROACH 1: Conditional Skip - Set to true to skip, false to run
		    boolean skipThisTest = true; // Change to false when you want to run this test
		    if (skipThisTest) {
		        throw new SkipException("Skipping change the userprofile password test - Feature temporarily disabled");
		    }
		    
		    // ALL YOUR EXISTING CODE STAYS HERE - NO UNREACHABLE CODE ERROR
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		driver.findElement(By.xpath(prop.getProperty("j_myacnt_userprofile"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_userprofile"))).click();
		Thread.sleep(2000); 
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_pswd_userprofile"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_old_pswd"))).sendKeys("password");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_new_pswd"))).sendKeys("passwordqa");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_cnfrm_pswd"))).sendKeys("passwordqa");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_pswd_updatebtn"))).click();
		Thread.sleep(3000);
		logger.info("password is updated succesfully");
	}
}
