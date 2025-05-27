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

public class User_Others_Petsearchbar {
	Logger logger = LogManager.getLogger(User_Others_Petsearchbar.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("User_Others_Petsearchbar.properties");
	
	
	@Test(enabled=true)
	public void SearchingPetInTheSearchBar() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_petsearch"))).sendKeys("Donkey");
		Thread.sleep(3000);
		driver.findElement(By.name(prop.getProperty("j_searchbutton"))).click();
		Thread.sleep(7000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchbar =wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("j_clearsearch"))));
        searchbar.click();
		logger.info("Search bar clicked successfully");
}
}

