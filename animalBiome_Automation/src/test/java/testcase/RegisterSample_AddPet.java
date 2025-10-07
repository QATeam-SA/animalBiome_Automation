package testcase;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.ExcelUtils;
import base.Instance;
import base.PropertiesFile;

public class RegisterSample_AddPet {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("RegisterSample_AddPet.properties");
	Logger logger = LogManager.getLogger(RegisterSample_AddPet.class);
	@Test(priority = 10, enabled = true)
	public void AddingDogThroughSampleRegistration() throws InterruptedException, AWTException, IOException {
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_register_sample"))).click();
		Thread.sleep(5000);
		logger.info("***** Started adding pet *******");		
		WebElement addpet = driver.findElement(By.xpath(prop.getProperty("N_addpet")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addpet);
		Thread.sleep(1000);
		addpet.click();
		Thread.sleep(5000);
	
		/* Thread.sleep(5000);
		 * driver.findElement(By.xpath(prop.getProperty("N_Profile_Picture"))).click();
		 * Robot rb = new Robot(); rb.delay(2000);
		 * StringSelection ss = new StringSelection(prop.getProperty("Upload_Dog"));
		 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		 * rb.keyPress(KeyEvent.VK_CONTROL); rb.keyPress(KeyEvent.VK_V); rb.delay(2000);
		 * rb.keyRelease(KeyEvent.VK_CONTROL); rb.keyRelease(KeyEvent.VK_V);
		 * rb.delay(2000); rb.keyPress(KeyEvent.VK_ENTER);
		 * rb.keyRelease(KeyEvent.VK_ENTER); rb.delay(2000);*/

		WebElement fileInput = driver.findElement(By.xpath(prop.getProperty("FileUploadInput")));
        fileInput.sendKeys(prop.getProperty("Upload_Dog"));
        Thread.sleep(2000);
		driver.switchTo();
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath(prop.getProperty("NDrag_&_drop")));
		Thread.sleep(2000);
		act.dragAndDropBy(ele, 10, 10).perform();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		driver.findElement(By.xpath(prop.getProperty("N_Submit"))).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,300)", "");
		WebElement breed = driver.findElement(By.xpath(prop.getProperty("N_select_breed")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", breed);
		Thread.sleep(1000);
		breed.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("Nbreed"))).click();
		Thread.sleep(1000);
		String excelPath = PropertiesFile.getExcelFilePath();
		String sheetName = PropertiesFile.getPetExcelSheetName();

		ExcelUtils.loadExcelFile(excelPath, sheetName);

		String speciesSelected = "User_Dog";
		String newPetName = base.ExcelUtils.UniquePetName(prop.getProperty("G_Enter_Dog_Name"));

		driver.findElement(By.xpath(prop.getProperty("G_Dog_Name"))).sendKeys(newPetName);

		ExcelUtils.addPetNameToSpeciesColumn(speciesSelected, newPetName);
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Age_Years"))).sendKeys(prop.getProperty("N_enter_Age_Y"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Age_Month"))).sendKeys(prop.getProperty("N_enter_Age_M"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Gender"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Weight"))).sendKeys(prop.getProperty("N_Enter_Weight"));
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Kg/Lbs"))).click();
		Thread.sleep(2000);
		WebElement gender = driver.findElement(By.xpath(prop.getProperty("N_S/N")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", gender);
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("N_street"))).sendKeys(prop.getProperty("N_Enter_street"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_city"))).sendKeys(prop.getProperty("N_Enter_City"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_state"))).sendKeys(prop.getProperty("N_Enter_State"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_postal_Code"))).sendKeys(prop.getProperty("N_Postal_Code"));
		Thread.sleep(2000);
		WebElement nextbtn = driver.findElement(By.xpath(prop.getProperty("N_MP_Next")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextbtn);
		Thread.sleep(1500);
		logger.info("***** My Pet details has been added successfully *******");
	}

	@Test(priority = 11, enabled = true)
	public void AddPet_PetHealth() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath(prop.getProperty("N_Antibiotic"))).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,200)");
		WebElement anti1 = driver.findElement(By.xpath(prop.getProperty("N_cefovecin")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", anti1);
		Thread.sleep(1000);
		WebElement anti2 = driver.findElement(By.xpath(prop.getProperty("N_cephalexin")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", anti2);
		Thread.sleep(1000);
		WebElement anti3 = driver.findElement(By.xpath(prop.getProperty("N_Other")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", anti3);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);
		
		WebElement bodycon = driver.findElement(By.xpath(prop.getProperty("N_Body_condition")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", bodycon);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,900)");
		Thread.sleep(2000);
		
		WebElement med = driver.findElement(By.xpath(prop.getProperty("N_Medication")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", med);
		Thread.sleep(2000);
		WebElement med1 = driver.findElement(By.xpath(prop.getProperty("N_Antithis")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", med1);
		Thread.sleep(2000);
		WebElement med2 = driver.findElement(By.xpath(prop.getProperty("N_antiseiz")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", med2);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(2000);
		WebElement supp = driver.findElement(By.xpath(prop.getProperty("N_supplement")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", supp);
		Thread.sleep(2000);
		WebElement supp1 = driver.findElement(By.xpath(prop.getProperty("N_postbiotic")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", supp1);
		Thread.sleep(2000);		
		WebElement supp2 = driver.findElement(By.xpath(prop.getProperty("N_JointHealth")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", supp2);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(2000);
		WebElement absupp = driver.findElement(By.xpath(prop.getProperty("N_AbSupplements")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", absupp);
		Thread.sleep(2000);
		WebElement absupp1 = driver.findElement(By.xpath(prop.getProperty("N_GMP")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", absupp1);
		Thread.sleep(2000);
		WebElement absupp2 = driver.findElement(By.xpath(prop.getProperty("N_GRS")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", absupp2);
		Thread.sleep(2000);
		WebElement absuppchild = driver.findElement(By.xpath(prop.getProperty("N_30Capsules")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", absuppchild);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(2000);
		
		WebElement phy = driver.findElement(By.xpath(prop.getProperty("N_Physicalcondition")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", phy);
		Thread.sleep(2000);
		WebElement phy1 = driver.findElement(By.xpath(prop.getProperty("N_OralHealth")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", phy1);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);
		WebElement phychild = driver.findElement(By.xpath(prop.getProperty("N_CG")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", phychild);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(1000);
		WebElement phy2 = driver.findElement(By.xpath(prop.getProperty("N_GiHealth")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", phy2);
		Thread.sleep(2000);		
		WebElement phychild2 = driver.findElement(By.xpath(prop.getProperty("N_C_Constipation")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", phychild2);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(500);
		Actions actions = new Actions(driver);
		WebElement E = driver.findElement(By.xpath(prop.getProperty("N_PH_Notes")));
		actions.moveToElement(E).click().sendKeys(prop.getProperty("N_Enter_Notes")).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Diet"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("N_Dry"))).click();
		Thread.sleep(2000);
		WebElement symp = driver.findElement(By.xpath(prop.getProperty("N_Symtoms_None")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", symp);
		Thread.sleep(2000);	
		WebElement PHbtn = driver.findElement(By.xpath(prop.getProperty("N_PH_Next")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", PHbtn);
		logger.info("***** My Pet health details has been added successfully *******");

	}

	@Test(priority = 12, enabled = true)
	public void AddPet_vet() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		WebElement addvet = driver.findElement(By.xpath(prop.getProperty("N_Add_Vet")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addvet);
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Vet_clinic_Name"))).sendKeys(prop.getProperty("N_Enter_Vclinic_Name"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Vet_Name"))).sendKeys(prop.getProperty("N_Enter_Vname"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_V_Street"))).sendKeys(prop.getProperty("N_V_Enter_Street"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_V_City"))).sendKeys(prop.getProperty("N_V_Enter_City"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_V_State"))).sendKeys(prop.getProperty("N_V_Enter_State"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_V_postal_code"))).sendKeys(prop.getProperty("N_V_Enter_Postal_Code"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_V_VetEmail"))).sendKeys(prop.getProperty("N_Enter_VetEmail"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_V_PhoneNo"))).sendKeys(prop.getProperty("N_Enter_PH"));
		Thread.sleep(2000);
		WebElement save = driver.findElement(By.xpath(prop.getProperty("N_V_save")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", save);
		Thread.sleep(2000);
		WebElement complete = driver.findElement(By.xpath(prop.getProperty("N_complete")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", complete);
		Thread.sleep(1000);
		System.out.println("Vet Added Successfully");
		logger.info("***** My Pet vet details has been added successfully *******");
		Thread.sleep(50000);
		WebElement titleValidation = driver.findElement(By.xpath("//span[text()='Complete']"));

		String expectedText = "Complete";
		String actualText = titleValidation.getText();
		if (actualText.equals(expectedText)) {
			System.out.println("Both Text are Same. The title is" + actualText);
		} else {
			System.out.println("Both Text are not Same. The dispalyed text is" + actualText);
		}
		Thread.sleep(2000);
		//driver.findElement(By.xpath(prop.getProperty("N_Pet_Portal_Home"))).click();
		WebElement pethome = driver.findElement(By.xpath(prop.getProperty("N_Pet_Portal_Home")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", pethome);
		logger.info("***** Title vaildation successfully completed *******");

	}

}
