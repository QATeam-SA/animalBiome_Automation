package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Instance {
	public static WebDriver driver;

	  public static WebDriver getInstance() 	  {
		  if (driver == null) 
		   {
			  	WebDriverManager.chromedriver().setup();  
			   	ChromeOptions options = new ChromeOptions();
			   	driver = new ChromeDriver(options);
		   }
		   return driver;
		 }
}
