package testcase;

import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class SearchBar {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("SearchBar.properties");
	Logger logger = LogManager.getLogger(SearchBar.class);
	@Test(enabled = true)
	public void SearchButton() throws InterruptedException {
		Thread.sleep(4000);
		logger.info("***** Started testing Search buttin in the home page *******");
		driver.findElement(By.xpath(prop.getProperty("N_Ab_Logo"))).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(prop.getProperty("N_HorseSearch"))).sendKeys(prop.getProperty("N_Horse_Name"));
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("N_SearchButton"))));
		searchBtn.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Crossed"))).click();
		logger.info("*****Search buttin tested properly in the home page *******");
}
}