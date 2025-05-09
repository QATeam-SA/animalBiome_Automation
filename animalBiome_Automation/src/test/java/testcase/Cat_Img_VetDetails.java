package testcase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.ExcelUtils;
import base.Instance;
import base.PropertiesFile;

public class Cat_Img_VetDetails {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Cat_Img_VetDetails.properties");
	Logger logger = LogManager.getLogger(Cat_Img_VetDetails.class);

	@Test(priority = 4, enabled = true)
	public void AddingACatWithImageAndVetDetails() throws InterruptedException, AWTException, IOException
	{
		logger.info("Started adding mypet details");
		Thread.sleep(8000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		driver.findElement(By.xpath(prop.getProperty("j_addpet"))).click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath(prop.getProperty("j_select_cat"))).click();
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,-200)");
		driver.findElement(By.xpath(prop.getProperty("j_profile_pic"))).click();
		Thread.sleep(5000);
		Robot rb = new Robot();
		rb.delay(2000);

		StringSelection ss = new StringSelection(prop.getProperty("Upload_cat"));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.delay(2000);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.delay(2000);
		driver.switchTo();
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath(prop.getProperty("j_Drag_&_Drop")));
		Thread.sleep(2000);
		act.dragAndDropBy(ele, 30, 20).perform();
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,400)");
		driver.findElement(By.xpath(prop.getProperty("j_submit"))).click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath(prop.getProperty("j_cat_selectbreed"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("j_breeds"))).click();
		Thread.sleep(1000);
		String excelPath = PropertiesFile.getExcelFilePath();
		String sheetName = PropertiesFile.getPetExcelSheetName();

		ExcelUtils.loadExcelFile(excelPath, sheetName);

		String speciesSelected = "User_Cat";
		String newPetName = base.ExcelUtils.UniquePetName(prop.getProperty("j_Enter_Cat_Name"));

		driver.findElement(By.xpath(prop.getProperty("j_Cat_Name"))).sendKeys(newPetName);

		ExcelUtils.addPetNameToSpeciesColumn(speciesSelected, newPetName);
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("j_Age_Years"))).sendKeys(prop.getProperty("j_enter_Age"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("j_Age_Months"))).sendKeys(prop.getProperty("j_enter_Months"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("j_sex"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("j_weight"))).sendKeys("22");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("j_kg_lbs"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("j_S/N"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("j_street"))).sendKeys("Street");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("j_city"))).sendKeys("City");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("j_state"))).sendKeys("State");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("j_postalcode"))).sendKeys("785670");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("j_nxt_btn"))).click();
		Thread.sleep(2000);
		logger.info("My pet section has been added successfully");
	}
	
	  @Test(priority = 5, enabled = true) public void addpet_pethealth() throws
	  InterruptedException, AWTException 
	  {
		  logger.info("Started adding pet health details");
		  JavascriptExecutor jse = (JavascriptExecutor) driver;
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(prop.getProperty("j_Antibiotics"))).click();
		  Thread.sleep(2000);
		  jse.executeScript("window.scrollBy(0,200)");
		  List<WebElement> checkboxes = driver.findElements(By.xpath(prop.getProperty("j_AllAntibiotics")));
		  for (int i = 0; i < checkboxes.size(); i++) 
		  {
			  if (checkboxes.get(i).isDisplayed()) 
			  {
				  checkboxes.get(i).click();
				  Thread.sleep(1000);
			  }
		  }
		  Thread.sleep(3000);
		  driver.findElement(By.xpath(prop.getProperty("j_Body_condition"))).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(prop.getProperty("j_Medications"))).click();
		  Thread.sleep(2000);
		  List<WebElement> allcheckboxes = driver.findElements(By.name(prop.getProperty("j_AllMedications")));
			for (WebElement checkbox : allcheckboxes) 
			{
				if (!checkbox.isSelected()) 
				{

					checkbox.click();
					Thread.sleep(1000);
				}
			}
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		  driver.findElement(By.xpath(prop.getProperty("j_cisapride/Propulsid"))).click();
		  Thread.sleep(1000);
		  jse.executeScript("window.scrollBy(0,300)");
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(prop.getProperty("j_Supplements"))).click();
		  Thread.sleep(1500);
		  List<WebElement> suppcheck = driver.findElements(By.name(prop.getProperty("j_AllSupplements")));
			for (WebElement checkbox : suppcheck) 
			{
				if (!checkbox.isSelected()) 
				{

					checkbox.click();
					Thread.sleep(1000);
				}
			}
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		  List<WebElement> suppchild = driver.findElements(By.xpath(prop.getProperty("j_Fiberchild")));
			for (WebElement checkbox : suppchild) 
			{
				if (!checkbox.isSelected()) 
				{

					checkbox.click();
				}
			}
		  Thread.sleep(1000);
		  jse.executeScript("window.scrollBy(0,500)");
		  Thread.sleep(2500);
		  driver.findElement(By.xpath(prop.getProperty("j_ABSupplements"))).click();
			Thread.sleep(1000);
			List<WebElement> absupp = driver.findElements(By.name(prop.getProperty("j_All_ABSupllements")));
			for (WebElement checkbox : absupp) 
			{
				if (!checkbox.isSelected()) 
				{

					checkbox.click();
					Thread.sleep(1000);
				}
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			List<WebElement> absuppchild = driver.findElements(By.xpath(prop.getProperty("j_child_ABSupplemets")));
			for (WebElement checkbox : absuppchild) 
			{
				if (!checkbox.isSelected()) 
				{

					checkbox.click();
					Thread.sleep(1000);
				}
			}
			Thread.sleep(1000);
			jse.executeScript("window.scrollBy(0,500)");
			Thread.sleep(2500);
			driver.findElement(By.xpath(prop.getProperty("j_Physical_conditions"))).click();
			Thread.sleep(1000);
			List<WebElement> phycon = driver.findElements(By.name(prop.getProperty("j_All_phyconditions")));
			for (WebElement checkbox : phycon) 
			{
				if (!checkbox.isSelected()) 
				{
					checkbox.click();
					Thread.sleep(1000);
				}
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			List<WebElement> phyconchild = driver.findElements(By.xpath(prop.getProperty("j_PhycondChild")));
			for (WebElement checkbox : phyconchild) 
			{
				if (!checkbox.isSelected()) 
				{
					checkbox.click();
					Thread.sleep(1000);
				}
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			List<WebElement> phyconchild1 = driver.findElements(By.xpath(prop.getProperty("j_PhycondChild1")));
			for (WebElement checkbox : phyconchild1) 
			{
				if (!checkbox.isSelected()) 
				{
					checkbox.click();
					Thread.sleep(1000);
				}
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			List<WebElement> phyconchild2 = driver.findElements(By.xpath(prop.getProperty("j_PhycondChild1")));
			for (WebElement checkbox : phyconchild2) 
			{
				if (!checkbox.isSelected()) 
				{
					checkbox.click();
					Thread.sleep(1000);
				}
			}
			Thread.sleep(3000);
			driver.findElement(By.xpath(prop.getProperty("j_Phycond_description"))).sendKeys("All Physical conditions selected");
			Thread.sleep(2000);
			driver.findElement(By.xpath(prop.getProperty("j_Diet"))).click();
			Thread.sleep(2000);
			List<WebElement> diet = driver.findElements(By.xpath(prop.getProperty("j_Alldiet")));
			for (WebElement checkbox : diet) 
			{
				if (!checkbox.isSelected()) 
				{
					checkbox.click();
					Thread.sleep(1000);
				}
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			List<WebElement> dietchild = driver.findElements(By.xpath(prop.getProperty("j_Dietchild")));
			for (WebElement checkbox : dietchild) 
			{
				if (!checkbox.isSelected()) 
				{
					checkbox.click();
					Thread.sleep(1000);
				}
			}
			Thread.sleep(2000);
			driver.findElement(By.xpath(prop.getProperty("j_Symptoms"))).click();
			Thread.sleep(1000);
			List<WebElement> symp = driver.findElements(By.name(prop.getProperty("j_AllSymptoms")));
			for (WebElement checkbox : symp) 
			{
				if (!checkbox.isSelected()) 
				{
					checkbox.click();
					Thread.sleep(1000);
				}
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			List<WebElement> sympchild1 = driver.findElements(By.xpath(prop.getProperty("j_Sympchild1")));
			for (WebElement checkbox : sympchild1) 
			{
				if (!checkbox.isSelected()) 
				{
					checkbox.click();
					Thread.sleep(1000);
				}
			}
			List<WebElement> severity = driver.findElements(By.xpath(prop.getProperty("j_Severity")));
			for (WebElement checkbox : severity) 
			{
				if (!checkbox.isSelected()) 
				{
					checkbox.click();
				}
			}
			List<WebElement> frequency = driver.findElements(By.xpath(prop.getProperty("j_Frequency")));
			for (WebElement checkbox : frequency) 
			{
				if (checkbox.getTagName().equals("select")) 
				{
					Select s1 = new Select(checkbox);
					if (!s1.isMultiple() && !s1.getFirstSelectedOption().getText().equals("Desired Option")) 
					{
						s1.selectByIndex(3);
						Thread.sleep(1000);
					}
				}
			}
			Thread.sleep(1000);
			driver.findElement(By.xpath(prop.getProperty("j_Sympdescription"))).sendKeys("All Symptoms are selected.");
			Thread.sleep(1000);
			jse.executeScript("window.scrollBy(0,100)");
			driver.findElement(By.xpath(prop.getProperty("j_Next_btn"))).click();
			logger.info("Added pet health details successfully");
	  }
	  
	  @Test(priority = 6, enabled = true)
		public void addpet_vetdetails() throws InterruptedException 
	  {
		  Thread.sleep(2000);
		  logger.info("Started adding Vet details");
		  JavascriptExecutor jse = (JavascriptExecutor) driver;
		  jse.executeScript("window.scrollBy(0,100)");
		  driver.findElement(By.xpath(prop.getProperty("j_Addvet"))).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(prop.getProperty("j_ClinicName"))).sendKeys("Q's vet clinic");
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(prop.getProperty("j_Veternarian_Name"))).sendKeys("Drake");
		  Thread.sleep(2000);
		  jse.executeScript("window.scrollBy(0,300)");
		  Thread.sleep(3000);
		  driver.findElement(By.xpath(prop.getProperty("j_Clinic_Street"))).sendKeys("Street");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(prop.getProperty("j_Clinic_City"))).sendKeys("City");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(prop.getProperty("j_Clinic_State"))).sendKeys("State");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(prop.getProperty("j_Clinic_Postalcode"))).sendKeys("582720");
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(prop.getProperty("j_VetMail"))).sendKeys("qavet@gmail.com");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(prop.getProperty("j_vet_phnum"))).sendKeys("9876543210");
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(prop.getProperty("j_SaveButton"))).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath(prop.getProperty("j_Complete"))).click();
		  Thread.sleep(5000);
		  logger.info("Vet details added successfully");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(prop.getProperty("j_PetPortal"))).click();
		  Thread.sleep(8000);
		  logger.info("Pet added successfully with image & Vet details");
	  }
	  
}
