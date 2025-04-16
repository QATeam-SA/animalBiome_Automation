package testcase;

import java.awt.AWTException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import base.Instance;
import base.PropertiesFile;

public class Register_Sample_Gut {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Register_Sample_Gut.properties");
	Logger logger = LogManager.getLogger(Register_Sample_Gut.class);

	@Test(priority = 14, enabled = true)
		public void RegisteringGutSampleForADog() throws InterruptedException, AWTException {
		logger.info("***** Gut sample registration process has been started*******");
		    Thread.sleep(8000);
		    driver.findElement(By.xpath(prop.getProperty("Nregister_sample"))).click();
		    Thread.sleep(4000);
			WebElement e =driver.findElement(By.xpath(prop.getProperty("N_select_pet")));
			Select ss = new Select(e);
			 Thread.sleep(2000);
			ss.selectByVisibleText("Athena");;
			Thread.sleep(2000);
			WebElement e1 =driver.findElement(By.xpath(prop.getProperty("N_Sample")));
			Select st = new Select(e1);
			 Thread.sleep(2000);
			st.selectByIndex(1);
			Thread.sleep(3000);
			driver.findElement(By.xpath(prop.getProperty("N_Fecal_C"))).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(prop.getProperty("N_Fecal_Color"))).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(prop.getProperty("N_T_submision"))).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(prop.getProperty("N_Sample_ID"))).sendKeys(prop.getProperty("N_Enter_SampleID"));
			Thread.sleep(4000);
			driver.findElement(By.xpath(prop.getProperty("N_Calender"))).click();
			
			Thread.sleep(10000); 
			driver.switchTo();
			driver.findElement(By.xpath(prop.getProperty("N_Date"))).click();
		    Thread.sleep(2000);
				 
			 
			
				/*
				 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
				 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.
				 * xpath(prop.getProperty("N_Entire_Calender")))); String aMonth =
				 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.
				 * getProperty("N_Current_Month")))).getText(); String aYear =
				 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.
				 * getProperty("N_Current_Year")))).getText();
				 * 
				 * while (!(aMonth.equals("March") && aYear.equals("2025"))) {
				 * 
				 * driver.findElement(By.xpath(prop.getProperty("N_Back"))).click();
				 * 
				 * wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(prop.
				 * getProperty("N_Current_Month"))))); aMonth =
				 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.
				 * getProperty("N_Current_Month")))).getText(); aYear =
				 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.
				 * getProperty("N_Current_Year")))).getText(); }
				 * 
				 * driver.findElement(By.xpath(prop.getProperty("N_D"))).click();
				 */
				/*
				 * driver.switchTo(); Thread.sleep(2000);
				 * 
				 * String Year= "2025"; String Month= "February"; String Day= "1"; while(true) {
				 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
				 * String aMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(
				 * By.xpath(prop.getProperty("N_Current_Month")))).getText();
				 * 
				 * String aYear = wait.until(ExpectedConditions.visibilityOfElementLocated(
				 * By.xpath(prop.getProperty("N_Current_Year")))).getText();
				 * if(aMonth.equals(Month) && aYear.equals(Year)) { break; } WebDriverWait wait1
				 * = new WebDriverWait(driver, Duration.ofSeconds(10)); WebElement
				 * currentCDElement = wait1
				 * .until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty(
				 * "N_Back")))); currentCDElement.click(); Thread.sleep(2000); List<WebElement>
				 * alldates= driver.findElements(By.xpath(prop.getProperty("N_All_Date")));
				 * for(WebElement dt:alldates) { if(dt.getText().equals(Day)) { dt.click();
				 * break; } } }
				 */
	      Thread.sleep(4000);
			driver.findElement(By.xpath(prop.getProperty("N_Next_B"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(prop.getProperty("N_Complete"))).click();
			Thread.sleep(9000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");
			Thread.sleep(10000);
			driver.findElement(By.xpath(prop.getProperty("N_viewPortal"))).click();
			Thread.sleep(3000);
			WebElement titleValidation = driver.findElement(By.xpath("//div[@class='col-sm-12 col-lg-12 col-md-12 alert alert-success alert-dismissible ng-star-inserted']"));

			String expectedText = "Your pet's sample has been successfully registered.";
			String actualText = titleValidation.getText();
			if (actualText.equals(expectedText)) {
				System.out.println("Both Text are Same. The title is" + actualText);
			} else {
				System.out.println("Both Text are not Same. The dispalyed text is" + actualText);
			}
			logger.info("***** Gut sample registration process has been completed******");
			
			
			
			
			
			
			
			
			
			
		}
}
