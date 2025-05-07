package base;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;



public class PropertiesFile {
	public WebDriver driver;
	public Properties prop = new Properties();
	public FileReader input;
	public Logger logger;

	
	public static Properties readPropertyFile(String in){

		Properties prop = new Properties();

		File file = new File("src/test/resources/"+in);

		FileInputStream fileInput = null;
		try {
		fileInput = new FileInputStream(file);

		} 
		catch (FileNotFoundException e) {
		e.printStackTrace();
		}


		//load properties file
		try {
		prop.load(fileInput);
		} catch (IOException e) {
		e.printStackTrace();
		}
		return prop;
		}
	

	 
	@BeforeTest
	public void setUp()throws IOException, InterruptedException {
		logger=LogManager.getLogger(this.getClass());
		
		if(driver== null) {	
			 {
				FileReader input = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\DG_Url.properties");
				prop.load(input);
			}
			 if(prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					driver.get(prop.getProperty("baseUrl"));
					
				}
				else if(prop.getProperty("Browser").equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					driver.get(prop.getProperty("baseUrl"));
					
				}
			 }
	}
	
	
    public static String getExcelFilePath() {
        Properties prop = readPropertyFile("ab_datafile.properties");
        return prop.getProperty("ExcelPath");
    }

    public static String getExcelSheetName() {
        Properties prop = readPropertyFile("ab_datafile.properties");
        return prop.getProperty("ExcelSheet");
    }
    public static String getPetExcelSheetName() {
        Properties prop = readPropertyFile("ab_datafile.properties");
        return prop.getProperty("PetExcelSheet");
    }
    
	
	@AfterTest	
	public void tearDown() {
			System.out.println("Browser Opened Successfully");
}
	
	
	}
	
