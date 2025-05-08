package testcase;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.ExcelUtils;
import base.Instance;
import base.PropertiesFile;

public class Add_Cat_None {
	Logger logger = LogManager.getLogger(Add_Cat_None.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Add_Cat_None.properties");
	
	@Test(priority=3,enabled=true)
	public void AddingACatWithNoneOptions() throws InterruptedException, IOException {
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		driver.findElement(By.xpath(prop.getProperty("j_addpet"))).click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath(prop.getProperty("j_select_cat"))).click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath(prop.getProperty("j_cat_selectbreed"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_breeds"))).click();
		Thread.sleep(3000);
		String excelPath = PropertiesFile.getExcelFilePath();
		String sheetName = PropertiesFile.getPetExcelSheetName();

		ExcelUtils.loadExcelFile(excelPath, sheetName);

		String speciesSelected = "User_Cat";
		String newPetName = base.ExcelUtils.UniquePetName(prop.getProperty("j_Enter_Cat_Name"));

		driver.findElement(By.xpath(prop.getProperty("j_Cat_Name"))).sendKeys(newPetName);

		ExcelUtils.addPetNameToSpeciesColumn(speciesSelected, newPetName);
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_Age_Years"))).sendKeys(prop.getProperty("j_enter_Age"));
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_Age_Months"))).sendKeys(prop.getProperty("j_enter_Months"));
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_sex"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_weight"))).sendKeys("22");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_kg_lbs"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_S/N"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_street"))).sendKeys("Street");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("j_city"))).sendKeys("City");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("j_state"))).sendKeys("State");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("j_postalcode"))).sendKeys("785670");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_nxt_btn"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_antibiotics"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_body_condition"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_medications"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_supplements"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_ab_supplements"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_phys_conditions"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_diet"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_diet_type"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_symptoms"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_nxt_btn"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_complete"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_petportal"))).click();
		Thread.sleep(3000);
		logger.info("pet details added successfully by selecting None");
	}
}
