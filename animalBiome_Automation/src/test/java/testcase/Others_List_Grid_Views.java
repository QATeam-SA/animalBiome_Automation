package testcase;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class Others_List_Grid_Views {
	Logger logger = LogManager.getLogger(Others_List_Grid_Views.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Others_List_Grid_Views.properties");
	
	
	@Test(priority=17,enabled=true)
	public void ClickingOnListAndGridViews() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("j_listview"))).click();
		logger.info("successfully clicked on listview");
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("j_gridview"))).click();
		Thread.sleep(3000);
		logger.info("successfully clicked on gridview");
}
}
