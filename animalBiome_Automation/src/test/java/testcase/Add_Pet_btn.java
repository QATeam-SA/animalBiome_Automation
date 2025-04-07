package testcase;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class Add_Pet_btn {
	Logger logger = LogManager.getLogger(Add_Pet_btn.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Add_Pet_btn.properties");
	
	@Test(priority=4,enabled=true)
	public void addpet() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("ADDPET"))).click();
		Thread.sleep(2000);
		driver.navigate().back();
		logger.info("Add pet button clicked successfully");
	}
}
