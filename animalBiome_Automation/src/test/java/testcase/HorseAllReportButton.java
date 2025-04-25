package testcase;

import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class HorseAllReportButton {
	Logger logger = LogManager.getLogger(HorseAllReportButton.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("HorseAllReportButton.properties");

	@Test(enabled = true)
	public void ClickingHorseAllReportButton() throws InterruptedException {
		
		Thread.sleep(3000);
		logger.info("***** Started viewing all report by Viewing a horse profile*******");
		driver.findElement(By.xpath(prop.getProperty("N_HorseSearch"))).sendKeys(prop.getProperty("N_Horse_Name"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.findElement(By.xpath(prop.getProperty("N_SearchButton"))).click();
		Thread.sleep(3000);
		WebElement mh = driver.findElement(By.xpath(prop.getProperty("N_Mousehover")));
		Actions action = new Actions(driver);
		action.moveToElement(mh).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_ViewButton"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_AllReports"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.findElement(By.xpath(prop.getProperty("N_ReportSearch"))).sendKeys(prop.getProperty("N_Sample_ID"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_ReportSearchButton"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_View"))).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
		WebElement cl = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("NHome"))));
		cl.click();

		logger.info("***** Clicked report button & Viewed the report successfully*******");

	}
}
