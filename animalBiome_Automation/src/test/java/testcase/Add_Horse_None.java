package testcase;

import java.time.Duration;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class Add_Horse_None {
	Logger logger = LogManager.getLogger(Add_Horse_None.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Add_Horse_None.properties");

	@Test(enabled = true)
	public void AddingHorsePetDetails() throws InterruptedException {
		Thread.sleep(4000);
		logger.info("***** Adding a horse with none details *******");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		driver.findElement(By.xpath(prop.getProperty("NADDPET"))).click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath(prop.getProperty("NHorse"))).click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath(prop.getProperty("NselectBreed"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("NbreedType"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_Horse_Name")))
				.sendKeys((prop.getProperty("N_Enter_Horse_Name")) + "_" + System.currentTimeMillis());
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_Age_Years"))).sendKeys(prop.getProperty("N_enter_Age"));
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_Age_Months"))).sendKeys(prop.getProperty("N_enter_Month"));
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dropdown = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("N_Horse_Sex"))));
		Select horseSexSelect = new Select(dropdown);
		horseSexSelect.selectByIndex(1);

		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_weight"))).sendKeys("92");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_kg_lbs"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_Primary_Dis_NotApplicble"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_Cold_Breaking"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_street"))).sendKeys(prop.getProperty("N_Enter_street"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_city"))).sendKeys(prop.getProperty("N_Enter_City"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_postal_Code"))).sendKeys(prop.getProperty("N_Postal_Code"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_state"))).sendKeys(prop.getProperty("N_Enter_State"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_MP_Next"))).click();
		logger.info("***** My Pet details has been added successfully *******");
	}

	@Test(enabled = true)
	public void AddingHorsePetHealthdetails() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Antibiotics_No"))).click();
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Medication_No"))).click();
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Timeframe"))).click();
		Thread.sleep(2000);
		driver.switchTo() /* frame("kustomer-ui-sdk-iframe") */ ;
		driver.findElement(By.xpath(prop.getProperty("N_Timeframe_Type"))).click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Suppliment"))).click();
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Location_City")))
				.sendKeys(prop.getProperty("N_Location_Enter_City"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Location_State")))
				.sendKeys(prop.getProperty("N_Location_Enter_State"));
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement hl = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("N_Horse_Live"))));
		Select horseLive = new Select(hl);
		horseLive.selectByIndex(2);
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Time_Stalled")))
				.sendKeys(prop.getProperty("N_enter_TimeStalled"));
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		WebElement hg = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("N_Horse_Grazing"))));
		Select horseGrazing = new Select(hg);
		horseGrazing.selectByIndex(1);
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Horse_grain_No"))).click();
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Horse_Hay_No"))).click();
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Horse_Physical_No"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_H_Symptoms_None"))).click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		WebElement wl = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("N_Avg_Workload"))));
		Select workLoad = new Select(wl);
		workLoad.selectByIndex(3);
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Hault_No"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_Stressor_No"))).click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_PetHealth_Next"))).click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Horse_Complete"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_Horse_Portal"))).click();
		Thread.sleep(5000);
		WebElement titleValidation = driver.findElement(By.xpath(
				"//div[@class='col-sm-12 col-lg-12 col-md-12 alert alert-success alert-dismissible ng-star-inserted']"));

		String expectedText = "Pet added successfully.";
		String actualText = titleValidation.getText();
		if (actualText.equals(expectedText)) {
			System.out.println("Both Text are Same. The title is" + actualText);
		} else {
			System.out.println("Both Text are not Same. The dispalyed text is" + actualText);
		}

		logger.info("***** Horse added successfully with none details *******");

	}
}