package testcase;

import java.awt.AWTException;
import java.time.Duration;
import java.util.Properties;

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

public class EditHorse_HomePage {
	Logger logger = LogManager.getLogger(EditHorse_HomePage.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("EditHorse_HomePage.properties");

	@Test(enabled = true)
	public void EditingHorseFromHomePage() throws InterruptedException {
		
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		logger.info("***** Started editing the pet from home page*******");
		WebElement mh = driver.findElement(By.xpath(prop.getProperty("N_Mousehover")));
		Actions action = new Actions(driver);
		action.moveToElement(mh).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_H_Edit"))).click();
		Thread.sleep(1500);
		jse.executeScript("window.scrollBy(0,400)");
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(1000));
        WebElement br =wait3
                .until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("NBreed"))));
        br.click();
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(2000));
        WebElement hp =wait4
                .until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("NbreedType"))));
        hp.click();
		jse.executeScript("window.scrollBy(0,400)");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dropdown = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("N_Horse_Sex"))));
		Select horseSexSelect = new Select(dropdown);
		horseSexSelect.selectByIndex(3);
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_kg_lbs"))).click();
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Primary_Dis"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_select_Dis"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_Dis_Type"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_Cold_Breaking"))).click();
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("N_Cold_Breaking_Text")))
				.sendKeys(prop.getProperty("N_CB_Enter_text"));
	
		Thread.sleep(1500);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("N_Next"))).click();
		logger.info("***** Ny Pet section of horse edited successfully *******");

	}

	@Test(enabled = true)
	public void EdittingHorsePetHealthdetails() throws InterruptedException {
		Thread.sleep(2000);
		logger.info("***** Editing  horse with random details in pet Health section*******");
		driver.findElement(By.xpath(prop.getProperty("N_Antibiotics_yes"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_Antibiotics_Type"))).sendKeys(prop.getProperty("N_anti_Name"));
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Medication_yes"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Med_Type1"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Med_Type1_Text")))
				.sendKeys(prop.getProperty("N_Med_Enter1_Text"));
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Med_Type2"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Med_Type2_Text")))
				.sendKeys(prop.getProperty("N_Med_Enter2_Text"));
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Timeframe"))).click();
		Thread.sleep(2000);
		driver.switchTo();
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
		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement hl = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("N_Horse_Live"))));
		Select horseLive = new Select(hl);
		horseLive.selectByIndex(4);
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Time_Stalled"))).clear();
		driver.findElement(By.xpath(prop.getProperty("N_Time_Stalled")))
				.sendKeys(prop.getProperty("N_enter_TimeStalled"));
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		WebElement hg = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("N_Horse_Grazing"))));
		Select horseGrazing = new Select(hg);
		horseGrazing.selectByIndex(2);
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
		driver.findElement(By.xpath(prop.getProperty("N_Phy_Gi"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Phy_GI_Text"))).sendKeys(prop.getProperty("N_Enter_Gi_Text"));
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Phy_oral"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Phy_oral_Text")))
				.sendKeys(prop.getProperty("N_Enter_oral_Text"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_H_Symptoms_Yes"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Symp_GI"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Symp_GI_Text")))
				.sendKeys(prop.getProperty("N_Symp_GI_enter_Text"));
		Thread.sleep(1000);
		WebElement sev = driver.findElement(By.xpath(prop.getProperty("N_GI_Sev")));
		wait.until(ExpectedConditions.elementToBeClickable(sev));
		Select s1 = new Select(sev);
		s1.selectByIndex(1);

		Thread.sleep(1500);

		WebElement freq = driver.findElement(By.xpath(prop.getProperty("N_GI_freq")));
		wait.until(ExpectedConditions.elementToBeClickable(freq));
		Select s2 = new Select(freq);
		s2.selectByIndex(2);

		Thread.sleep(1500);

		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("N_Symp_stiff"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Symp_stiff_Text")))
				.sendKeys(prop.getProperty("N_Symp_stiff_enter_Text"));
		Thread.sleep(1000);
		WebElement sev1 = driver.findElement(By.xpath(prop.getProperty("N_stiff_Sev")));
		wait.until(ExpectedConditions.elementToBeClickable(sev1));
		Select s3 = new Select(sev1);
		s3.selectByIndex(2);

		Thread.sleep(1500);

		WebElement freq1 = driver.findElement(By.xpath(prop.getProperty("N_stiff_freq")));
		wait.until(ExpectedConditions.elementToBeClickable(freq1));
		Select s4 = new Select(freq1);
		s4.selectByIndex(1);

		Thread.sleep(1500);

		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1500);
		WebElement wl = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("N_Avg_Workload"))));
		Select workLoad = new Select(wl);
		workLoad.selectByIndex(2);
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("N_Hault_Yes"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("N_Stressor_Yes"))).click();
		Thread.sleep(1500);
		jse.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("N_PetHealth_Next"))).click();
		logger.info("***** Editted pet health section of horse *******");
	}

	@Test(enabled = true)
	public void EdittingHorseVetdetails() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		logger.info("***** Vet details adding process has been started *******");
		driver.findElement(By.xpath(prop.getProperty("N_Add_Vet"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("N_Vet_clinic_Name")))
				.sendKeys(prop.getProperty("N_Enter_Vclinic_Name"));
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("N_Vet_Name"))).sendKeys(prop.getProperty("N_Enter_Vname"));
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("N_V_Street"))).sendKeys(prop.getProperty("N_V_Enter_Street"));
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("N_V_City"))).sendKeys(prop.getProperty("N_V_Enter_City"));
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("N_V_State"))).sendKeys(prop.getProperty("N_V_Enter_State"));
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("N_V_postal_code")))
				.sendKeys(prop.getProperty("N_V_Enter_Postal_Code"));
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("N_V_VetEmail"))).sendKeys(prop.getProperty("N_Enter_VetEmail"));
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("N_V_PhoneNo"))).sendKeys(prop.getProperty("N_Enter_PH"));
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("N_V_save"))).click();
		Thread.sleep(1500);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("N_complete"))).click();
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement hp = wait4
				.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("N_Horse_Portal_Home"))));
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

		logger.info("***** Edited  Horse with random selection of questionnaire *******");

	}
}