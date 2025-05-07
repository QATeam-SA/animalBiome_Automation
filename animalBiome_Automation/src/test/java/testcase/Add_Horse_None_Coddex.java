package testcase;

        import java.io.IOException;
        import java.time.Duration;
        import java.util.Properties;

        import org.apache.logging.log4j.LogManager;
        import org.apache.logging.log4j.Logger;
        import org.openqa.selenium.By;
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.Select;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.annotations.Test;

        import base.ExcelUtils;
        import base.Instance;
        import base.PropertiesFile;

        public class Add_Horse_None_Coddex {
            Logger logger = LogManager.getLogger(Add_Horse_None_Coddex.class);
            WebDriver driver = Instance.getInstance();
            Properties prop = PropertiesFile.readPropertyFile("Add_Horse_None.properties");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            @Test(enabled = true)
            public void AddingHorsePetDetails() throws InterruptedException, IOException {
                logger.info("***** Adding a horse with none details *******");

                clickElement(prop.getProperty("NADDPET"));
                scrollPage(200);
                clickElement(prop.getProperty("NHorse"));
                scrollPage(200);
                clickElement(prop.getProperty("NselectBreed"));
                clickElement(prop.getProperty("NbreedType"));

                String excelPath = PropertiesFile.getExcelFilePath();
                String sheetName = PropertiesFile.getPetExcelSheetName();
                ExcelUtils.loadExcelFile(excelPath, sheetName);

                String speciesSelected = "User_Horse";
                String newPetName = base.ExcelUtils.UniquePetName(prop.getProperty("N_Enter_Horse_Name"));
                driver.findElement(By.xpath(prop.getProperty("N_Horse_Name"))).sendKeys(newPetName);
                ExcelUtils.addPetNameToSpeciesColumn(speciesSelected, newPetName);

                fillPetDetails();
                logger.info("***** My Pet details have been added successfully *******");
            }

            private void fillPetDetails() {
                sendKeys(prop.getProperty("N_Age_Years"), prop.getProperty("N_enter_Age"));
                sendKeys(prop.getProperty("N_Age_Months"), prop.getProperty("N_enter_Month"));

                WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("N_Horse_Sex"))));
                new Select(dropdown).selectByIndex(1);

                sendKeys(prop.getProperty("N_weight"), "92");
                clickElement(prop.getProperty("N_kg_lbs"));
                clickElement(prop.getProperty("N_Primary_Dis_NotApplicble"));
                clickElement(prop.getProperty("N_Cold_Breaking"));
                sendKeys(prop.getProperty("N_street"), prop.getProperty("N_Enter_street"));
                sendKeys(prop.getProperty("N_city"), prop.getProperty("N_Enter_City"));
                sendKeys(prop.getProperty("N_postal_Code"), prop.getProperty("N_Postal_Code"));
                sendKeys(prop.getProperty("N_state"), prop.getProperty("N_Enter_State"));
                clickElement(prop.getProperty("N_MP_Next"));
            }

            @Test(enabled = true)
            public void AddingHorsePetHealthDetails() throws InterruptedException {
                clickElement(prop.getProperty("N_Antibiotics_No"));
                scrollPage(200);
                clickElement(prop.getProperty("N_Medication_No"));
                scrollPage(200);
                clickElement(prop.getProperty("N_Timeframe"));

				driver.switchTo()/* .frame("kustomer-ui-sdk-iframe") */;
                clickElement(prop.getProperty("N_Timeframe_Type"));               
                
                scrollPage(200);
                clickElement(prop.getProperty("N_Suppliment"));
                scrollPage(200);
                sendKeys(prop.getProperty("N_Location_City"), prop.getProperty("N_Location_Enter_City"));
                sendKeys(prop.getProperty("N_Location_State"), prop.getProperty("N_Location_Enter_State"));

                WebElement hl = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("N_Horse_Live"))));
                new Select(hl).selectByIndex(2);

                scrollPage(200);
                sendKeys(prop.getProperty("N_Time_Stalled"), prop.getProperty("N_enter_TimeStalled"));

                selectHorseGrazing();
                finalizeHealthDetails();

                logger.info("***** Horse added successfully with none details *******");
            }

            private void selectHorseGrazing() {
                WebElement hg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("N_Horse_Grazing"))));
                new Select(hg).selectByIndex(1);
                scrollPage(200);

                clickElement(prop.getProperty("N_Horse_grain_No"));
                scrollPage(200);
                clickElement(prop.getProperty("N_Horse_Hay_No"));
                scrollPage(200);
                clickElement(prop.getProperty("N_Horse_Physical_No"));
                scrollPage(200);
                clickElement(prop.getProperty("N_H_Symptoms_None"));
            }

            private void finalizeHealthDetails() {
                WebElement wl = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("N_Avg_Workload"))));
                new Select(wl).selectByIndex(3);

                clickElement(prop.getProperty("N_Hault_No"));
                clickElement(prop.getProperty("N_Stressor_No"));
                clickElement(prop.getProperty("N_PetHealth_Next"));

                scrollPage(300);
                clickElement(prop.getProperty("N_Horse_Complete"));
                clickElement(prop.getProperty("N_Horse_Portal"));

                validateSuccessMessage();
            }

            private void validateSuccessMessage() {
                WebElement titleValidation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "//div[@class='col-sm-12 col-lg-12 col-md-12 alert alert-success alert-dismissible ng-star-inserted']")));

                String expectedText = "Pet added successfully.";
                String actualText = titleValidation.getText();

                if (actualText.equals(expectedText)) {
                    System.out.println("Both Texts are the same. The title is " + actualText);
                } else {
                    System.out.println("Both Texts are not the same. The displayed text is " + actualText);
                }
            }

            private void scrollPage(int pixels) {
                jse.executeScript("window.scrollBy(0," + pixels + ")");
            }

            private void clickElement(String property) {
				
            	/*
				 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(property))).click
				 * ();
				 */
            	try {
                    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(property)));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
                    wait.until(ExpectedConditions.elementToBeClickable(element));
                    element.click();
                } catch (Exception e) {
                    // Fallback to JS click if standard click fails
                    WebElement fallback = driver.findElement(By.xpath(property));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fallback);
                    System.out.println("⚠️ JS click used for element: " + property);
                }
            }
            

            private void sendKeys(String property, String keysToSend) {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(property))).sendKeys(keysToSend);
            }
        }