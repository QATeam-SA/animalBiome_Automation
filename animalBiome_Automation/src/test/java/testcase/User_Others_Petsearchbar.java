package testcase;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class User_Others_Petsearchbar {
	Logger logger = LogManager.getLogger(User_Others_Petsearchbar.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("User_Others_Petsearchbar.properties");
	
	
	@Test(priority=17,enabled=true)
	public void SearchingPetInTheSearchBar() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_petsearch"))).sendKeys("Donkey");
		Thread.sleep(3000);
		driver.findElement(By.name(prop.getProperty("j_searchbutton"))).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath(prop.getProperty("j_clearsearch"))).click();
		logger.info("Search bar clicked successfully");
}
}

