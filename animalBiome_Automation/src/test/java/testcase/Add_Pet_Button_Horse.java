package testcase;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class Add_Pet_Button_Horse {
	Logger logger = LogManager.getLogger(Add_Pet_Button_Horse.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Add_Pet_Button_Horse.properties");

	@Test(enabled = true)
	public void ClickingAddPetButton() throws InterruptedException {
		Thread.sleep(4000);
		/*
		 * driver.findElement(By.xpath(prop.getProperty("NHome"))).click();
		 * Thread.sleep(2000);
		 */
		driver.findElement(By.xpath(prop.getProperty("NADDPET"))).click();
		Thread.sleep(2000);
		driver.navigate().back();
		logger.info("Add pet button clicked successfully");
	}
}
