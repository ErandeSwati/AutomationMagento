package testScenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.Assert;
import pageObjects.BrowserInitializer;
import pageObjects.GearSection;
import java.time.Duration;
import java.util.List;

public class GearFitnessEquipmentCategorySizeSectionFunctionality {
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
        // Click on Fitness Equipment section
    	gearSection.clickFitnessEquipmentSection();

        // Wait for the page to load and verify the Fitness Equipment is displayed
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
    @Test(priority=4)
    public void verifyCategoryCardio() {
            
    	 // Click on the category options
        gearSection.clickCategory();
        
        // Click on the cardio option
        gearSection.clickCardio();
        
        // Get the count of Cardio Items
        String itemCount = gearSection.getItemCount();
        
        System.out.println("Total Cardio Item count is: " + itemCount);
        
        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");
        
        // Verify that the count is greater than 0
        int count = Integer.parseInt(itemCount.split(" ")[0]);
        Assert.assertTrue(count > 0, "Number of Cardio items should be greater than 0");
        
        // Verify that the page is displaying only cardio
        List<String> productNames = gearSection.getProductNames();
        for (String productName : productNames) {
            Assert.assertTrue(productName.contains("Cardio"), "Product name should contain 'Cardio'");
        }
        // Click on the "Clear All" button
        gearSection.clickGearAll();
    }
    @Test(priority=3)
    public void verifyCategoryExercise() {
            
    	 // Click on the category options
        gearSection.clickCategory();
        
        // Click on the Exercise option
        gearSection.clickExerciseCategory();
        
        // Get the count of Exercise Items
        String itemCount = gearSection.getItemCount();
        
        System.out.println("Total Exercise Item count is: " + itemCount);
        
        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");
        
        // Verify that the count is greater than 0
        int count = Integer.parseInt(itemCount.split(" ")[0]);
        Assert.assertTrue(count > 0, "Number of Exercise items should be greater than 0");
        
        // Verify that the page is displaying only Exercise Items
        List<String> productNames = gearSection.getProductNames();
        for (String productName : productNames) {
            Assert.assertTrue(productName.contains("Exercise"), "Product name should contain 'Exercise'");
        }
        // Click on the "Clear All" button
        gearSection.clickGearAll();
    }
    
    @Test(priority=5)
    public void verifySize55Items() {
        // Click on the size options
        gearSection.clickSize();
        
        // Click on the size 55 cm option
        gearSection.clickSize55();
        
        // Get the count of items
        String itemCount = gearSection.getItemCount();
        
        System.out.println("Total 55 cm Item count is: " + itemCount);
        
        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");
        
        // Verify that the count is greater than 0
        int count = Integer.parseInt(itemCount.split(" ")[0]);
        Assert.assertTrue(count > 0, "Number of 55 cm items should be greater than 0");
        
        // Verify that the page is displaying only 55 cm items
        List<String> productNames = gearSection.getProductNames();
        for (String productName : productNames) {
            Assert.assertTrue(productName.contains("55 cm"), "Product name should contain '55 cm'");
        }
        // Click on the "Clear All" button
        gearSection.clickGearAll();
    }
    @Test(priority=6)
    public void verifySize65Items() {
        // Click on the size options
        gearSection.clickSize();
        
        // Click on the size 65 cm option
        gearSection.clickSize65();
        
        // Get the count of items
        String itemCount = gearSection.getItemCount();
        
        System.out.println("Total 65 cm Item count is: " + itemCount);
        
        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");
        
        // Verify that the count is greater than 0
        int count = Integer.parseInt(itemCount.split(" ")[0]);
        Assert.assertTrue(count > 0, "Number of 65 cm items should be greater than 0");
        
        // Verify that the page is displaying only 65 cm items
        List<String> productNames = gearSection.getProductNames();
        for (String productName : productNames) {
            Assert.assertTrue(productName.contains("65 cm"), "Product name should contain '65 cm'");
        }
        // Click on the "Clear All" button
        gearSection.clickGearAll();
    }
    @Test(priority=7)
    public void verifySize75Items() {
        // Click on the size options
        gearSection.clickSize();
        
        // Click on the size 75 cm option
        gearSection.clickSize75();
        
        // Get the count of items
        String itemCount = gearSection.getItemCount();
        
        System.out.println("Total 75 cm Item count is: " + itemCount);
        
        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");
        
        // Verify that the count is greater than 0
        int count = Integer.parseInt(itemCount.split(" ")[0]);
        Assert.assertTrue(count > 0, "Number of 75 cm items should be greater than 0");
        
        // Verify that the page is displaying only 75 cm items
        List<String> productNames = gearSection.getProductNames();
        for (String productName : productNames) {
            Assert.assertTrue(productName.contains("75 cm"), "Product name should contain '75 cm'");
        }
        // Click on the "Clear All" button
        gearSection.clickGearAll();
    }
    @Test(priority=8)
    public void verifySize6FootItems() {
        // Click on the size options
        gearSection.clickSize();
        
        // Click on the 6-foot size option
        gearSection.clickSize6Foot();
        
        // Get the count of items
        String itemCount = gearSection.getItemCount();
        
        System.out.println("Total 6-foot Item count is: " + itemCount);
        
        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");
        
        // Verify that the count is greater than 0
        int count = Integer.parseInt(itemCount.split(" ")[0]);
        Assert.assertTrue(count > 0, "Number of 6-foot items should be greater than 0");
        
        // Verify that the page is displaying only 6-foot items
        List<String> productNames = gearSection.getProductNames();
        for (String productName : productNames) {
            Assert.assertTrue(productName.contains("6 foot"), "Product name should contain '6 foot'");
        }
        // Click on the "Clear All" button
        gearSection.clickGearAll();
    }
    @Test(priority=9)
    public void verifySize8FootItems() {
        // Click on the size options
        gearSection.clickSize();
        
        // Click on the 8-foot size option
        gearSection.clickSize8Foot();
        
        // Get the count of items
        String itemCount = gearSection.getItemCount();
        
        System.out.println("Total 8-foot Item count is: " + itemCount);
        
        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");
        
        // Verify that the count is greater than 0
        int count = Integer.parseInt(itemCount.split(" ")[0]);
        Assert.assertTrue(count > 0, "Number of 8-foot items should be greater than 0");
        
        // Verify that the page is displaying only 8-foot items
        List<String> productNames = gearSection.getProductNames();
        for (String productName : productNames) {
            Assert.assertTrue(productName.contains("8 foot"), "Product name should contain '8 foot'");
        }
        // Click on the "Clear All" button
        gearSection.clickGearAll();
    }
    @Test(priority=10)
    public void verifySize10FootItems() {
        // Click on the size options
        gearSection.clickSize();
        
        // Click on the 10-foot size option
        gearSection.clickSize10Foot();
        
        // Get the count of items
        String itemCount = gearSection.getItemCount();
        
        System.out.println("Total 10-foot Item count is: " + itemCount);
        
        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");
        
        // Verify that the count is greater than 0
        int count = Integer.parseInt(itemCount.split(" ")[0]);
        Assert.assertTrue(count > 0, "Number of 10-foot items should be greater than 0");
        
        // Verify that the page is displaying only 10-foot items
        List<String> productNames = gearSection.getProductNames();
        for (String productName : productNames) {
            Assert.assertTrue(productName.contains("10 foot"), "Product name should contain '10 foot'");
        }
        // Click on the "Clear All" button
        gearSection.clickGearAll();
    }
    
    @Test(priority=11)
    @Ignore
    public void verifyPageContainsOnlyBlueProducts() {
        // Click on the color options
        gearSection.clickColor();
        
        // Click on the Blue color option
        gearSection.clickColorBlue();
        
        // Wait for the product  to load after applying the filter
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("product-image-container")));
        
        // Find all product image  on the page
        List<WebElement> productContainers = driver.findElements(By.className("product-image-container"));
        
        // Track if any non-blue product is found
        boolean nonBlueProductFound = false;
        
        // Loop through each product to verify if it contains blue products
        for (WebElement productContainer : productContainers) {
            // You would replace "colorClass" with the actual class 
            String colorClass = productContainer.getAttribute("colorClass");
            
            // Check if the product is blue
            if (colorClass != null && colorClass.equalsIgnoreCase("blue")) {
                // Product is blue
                System.out.println("Product is blue");
            } else {
                // Product is not blue
                System.out.println("Product is not blue");
                nonBlueProductFound = true;
            }
        }
        
        // Verify if any non-blue product was found
        if (nonBlueProductFound) {
            // If any non-blue product is found, fail the test
            Assert.fail("Page contains non-blue products");
        } else {
            // If no non-blue product is found, all products are blue
            System.out.println("All products are blue");
        }
    }
    @AfterTest
    public void closeBroswer() {
        driver.quit();
    }
}
