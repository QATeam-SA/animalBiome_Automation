package testcase;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class Deactivate_Horse_From_ListView {

	Logger logger = LogManager.getLogger(Deactivate_Horse_From_ListView.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Deactivate_Horse_From_ListView.properties");
	
	@Test(enabled = true)
	public void DeactivatingHorseFromListView() throws InterruptedException {
		Thread.sleep(4000);
		logger.info("***** Started deactivate Horse from list view*******");
		WebElement lv = driver.findElement(By.xpath(prop.getProperty("Nlistview")));
		lv.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("Ndeactivate"))).click();
		logger.info("***** Deactivate Horse from the List view successfully*******");
		
}
}