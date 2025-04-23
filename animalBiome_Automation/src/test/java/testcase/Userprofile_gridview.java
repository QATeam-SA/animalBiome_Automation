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

public class Userprofile_gridview {
	Logger logger = LogManager.getLogger(Userprofile_gridview.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Userprofile_gridview.properties");
	
	@Test(priority=9,enabled=true)
	public void ViewAndEditAndDeletePetDetailsFromGridview() throws InterruptedException 
	{
		//view pet details
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		driver.findElement(By.xpath(prop.getProperty("j_myacnt_userprofile"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_userprofile"))).click();
		Thread.sleep(2000); 
		jse.executeScript("window.scrollBy(0,300)");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_searchbar"))).sendKeys("nepo"); 
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_searchbtn"))).click();
		Thread.sleep(3000);
		 
		WebElement targetelement = driver.findElement(By.xpath(prop.getProperty("j_mousehover")));
		Actions action = new Actions(driver);
		action.moveToElement(targetelement).perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_viewbtn_uprfl"))).click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,600)");
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,-400)");
		Thread.sleep(3000);
		logger.info("view pet details is successfull");
		driver.navigate().back();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_petportlhome"))).click();
	
		//edit pet details
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_myacnt_userprofile"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_userprofile"))).click();
		Thread.sleep(2000); 
		
		driver.findElement(By.xpath(prop.getProperty("j_searchbar"))).sendKeys("nepo"); 
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_searchbtn"))).click();
		Thread.sleep(3000);
		 
		WebElement targetelement1 = driver.findElement(By.xpath(prop.getProperty("j_mousehover")));
		Actions action1 = new Actions(driver);
		action1.moveToElement(targetelement1).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_editbtn_uprfl"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_nxtbtn"))).click();
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_antibiotics_amoxicillin"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_ph_nxtbtn"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_cmpltebtn"))).click();
		Thread.sleep(3000);
		logger.info("Edit pet details is successfull");
		driver.findElement(By.xpath(prop.getProperty("j_viewpoertalbtn"))).click();
		
		//delete pet in grid view in userprofile
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_myacnt_userprofile"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_userprofile"))).click();
		/*
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath(prop.getProperty("j_searchbar"))).sendKeys(
		 * "chant"); Thread.sleep(3000);
		 * driver.findElement(By.xpath(prop.getProperty("j_searchbtn"))).click();
		 */
		Thread.sleep(3000);
		WebElement targetelement2 = driver.findElement(By.xpath(prop.getProperty("j_mousehover")));
		Actions action2 = new Actions(driver);
		action2.moveToElement(targetelement2).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_delbtn_uprfl"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_del_popup"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_petportlhome"))).click();
		logger.info("pet deleted successfully");
		
		
	}
	
	
	
	
}
