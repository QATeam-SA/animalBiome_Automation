package testcase;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
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

import base.ExcelUtils;
import base.Instance;
import base.PropertiesFile;

public class My_Account_Register_Oralsample {
		Logger logger = LogManager.getLogger(My_Account_Register_Oralsample.class);
		WebDriver driver = Instance.getInstance();
		Properties prop = PropertiesFile.readPropertyFile("My_Account_Register_Oralsample.properties");
		
		@Test(priority=11,enabled=true)
		public void RegisteringOralSampleThroughMyAccount() throws InterruptedException, IOException {
			Thread.sleep(10000);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			logger.info("Oral sample registration process has been started");
			driver.findElement(By.xpath(prop.getProperty("j_myaccount"))).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath(prop.getProperty("j_register_sample"))).click();
			Thread.sleep(2000);
			jse.executeScript("window.scrollBy(0,200)");
			String excelPath = PropertiesFile.getExcelFilePath();
			String sheetName = PropertiesFile.getPetExcelSheetName();
			ExcelUtils.loadExcelFile(excelPath, sheetName);
			
			String petName = ExcelUtils.getAvailablePetName("User_Cat");

			if (petName != null) {
			    
				Select dropdown = new Select(driver.findElement(By.xpath(prop.getProperty("j_select_pet"))));
				Thread.sleep(3000);
				dropdown.selectByVisibleText(petName);
			    Thread.sleep(2000); 
			    ExcelUtils.deletePetNameFromSpeciesColumn("User_Cat", petName);
			} else {
			    System.out.println("No available pet name found in User_Cat column!");
			}
			Thread.sleep(2000);
			jse.executeScript("window.scrollBy(0,200)");
			WebElement e1 =driver.findElement(By.xpath(prop.getProperty("j_sample")));
			Select st = new Select(e1);
			 Thread.sleep(2000);
			st.selectByIndex(2);
			Thread.sleep(3000);
			jse.executeScript("window.scrollBy(0,200)");
			driver.findElement(By.xpath(prop.getProperty("j_test_submission"))).click();
			Thread.sleep(3000);
			String excelPath1 = PropertiesFile.getExcelFilePath();
			String sheetName1 = PropertiesFile.getExcelSheetName();

			ExcelUtils.loadExcelFile(excelPath1, sheetName1);

			String sampleId = ExcelUtils.getNextSample("User_Cat_Oral");
			System.out.println("Fetched Sample ID: " + sampleId);

			driver.findElement(By.xpath(prop.getProperty("j_Sample_ID"))).sendKeys(sampleId);

			Thread.sleep(6000);
			try {
				LocalDate currentDate = LocalDate.now();
				String currentDay = String.valueOf(currentDate.getDayOfMonth());
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
				String formattedDate = currentDate.format(formatter);

				WebElement dateField = driver.findElement(By.xpath("//input[@id='flatpickr']"));
				dateField.click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.backdrop.full-screen")));
				List<WebElement> dates = driver.findElements(By.xpath("//span[@aria-label='" + formattedDate + "']"));

				for (WebElement date : dates) {
					if (date.getText().equals(currentDay)) {
						date.click();
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		    Thread.sleep(3000);
		    driver.findElement(By.xpath(prop.getProperty("j_next_btn"))).click();
		    Thread.sleep(3000);
		    jse.executeScript("window.scrollBy(0,700)");
		    Thread.sleep(4000);
		    driver.findElement(By.xpath(prop.getProperty("j_complete_btn"))).click();
		    Thread.sleep(9000);
			jse.executeScript("window.scrollBy(0,200)");
			Thread.sleep(10000);
		    driver.findElement(By.xpath(prop.getProperty("j_view_petportal"))).click();
		    Thread.sleep(3000);
		    logger.info("Oral sample registration process has been completed");
		}
	}


