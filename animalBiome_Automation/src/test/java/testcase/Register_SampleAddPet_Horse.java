package testcase;

import java.io.IOException;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

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

public class Register_SampleAddPet_Horse {
	Logger logger = LogManager.getLogger(Register_SampleAddPet_Horse.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Register_SampleAddPet_Horse.properties");


@Test(enabled = true)
public void AddingHorsePetDetails() throws InterruptedException, IOException {
	Thread.sleep(4000);
	driver.findElement(By.xpath(prop.getProperty("N_Register_Sample"))).click();
	Thread.sleep(1500);
	logger.info("***** Adding a horse with all details in my pet section*******");
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	driver.findElement(By.xpath(prop.getProperty("NADDPET"))).click();
	Thread.sleep(3000);
	jse.executeScript("window.scrollBy(0,200)");
	driver.findElement(By.xpath(prop.getProperty("NHorse"))).click();
	Thread.sleep(2000);
	jse.executeScript("window.scrollBy(0,200)");
	driver.findElement(By.xpath(prop.getProperty("NselectBreed"))).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath(prop.getProperty("NbreedType"))).click();
	Thread.sleep(2000);
	
	
	String excelPath = PropertiesFile.getExcelFilePath();
	String sheetName = PropertiesFile.getPetExcelSheetName();

	ExcelUtils.loadExcelFile(excelPath, sheetName);

	String speciesSelected = "User_Horse";
	String newPetName = base.ExcelUtils.UniquePetName(prop.getProperty("N_Enter_Horse_Name"));

	driver.findElement(By.xpath(prop.getProperty("N_Horse_Name"))).sendKeys(newPetName);

	ExcelUtils.addPetNameToSpeciesColumn(speciesSelected, newPetName);
	
	Thread.sleep(1500);
	driver.findElement(By.xpath(prop.getProperty("N_Age_Years"))).sendKeys(prop.getProperty("N_enter_Age"));
	Thread.sleep(1500);
	driver.findElement(By.xpath(prop.getProperty("N_Age_Months"))).sendKeys(prop.getProperty("N_enter_Month"));
	Thread.sleep(1000);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement dropdown = wait
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("N_Horse_Sex"))));
	Select horseSexSelect = new Select(dropdown);
	horseSexSelect.selectByIndex(2);

	Thread.sleep(3000);
	driver.findElement(By.xpath(prop.getProperty("N_weight"))).sendKeys("92");
	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("N_kg_lbs"))).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath(prop.getProperty("N_Primary_Dis"))).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath(prop.getProperty("N_select_Dis"))).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath(prop.getProperty("N_Dis_Type"))).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath(prop.getProperty("N_Cold_Breaking"))).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("N_Cold_Breaking_Text")))
			.sendKeys(prop.getProperty("N_CB_Enter_text"));
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
	logger.info("***** My Pet details of horse has been added successfully *******");
}

@Test(enabled = true)
public void AddingHorsePetHealthdetails() throws InterruptedException {
	Thread.sleep(2000);
	logger.info("***** Adding a horse with all details in pet Health section*******");
	driver.findElement(By.xpath(prop.getProperty("N_Antibiotics_yes"))).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath(prop.getProperty("N_Antibiotics_Type"))).sendKeys(prop.getProperty("N_anti_Name"));
	Thread.sleep(2000);
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	jse.executeScript("window.scrollBy(0,200)");
	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("N_Medication_yes"))).click();
	Thread.sleep(2000);
	List<WebElement> med = driver.findElements(By.xpath(prop.getProperty("N_All_Medication")));
	Thread.sleep(2000);
	for (WebElement m : med) {

		if (!m.isSelected()) {
			m.click();
			Thread.sleep(1000);
		}

	}
	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	List<WebElement> Mdesc = driver.findElements(By.xpath(prop.getProperty("N_All_Med_Description")));
	Set<WebElement> alreadyUsed = new HashSet<>(); // Store filled elements

	for (WebElement m1 : Mdesc) {
		wait1.until(ExpectedConditions.elementToBeClickable(m1));
		if (m1.isDisplayed() && m1.isEnabled()) {
			m1.clear();
			m1.sendKeys(prop.getProperty("N_Type_desc"));
			alreadyUsed.add(m1); // Track this field
		}
	}

	jse.executeScript("window.scrollBy(0,200)");
	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("N_Timeframe"))).click();
	Thread.sleep(2000);
	driver.switchTo() /* frame("kustomer-ui-sdk-iframe") */ ;
	driver.findElement(By.xpath(prop.getProperty("N_Timeframe_Type"))).click();
	Thread.sleep(3000);
	jse.executeScript("window.scrollBy(0,200)");
	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("N_Suppliment_Yes"))).click();
	Thread.sleep(2000);
	jse.executeScript("window.scrollBy(0,200)");
	Thread.sleep(3000);
	driver.findElement(By.xpath(prop.getProperty("N_Suppliment_Brand")))
			.sendKeys(prop.getProperty("N_enter_Brand"));
	Thread.sleep(3000);
	driver.findElement(By.xpath(prop.getProperty("N_Suppliment_type")))
			.sendKeys(prop.getProperty("N_product_Type"));
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
	horseLive.selectByIndex(3);
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
	horseGrazing.selectByIndex(3);
	Thread.sleep(2000);
	jse.executeScript("window.scrollBy(0,200)");
	Thread.sleep(2000);

	driver.findElement(By.xpath(prop.getProperty("N_Horse_grain_yes"))).click();
	Thread.sleep(2000);

	driver.findElement(By.xpath(prop.getProperty("N_Grain_Brand"))).sendKeys(prop.getProperty("N_Brand_name"));
	Thread.sleep(3000);
	driver.findElement(By.xpath(prop.getProperty("N_Grain_formulation")))
			.sendKeys(prop.getProperty("N_Formulation_Name"));
	Thread.sleep(3000);
	driver.findElement(By.xpath(prop.getProperty("N_pound_perDay")))
			.sendKeys(prop.getProperty("N_Enter_Pound_PerDay"));

	Thread.sleep(2000);

	jse.executeScript("window.scrollBy(0,200)");
	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("N_Horse_Hay_yes"))).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("N_Hay_type"))).sendKeys(prop.getProperty("N_Enter_Type"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("N_Hay_PoundPerDay")))
			.sendKeys(prop.getProperty("N_Hay_enter_pound"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("N_Horse_Physical_Yes"))).click();
	Thread.sleep(2000);
	List<WebElement> phycond = driver.findElements(By.xpath(prop.getProperty("N_All_phycond")));
	WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
	for (WebElement pc : phycond) {
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("N_All_phycond"))));
		if (!pc.isSelected()) {
			pc.click();

		}

	}
	Thread.sleep(3000);
	WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
	List<WebElement> ptext = driver.findElements(By.xpath(prop.getProperty("N_Phycond_Text")));

	for (WebElement pc : ptext) {
		if (alreadyUsed.contains(pc)) {
			continue;
		}

		wait3.until(ExpectedConditions.elementToBeClickable(pc));
		String existingText = pc.getAttribute("value");

		if (pc.isDisplayed() && pc.isEnabled() && (existingText == null || existingText.trim().isEmpty())) {
			pc.clear();
			pc.sendKeys(prop.getProperty("N_pc_enter_text"));
		}
	}

	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("N_H_Symptoms_Yes"))).click();
	Thread.sleep(3000);
	List<WebElement> symp = driver.findElements(By.xpath(prop.getProperty("N_H_All_Symptoms")));
	Thread.sleep(2000);
	for (WebElement s : symp) {

		if (!s.isSelected()) {
			s.click();
			Thread.sleep(1000);
		}
	}
	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("N_Behave_Text")))
			.sendKeys(prop.getProperty("N_Behave_EnterText"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("N_GiConcern_Text")))
			.sendKeys(prop.getProperty("N_GiConcern_EnterText"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("N_Oral_Text")))
			.sendKeys(prop.getProperty("N_Oral_EnterText"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("N_Skin_text")))
			.sendKeys(prop.getProperty("N_Skin_enterText"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("N_Stiff_Text")))
			.sendKeys(prop.getProperty("N_Stiff_Enter_text"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("N_other_text")))
			.sendKeys(prop.getProperty("N_Other_EnterText"));
	
	Thread.sleep(3000);
	List<WebElement> sev = driver.findElements(By.xpath(prop.getProperty("N_H_All_Severity")));
	Thread.sleep(2000);
	for (WebElement se : sev) {
		wait.until(ExpectedConditions.elementToBeClickable(se));
		if (se.getTagName().equals("select")) {
			Select s1 = new Select(se);
			s1.selectByIndex(1);
			Thread.sleep(1000);
		}
	}
	Thread.sleep(3000);
	List<WebElement> freq = driver.findElements(By.xpath(prop.getProperty("N_H_All_Frequency")));
	Thread.sleep(2000);
	for (WebElement fre : freq) {
		wait.until(ExpectedConditions.elementToBeClickable(fre));
		if (fre.getTagName().equals("select")) {
			Select f = new Select(fre);
			f.selectByIndex(1);
			Thread.sleep(1000);
		}
	}
	Thread.sleep(3000);
	jse.executeScript("window.scrollBy(0,200)");
	Thread.sleep(2000);
	WebElement wl = wait
			.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("N_Avg_Workload"))));
	Select workLoad = new Select(wl);
	workLoad.selectByIndex(3);
	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("N_Hault_Yes"))).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath(prop.getProperty("N_Stressor_Yes"))).click();
	Thread.sleep(3000);
	jse.executeScript("window.scrollBy(0,200)");
	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("N_PetHealth_Next"))).click();
	Thread.sleep(3000);
	jse.executeScript("window.scrollBy(0,300)");
	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("N_Horse_Complete"))).click();
	WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement hp =wait4
			.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("N_Horse_Portal"))));
	hp.click();
	Thread.sleep(6000);
	WebElement titleValidation = driver.findElement(By.xpath(
			"//div[@class='col-sm-12 col-lg-12 col-md-12 alert alert-success alert-dismissible ng-star-inserted']"));

	String expectedText = "Pet added successfully.";
	String actualText = titleValidation.getText();
	if (actualText.equals(expectedText)) {
		System.out.println("Both Text are Same. The title is" + actualText);
	} else {
		System.out.println("Both Text are not Same. The dispalyed text is" + actualText);
	}

	logger.info("***** Horse added successfully with all details w/o image & vet *******");


}
}
