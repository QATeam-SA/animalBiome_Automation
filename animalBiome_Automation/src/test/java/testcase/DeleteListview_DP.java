package testcase;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class DeleteListview_DP {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("DeleteListview_DP.properties");
	Logger logger = LogManager.getLogger(DeleteListview_DP.class);
	@Test(priority = 9, enabled = true)
	public void DeletingDeactivatedPetInListView() throws InterruptedException {
		Thread.sleep(8000);
		logger.info("***** Started deleteing deactivated pet in the List view*******");
		driver.findElement(By.xpath(prop.getProperty("Nmyaccount"))).click();
		driver.findElement(By.xpath(prop.getProperty("Nuserprofile"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("Nlv"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("Nlvdelete"))).click();
		driver.switchTo();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("Ndpopup"))).click();
		System.out.println("Deactivated pet deleted successfully in list view");
		logger.info("***** Deactivated pet deleted successfully in the grid view *******");
		/*NOTE := In the user profile first pet should be deactivated then it will work. */
}

}
