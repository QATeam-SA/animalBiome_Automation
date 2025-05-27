package testcase;
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

public class Edit_CatDetails {
	Logger logger = LogManager.getLogger(Edit_CatDetails.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Edit_CatDetails.properties");
	
	@Test(priority=9,enabled=true)
	public void EditingTheCatDetails() throws InterruptedException {
		Thread.sleep(10000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(6000);
		WebElement targetelement = driver.findElement(By.xpath(prop.getProperty("j_mousehover")));
		Actions action = new Actions(driver);
		action.moveToElement(targetelement).perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_editbutton"))).click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_nextbutton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_antibiotics"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_antibiotics_amoxicillin"))).click();
		jse.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath(prop.getProperty("j_antibiotics_metronidazole"))).click();
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_medications_Y/N"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_medications"))).click();
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_supplements_Y/N"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_supplements"))).click();
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_animabiomesupplemets_Y/N"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_animalbiomesupplements"))).click();
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_physicalconditionselect"))).click();
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_physcon_cancer"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_GIcancer"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_child_GIcancer"))).click();
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_diet"))).click();
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_symptoms"))).click();
		Thread.sleep(2000);	
		driver.findElement(By.xpath(prop.getProperty("j_pethealth_nextbtn"))).click();
		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_vetinfo_completebtn"))).click();
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_petportalhome"))).click();
		Thread.sleep(2000);
		logger.info("pet edited successfully from homepage");
		
		//edit pet details from view pet portal page
		Thread.sleep(6000);
		WebElement targetelement1 = driver.findElement(By.xpath(prop.getProperty("j_MouseHover")));
		Actions action1 = new Actions(driver);
		action1.moveToElement(targetelement1).perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_Viewbutton"))).click();
		Thread.sleep(4000);
		jse.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath(prop.getProperty("j_Editpetprofile_button"))).click();
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("j_Nextbutton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_Antibiotics"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_Body_condition"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_Medications"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_Supplements"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_Ab_supplements"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_Phys_conditions"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_Diet"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_Diet_type"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_Symptoms"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_Nxt_btn"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_Complete"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("j_Petportal"))).click();
		Thread.sleep(3000);
		logger.info("pet edited successfully from view pet portal page");
	}
}


