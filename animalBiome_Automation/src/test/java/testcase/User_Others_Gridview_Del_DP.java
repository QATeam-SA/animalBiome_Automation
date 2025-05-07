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

public class User_Others_Gridview_Del_DP {
	Logger logger = LogManager.getLogger(User_Others_Gridview_Del_DP.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("User_Others_Gridview_Del_DP.properties");
	
	@Test(priority=13,enabled=true)
	public void DeletingOtherDeactivatedPetInGridView() throws InterruptedException 
	{
		Thread.sleep(6000);
		driver.findElement(By.xpath(prop.getProperty("j_myaccount"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_userprofile"))).click();
		Thread.sleep(4000); 
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(4000);
		WebElement targetelement = driver.findElement(By.xpath(prop.getProperty("j_mousehover")));
		Actions action = new Actions(driver);
		action.moveToElement(targetelement).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_delbtn_uprfl"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_del_popup"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_petportlhome"))).click();
		logger.info("pet deleted successfully");
	}
}

