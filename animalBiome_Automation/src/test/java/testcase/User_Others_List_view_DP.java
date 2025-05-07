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

public class User_Others_List_view_DP {
	Logger logger = LogManager.getLogger(User_Others_List_view_DP.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("User_Others_List_view_DP.properties");
	
	@Test(priority=13,enabled=true)
	public void ViewOtherDeactivatedPetInListView() throws InterruptedException 
	{
		Thread.sleep(6000);
		driver.findElement(By.xpath(prop.getProperty("j_myaccount"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_userprofile"))).click();
		Thread.sleep(4000); 
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_listview"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_list_viewbtn"))).click(); 
		Thread.sleep(5000); 
		jse.executeScript("window.scrollBy(0,600)");
		Thread.sleep(4000); 
		jse.executeScript("window.scrollBy(0,-600)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_userprofile_petportalhome"))).click();
		logger.info(" viewed deactivated the pet in list view");
	}
}