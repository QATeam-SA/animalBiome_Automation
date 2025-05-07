package testcase;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class Signin_Existinguser {
	WebDriver driver = Instance.getInstance();
	 Properties prop = PropertiesFile.readPropertyFile("Signin_Existinguser.properties");
	 Logger logger = LogManager.getLogger(Signin_Existinguser.class);

	@Test(priority=2, enabled=true)
	public void Login() throws InterruptedException {
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get(prop.getProperty("baseURL"));
		Thread.sleep(5000);
		driver.switchTo(); //switching to pop-up
		driver.findElement(By.xpath(prop.getProperty("Accesscode"))).sendKeys(prop.getProperty("Authkey"));
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("Acessbutton"))).click();
		Thread.sleep(4000);
		System.out.println("Accessed successfully");
		logger.info("***** pop up Accessed successfully *******");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("N_SignInManuallyInstead"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Email"))).sendKeys(prop.getProperty("Emailid"));
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("password"))).sendKeys(prop.getProperty("pw"));
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("signIn"))).click();
		System.out.println("Login Sucessfully with existingUser");
		logger.info("***** Log in successfully *******");
}
}
