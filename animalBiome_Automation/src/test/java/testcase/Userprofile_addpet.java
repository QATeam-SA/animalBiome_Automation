package testcase;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class Userprofile_addpet {
	Logger logger = LogManager.getLogger(Userprofile_addpet.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Userprofile_addpet.properties");
	
	@Test(priority=16,enabled=true)
	public void ClickAddPetButton() throws InterruptedException 
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_addpet_uprfle"))).click();
		Thread.sleep(4000);
		driver.navigate().back();
		logger.info("Add pet button clicked successfully");
	}
}
