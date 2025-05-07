package testcase;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class User_Others_OpeningReports {
		Logger logger = LogManager.getLogger(User_Others_OpeningReports.class);
		WebDriver driver = Instance.getInstance();
		Properties prop = PropertiesFile.readPropertyFile("User_Others_OpeningReports.properties");
		
		@Test(priority=14,enabled=true)
		public void OpeningReportsForOthers() throws InterruptedException {
			Thread.sleep(5000);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			Thread.sleep(3000);
			jse.executeScript("window.scrollBy(0,700)");
			Thread.sleep(4000);
			driver.findElement(By.xpath(prop.getProperty("j_mcbrpt_searchbar"))).sendKeys("AJXAHU");
			Thread.sleep(4000);
			driver.findElement(By.xpath(prop.getProperty("j_mcbrpt_searchbtn"))).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(prop.getProperty("j_rprt_click"))).click();
			Thread.sleep(2000);
			jse.executeScript("window.scrollBy(0,-700)");
			Thread.sleep(2000);
			long lastHeight = (long) jse.executeScript("return document.body.scrollHeight");

			while (true) {
			    jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			    Thread.sleep(3000); // Wait for content to load

			    long newHeight = (long) jse.executeScript("return document.body.scrollHeight");
			    if (newHeight == lastHeight) 
			    {
			        break;
			    }
			    lastHeight = newHeight;
			}
			jse.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(3000);
			WebElement innerScrollDiv = driver.findElement(By.xpath(prop.getProperty("j_innerscroll"))); // Replace selector
	        jse.executeScript("arguments[0].scrollTop = 400;", innerScrollDiv); // Vertical scroll
	        Thread.sleep(1000);
	        driver.findElement(By.xpath(prop.getProperty("j_reg_details"))).click();
			Thread.sleep(3000);
			jse.executeScript("window.scrollBy(0,700)");
			Thread.sleep(3000);
			jse.executeScript("window.scrollBy(0,-700)");
			Thread.sleep(2000);
			jse.executeScript("arguments[0].scrollTop = -200;", innerScrollDiv);
			Thread.sleep(3000);
			driver.findElement(By.xpath(prop.getProperty("j_share_report"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(prop.getProperty("j_copylink"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(prop.getProperty("j_close"))).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(prop.getProperty("j_schedulecall"))).click();
			Thread.sleep(5000);
			jse.executeScript("window.scrollBy(0,700)");
			Thread.sleep(3000);
			jse.executeScript("window.scrollBy(0,-700)");
			Thread.sleep(3000);
			driver.navigate().back();
			Thread.sleep(2000);
			jse.executeScript("window.scrollBy(0,-100)");
			Thread.sleep(2000);
			driver.findElement(By.xpath(prop.getProperty("j_ab_logo"))).click();
			logger.info("Opening Report is successfull");
			}
}
