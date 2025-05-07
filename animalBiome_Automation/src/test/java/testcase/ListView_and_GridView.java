package testcase;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class ListView_and_GridView {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("ListView_and_GridView.properties");
	Logger logger = LogManager.getLogger(ListView_and_GridView.class);
	@Test(enabled = true)
	public void SearchButton() throws InterruptedException {
		Thread.sleep(3000);
		logger.info("***** Clicking Listview buttin in the home page *******");
		driver.findElement(By.xpath(prop.getProperty("N_ListView"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_GridView"))).click();
		logger.info("***** Clicked Grid view buttin in the home page *******");
	}}