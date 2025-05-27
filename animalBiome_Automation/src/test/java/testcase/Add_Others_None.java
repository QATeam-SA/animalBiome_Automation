package testcase;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.ExcelUtils;
import base.Instance;
import base.PropertiesFile;

public class Add_Others_None {

	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Add_Others_None.properties");
	Logger logger = LogManager.getLogger(Add_Others_None.class);

	@Test(priority = 15, enabled = true)
	public void AddingOtherSpeciesWithNone() throws Exception {

		// ------- MY PET---------

		JavascriptExecutor js = OtherSpeciesDetails();

		// ----------PET HEALTH---------

		SpeciesHealthdetails(js);

	}

	private JavascriptExecutor OtherSpeciesDetails() throws InterruptedException, Exception {

		Thread.sleep(10000);
		driver.findElement(By.xpath(prop.getProperty("G_AddPetButton"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_OtherButton"))).click();
		Thread.sleep(2000);
		Select species = new Select(driver.findElement(By.xpath(prop.getProperty("G_SelectSpecies"))));
		species.selectByVisibleText("Bird");
		Thread.sleep(1500);
		Select breed = new Select(driver.findElement(By.xpath(prop.getProperty("G_SelectBreed"))));
		breed.selectByVisibleText("House Sparrow");
		Thread.sleep(1500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		String excelPath = PropertiesFile.getExcelFilePath();
		String sheetName = PropertiesFile.getPetExcelSheetName();

		ExcelUtils.loadExcelFile(excelPath, sheetName);

		String newPetName = base.ExcelUtils.UniquePetName(prop.getProperty("G_Enter_Others_Name"));

		driver.findElement(By.xpath(prop.getProperty("G_Others_Name"))).sendKeys(newPetName);
		Thread.sleep(1000);
		driver.findElement(By.name(prop.getProperty("G_Otheryears"))).sendKeys("3");
		driver.findElement(By.name(prop.getProperty("G_Othermonths"))).sendKeys("10");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_Othersex"))).click();
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.name(prop.getProperty("G_Otherweight"))).sendKeys("25.09");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_weightunits"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_Othergender"))).click();
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_Street"))).sendKeys("Hallstrom");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_City"))).sendKeys("42 Wallaby Way");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_State"))).sendKeys("Sydney");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_PostalCode"))).sendKeys("POA 3585");
		Thread.sleep(1000);
		Select s = new Select(driver.findElement(By.xpath(prop.getProperty("G_Country"))));
		s.selectByVisibleText("Australia");
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_AddPet_Nextbutton"))).click();
		logger.info(" Added Pet Details successfully");
		return js;

	}

	private void SpeciesHealthdetails(JavascriptExecutor js) throws InterruptedException, Exception {

		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_Antibiotics"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_Medications"))).click();
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_Supplements"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_Physicalcond"))).click();
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_Diet"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_Symptoms"))).click();
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		driver.findElement(By.name(prop.getProperty("G_Health_NextButton"))).click();
		Thread.sleep(2000);
		logger.info(" Health Details added successfully");
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_CompleteButton"))).click();
		Thread.sleep(1500);
		logger.info(" Other species added with NONE");
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_PetPortalbutton"))).click();

	}

}