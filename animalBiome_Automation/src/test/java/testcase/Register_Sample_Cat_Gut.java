package testcase;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class Register_Sample_Cat_Gut {
	Logger logger = LogManager.getLogger(Register_Sample_Cat_Gut.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Register_Sample_Cat_Gut.properties");
	
	@Test(priority=9,enabled=true)
	public void RegisteringGutSampleForACat() throws InterruptedException 
	{
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		logger.info("Gut sample registration process has been started");
		driver.findElement(By.xpath(prop.getProperty("j_reg_sample"))).click();
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,200)");
		WebElement e =driver.findElement(By.xpath(prop.getProperty("j_selectpet")));
		Select sp = new Select(e);
		 Thread.sleep(2000);
		sp.selectByVisibleText("Aaqua");
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,200)");
		WebElement e1 =driver.findElement(By.xpath(prop.getProperty("j_sample")));
		Select st = new Select(e1);
		 Thread.sleep(2000);
		st.selectByIndex(1);
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath(prop.getProperty("j_Fecal_C"))).click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath(prop.getProperty("j_fecal_color"))).click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath(prop.getProperty("j_test_submission"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_click_sample"))).sendKeys(prop.getProperty("j_Sample_Id"));
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_Calender"))).click();
		Thread.sleep(10000); 
		driver.switchTo();
		driver.findElement(By.xpath(prop.getProperty("j_Date"))).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath(prop.getProperty("j_next_btn"))).click();
	    Thread.sleep(3000);
	    jse.executeScript("window.scrollBy(0,700)");
	    Thread.sleep(4000);
	    driver.findElement(By.xpath(prop.getProperty("j_complete_btn"))).click();
	    Thread.sleep(9000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(10000);
	    driver.findElement(By.xpath(prop.getProperty("j_view_petportal"))).click();
	    Thread.sleep(3000);
	    logger.info("Gut sample registration process has been completed");
		
	}
}
