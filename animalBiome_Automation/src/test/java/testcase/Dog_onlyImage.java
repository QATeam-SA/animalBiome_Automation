package testcase;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.ExcelUtils;
import base.Instance;
import base.PropertiesFile; 

public class Dog_onlyImage {
	
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Dog_onlyImage.properties");
	Logger logger = LogManager.getLogger(Dog_onlyImage.class);



	@Test(priority = 9, enabled = true)
	public void AddingDogOnlyWithImgAndNotVetDetails() throws Exception {

		// ------- MY PET---------

		JavascriptExecutor js = MypetDetails();

		// ----------PET HEALTH---------

		PetHealthdetails(js);

	}
	
	private JavascriptExecutor MypetDetails() throws InterruptedException, Exception {

		logger.info("***Started adding dog with image****");
		Thread.sleep(10000);
		driver.findElement(By.xpath(prop.getProperty("G_AddPet"))).click();
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath(prop.getProperty("G_DogButton")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		
		WebElement fileInput = driver.findElement(By.xpath(prop.getProperty("FileUploadInput")));
        fileInput.sendKeys(prop.getProperty("G_UploadImage"));
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("G_ImageSubmit"))).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("G_SelectBreed"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("G_BreedName"))).click();
		Thread.sleep(3000);
		String excelPath = PropertiesFile.getExcelFilePath();
		String sheetName = PropertiesFile.getPetExcelSheetName();

		ExcelUtils.loadExcelFile(excelPath, sheetName);

		String newPetName = base.ExcelUtils.UniquePetName(prop.getProperty("G_Enter_Dog_Name"));
		driver.findElement(By.xpath(prop.getProperty("G_Dog_Name"))).sendKeys(newPetName);
		Thread.sleep(1000);
		driver.findElement(By.name(prop.getProperty("G_Dogyears"))).sendKeys("11");
		Thread.sleep(1000);
		driver.findElement(By.name(prop.getProperty("G_Dogmonths"))).sendKeys("10");
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath(prop.getProperty("G_Dogsex")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.name(prop.getProperty("G_Dogweight"))).sendKeys("9999.99");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_weightunits"))).click();
		Thread.sleep(1500);
		WebElement gender = driver.findElement(By.xpath(prop.getProperty("G_Doggender")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", gender);
		Thread.sleep(1500);		
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_Street"))).sendKeys("Street");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_City"))).sendKeys("City");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_State"))).sendKeys("State");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_PostalCode"))).sendKeys("785670");
		Thread.sleep(1000);
		Select s = new Select(driver.findElement(By.xpath(prop.getProperty("G_Country"))));
		s.selectByVisibleText("Andorra");
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_AddPet_Nextbutton"))).click();
		System.out.println("***Added Pet Details successfully****");
		return js;

	}

	private void PetHealthdetails(JavascriptExecutor js) throws InterruptedException {

		logger.info("****Started added user dog health details****");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_Antibiotics"))).click();
		Thread.sleep(2000);
		List<WebElement> checkboxes = driver.findElements(By.xpath(prop.getProperty("G_AllAntibiotics")));
		for (WebElement checkbox : checkboxes) {
			if (checkbox.isDisplayed()) {
				js.executeScript("arguments[0].click();", checkbox);
				Thread.sleep(1000);
			}
		}	
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,700)");
		
		WebElement bodycond = driver.findElement(By.id(prop.getProperty("G_Bodyconditions")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bodycond);
		Thread.sleep(1000);
		bodycond.click();
		Thread.sleep(3000);
		
		WebElement Med = driver.findElement(By.xpath(prop.getProperty("G_Medications")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Med);
		Thread.sleep(500);
		Med.click();
		Thread.sleep(3000);
		List<WebElement> allcheckboxes = driver.findElements(By.xpath(prop.getProperty("G_AllMedications")));
		for (WebElement checkbox : allcheckboxes) {
			if (checkbox.isDisplayed()) {
				js.executeScript("arguments[0].click();", checkbox);
				Thread.sleep(1000);
			}
		}

		WebElement medcond = driver.findElement(By.xpath(prop.getProperty("G_cisapride/Propulsid")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", medcond);
		Thread.sleep(1000);
		medcond.click();
        Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(prop.getProperty("G_Supplements"))).click();
		Thread.sleep(1500);
		List<WebElement> suppcheck = driver.findElements(By.name(prop.getProperty("G_AllSupplements")));
		for (WebElement checkbox : suppcheck) {
			if (checkbox.isDisplayed()) {
				js.executeScript("arguments[0].click();", checkbox);
				Thread.sleep(1000);
			}
		}
		Thread.sleep(1000);
		List<WebElement> suppchild = driver.findElements(By.xpath(prop.getProperty("G_Fiberchild")));
		for (WebElement checkbox : suppchild) {
			if (checkbox.isDisplayed()) {
				js.executeScript("arguments[0].click();", checkbox);
				Thread.sleep(1000);
			}
		}
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2500);

		WebElement aBsupp = driver.findElement(By.xpath(prop.getProperty("G_ABSupplements")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aBsupp);
		Thread.sleep(1000);
		aBsupp.click();
		Thread.sleep(1000);
		List<WebElement> absupp = driver.findElements(By.name(prop.getProperty("G_AllabSupplements")));
		for (WebElement checkbox : absupp) {
			if (checkbox.isDisplayed()) {
				js.executeScript("arguments[0].click();", checkbox);
				Thread.sleep(1000);
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		List<WebElement> absuppchild = driver.findElements(By.xpath(prop.getProperty("G_ABsuppchild")));
		for (WebElement checkbox : absuppchild) {
			if (checkbox.isDisplayed()) {
				js.executeScript("arguments[0].click();", checkbox);
				Thread.sleep(1000);
			}
		}
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		
		WebElement physical = driver.findElement(By.xpath(prop.getProperty("G_PhysicalConditions")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", physical);
		Thread.sleep(1000);
		physical.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_OralHealth"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_Chronic"))).click();		
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("G_Phydescription"))).sendKeys("All Physical conditions selected");
		Thread.sleep(2000);
		
		WebElement dietary = driver.findElement(By.xpath(prop.getProperty("G_Diet")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dietary);
		Thread.sleep(1000);
		dietary.click();
		driver.findElement(By.xpath(prop.getProperty("G_Wet"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_DryKibble"))).click();
		Thread.sleep(2000);
		
		WebElement sympt = driver.findElement(By.xpath(prop.getProperty("G_Symptoms")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sympt);
		Thread.sleep(1000);
		sympt.click();
		Thread.sleep(1500);
		WebElement symchild = driver.findElement(By.xpath(prop.getProperty("G_GIConcerns")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", symchild);
		Thread.sleep(1000);
		symchild.click();		
		Thread.sleep(1000);
		WebElement symp1 = driver.findElement(By.xpath(prop.getProperty("G_Gichild")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", symp1);
		Thread.sleep(1000);
		symp1.click();		
		Thread.sleep(1000);
		Select severity = new Select(driver.findElement(By.xpath(prop.getProperty("G_Severity"))));
		severity.selectByVisibleText("Mild");
		Thread.sleep(1000);
		Select freq = new Select(driver.findElement(By.xpath(prop.getProperty("G_Frequency"))));
		freq.selectByVisibleText(" Sometimes, a single episode ");
		Thread.sleep(1000);		
		driver.findElement(By.xpath(prop.getProperty("G_Symdescription"))).sendKeys("All Symptoms are selected.");
		Thread.sleep(1000);
		
		WebElement nextbtn = driver.findElement(By.xpath(prop.getProperty("G_HealthNext")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextbtn);
		Thread.sleep(1000);
		nextbtn.click();
		Thread.sleep(2000);
		WebElement endpbtn = driver.findElement(By.xpath(prop.getProperty("G_Complete")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", endpbtn);
		Thread.sleep(1000);
		endpbtn.click();
		System.out.println("***User dog added with health details***");
		Thread.sleep(9000);
		WebElement viewportal = driver.findElement(By.xpath(prop.getProperty("G_PetPortalHome")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewportal);
		Thread.sleep(1000);
		viewportal.click();
		System.out.println("***Pet added successfully with image & without Vet***");
	}

}

