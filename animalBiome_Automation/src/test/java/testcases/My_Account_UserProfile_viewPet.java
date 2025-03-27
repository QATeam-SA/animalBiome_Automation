package testcase;

import java.awt.AWTException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class My_Account_UserProfile_viewPet {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("My_Account_UserProfile_viewPet.properties");
	Logger logger = LogManager.getLogger(My_Account_UserProfile_viewPet.class);

	@Test(priority = 16, enabled = true)
		public void My_Ac_ViewPet() throws InterruptedException, AWTException {
		logger.info("***** Started going to My account user profile *******");
		    Thread.sleep(8000);
		    driver.findElement(By.xpath(prop.getProperty("N_myaccount"))).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath(prop.getProperty("N_userprofile"))).click();
		    Thread.sleep(10000);
		    Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath(prop.getProperty("N_Flip")))).perform();
			Thread.sleep(2000);
			driver.findElement(By.xpath(prop.getProperty("N_View"))).click();
			logger.info("***** Viewed the profile successfully *******");
			
			
	}
	}
