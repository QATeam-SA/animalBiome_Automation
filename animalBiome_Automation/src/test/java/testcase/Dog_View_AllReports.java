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
public class Dog_View_AllReports {

	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Dog_View_AllReports.properties");
	Logger logger = LogManager.getLogger(Dog_View_AllReports.class);

	@Test(priority = 6, enabled = true)
	public void ViewingReportDetailsOfADog() throws Exception {
		
		//------VEIW DOG Details---------
		
		JavascriptExecutor js=veiwdogDetails();
		
		//--------ALL REPORTS Details------------
		
		reportsDetails(js);
		
	}
	
	private void reportsDetails(JavascriptExecutor js) throws Exception {
		
		driver.findElement(By.xpath(prop.getProperty("G_AllReports"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_ReportSearch"))).sendKeys("UTEEXV");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("G_ReportSearchButton"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("G_PetPortalHome"))).click();
		Thread.sleep(7000);
		
		driver.findElement(By.xpath(prop.getProperty("G_DogSearch"))).sendKeys("Champ");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.findElement(By.cssSelector(prop.getProperty("G_SearchButton"))).click();
		Thread.sleep(10000);
		WebElement mh = driver.findElement(By.xpath(prop.getProperty("G_Mousehover")));
		Actions action = new Actions(driver);
		action.moveToElement(mh).perform();
		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement report = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("G_ReportsButton"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", report);
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("G_PetPortalHome"))).click();
		logger.info("Viewed Pet details successfully");
		
	}
	
	private JavascriptExecutor veiwdogDetails() throws InterruptedException {
		
		Thread.sleep(7000);
		driver.findElement(By.xpath(prop.getProperty("G_DogSearch"))).sendKeys("Champ");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.findElement(By.cssSelector(prop.getProperty("G_SearchButton"))).click();
		Thread.sleep(10000);
		WebElement mh = driver.findElement(By.xpath(prop.getProperty("G_Mousehover")));
		Actions action = new Actions(driver);  //mousehover actions
		action.moveToElement(mh).perform();
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement view = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("G_ViewButton"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", view);
		Thread.sleep(7000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)"); //Scroll down
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-400)"); // scroll up
		Thread.sleep(3000);
		return js;
				
	}
	
}

