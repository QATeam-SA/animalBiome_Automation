package testcase;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class DeleteListView_Horse_DP {

	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("DeleteListView_Horse_DP.properties");
	Logger logger = LogManager.getLogger(DeleteListView_Horse_DP.class);
	@Test(enabled = true)
	public void DeletingDeactivatedHorseInListView() throws InterruptedException {
		Thread.sleep(4000);
		logger.info("***** Started deleteing deactivated Horse in the List view*******");
		driver.findElement(By.xpath(prop.getProperty("Nmyaccount"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Nuserprofile"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("Nlv"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("Nlvdelete"))).click();
		driver.switchTo();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("Ndpopup"))).click();
		logger.info("***** Deactivated Horse deleted successfully in the grid view *******");
		/*NOTE := In the user profile first pet should be deactivated then it will work. */
}

}