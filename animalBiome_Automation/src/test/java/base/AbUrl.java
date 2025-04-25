package base;



import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;




public class AbUrl {
	WebDriver driver = Instance.getInstance();
	
 Properties prop = PropertiesFile.readPropertyFile("aburl.properties");
	
	@Test(priority=1, enabled=true)
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
		System.out.println("LoggedIn successfully");
}
}