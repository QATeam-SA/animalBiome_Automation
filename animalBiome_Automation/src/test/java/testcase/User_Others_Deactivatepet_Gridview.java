package testcase;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class User_Others_Deactivatepet_Gridview {
	Logger logger = LogManager.getLogger(User_Others_Deactivatepet_Gridview.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("User_Others_Deactivatepet_Gridview.properties");
	
	@Test(priority=11,enabled=true)
	public void DeactivatingOtherPetInGridView() throws InterruptedException {
		  Thread.sleep(4000);
		  WebElement targetelement =driver.findElement(By.xpath(prop.getProperty("j_MouseHover"))); 
		  Actions action = new Actions(driver); 
		  action.moveToElement(targetelement).perform();
		  Thread.sleep(4000);
		  driver.findElement(By.xpath(prop.getProperty("j_DeactivateBtn"))).click();
		  Thread.sleep(4000);
		  logger.info("Deactivated the pet in grid view");
}
}