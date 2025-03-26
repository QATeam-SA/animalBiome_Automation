package testcases;

import java.awt.AWTException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class Register_Sample_Oral {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Register_Sample_Oral.properties");
	Logger logger = LogManager.getLogger(Register_Sample_Oral.class);

	@Test(priority = 16, enabled = true)
	public void Oral_Sample_Registration() throws InterruptedException, AWTException {
	
	    Thread.sleep(8000);
	    logger.info("***** Oral sample registration process has been started*******");
	    driver.findElement(By.xpath(prop.getProperty("Nregister_sample"))).click();
	    Thread.sleep(4000);
		WebElement e =driver.findElement(By.xpath(prop.getProperty("N_select_pet")));
		Select ss = new Select(e);
		 Thread.sleep(2000);
		ss.selectByIndex(4);
		Thread.sleep(2000);
		WebElement e1 =driver.findElement(By.xpath(prop.getProperty("N_Sample")));
		Select st = new Select(e1);
		 Thread.sleep(2000);
		st.selectByIndex(2);
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_T_submision"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Sample_ID"))).sendKeys(prop.getProperty("N_Enter_SampleID"));
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("N_Calender"))).click();
		Thread.sleep(10000);
		driver.switchTo();
		driver.findElement(By.xpath(prop.getProperty("N_Date"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Next_B"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_Complete"))).click();
		Thread.sleep(9000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(10000);
		driver.findElement(By.xpath(prop.getProperty("N_viewPortal"))).click();
		Thread.sleep(3000);
		WebElement titleValidation = driver.findElement(By.xpath("//div[@class='col-sm-12 col-lg-12 col-md-12 alert alert-success alert-dismissible ng-star-inserted']"));

		String expectedText = "Your pet's sample has been successfully registered.";
		String actualText = titleValidation.getText();
		if (actualText.equals(expectedText)) {
			System.out.println("Both Text are Same. The title is" + actualText);
		} else {
			System.out.println("Both Text are not Same. The dispalyed text is" + actualText);
		}
		logger.info("***** Oral sample registration process has been completed******");

}
}
