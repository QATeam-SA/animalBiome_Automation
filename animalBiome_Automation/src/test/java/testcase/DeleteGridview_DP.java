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

public class DeleteGridview_DP {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("DeleteGridview_DP.properties");
	Logger logger = LogManager.getLogger(DeleteGridview_DP.class);
	@Test(priority = 8, enabled = true)
	public void DeletingDeactivatedPetInGridView() throws InterruptedException {
		Thread.sleep(8000);
		logger.info("***** Started deleteing deactivated pet in the grid view*******");
		driver.findElement(By.xpath(prop.getProperty("Nmyaccount"))).click();
		driver.findElement(By.xpath(prop.getProperty("Nuserprofile"))).click();
		Actions act = new Actions(driver);
		Thread.sleep(10000);
		act.moveToElement(driver.findElement(By.xpath(prop.getProperty("NdlipB")))).perform();
		System.out.println("mosehover to the element successfully");
		Thread.sleep(3000);
		WebElement Dclick = driver.findElement(By.xpath(prop.getProperty("Nd")));
		Thread.sleep(1000);
		Dclick.click();
		Thread.sleep(2000);
		driver.switchTo();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("NdeletePopup"))).click();
		logger.info("***** Deactivated pet deleted successfully in the grid view *******");
		/*NOTE := in the user profile first pet should be deactivated then it will work. */
}
}
