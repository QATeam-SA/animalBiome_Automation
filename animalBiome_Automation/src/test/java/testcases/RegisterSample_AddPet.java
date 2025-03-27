package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class RegisterSample_AddPet {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("RegisterSample_AddPet.properties");
	Logger logger = LogManager.getLogger(RegisterSample_AddPet.class);
	@Test(priority = 10, enabled = true)
	public void AddPet_MyPet() throws InterruptedException, AWTException {
		Thread.sleep(8000);
		driver.findElement(By.xpath(prop.getProperty("Nmyaccount"))).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(prop.getProperty("N_Pet_PortalHome"))).click();
		Thread.sleep(2000);
		logger.info("***** Started adding pet *******");
		driver.findElement(By.xpath(prop.getProperty("Nregister_sample"))).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(prop.getProperty("N_addpet"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("N_Profile_Picture"))).click();

		Thread.sleep(5000);

		Robot rb = new Robot();
		rb.delay(2000);

		StringSelection ss = new StringSelection(prop.getProperty("Upload_Dog"));
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
		WebElement ele = driver.findElement(By.xpath(prop.getProperty("NDrag_&_drop")));
		Thread.sleep(2000);
		act.dragAndDropBy(ele, 30, 60).perform();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		driver.findElement(By.xpath(prop.getProperty("N_Submit"))).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,300)", "");
		driver.findElement(By.xpath(prop.getProperty("N_select_breed"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("Nbreed"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("NP_Name"))).sendKeys(prop.getProperty("NPet_Name"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("NP_Name_R"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Age_Years"))).sendKeys(prop.getProperty("N_enter_Age_Y"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Age_Month"))).sendKeys(prop.getProperty("N_enter_Age_M"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Gender"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Weight"))).sendKeys(prop.getProperty("N_Enter_Weight"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Kg/Lbs"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_S/N"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_street"))).sendKeys(prop.getProperty("N_Enter_street"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_city"))).sendKeys(prop.getProperty("N_Enter_City"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_postal_Code"))).sendKeys(prop.getProperty("N_Postal_Code"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_state"))).sendKeys(prop.getProperty("N_Enter_State"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_MP_Next"))).click();
		logger.info("***** My Pet details has been added successfully *******");
	}

	@Test(priority = 11, enabled = true)
	public void AddPet_PetHealth() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath(prop.getProperty("N_Antibiotic"))).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath(prop.getProperty("N_cefovecin"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("N_cephalexin"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("N_Other"))).click();
		Thread.sleep(1000);

		js.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("N_B_condition"))).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Medication"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Antithis"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_antiseiz"))).click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_supplement"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_postbiotic"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_JointHealth"))).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_AbSupplements"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_GMP"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_GRS"))).click();
		js.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_30Capsules"))).click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Physicalcondition"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_OralHealth"))).click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("N_CG"))).click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("N_GiHealth"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_C_Constipation"))).click();
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
		driver.findElement(By.xpath(prop.getProperty("N_Symtoms_None"))).click();
		/*
		 * driver.findElement(By.xpath(prop.getProperty("N_Wet"))).click();
		 * Thread.sleep(2000);
		 */

		/*
		 * driver.findElement(By.xpath(prop.getProperty("N_Symptoms"))).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath(prop.getProperty("N_GiConcern"))).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath(prop.getProperty("N_Symptom_Cons"))).click();
		 * Thread.sleep(2000); WebElement e =
		 * driver.findElement(By.xpath(prop.getProperty("N_CS"))); Select ss = new
		 * Select(e); Thread.sleep(2000); ss.selectByIndex(2); Thread.sleep(2000);
		 * WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		 * WebElement e1 =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty(
		 * "N_CF")))); Select sf = new Select(e1); Thread.sleep(4000);
		 * ss.selectByIndex(3); Thread.sleep(2000);
		 * driver.findElement(By.xpath(prop.getProperty("N_Current_CD"))).sendKeys(prop.
		 * getProperty("N_CD_Notes"));
		 */
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_PH_Next"))).click();
		logger.info("***** My Pet health details has been added successfully *******");

	}

	@Test(priority = 12, enabled = true)
	public void AddPet_vet() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Add_Vet"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Vet_clinic_Name")))
				.sendKeys(prop.getProperty("N_Enter_Vclinic_Name"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Vet_Name"))).sendKeys(prop.getProperty("N_Enter_Vname"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_V_Street"))).sendKeys(prop.getProperty("N_V_Enter_Street"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_V_City"))).sendKeys(prop.getProperty("N_V_Enter_City"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_V_State"))).sendKeys(prop.getProperty("N_V_Enter_State"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_V_postal_code")))
				.sendKeys(prop.getProperty("N_V_Enter_Postal_Code"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_V_VetEmail"))).sendKeys(prop.getProperty("N_Enter_VetEmail"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_V_PhoneNo"))).sendKeys(prop.getProperty("N_Enter_PH"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_V_save"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_complete"))).click();
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
		driver.findElement(By.xpath(prop.getProperty("N_Pet_Portal_Home"))).click();
		logger.info("***** Title vaildation successfully completed *******");

	}

}
