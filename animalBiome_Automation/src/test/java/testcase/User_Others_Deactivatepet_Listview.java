package testcase;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class User_Others_Deactivatepet_Listview {
	Logger logger = LogManager.getLogger(User_Others_Deactivatepet_Listview.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("User_Others_Deactivatepet_Listview.properties");
	
	@Test(priority=11,enabled=true)
	public void DeactivatingOtherPetInListView() throws InterruptedException {
		  Thread.sleep(4000);
		  driver.findElement(By.xpath(prop.getProperty("j_Listview"))).click();
		  Thread.sleep(4000);
		  driver.findElement(By.xpath(prop.getProperty("j_Deactivatebtn_lview"))).click();
		  Thread.sleep(3000);
		  logger.info("Deactivated pet in list view");
	}
}