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

public class User_Others_ReportSearchbar {
	Logger logger = LogManager.getLogger(User_Others_ReportSearchbar.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("User_Others_ReportSearchbar.properties");
	
	
	@Test(priority=20,enabled=true)
	public void SearchingreportInTheMbReportSearchBar() throws InterruptedException {
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(2000); 
		jse.executeScript("window.scrollBy(0,700)");
		Thread.sleep(7000);
		driver.findElement(By.xpath(prop.getProperty("j_mcbrpt_searchbar"))).sendKeys("AJXAHU");
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_mcbrpt_searchbtn"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_mcbrpt_clearsrch"))).click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(3000);
		logger.info("MicrobiomeReport search is clicked successfully");
}
}