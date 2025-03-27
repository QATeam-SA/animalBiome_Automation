package testcase;

import java.awt.AWTException;
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

import base.Instance;
import base.PropertiesFile;

public class My_Account_UserProfile_EditPet {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("My_Account_UserProfile_EditPet.properties");
	Logger logger = LogManager.getLogger(My_Account_UserProfile_EditPet.class);

	@Test(priority = 17, enabled = true)
	public void Edit_MyPet() throws InterruptedException, AWTException {
		logger.info("***** Started going to My account user profile *******");
		Thread.sleep(8000);
		driver.findElement(By.xpath(prop.getProperty("N_myaccount"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_userprofile"))).click();
		logger.info("***** Started viewing pet *******");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("Nsearchbox"))).sendKeys(prop.getProperty("Ntext"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Enter"))).click();
		Thread.sleep(11000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(prop.getProperty("N_Flip")))).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_View"))).click();

		logger.info("***** Started editing pet in the my pet section *******");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_EditPet"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_gender"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_S/N"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_NextB"))).click();
	}

	@Test(priority = 18, enabled = true)
	public void Edit_PetHealth() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		logger.info("***** Started editing pet in the pet health section *******");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_AntiBio_None"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("N_AntiBio_yes"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_AntiBio_Type"))).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("N_Body_Cond"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("N_Medication_None"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("N_Medication_yes"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("N_Medication"))).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("N_Suppli_none"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("N_Suppli_yes"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("N_Suppli"))).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("N_Ab_suppli_none"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("N_Ab_suppli_yes"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("N_Ab_suppli"))).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_PCondition"))).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,400)");
		driver.findElement(By.xpath(prop.getProperty("N_diet"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("N_diet_Type"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("N_Symptoms_none"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_Symptoms"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_GI"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_Symp_V"))).click();
		Thread.sleep(3000);
		WebElement e = driver.findElement(By.xpath(prop.getProperty("N_V_Severity")));
		Select ss = new Select(e);
		Thread.sleep(2000);
		ss.selectByIndex(1);
		WebElement e1 = driver.findElement(By.xpath(prop.getProperty("N_V_frequency")));
		Select sf = new Select(e1);
		Thread.sleep(2000);
		sf.selectByIndex(2);
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("N_Next_Button"))).click();

	}

	@Test(priority = 19, enabled = true)
	public void Edit_Vet() throws InterruptedException, AWTException {

		Thread.sleep(6000);
		logger.info("***** Started adding vet *******");

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
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("N_Pet_Portal_Home"))).click();
		Thread.sleep(2000);
		
		WebElement titleValidation = driver.findElement(By.xpath("(//div[@class='col-sm-12 col-lg-12 col-md-12 alert alert-success alert-dismissible ng-star-inserted'])[1]"));

		String expectedText = "Pet updated successfully.";
		String actualText = titleValidation.getText();
		if (actualText.equals(expectedText)) {
			System.out.println("Both Text are Same. The title is" + actualText);
		} else {
			System.out.println("Both Text are not Same. The dispalyed text is" + actualText);
		}
		
		System.out.println("THE PROCESS HAS BEEN COMPLETED");
		logger.info("***** The process of editing pet has been successfully completed *******");


	}
}
