package testcase;

import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class Pagination {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Pagination.properties");
	Logger logger = LogManager.getLogger(Pagination.class);
	@Test(enabled = true)

	public void paginationTest() throws InterruptedException {
	    Thread.sleep(4000);
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // Scroll & Click SINGLE FORWARD 3 times
	    for (int i = 0; i < 3; i++) {
	        scrollToPagination(js, driver);
	        Thread.sleep(1000);
	        try {
	            WebElement nextArrow = driver.findElement(By.xpath(prop.getProperty("N_Single_forward_Arrow")));
	            if (nextArrow.isDisplayed() && nextArrow.isEnabled()) {
	                nextArrow.click();
	                System.out.println("Clicked NEXT →");
	                Thread.sleep(2000);
	            } else {
	                break;
	            }
	        } catch (NoSuchElementException e) {
	            System.out.println("Next arrow not found.");
	            break;
	        }
	    }

	    // Scroll & Click DOUBLE FORWARD (Last Page)
	    scrollToPagination(js, driver);
	    Thread.sleep(1000);
	    try {
	        WebElement lastPageArrow = driver.findElement(By.xpath(prop.getProperty("N_Double_forward_Arrow")));
	        if (lastPageArrow.isDisplayed() && lastPageArrow.isEnabled()) {
	            lastPageArrow.click();
	            System.out.println("Clicked LAST PAGE »»");
	            Thread.sleep(2000);
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("Last page arrow not found.");
	    }

	    // Scroll & Click SINGLE BACKWARD 4 times
	    for (int i = 0; i < 4; i++) {
	        scrollToPagination(js, driver);
	        Thread.sleep(1000);
	        try {
	            WebElement prevArrow = driver.findElement(By.xpath(prop.getProperty("N_Single_Backward_Arrow")));
	            if (prevArrow.isDisplayed() && prevArrow.isEnabled()) {
	                prevArrow.click();
	                System.out.println("Clicked PREVIOUS ←");
	                Thread.sleep(2000);
	            } else {
	                break;
	            }
	        } catch (NoSuchElementException e) {
	            System.out.println("Previous arrow not found.");
	            break;
	        }
	    }

	    // Scroll & Click DOUBLE BACKWARD (First Page)
	    scrollToPagination(js, driver);
	    Thread.sleep(1000);
	    try {
	        WebElement firstPageArrow = driver.findElement(By.xpath(prop.getProperty("N_Double_Backward_Arrow")));
	        if (firstPageArrow.isDisplayed() && firstPageArrow.isEnabled()) {
	            firstPageArrow.click();
	            System.out.println("Clicked FIRST PAGE ««");
	            Thread.sleep(2000);
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("First page arrow not found.");
	    }

	    System.out.println("Pagination test completed.");
	    
	}

	private void scrollToPagination(JavascriptExecutor js, WebDriver driver) {
	    try {
	        WebElement pagination = driver.findElement(By.xpath("(//a[@aria-label='Next'])[2]")); // Scroll to visible pagination
	        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", pagination);
	        System.out.println("Scrolled to pagination");
	    } catch (NoSuchElementException e) {
	        System.out.println("Pagination element not found to scroll to.");
	    }
	}

	}