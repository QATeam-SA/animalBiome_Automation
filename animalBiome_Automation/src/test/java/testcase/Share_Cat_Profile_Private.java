package testcase;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class Share_Cat_Profile_Private {
	Logger logger = LogManager.getLogger(Share_Cat_Profile_Private.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Share_Cat_Profile_Private.properties");
	
	
	@Test(priority=14,enabled=true)
	public void sharepetprofile_private()
	{
		
	}
}
