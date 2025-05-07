package testcase;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class User_Others_Grid_view_DP {
	Logger logger = LogManager.getLogger(User_Others_Grid_view_DP.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("User_Others_Grid_view_DP.properties");
	
	@Test(priority=13,enabled=true)
	public void ViewOtherDeactivatedPetInGridView() throws InterruptedException 
	{
		Thread.sleep(6000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_myaccount"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_userprofile"))).click();
		Thread.sleep(4000); 
		jse.executeScript("window.scrollBy(0,200)");
		WebElement targetelement =driver.findElement(By.xpath(prop.getProperty("j_mousehover"))); 
		Actions action = new Actions(driver); 
		action.moveToElement(targetelement).perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_view_dp"))).click();
		Thread.sleep(4000);
		jse.executeScript("window.scrollBy(0,600)");
		Thread.sleep(4000);
		jse.executeScript("window.scrollBy(0,-600)");
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_userprofile_petportalhome"))).click();
		logger.info("view deactivated pet in grid view is successfull");
	}
}
