package testcase;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class Signout_Existinguser {
	Logger logger = LogManager.getLogger(Signout_Existinguser.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Signout_Existinguser.properties");
	
	@Test(priority=28, enabled=true)
	public void signout() throws InterruptedException {
		driver.findElement(By.xpath(prop.getProperty("j_My_Account"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("j_SignOut"))).click();
		Thread.sleep(5000);
		System.out.println("signedout successfully");
		logger.info("Existing user is sucessfully Successfully SignedOut");
		throw new SkipException("Skipping this test on purpose.");
	}
}
