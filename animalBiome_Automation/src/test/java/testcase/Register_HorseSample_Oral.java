package testcase;

import java.awt.AWTException;
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

public class Register_HorseSample_Oral {

	Logger logger = LogManager.getLogger(Register_HorseSample_Oral.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Register_HorseSample_Oral.properties");
	
	@Test(enabled = true)
	public void RegisteringTheHorseOralSample() throws InterruptedException, AWTException, IOException {
		logger.info("***** Horse Oral sample registration process has been started*******");
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("N_Register_Sample"))).click();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1500);
		
		String excelPath = PropertiesFile.getExcelFilePath();
		String sheetName = PropertiesFile.getPetExcelSheetName();
		ExcelUtils.loadExcelFile(excelPath, sheetName);
		
		String petName = ExcelUtils.getAvailablePetName("User_Horse");

		if (petName != null) {
		    
			Select dropdown = new Select(driver.findElement(By.xpath(prop.getProperty("N_select_pet"))));
			dropdown.selectByVisibleText(petName);
			
		    Thread.sleep(2000); 
		    ExcelUtils.deletePetNameFromSpeciesColumn("User_Horse", petName);
		} else {
		    System.out.println("No available pet name found in User_Horse column!");
		}
         
		Thread.sleep(2000);
		WebElement e1 = driver.findElement(By.xpath(prop.getProperty("N_Sample")));
		Select st = new Select(e1);
		Thread.sleep(2000);
		st.selectByIndex(2);
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("N_T_submision"))).click();
        Thread.sleep(1500);
		
        jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1500);
		String excelPath1 = PropertiesFile.getExcelFilePath();
		String sheetName1 = PropertiesFile.getExcelSheetName();

		ExcelUtils.loadExcelFile(excelPath1, sheetName1);

		String sampleId = ExcelUtils.getNextSample("User_Fauna");
		System.out.println("Fetched Sample ID: " + sampleId);

		driver.findElement(By.xpath(prop.getProperty("N_Sample_ID"))).sendKeys(sampleId);

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
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("N_Next_B"))).click();
		Thread.sleep(1500);
		jse.executeScript("window.scrollBy(0,900)");
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("N_Complete"))).click();
		Thread.sleep(9000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(10000);
		driver.findElement(By.xpath(prop.getProperty("N_HorsePortal"))).click();
		Thread.sleep(4000);
		WebElement titleValidation = driver.findElement(By.xpath(
				"//div[@class='col-sm-12 col-lg-12 col-md-12 alert alert-success alert-dismissible ng-star-inserted']"));

		String expectedText = "Your pet's sample has been successfully registered.";
		String actualText = titleValidation.getText();
		if (actualText.equals(expectedText)) {
			System.out.println("Both Text are Same. The title is" + actualText);
		} else {
			System.out.println("Both Text are not Same. The dispalyed text is" + actualText);
		}
		logger.info("***** Horse Oral Sample registration process has been completed******");

	}
}
