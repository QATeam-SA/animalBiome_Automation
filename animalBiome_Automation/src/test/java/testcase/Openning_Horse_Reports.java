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

public class Openning_Horse_Reports {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Openning_Horse_Reports.properties");
	Logger logger = LogManager.getLogger(Openning_Horse_Reports.class);
	@Test(enabled = true)
	public void OpenningHorseReportFromMicrobiomeReport() throws InterruptedException {
		Thread.sleep(4000);
		logger.info("***** Started viewing Horse report in the microbiome report section*******");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 850);");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("N_Report_srch_Box"))).sendKeys(prop.getProperty("N_Sample_ID"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("N_Search_Btn"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Open_Report"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("N_Ab_Logo"))).click();
		System.out.println("Report viewed Successfully");
	}
}