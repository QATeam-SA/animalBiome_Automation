package testcase;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

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
	
   private JavascriptExecutor MydogDetails() {
		// TODO Auto-generated method stub
		return null;
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
}
