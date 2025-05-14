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

public class Cat_View_AllReports {
	Logger logger = LogManager.getLogger(Cat_View_AllReports.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Cat_View_AllReports.properties");
	
	
	@Test(priority=5,enabled=true)
	public void ClickingOnViewAndAllReportsForACat() throws InterruptedException {
		Thread.sleep(10000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		//clicking on the view button
		driver.findElement(By.xpath(prop.getProperty("petsearch"))).sendKeys("sera");
		Thread.sleep(4000);
		driver.findElement(By.name(prop.getProperty("searchbutton"))).click();
		Thread.sleep(8000);
		WebElement targetelement = driver.findElement(By.xpath(prop.getProperty("j_mousehover")));
		Actions action = new Actions(driver);
		action.moveToElement(targetelement).perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_viewbutton"))).click();
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(0,-500)");
		logger.info("clicked on the view button from pet portal home of the pet");
		
		//clicking on the all reports button
		driver.findElement(By.xpath(prop.getProperty("j_allreportbutton"))).click();
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(0,-300)");
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_petportalhome"))).click();
		logger.info("clicked on the allreports button from view pet details page");
		
		// clicking on the Report button 
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("petsearch"))).sendKeys("sera");
		Thread.sleep(4000);
		driver.findElement(By.name(prop.getProperty("searchbutton"))).click();
		Thread.sleep(8000);
		WebElement targetelement1 = driver.findElement(By.xpath(prop.getProperty("j_mousehover")));
		Actions action1 = new Actions(driver);
		action1.moveToElement(targetelement1).perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_reportbutton"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("j_petportalhome"))).click();
		logger.info("clicked on the report button from pet portal home of the pet");
	}
	
	
}


