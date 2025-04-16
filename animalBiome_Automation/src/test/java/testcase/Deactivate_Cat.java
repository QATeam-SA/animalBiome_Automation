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

public class Deactivate_Cat {
	Logger logger = LogManager.getLogger(Deactivate_Cat.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Deactivate_Cat.properties");
	
	@Test(priority=11,enabled=true)
	public void DeactivatingAndViewAllReportsOfCat() throws InterruptedException {
		  Thread.sleep(10000); 
		  JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		  //deactivate pet from grid view 
		  driver.findElement(By.xpath(prop.getProperty("petsearch"))).sendKeys("dido4"); 
		  Thread.sleep(4000);
		  driver.findElement(By.name(prop.getProperty("searchbutton"))).click();
		  Thread.sleep(8000); WebElement targetelement =
		  driver.findElement(By.xpath(prop.getProperty("j_mousehover"))); 
		  Actions action = new Actions(driver); 
		  action.moveToElement(targetelement).perform();
		  Thread.sleep(4000);
		  driver.findElement(By.xpath(prop.getProperty("j_deactivatebtn"))).click();
		  Thread.sleep(4000);
		  driver.findElement(By.xpath(prop.getProperty("j_search_clearbtn"))).click();
		  logger.info("deactivated the pet in grid view");
		  
		  //deactivate pet from list view
		  Thread.sleep(4000);
		  driver.findElement(By.xpath(prop.getProperty("j_listview"))).click();
		  Thread.sleep(4000);
		  driver.findElement(By.xpath(prop.getProperty("petsearch"))).sendKeys("dido3"); 
		  Thread.sleep(4000);
		  driver.findElement(By.name(prop.getProperty("searchbutton"))).click();
		  Thread.sleep(8000);
		  driver.findElement(By.xpath(prop.getProperty("j_deactivebtn_listview"))).click(); 
		  Thread.sleep(6000);
		  driver.findElement(By.xpath(prop.getProperty("j_search_clearbtn"))).click();
		  Thread.sleep(5000);
		  logger.info("deactivated the pet in list view");
		 
		  //view deactivated pet grid view
		  driver.findElement(By.xpath(prop.getProperty("j_myaccount"))).click();
		  Thread.sleep(4000);
		  driver.findElement(By.xpath(prop.getProperty("j_userprofile"))).click();
		  Thread.sleep(4000); 
		  jse.executeScript("window.scrollBy(0,200)");
		  Thread.sleep(4000);
		  driver.findElement(By.xpath(prop.getProperty("j_petsearch_userprofile"))).sendKeys("dido4"); 
		  Thread.sleep(4000);
		  driver.findElement(By.name(prop.getProperty("searchbutton"))).click();
		  Thread.sleep(8000); 
		  WebElement targetelement1 =driver.findElement(By.xpath(prop.getProperty("j_mousehover"))); 
		  Actions action1 = new Actions(driver);
		  action1.moveToElement(targetelement1).perform(); 
		  Thread.sleep(4000);
		  driver.findElement(By.xpath(prop.getProperty("j_userprofile_viewbutton"))).click(); 
		  Thread.sleep(8000); 
		  jse.executeScript("window.scrollBy(0,300)");
		  Thread.sleep(4000); 
		  jse.executeScript("window.scrollBy(0,-300)");
		  Thread.sleep(4000);
		  driver.findElement(By.xpath(prop.getProperty("j_userprofile_petportalhome"))).click();
		  logger.info(" view deactivated the pet in grid view");
		  
		  
		  //view deactivated pet list view
		  driver.findElement(By.xpath(prop.getProperty("j_myaccount"))).click();
		  Thread.sleep(4000);
		  driver.findElement(By.xpath(prop.getProperty("j_userprofile"))).click();
		  Thread.sleep(4000); jse.executeScript("window.scrollBy(0,200)");
		  Thread.sleep(4000);
		  driver.findElement(By.xpath(prop.getProperty("j_listview"))).click();
		  Thread.sleep(4000);
		  driver.findElement(By.xpath(prop.getProperty("j_petsearch_userprofile"))).sendKeys("dido4"); 
		  Thread.sleep(4000);
		  driver.findElement(By.name(prop.getProperty("searchbutton"))).click();
		  Thread.sleep(8000); 
		  driver.findElement(By.xpath(prop.getProperty("j_list_viewbtn"))).click(); 
		  Thread.sleep(8000); 
		  jse.executeScript("window.scrollBy(0,300)");
		  Thread.sleep(4000); 
		  jse.executeScript("window.scrollBy(0,-300)");
		  Thread.sleep(4000);
		  driver.findElement(By.xpath(prop.getProperty("j_userprofile_petportalhome"))).click(); Thread.sleep(2000);
		  logger.info(" view deactivated the pet in list view");
		 
		
		
		//all reports of a deactivated pet
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_myaccount"))).click();
		  Thread.sleep(4000);
		  driver.findElement(By.xpath(prop.getProperty("j_userprofile"))).click();
		  Thread.sleep(4000); 
		  jse.executeScript("window.scrollBy(0,200)");
		  Thread.sleep(4000);
		  driver.findElement(By.xpath(prop.getProperty("j_petsearch_userprofile"))).sendKeys("orio"); 
		  Thread.sleep(4000);
		  driver.findElement(By.name(prop.getProperty("searchbutton"))).click();
		  Thread.sleep(8000); 
		  WebElement targetelement3 = driver.findElement(By.xpath(prop.getProperty("j_mousehover"))); Actions
		  action3 = new Actions(driver);
		  action3.moveToElement(targetelement3).perform(); Thread.sleep(4000);
		  driver.findElement(By.xpath(prop.getProperty("j_userprofile_viewbutton"))).click(); 
		  Thread.sleep(6000); 
		  driver.findElement(By.xpath(prop.getProperty("j_userprofile_allrptbutton"))).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(prop.getProperty("j_sampleid_searchbtn"))).sendKeys("RFAAEC");
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
