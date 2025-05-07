package testcase;

import java.util.ArrayList;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class Share_Horse_Profile_Public {

	Logger logger = LogManager.getLogger(Share_Horse_Profile_Public.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Share_Horse_Profile_Public.properties");

	@Test(enabled = true)
	public void SharingThePublicHorseProfile() throws InterruptedException {
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		driver.findElement(By.xpath(prop.getProperty("N_petsearch"))).sendKeys("stanley");
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("N_searchbutton"))).click();
		Thread.sleep(2000);
		WebElement targetelement = driver.findElement(By.xpath(prop.getProperty("N_mousehover")));
		Actions action = new Actions(driver);
		action.moveToElement(targetelement).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_viewbutton"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_sharepetprofile"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_copylink"))).click();
		Thread.sleep(2000);
		String typedText = driver.findElement(By.xpath("//input[@readonly='readonly']")).getAttribute("value");
		System.out.println("public link is " + typedText);
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,-300)");
		driver.get(typedText);
		Thread.sleep(2000);
		driver.close();
		logger.info("public Horse profile is successfull");
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("N_closebutton"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_HorsePortalHome"))).click();
	}
}