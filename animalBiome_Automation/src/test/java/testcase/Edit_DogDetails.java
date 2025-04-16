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

public class Edit_DogDetails {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Edit_DogDetails.properties");
	Logger logger = LogManager.getLogger(Edit_DogDetails.class);
	
	@Test(priority = 7, enabled = true)
	public void EditingTheDogDetails() throws Exception {
		
		//----------Edit By Home Page--------
		
		JavascriptExecutor js = EditdogDetails();
		
		//----------Edit By View------
		
		EditDetails(js);
		
	}
	
	private void EditDetails(JavascriptExecutor js) throws InterruptedException {
		
		Thread.sleep(7000);
		driver.findElement(By.xpath(prop.getProperty("G_DogSearch"))).sendKeys("Pint");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.findElement(By.cssSelector(prop.getProperty("G_SearchButton"))).click();
		Thread.sleep(10000);

		WebElement mh = driver.findElement(By.xpath(prop.getProperty("G_Mousehover")));
		Actions action = new Actions(driver);
		action.moveToElement(mh).perform();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement view = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("G_ViewButton"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", view);
		Thread.sleep(7000);
		driver.findElement(By.xpath(prop.getProperty("G_EditPet"))).click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath(prop.getProperty("G_AddPet_Nextbutton"))).click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,800)");
		driver.findElement(By.xpath(prop.getProperty("G_PetHealth_Nextbutton"))).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_Complete"))).click();
		logger.info("Edited Successfully from ViewPage");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("G_PetPortalHome"))).click();
		
	}
	
	
	private JavascriptExecutor EditdogDetails() throws InterruptedException {
		
		Thread.sleep(10000);
		driver.findElement(By.xpath(prop.getProperty("G_DogSearch"))).sendKeys("Cosmos");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.findElement(By.cssSelector(prop.getProperty("G_SearchButton"))).click();
		Thread.sleep(10000);
		WebElement mh = driver.findElement(By.xpath(prop.getProperty("G_Mousehover")));
		Actions action = new Actions(driver);
		action.moveToElement(mh).perform();
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement view = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("G_EditButton"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", view);
		Thread.sleep(7000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(prop.getProperty("G_AddPet_Nextbutton"))).click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,800)");
		driver.findElement(By.xpath(prop.getProperty("G_PetHealth_Nextbutton"))).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_Complete"))).click();
		logger.info("Edited Successfully from HomePage");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("G_PetPortalHome"))).click();
		
		return js;
	
		
	}
}