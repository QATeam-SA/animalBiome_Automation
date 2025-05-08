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

public class Add_Dog_None {
	
	Logger logger = LogManager.getLogger(Add_Dog_None.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Add_Dog_None.properties");

	@Test(priority = 5, enabled=true)
	public void adddog() throws Exception {
		
		// ------- MY PET---------

		JavascriptExecutor js = MydogDetails();

		// ----------PET HEALTH---------

		PetHealthdetails(js);
				
	}
	
   private void PetHealthdetails(JavascriptExecutor js) throws InterruptedException {
		
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_Antibiotics"))).click();
		Thread.sleep(1500);
		driver.findElement(By.id(prop.getProperty("G_Bodyconditions"))).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,1100)");
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_Medications"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_Supplements"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_AnimalBiomesupplements"))).click();
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_Physicalconditions"))).click();
		driver.findElement(By.xpath(prop.getProperty("G_Diet"))).click();
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_Dietoptions"))).click();
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_Symptoms"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_PetHealth_Nextbutton"))).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("G_Complete"))).click();
		System.out.println("Pet added Successfully");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("G_View_PetPortal"))).click();
		Thread.sleep(3000);
		System.out.println("Return to Pet Portal Successfully");
	
	}
		
	private JavascriptExecutor MydogDetails() throws InterruptedException, Exception {

		Thread.sleep(10000);
		driver.findElement(By.xpath(prop.getProperty("G_AddPet"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_DogButton"))).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_SelectBreed"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_BreedName"))).click();
		Thread.sleep(1000);
		String excelPath = PropertiesFile.getExcelFilePath();
		String sheetName = PropertiesFile.getPetExcelSheetName();

		ExcelUtils.loadExcelFile(excelPath, sheetName);

		String speciesSelected = "User_Dog";
		String newPetName = base.ExcelUtils.UniquePetName(prop.getProperty("G_Enter_Dog_Name"));

		driver.findElement(By.xpath(prop.getProperty("G_Dog_Name"))).sendKeys(newPetName);

		ExcelUtils.addPetNameToSpeciesColumn(speciesSelected, newPetName);
		Thread.sleep(1000);
		driver.findElement(By.name(prop.getProperty("G_Dogyears"))).sendKeys("3");
		driver.findElement(By.name(prop.getProperty("G_Dogmonths"))).sendKeys("5");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_Dogsex"))).click();
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.name(prop.getProperty("G_Dogweight"))).sendKeys("56");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_weightunits"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_Doggender"))).click();
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_Street"))).sendKeys("Street");
		driver.findElement(By.xpath(prop.getProperty("G_City"))).sendKeys("City");
		driver.findElement(By.xpath(prop.getProperty("G_State"))).sendKeys("State");
		driver.findElement(By.xpath(prop.getProperty("G_PostalCode"))).sendKeys("123456789");
		Select s=new Select(driver.findElement(By.xpath(prop.getProperty("G_Country"))));
		s.selectByVisibleText("Australia");
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_AddPet_Nextbutton"))).click();
		return js;
		
	}
	
	
}