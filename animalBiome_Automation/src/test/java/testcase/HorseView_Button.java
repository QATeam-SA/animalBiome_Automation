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

public class HorseView_Button {
	Logger logger = LogManager.getLogger(HorseView_Button.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("HorseView_Button.properties");

	@Test(enabled = true)
	public void ClickingHorseViewButton() throws InterruptedException {
		Thread.sleep(4000);
		logger.info("***** Viewing a horse profile*******");
		driver.findElement(By.xpath(prop.getProperty("N_HorseSearch"))).sendKeys(prop.getProperty("N_Horse_Name"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.findElement(By.xpath(prop.getProperty("N_SearchButton"))).click();
		Thread.sleep(6000);
		WebElement mh = driver.findElement(By.xpath(prop.getProperty("N_Mousehover")));
		Actions action = new Actions(driver);
		action.moveToElement(mh).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_ViewButton"))).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement cl= wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("N_Pet_Portal_Home"))));
		cl.click();
		
		logger.info("***** Viewed a horse profile by clicking on view button*******");

	}
}
