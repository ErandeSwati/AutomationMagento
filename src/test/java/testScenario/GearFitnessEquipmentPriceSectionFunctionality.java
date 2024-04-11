package testScenario;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.BrowserInitializer;
import pageObjects.GearSection;

public class GearFitnessEquipmentPriceSectionFunctionality {
	private BrowserInitializer browserInitializer;
    private WebDriver driver;
    private GearSection gearSection;
    @BeforeTest
    public void setUp() {
    	browserInitializer = new BrowserInitializer();
        driver = browserInitializer.getDriver();
        gearSection = new GearSection(driver);
    }

    @Test(priority=1)
    public void testGearSectionTitle() {
     
       // Click on Men section
        gearSection.clickGearSection();

        // Get the title of the page
        String pageTitle = driver.getTitle();
        
        System.out.println("Page Title is:"+pageTitle);

        // Assert that the title contains expected text
        Assert.assertTrue(pageTitle.contains("Gear"), "Page title does not contain expected text 'Gear'");
    }
    @Test(priority=2)
    public void testFitnessEquipmentSectionDisplayAndTitle() {
        // Click on FitnessEquipment section
    	gearSection.clickFitnessEquipmentSection();

        // Wait for the page to load and verify the FitnessEquipment is displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isFitnessEquipmentDisplayed = wait.until(ExpectedConditions.urlContains("fitness-equipment.html"));
        
        // Assert that the fitness-equipment is displayed
        Assert.assertTrue(isFitnessEquipmentDisplayed, "Fitness Equipment page is not displayed");

        // Get the title of the page
        String pageTitle = driver.getTitle();
        System.out.println("Fitness Equipment page title: "+pageTitle);

        // Assert that the title contains expected text
        Assert.assertTrue(pageTitle.contains("Fitness Equipment"), "Page title does not contain expected text 'Fitness Equipment'");
    }
    @Test(priority=3)
    public void verifyProductPriceRange910() {
        // Click on the Price filter
        gearSection.clickPriceFitness();

        // Click on the Price range $9-10
        gearSection.clickPrice910();

        // Get the count of products
        String itemCount = gearSection.getItemCount();
        System.out.println("Total product count in the $9-10 range is: " + itemCount);

        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");

        // Retrieve the product names
        List<String> productNames = gearSection.getProductNames();

        // Verify that all products displayed on the page contain prices within the range $9-10
        for (String productName : productNames) {
            // Extract the price from the product name
            String priceString = getPriceFromProductName(productName);
            double price = Double.parseDouble(priceString);

            // Verify that the price is within the range $9-10
            Assert.assertTrue(price >= 9 && price <= 10, "Product price should be within the range $9-10");
        }

        // Clear all filters
        gearSection.clickGearAll();
    }

    @Test(priority=4)
    public void verifyProductPriceRange1020() {
        // Click on the Price filter
        gearSection.clickPriceFitness();

        // Click on the Price range $10-20
        gearSection.clickPrice1020();

        // Get the count of products
        String itemCount = gearSection.getItemCount();
        System.out.println("Total product count in the $10-20 range is: " + itemCount);

        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");

        // Retrieve the product names
        List<String> productNames = gearSection.getProductNames();

        // Verify that all products displayed on the page contain prices within the range $10-20
        for (String productName : productNames) {
            // Extract the price from the product name
            String priceString = getPriceFromProductName(productName);
            double price = Double.parseDouble(priceString);

            // Verify that the price is within the range $10-20
            Assert.assertTrue(price >= 10 && price <= 20, "Product price should be within the range $10-20");
        }

        // Clear all filters
        gearSection.clickGearAll();
    }
    @Test(priority=5)
    public void verifyProductPriceRange2030() {
        // Click on the Price filter
        gearSection.clickPriceFitness();

        // Click on the Price range $20-30
        gearSection.clickPrice2030Fitness();

        // Get the count of products
        String itemCount = gearSection.getItemCount();
        System.out.println("Total product count in the $20-30 range is: " + itemCount);

        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");

        // Retrieve the product names
        List<String> productNames = gearSection.getProductNames();

        // Verify that all products displayed on the page contain prices within the range $20-30
        for (String productName : productNames) {
            // Extract the price from the product name
            String priceString = getPriceFromProductName(productName);
            double price = Double.parseDouble(priceString);

            // Verify that the price is within the range $20-30
            Assert.assertTrue(price >= 20 && price <= 30, "Product price should be within the range $20-30");
        }

        // Clear all filters
        gearSection.clickGearAll();
    }

    @Test(priority=6)
    public void verifyProductPriceRange60Above() {
        // Click on the Price filter
        gearSection.clickPriceFitness();

        // Click on the Price range $60 and above
        gearSection.clickPrice60Above();

        // Get the count of products
        String itemCount = gearSection.getItemCount();
        System.out.println("Total product count in the $60 and above range is: " + itemCount);

        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");

        // Retrieve the product names
        List<String> productNames = gearSection.getProductNames();

        // Verify that all products displayed on the page contain prices $60 and above
        for (String productName : productNames) {
            // Extract the price from the product name
            String priceString = getPriceFromProductName(productName);
            double price = Double.parseDouble(priceString);

            // Verify that the price is $60 and above
            Assert.assertTrue(price >= 60, "Product price should be $60 and above");
        }

        // Clear all filters
        gearSection.clickGearAll();
    }
    
    
 //Method to extract price from product name
    private String getPriceFromProductName(String productName) {
        // Extracting price from the HTML structure
        String priceString = "";
        int startIndex = productName.indexOf("$"); // Find the starting index of price
        int endIndex = productName.indexOf("</span>", startIndex); // Find the ending index of price
        if (startIndex != -1 && endIndex != -1) {
            priceString = productName.substring(startIndex + 1, endIndex); // Extract the price string
        }
        return priceString.trim(); // Trim any leading or trailing spaces
    }   
    
    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}
