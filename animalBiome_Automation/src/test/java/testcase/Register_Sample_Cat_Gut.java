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

public class Register_Sample_Cat_Gut {
	Logger logger = LogManager.getLogger(Register_Sample_Cat_Gut.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Register_Sample_Cat_Gut.properties");
	
	@Test(priority=9,enabled=true)
	public void RegisteringGutSampleForACat() throws InterruptedException, IOException 
	{
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		logger.info("Cat Gut sample registration process has been started");
		driver.findElement(By.xpath(prop.getProperty("j_reg_sample"))).click();
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,200)");
		String excelPath = PropertiesFile.getExcelFilePath();
		String sheetName = PropertiesFile.getPetExcelSheetName();
		ExcelUtils.loadExcelFile(excelPath, sheetName);
		
		String petName = ExcelUtils.getAvailablePetName("User_Cat");

		if (petName != null) {
		    
			Select dropdown = new Select(driver.findElement(By.xpath(prop.getProperty("j_select_pet"))));
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
		st.selectByIndex(1);
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath(prop.getProperty("j_Fecal_C"))).click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath(prop.getProperty("j_fecal_color"))).click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath(prop.getProperty("j_test_submission"))).click();
		Thread.sleep(3000);
		String excelPath1 = PropertiesFile.getExcelFilePath();
		String sheetName1 = PropertiesFile.getExcelSheetName();

		ExcelUtils.loadExcelFile(excelPath1, sheetName1);

		String sampleId = ExcelUtils.getNextSample("User_Cat_Gut");
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
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_next_btn"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_complete_btn"))).click();
		Thread.sleep(9000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(10000);
		driver.findElement(By.xpath(prop.getProperty("j_view_petportal"))).click();
		Thread.sleep(3000);
		WebElement titleValidation = driver.findElement(By.xpath(
				"//div[@class='col-sm-12 col-lg-12 col-md-12 alert alert-success alert-dismissible ng-star-inserted']"));

		String expectedText = "Your pet's sample has been successfully registered.";
		String actualText = titleValidation.getText();
		if (actualText.equals(expectedText)) {
			System.out.println("Both Text are Same. The title is" + actualText);
		} else {
			System.out.println("Both Text are not Same. The dispalyed text is" + actualText);
		}
	    logger.info(" Cat Gut sample registration process has been completed");
		
	}
}
