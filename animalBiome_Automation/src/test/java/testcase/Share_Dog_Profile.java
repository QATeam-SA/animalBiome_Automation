package testcase;
import java.time.Duration;
import java.util.ArrayList;
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


public class Share_Dog_Profile {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Share_Dog_Profile.properties");
	Logger logger = LogManager.getLogger(Share_Dog_Profile.class);
	
	@Test(priority = 8, enabled = true)
	public void sharingDogProfile() throws Exception {

		// ----------Share Pet Profile [PUBLIC]--------

		JavascriptExecutor js = SharePetprofile();

		// ----------Share Pet Profile [PRIVATE]------

		ShareProfile_Private(js);

	}

	private void ShareProfile_Private(JavascriptExecutor js) throws InterruptedException {

		Thread.sleep(7000);
		WebElement myaccount = driver.findElement(By.xpath(prop.getProperty("G_MyAccount")));
		Actions action1 = new Actions(driver);
		action1.moveToElement(myaccount).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_UserProfile"))).click();
		Thread.sleep(7000);
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_EditProfile"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("G_PrivateProfile"))).click();
		logger.info("Profile updated as Private");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("G_UpdateProfile"))).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath(prop.getProperty("G_SearchPet"))).sendKeys("chirag");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.findElement(By.xpath(prop.getProperty("G_Search"))).click();
		Thread.sleep(10000);
		WebElement flip = driver.findElement(By.xpath(prop.getProperty("G_Flip")));
		Actions action = new Actions(driver);
		action.moveToElement(flip).perform();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement view = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("G_View"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", view);
		Thread.sleep(7000);
		driver.findElement(By.xpath(prop.getProperty("G_SharePetProfile"))).click();
		Thread.sleep(4000);
		WebElement abc = driver.findElement(By.xpath(prop.getProperty("G_CopyLink")));
		abc.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_Close"))).click();
		Thread.sleep(1000);
		String typedText = driver.findElement(By.xpath(prop.getProperty("G_ReadText"))).getAttribute("value");
		logger.info("share link is " + typedText);
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.open()"); 
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(typedText);
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("G_PetPortal"))).click();
		
	}

	private JavascriptExecutor SharePetprofile() throws InterruptedException {

		Thread.sleep(5000);
		WebElement myaccount = driver.findElement(By.xpath(prop.getProperty("G_MyAccount")));
		Actions action1 = new Actions(driver);
		action1.moveToElement(myaccount).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("G_UserProfile"))).click();
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_EditProfile"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("G_PublicProfile"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("G_UpdateProfile"))).click();
		logger.info("Profile updated as Public");
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("G_PetPortal"))).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath(prop.getProperty("G_DogSearch"))).sendKeys("Cosmos");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.findElement(By.cssSelector(prop.getProperty("G_SearchButton"))).click();
		Thread.sleep(10000);
		WebElement mh = driver.findElement(By.xpath(prop.getProperty("G_Mousehover")));
		Actions action = new Actions(driver);
		action.moveToElement(mh).perform();
		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement view = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("G_ViewButton"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", view);
		Thread.sleep(7000);
		driver.findElement(By.xpath(prop.getProperty("G_SharePetProfile"))).click();
		Thread.sleep(4000);
		WebElement abc = driver.findElement(By.xpath(prop.getProperty("G_CopyLink")));
		abc.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_Close"))).click();
		Thread.sleep(1000);
		String typedText = driver.findElement(By.xpath(prop.getProperty("G_ReadText"))).getAttribute("value");
		logger.info("share link is " + typedText);
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.open()"); 
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(typedText);
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("G_PetPortal"))).click();
		
		return js;

	}

}
