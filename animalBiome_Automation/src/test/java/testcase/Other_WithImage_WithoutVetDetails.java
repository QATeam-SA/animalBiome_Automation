package testcase;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class Other_WithImage_WithoutVetDetails {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Other_WithImage_WithoutVetDetails.properties");
	Logger logger = LogManager.getLogger(Other_WithImage_WithoutVetDetails.class);

	@Test(priority = 16, enabled = true)
	public void OtherSpeciesWithoutImageandVet() throws Exception {

		// ------- MY PET---------

		JavascriptExecutor js = OtherSpeciesDetails();

		// ----------PET HEALTH---------

		SpeciesHealthdetails(js);
	}

	private JavascriptExecutor OtherSpeciesDetails() throws InterruptedException, Exception {

		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath(prop.getProperty("G_AddPetButton"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_OtherButton"))).click();
		Thread.sleep(2000);
		Select species = new Select(driver.findElement(By.xpath(prop.getProperty("G_SelectSpecies"))));
		species.selectByVisibleText("Rabbit");
		Thread.sleep(1500);
		Select breed = new Select(driver.findElement(By.xpath(prop.getProperty("G_SelectBreed"))));
		breed.selectByVisibleText("Californian");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath(prop.getProperty("G_other_Profile_Picture"))).click();

		Thread.sleep(5000);

		Robot rb = new Robot();
		rb.delay(2000);

		StringSelection ss = new StringSelection(prop.getProperty("Upload_other"));
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
		WebElement ele = driver.findElement(By.xpath(prop.getProperty("G_Drag_&_drop")));
		Thread.sleep(2000);
		act.dragAndDropBy(ele, 20, 20).perform();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)", "");
		driver.findElement(By.xpath(prop.getProperty("G_Submit"))).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		driver.findElement(By.id(prop.getProperty("G_PetName")))
				.sendKeys((prop.getProperty("G_pet_Oname")) + "_" + System.currentTimeMillis());
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_NickName"))).click();
		Thread.sleep(1000);
		driver.findElement(By.name(prop.getProperty("G_Otheryears"))).sendKeys("2");
		driver.findElement(By.name(prop.getProperty("G_Othermonths"))).sendKeys("4");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_Othersex"))).click();
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.name(prop.getProperty("G_Otherweight"))).sendKeys("10");
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
		driver.findElement(By.xpath(prop.getProperty("G_AntiDesc"))).sendKeys("Antibiotics");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_Medications"))).click();
		Thread.sleep(1000);
		List<WebElement> allmed = driver.findElements(By.xpath(prop.getProperty("G_AllMedications")));
		for (int i = 0; i < allmed.size(); i++) {

			if (allmed.get(i).isDisplayed()) {

				allmed.get(i).click();
				Thread.sleep(500);
			}
		}
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> MedDesc = driver.findElements(By.xpath(prop.getProperty("G_MedicationsDesc")));
        Set<WebElement> alreadyUsed = new HashSet<>(); // Store filled elements
        for (WebElement m1 : MedDesc) {
            wait1.until(ExpectedConditions.elementToBeClickable(m1));
            if (m1.isDisplayed() && m1.isEnabled()) {
                m1.clear();
                m1.sendKeys("Medications");
                alreadyUsed.add(m1); // Track this field
            }
        }
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_Supplements"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_SupDesc"))).sendKeys("Supplements");
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_Physicalcond"))).click();
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,200)");
		List<WebElement> allphy = driver.findElements(By.xpath(prop.getProperty("G_AllPhysical")));
		for (WebElement checkbox : allphy) {
			if (!checkbox.isSelected()) {

				checkbox.click();
				Thread.sleep(500);

			}
		}
		Thread.sleep(3000);
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> ptext = driver.findElements(By.xpath(prop.getProperty("G_PhysicalDesc")));

        for (WebElement pc : ptext) {
            if (alreadyUsed.contains(pc)) {
                continue;
            }

            wait3.until(ExpectedConditions.elementToBeClickable(pc));
            String existingText = pc.getAttribute("value");

            if (pc.isDisplayed() && pc.isEnabled() && (existingText == null || existingText.trim().isEmpty())) {
                pc.clear();
                pc.sendKeys("Physical Conditions");
            }
        }
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_Diet"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_DietDesc"))).sendKeys("Severe Diet");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_Symptoms"))).click();
		Thread.sleep(1000);
		List<WebElement> symp = driver.findElements(By.xpath(prop.getProperty("G_AllSymptoms")));
		for (WebElement checkbox : symp) {
			if (!checkbox.isSelected()) {
				checkbox.click();
				Thread.sleep(1000);
			}
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		List<WebElement> sympdesc = driver.findElements(By.id(prop.getProperty("G_SymptomDesc")));
		for (WebElement checkbox : sympdesc) {
			if (!checkbox.isSelected()) {
				checkbox.sendKeys("symptoms");
				Thread.sleep(1000);
			}
		}
		List<WebElement> severity = driver.findElements(By.xpath(prop.getProperty("G_Severity")));
		for (WebElement checkbox : severity) {
			if (!checkbox.isSelected()) 
			{
				checkbox.click();
			}
		}
		List<WebElement> frequency = driver.findElements(By.xpath(prop.getProperty("G_Frequency")));
		for (WebElement checkbox : frequency) {
			if (checkbox.getTagName().equals("select")) {
				Select s1 = new Select(checkbox);
				if (!s1.isMultiple() && !s1.getFirstSelectedOption().getText().equals("Desired Option")) {
					s1.selectByIndex(3);
					Thread.sleep(1000);
				}
			}
		}

		Thread.sleep(1000);
		driver.findElement(By.name(prop.getProperty("G_Health_NextButton"))).click();
		Thread.sleep(2000);
		logger.info(" Health Details added successfully");
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_CompleteButton"))).click();
		logger.info(" Other species added with image & w/vet details successfully");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_PetPortalbutton"))).click();
	}
}
