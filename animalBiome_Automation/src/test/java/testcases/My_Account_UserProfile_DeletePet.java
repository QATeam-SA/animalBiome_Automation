package testcases;

import java.awt.AWTException;
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

public class My_Account_UserProfile_DeletePet {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("My_Account_UserProfile_DeletePet.properties");
	Logger logger = LogManager.getLogger(Register_Sample_Gut.class);

	@Test(priority = 20, enabled = true)
	public void My_Ac_ViewPet() throws InterruptedException, AWTException {
		logger.info("***** Started going to My account user profile & delete the pet *******");
		Thread.sleep(8000);
		driver.findElement(By.xpath(prop.getProperty("N_myaccount"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_userprofile"))).click();
		logger.info("***** Started Deleteing pet *******");
		Thread.sleep(9000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(prop.getProperty("N_FLip1")))).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Delete"))).click();
		Thread.sleep(2000);
		driver.switchTo();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Confirm_Delete"))).click();
		Thread.sleep(1000);
		WebElement titleValidation = driver.findElement(By.xpath("//a[@class='close']/.."));

		String expectedText = "Pet successfully deleted.";
		String actualText = titleValidation.getText();
		if (actualText.equals(expectedText)) {
			System.out.println("Both Text are Same. The title is" + actualText);
		} else {
			System.out.println("Both Text are not Same. The dispalyed text is" + actualText);
		}

		logger.info("***** The pet has been deleted successfully from the my account user profile section *******");
		
		
		

}
}