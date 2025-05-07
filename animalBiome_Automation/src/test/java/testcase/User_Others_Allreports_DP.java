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

public class User_Others_Allreports_DP {
	Logger logger = LogManager.getLogger(User_Others_Allreports_DP.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("User_Others_Allreports_DP.properties");
	
	@Test(priority=14,enabled=true)
	public void DeletingOtherDeactivatedPetInListView() throws InterruptedException 
	{
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		driver.findElement(By.xpath(prop.getProperty("j_myaccount"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_userprofile"))).click();
		Thread.sleep(4000); 
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_petsearch_userprofile"))).sendKeys("Bird_Goose"); 
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_searchbtn_userprofile"))).click();
		Thread.sleep(8000); 
		WebElement targetelement = driver.findElement(By.xpath(prop.getProperty("j_mousehover"))); 
		Actions action = new Actions(driver);
		action.moveToElement(targetelement).perform(); 
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_userprofile_viewbutton"))).click(); 
		Thread.sleep(6000); 
		driver.findElement(By.xpath(prop.getProperty("j_userprofile_allrptbutton"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_sampleid_searchbtn"))).sendKeys("RNGRCE");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_sample_searchbtn"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_viewreport"))).click();
		Thread.sleep(8000);
		driver.navigate().back();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_report_petportalhome"))).click();
		logger.info(" clicked on all reports for deactivated  pet ");
	}
}