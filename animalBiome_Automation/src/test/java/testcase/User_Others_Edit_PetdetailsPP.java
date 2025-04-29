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

public class User_Others_Edit_PetdetailsPP {
	Logger logger = LogManager.getLogger(User_Others_Edit_PetdetailsPP.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("User_Others_Edit_PetdetailsPP.properties");
	
	@Test(priority=9,enabled=true)
	public void EditingTheOthersPetDetailsFromViewPetProfile() throws InterruptedException {
		Thread.sleep(10000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(6000);
		WebElement targetelement = driver.findElement(By.xpath(prop.getProperty("j_Mousehover")));
		Actions action = new Actions(driver);
		action.moveToElement(targetelement).perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_viewbutton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_Editpetbutton"))).click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_Nextbutton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_Antibiotics"))).click(); 
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_Supplements"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_Symptoms"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_Health_NextButton"))).click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_Complete"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_viewpetportal"))).click();
		Thread.sleep(3000);
		logger.info("pet details edited successfully from home page");
	}
}
