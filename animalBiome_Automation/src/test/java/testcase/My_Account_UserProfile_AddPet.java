package testcase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class My_Account_UserProfile_AddPet {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("My_Account_UserProfile_AddPet.properties");
	Logger logger = LogManager.getLogger(My_Account_UserProfile_AddPet.class);

	@Test(priority = 20, enabled = true)
	public void My_Ac_AddPet() throws InterruptedException, AWTException {
		logger.info("***** Started going to My account user profile & adding pet *******");
		Thread.sleep(8000);
		driver.findElement(By.xpath(prop.getProperty("N_myaccount"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_userprofile"))).click();
		logger.info("***** Started adding pet *******");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_AddPet"))).click();
		Thread.sleep(2000);
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
		act.dragAndDropBy(ele, 30, 20).perform();
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
		logger.info("***** My pet section has been added successfully*******");

	}

	@Test(priority = 21, enabled = true)
	public void AddPet_PetHealth() throws InterruptedException, AWTException, TimeoutException {
		Thread.sleep(2000);
		logger.info("***** Pet health section adding process has been started *******");
		driver.findElement(By.xpath(prop.getProperty("N_Antibiotic"))).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(2000);
		List<WebElement> a = driver.findElements(By.xpath(prop.getProperty("N_Antibiotics_List")));
		Thread.sleep(3000);
		for (WebElement A1 : a) {
			A1.click();
			Thread.sleep(1000);
		}
		js.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_B_condition"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Medication"))).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(4000);
		List<WebElement> m = driver.findElements(By.xpath(prop.getProperty("N_Medications_List")));
		Thread.sleep(3000);
		for (WebElement A2 : m) {
			A2.click();
			Thread.sleep(1000);
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_MM_C/P"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_supplement"))).click();
		Thread.sleep(4000);
		List<WebElement> s = driver.findElements(By.xpath(prop.getProperty("N_Suppliments_List")));
		Thread.sleep(3000);
		for (WebElement A3 : s) {
			A3.click();
			Thread.sleep(1000);
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_Insulin"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_Fos"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_PHusk"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_FBlend"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Other"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("N_AbSupplements"))).click();
		Thread.sleep(2000);
		List<WebElement> abs = driver.findElements(By.xpath(prop.getProperty("N_Ab_Supplements_List")));
		Thread.sleep(3000);
		for (WebElement A4 : abs) {
			A4.click();
			Thread.sleep(1000);
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_30"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_60"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_Physicalcondition"))).click();
		Thread.sleep(3000);
		List<WebElement> pcm = driver.findElements(By.xpath(prop.getProperty("N_Physical_main_List")));
		Thread.sleep(3000);
		for (WebElement A5 : pcm) {
			A5.click();
			Thread.sleep(1000);
		}
		Thread.sleep(3000);
		List<WebElement> pcn = driver.findElements(By.xpath(prop.getProperty("N_Phsy_Condition_Nested_List")));
		Thread.sleep(3000);
		for (WebElement A6 : pcn) {
			A6.click();
			Thread.sleep(1000);
		}
		Thread.sleep(3000);
		List<WebElement> pcn1 = driver.findElements(By.xpath(prop.getProperty("N_Psy_Condition_Remain")));
		Thread.sleep(3000);
		for (WebElement A7 : pcn1) {
			A7.click();
			Thread.sleep(1000);
		}
		Thread.sleep(3000);
		List<WebElement> pcn2 = driver.findElements(By.xpath(prop.getProperty("N_Phsy_Condition_Nested_List")));
		Thread.sleep(3000);
		for (WebElement A8 : pcn2) {

			if (!A8.isSelected()) {
				A8.click();
				Thread.sleep(1000);
			}

		}
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		WebElement E = driver.findElement(By.xpath(prop.getProperty("N_PH_Notes")));
		actions.moveToElement(E).click().sendKeys(prop.getProperty("N_Enter_Notes")).perform();

		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Diet"))).click();
		Thread.sleep(4000);
		List<WebElement> Diet = driver.findElements(By.xpath(prop.getProperty("N_Diet_List")));
		Thread.sleep(3000);
		for (WebElement A9 : Diet) {

			if (!A9.isSelected()) {
				A9.click();
				Thread.sleep(1000);
			}

		}
		Thread.sleep(4000);
		List<WebElement> DC = driver.findElements(By.xpath(prop.getProperty("N_Diet_List")));
		Thread.sleep(2000);
		for (WebElement A10 : DC) {

			if (!A10.isSelected()) {
				A10.click();
				Thread.sleep(1000);
			}

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Symptoms"))).click();
		Thread.sleep(3000);
		List<WebElement> symp = driver.findElements(By.xpath(prop.getProperty("N_Main_Symptoms")));
		Thread.sleep(2000);
		for (WebElement A11 : symp) {

			if (!A11.isSelected()) {
				A11.click();
				Thread.sleep(1000);
			}

		}
		Thread.sleep(3000);
		List<WebElement> symp1 = driver.findElements(By.xpath(prop.getProperty("N_Main_Symptoms")));
		Thread.sleep(2000);
		for (WebElement A12 : symp1) {

			if (!A12.isSelected()) {
				A12.click();
				Thread.sleep(1000);
			}

		}
		Thread.sleep(3000);

		List<WebElement> sev = driver.findElements(By.xpath(prop.getProperty("N_All_Severity")));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds

		for (WebElement A13 : sev) {
			wait.until(ExpectedConditions.elementToBeClickable(A13)); // Wait until the element is clickable

			// Check if the WebElement is a dropdown (select element)
			if (A13.getTagName().equals("select")) {
				Select s1 = new Select(A13);
				// Check if the element is not selected and then select by index
				if (!s1.isMultiple() && !s1.getFirstSelectedOption().getText().equals("Desired Option")) {
					s1.selectByIndex(2);
					Thread.sleep(1000);
				}
			}
			// Check if the WebElement is a checkbox (input type="checkbox")
			else if (A13.getTagName().equals("input") && A13.getAttribute("type").equals("checkbox")) {
				// Ensure the checkbox is enabled
				if (A13.isEnabled() && !A13.isSelected()) {
					A13.click(); // Click if enabled and not selected
					Thread.sleep(1000);
				}
			}

			// Handle frequency checkboxes in the same way
			List<WebElement> freq = driver.findElements(By.xpath(prop.getProperty("N_All_Frequency")));
			for (WebElement A14 : freq) {
				wait.until(ExpectedConditions.elementToBeClickable(A14)); // Wait until the element is clickable

				// Check if the WebElement is a dropdown (select element)
				if (A14.getTagName().equals("select")) {
					Select s2 = new Select(A14);
					// Check if the element is not selected and then select by index
					if (!s2.isMultiple() && !s2.getFirstSelectedOption().getText().equals("Desired Option")) {
						s2.selectByIndex(2);
						Thread.sleep(1000);
				}
				}
				// Handle the checkbox interaction
				else if (A14.getTagName().equals("input") && A14.getAttribute("type").equals("checkbox")) {
					// Ensure the checkbox is enabled
					if (A14.isEnabled() && !A14.isSelected()) {
						A14.click(); // Click if enabled and not selected
						Thread.sleep(1000);
					}
				}
			}
		}
		Thread.sleep(3000);
		WebElement E1 = driver.findElement(By.xpath(prop.getProperty("N_Current_CD")));
		actions.moveToElement(E1).click().sendKeys(prop.getProperty("N_CD_Notes")).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_PH_Next"))).click();

	}

	@Test(priority = 22, enabled = true)
	public void AddPet_vet() throws InterruptedException, AWTException {
		Thread.sleep(4000);
		logger.info("***** Vet details adding process has been started *******");
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
		logger.info("***** Vet details added successfully *******");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(150)); // Increase timeout if needed
		WebElement currentCDElement = wait
		    .until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("N_Pet_Portal_Home"))));
		currentCDElement.click();
		Thread.sleep(5000);
		WebElement titleValidation = driver.findElement(By.xpath(
				"//div[@class='col-sm-12 col-lg-12 col-md-12 alert alert-success alert-dismissible ng-star-inserted']"));

		String expectedText = "Pet added successfully.";
		String actualText = titleValidation.getText();
		if (actualText.equals(expectedText)) {
			System.out.println("Both Text are Same. The title is" + actualText);
		} else {
			System.out.println("Both Text are not Same. The dispalyed text is" + actualText);
		}

		logger.info("***** Pet added successfully with full details *******");

	}

}
