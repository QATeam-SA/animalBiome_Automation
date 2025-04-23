package testcase;

import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class Gridview_Deactivate_Pet {

	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Gridview_Deactivate_Pet.properties");
	Logger logger = LogManager.getLogger(Gridview_Deactivate_Pet.class);
	@Test(priority = 3, enabled = true)
	public void DeactivatingPetFromGridView() throws InterruptedException {
		Thread.sleep(7000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		logger.info("***** Started deactivate pet from grid view*******");
		Thread.sleep(9000);
		System.out.println("started hovering the pet");
		Actions act = new Actions(driver);
		Thread.sleep(3000);
		act.moveToElement(driver.findElement(By.xpath(prop.getProperty("NFlipover")))).perform();
		System.out.println("mosehover to the element successfully");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement deactivateButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("NDeactivateButton"))));
		deactivateButton.click();
		
		System.out.println("successfull");
		logger.info("***** Deactivate pet from the grid view successfully*******");

	}

}
