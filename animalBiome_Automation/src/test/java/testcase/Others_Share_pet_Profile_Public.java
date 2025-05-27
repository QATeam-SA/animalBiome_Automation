package testcase;

import java.util.ArrayList;
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

public class Others_Share_pet_Profile_Public {
	Logger logger = LogManager.getLogger(Others_Share_pet_Profile_Public.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Others_Share_pet_Profile_Public.properties");
	
	
	@Test(priority=14,enabled=true)
	public void SharingThePublicProfileForOthers() throws InterruptedException {
		Thread.sleep(10000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		driver.findElement(By.xpath(prop.getProperty("petsearch"))).sendKeys("hog insect");
		Thread.sleep(4000);
		driver.findElement(By.name(prop.getProperty("searchbutton"))).click();
		Thread.sleep(8000);
		WebElement targetelement = driver.findElement(By.xpath(prop.getProperty("j_mousehover")));
		Actions action = new Actions(driver);
		action.moveToElement(targetelement).perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_viewbutton"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_sharepetprofile"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_copylink"))).click();
		Thread.sleep(4000);
		String typedText =driver.findElement(By.xpath("//input[@readonly='readonly']")).getAttribute("value");
		System.out.println("public link is " + typedText);
		((JavascriptExecutor)driver).executeScript("window.open()"); 
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(4000);
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(4000);
		jse.executeScript("window.scrollBy(0,-300)");
		driver.get(typedText);
		Thread.sleep(4000); 
		driver.close(); 
		logger.info("public others pet profile is shared successfully");
		driver.switchTo().window(tabs.get(0)); 
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_closebutton"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_petportalhome"))).click();
		}
}
