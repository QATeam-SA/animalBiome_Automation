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

public class Register_Sample_Oral {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Register_Sample_Oral.properties");
	Logger logger = LogManager.getLogger(Register_Sample_Oral.class);

	@Test(priority = 16, enabled = true)
	public void RegisteringOralSampleForADog() throws InterruptedException, AWTException, IOException {
	
	    Thread.sleep(8000);
	    logger.info("***** Dog Oral sample registration process has been started*******");
	    driver.findElement(By.xpath(prop.getProperty("Nregister_sample"))).click();
	    Thread.sleep(4000);
	    JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1500);
		
		String excelPath = PropertiesFile.getExcelFilePath();
		String sheetName = PropertiesFile.getPetExcelSheetName();
		ExcelUtils.loadExcelFile(excelPath, sheetName);
		
		String petName = ExcelUtils.getAvailablePetName("User_Dog");

		if (petName != null) {
		    
			Select dropdown = new Select(driver.findElement(By.xpath(prop.getProperty("N_select_pet"))));
			Thread.sleep(3000);
			dropdown.selectByVisibleText(petName);
		    Thread.sleep(2000); 
		    ExcelUtils.deletePetNameFromSpeciesColumn("User_Dog", petName);
		} else {
		    System.out.println("No available pet name found in User_Dog column!");
		}
		Thread.sleep(2000);
		WebElement e1 =driver.findElement(By.xpath(prop.getProperty("N_Sample")));
		Select st = new Select(e1);
		 Thread.sleep(2000);
		st.selectByIndex(2);
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_T_submision"))).click();
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1500);
		String excelPath1 = PropertiesFile.getExcelFilePath();
		String sheetName1 = PropertiesFile.getExcelSheetName();

		ExcelUtils.loadExcelFile(excelPath1, sheetName1);

		String sampleId = ExcelUtils.getNextSample("User_Dog_Oral");
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
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Next_B"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Complete"))).click();
		Thread.sleep(9000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(7000);
		driver.findElement(By.xpath(prop.getProperty("N_viewPortal"))).click();
		Thread.sleep(5000);
		WebElement titleValidation = driver.findElement(By.xpath("//div[@class='col-sm-12 col-lg-12 col-md-12 alert alert-success alert-dismissible ng-star-inserted']"));

		String expectedText = "Your pet's sample has been successfully registered.";
		String actualText = titleValidation.getText();
		if (actualText.equals(expectedText)) {
			System.out.println("Both Text are Same. The title is" + actualText);
		} else {
			System.out.println("Both Text are not Same. The dispalyed text is" + actualText);
		}
		logger.info("***** Dog Oral sample registration process has been completed******");

}
}
