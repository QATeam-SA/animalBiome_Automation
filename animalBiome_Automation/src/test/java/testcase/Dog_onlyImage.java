package testcase;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
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

public class Dog_onlyImage {
	
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Dog_onlyImage.properties");
	Logger logger = LogManager.getLogger(Dog_onlyImage.class);



	@Test(priority = 9, enabled = true)
	public void AddingDogOnlyWithImgAndNotVetDetails() throws Exception {

		// ------- MY PET---------

		JavascriptExecutor js = MypetDetails();

		// ----------PET HEALTH---------

		PetHealthdetails(js);

	}
	
	private JavascriptExecutor MypetDetails() throws InterruptedException, Exception {

		logger.info("***Started adding dog with image****");
		Thread.sleep(10000);
		driver.findElement(By.xpath(prop.getProperty("G_AddPet"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_DogButton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("G_ProfileImage"))).click();
		Thread.sleep(5000);
		Robot robot = new Robot();
		robot.delay(5000);
		StringSelection select = new StringSelection(prop.getProperty("G_UploadImage"));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("G_ImageSubmit"))).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_SelectBreed"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_BreedName"))).click();
		Thread.sleep(1000);
		driver.findElement(By.id(prop.getProperty("G_PetName")))
				.sendKeys((prop.getProperty("G_pet_dname")) + "_" + System.currentTimeMillis());
		Thread.sleep(1000);
		driver.findElement(By.name(prop.getProperty("G_Dogyears"))).sendKeys("11");
		Thread.sleep(1000);
		driver.findElement(By.name(prop.getProperty("G_Dogmonths"))).sendKeys("10");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_Dogsex"))).click();
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.name(prop.getProperty("G_Dogweight"))).sendKeys("9999.99");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_weightunits"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_Doggender"))).click();
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_Street"))).sendKeys("Street");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_City"))).sendKeys("City");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_State"))).sendKeys("State");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_PostalCode"))).sendKeys("785670");
		Thread.sleep(1000);
		Select s = new Select(driver.findElement(By.xpath(prop.getProperty("G_Country"))));
		s.selectByVisibleText("Andorra");
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("G_AddPet_Nextbutton"))).click();
		System.out.println("***Added Pet Details successfully****");
		return js;

	}

	private void PetHealthdetails(JavascriptExecutor js) throws InterruptedException {

		logger.info("****Started added user dog health details****");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_Antibiotics"))).click();
		Thread.sleep(2000);
		List<WebElement> checkboxes = driver.findElements(By.xpath(prop.getProperty("G_AllAntibiotics")));
		for (int i = 0; i < checkboxes.size(); i++) {

			if (checkboxes.get(i).isDisplayed()) {

				checkboxes.get(i).click();
				Thread.sleep(1000);
			}
		}
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,700)");
		driver.findElement(By.id(prop.getProperty("G_Bodyconditions"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("G_Medications"))).click();
		Thread.sleep(3000);
		List<WebElement> allcheckboxes = driver.findElements(By.name(prop.getProperty("G_AllMedications")));
		for (WebElement checkbox : allcheckboxes) {
			if (!checkbox.isSelected()) {

				checkbox.click();
				Thread.sleep(1000);
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.xpath(prop.getProperty("G_cisapride/Propulsid"))).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_Supplements"))).click();
		Thread.sleep(1500);
		List<WebElement> suppcheck = driver.findElements(By.name(prop.getProperty("G_AllSupplements")));
		for (WebElement checkbox : suppcheck) {
			if (!checkbox.isSelected()) {

				checkbox.click();
				Thread.sleep(1000);
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		List<WebElement> suppchild = driver.findElements(By.xpath(prop.getProperty("G_Fiberchild")));
		for (WebElement checkbox : suppchild) {
			if (!checkbox.isSelected()) {

				checkbox.click();
			}
		}
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2500);
		driver.findElement(By.xpath(prop.getProperty("G_ABSupplements"))).click();
		Thread.sleep(1000);
		List<WebElement> absupp = driver.findElements(By.name(prop.getProperty("G_AllabSupplements")));
		for (WebElement checkbox : absupp) {
			if (!checkbox.isSelected()) {

				checkbox.click();
				Thread.sleep(1000);
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		List<WebElement> absuppchild = driver.findElements(By.xpath(prop.getProperty("G_ABsuppchild")));
		for (WebElement checkbox : absuppchild) {
			if (!checkbox.isSelected()) {

				checkbox.click();
				Thread.sleep(1000);
			}
		}
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2500);
		driver.findElement(By.xpath(prop.getProperty("G_PhysicalConditions"))).click();
		Thread.sleep(1000);
		List<WebElement> phycon = driver.findElements(By.name(prop.getProperty("G_AllPhycond")));
		for (WebElement checkbox : phycon) {
			if (!checkbox.isSelected()) {
				checkbox.click();
				Thread.sleep(1000);
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		List<WebElement> phyconchild = driver.findElements(By.xpath(prop.getProperty("G_PhyChild")));
		for (WebElement checkbox : phyconchild) {
			if (!checkbox.isSelected()) {
				checkbox.click();
				Thread.sleep(1000);
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		List<WebElement> phyconchild1 = driver.findElements(By.xpath(prop.getProperty("G_PhyChild1")));
		for (WebElement checkbox : phyconchild1) {
			if (!checkbox.isSelected()) {
				checkbox.click();
				Thread.sleep(1000);
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		List<WebElement> phyconchild2 = driver.findElements(By.xpath(prop.getProperty("G_PhyChild1")));
		for (WebElement checkbox : phyconchild2) {
			if (!checkbox.isSelected()) {
				checkbox.click();
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("G_Phydescription"))).sendKeys("All Physical conditions selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_Diet"))).click();
		List<WebElement> diet = driver.findElements(By.xpath(prop.getProperty("G_Alldiet")));
		for (WebElement checkbox : diet) {
			if (!checkbox.isSelected()) {
				checkbox.click();
				Thread.sleep(1000);
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		List<WebElement> dietchild = driver.findElements(By.xpath(prop.getProperty("G_Dietchild")));
		for (WebElement checkbox : dietchild) {
			if (!checkbox.isSelected()) {
				checkbox.click();
				Thread.sleep(1000);
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("G_Symptoms"))).click();
		Thread.sleep(1000);
		List<WebElement> symp = driver.findElements(By.name(prop.getProperty("G_AllSymp")));
		for (WebElement checkbox : symp) {
			if (!checkbox.isSelected()) {
				checkbox.click();
				Thread.sleep(1000);
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		List<WebElement> sympchild1 = driver.findElements(By.xpath(prop.getProperty("G_Symchild1")));
		for (WebElement checkbox : sympchild1) {
			if (!checkbox.isSelected()) {
				checkbox.click();
				Thread.sleep(1000);
			}
		}
		List<WebElement> severity = driver.findElements(By.xpath(prop.getProperty("G_Severity")));
		for (WebElement checkbox : severity) {
			if (!checkbox.isSelected()) {
				checkbox.click();
			}
		}
		List<WebElement> frequency = driver.findElements(By.xpath(prop.getProperty("G_Frequency")));
		for (WebElement checkbox : frequency) 
		{
			if (checkbox.getTagName().equals("select")) 
			{
				Select s1 = new Select(checkbox);
				if (!s1.isMultiple() && !s1.getFirstSelectedOption().getText().equals("Desired Option")) 
				{
					s1.selectByIndex(3);
					Thread.sleep(1000);
				}
			}
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_Symdescription"))).sendKeys("All Symptoms are selected.");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_HealthNext"))).click();
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("G_Complete"))).click();
		System.out.println("***User dog added with health details***");
		Thread.sleep(9000);
		driver.findElement(By.xpath(prop.getProperty("G_PetPortalHome"))).click();
		System.out.println("***Pet added successfully with image & without Vet***");
	}

}

