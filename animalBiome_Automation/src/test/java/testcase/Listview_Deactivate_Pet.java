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

public class Listview_Deactivate_Pet {

		WebDriver driver = Instance.getInstance();
		Properties prop = PropertiesFile.readPropertyFile("Listview_Deactivate_Pet.properties");
		Logger logger = LogManager.getLogger(Listview_Deactivate_Pet.class);
		@Test(priority = 4, enabled = true)
		public void DeactivatingPetFromListView() throws InterruptedException {
			Thread.sleep(8000);
			logger.info("***** Started deactivate pet from list view*******");
			WebElement lv = driver.findElement(By.xpath(prop.getProperty("Nlistview")));
			lv.click();
			Thread.sleep(6000);
			driver.findElement(By.xpath(prop.getProperty("Ndeactivate"))).click();
			logger.info("***** Deactivate pet from the List view successfully*******");
			
}
}