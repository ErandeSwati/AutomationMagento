package testScenario;
import org.openqa.selenium.WebDriver;
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
public class GearBagsStyleSectionFunctionality {
    private BrowserInitializer browserInitializer;
    private WebDriver driver;
    private GearSection gearSection;
    @BeforeTest
    public void setUp() {
    	browserInitializer = new BrowserInitializer();
        driver = browserInitializer.getDriver();
        gearSection = new GearSection(driver);
    }

    @Test(priority=0)
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
    public void testBagsSectionDisplayAndTitle() {
        // Click on Bags section
    	gearSection.clickBagsSection();

        // Wait for the page to load and verify the bag is displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isBagDisplayed = wait.until(ExpectedConditions.urlContains("bags.html"));
        
        // Assert that the bag is displayed
        Assert.assertTrue(isBagDisplayed, "Bags page is not displayed");

        // Get the title of the page
        String pageTitle = driver.getTitle();

        // Assert that the title contains expected text
        Assert.assertTrue(pageTitle.contains("Bags"), "Page title does not contain expected text 'Bags'");
    }
    
    @Test(priority=3)
    @Ignore
    public void testSortByName() {
    	
         // Select the "Product Name" sorting option
         gearSection.selectSortByProductName();
         // Retrieve the list of product names from the page
        List<String> productNames = gearSection.getProductNames();
        // Verify that the list of product names is sorted alphabetically
        boolean isSorted = isListSorted(productNames);
        Assert.assertTrue(isSorted, "Products are not sorted by name");
    }
    
    private boolean isListSorted(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }
        
    @Test(priority=4)
    public void verifyBackpackBagsDisplay() {          
        
        // Click on the style options
        gearSection.clickStyleClick();
        
        // Click on the backpack option
        gearSection.clickbackpackClick();
        
        // Get the count of backpack bags
        String itemCount = gearSection.getItemCount();
        
        System.out.println("Total Backpack count is:"+itemCount);
        
        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");
        
        // Verify that the count is greater than 0
        int count = Integer.parseInt(itemCount.split(" ")[0]);
        Assert.assertTrue(count > 0, "Number of backpack bags should be greater than 0");
        
        // Verify that the page is displaying only backpack bags
        List<String> productNames = gearSection.getProductNames();
        for (String productName : productNames) {
            Assert.assertTrue(productName.contains("Backpack"), "Product name should contain 'Backpack'");
        }
    }
    
    @Test(priority=5)       
    	public void testClearAllButtonFunctionality() {
            
            // Click on the "Clear All" button
            gearSection.clickGearAll();
            // Check if the filter is cleared
            String itemCountAfterClearAll = gearSection.getItemCount();
            System.out.println("Item Count after Clear Count"+itemCountAfterClearAll);
            // Verify that the filter is cleared successfully
            Assert.assertNotEquals(itemCountAfterClearAll, "", "Item count after clear all should not be empty");
            }
    
    @Test(priority=6)
    public void verifyLuggageBagsDisplay() {
            
    	 // Click on the style options
        gearSection.clickStyleClick();
        
        // Click on the Luggage option
        gearSection.clickLuggage();
        
        // Get the count of Luggage bags
        String itemCount = gearSection.getItemCount();
        
        System.out.println("Total Luggage count is: " + itemCount);
        
        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");
        
        // Verify that the count is greater than 0
        int count = Integer.parseInt(itemCount.split(" ")[0]);
        Assert.assertTrue(count > 0, "Number of Luggage bags should be greater than 0");
        
        // Verify that the page is displaying only luggage bags
        List<String> productNames = gearSection.getProductNames();
        for (String productName : productNames) {
            Assert.assertTrue(productName.contains("Luggage"), "Product name should contain 'Luggage'");
        }
        // Click on the "Clear All" button
        gearSection.clickGearAll();
    }
    @Test(priority=7)
    public void verifyDuffelBagsDisplay() {
            
    	 // Click on the style options
        gearSection.clickStyleClick();
        
        // Click on the Duffel option
        gearSection.clickDuffel();
        
        // Get the count of Duffel bags
        String itemCount = gearSection.getItemCount();
        
        System.out.println("Total Duffel count is: " + itemCount);
        
        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");
        
        // Verify that the count is greater than 0
        int count = Integer.parseInt(itemCount.split(" ")[0]);
        Assert.assertTrue(count > 0, "Number of Duffel bags should be greater than 0");
        
        // Verify that the page is displaying only Duffel bags
        List<String> productNames = gearSection.getProductNames();
        for (String productName : productNames) {
            Assert.assertTrue(productName.contains("Duffel"), "Product name should contain 'Duffel'");
        }
        // Click on the "Clear All" button
        gearSection.clickGearAll();
    }
    @Test(priority=8)
    public void verifyMessangerBagsDisplay() {
            
    	 // Click on the style options
        gearSection.clickStyleClick();
        
        // Click on the Duffel option
        gearSection.clickMessenger();
        
        // Get the count of Messenger bags
        String itemCount = gearSection.getItemCount();
        
        System.out.println("Total Messenger count is: " + itemCount);
        
        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");
        
        // Verify that the count is greater than 0
        int count = Integer.parseInt(itemCount.split(" ")[0]);
        Assert.assertTrue(count > 0, "Number of Messenger bags should be greater than 0");
        
        // Verify that the page is displaying only Messenger bags
        List<String> productNames = gearSection.getProductNames();
        for (String productName : productNames) {
            Assert.assertTrue(productName.contains("Messenger"), "Product name should contain 'Messenger'");
        }
        // Click on the "Clear All" button
        gearSection.clickGearAll();
    }
    @Test(priority=9)
    public void verifyLaptopBagsDisplay() {
            
    	 // Click on the style options
        gearSection.clickStyleClick();
        
        // Click on the Laptop option
        gearSection.clickLaptop();
        
        // Get the count of Laptop bags
        String itemCount = gearSection.getItemCount();
        
        System.out.println("Total Laptop count is: " + itemCount);
        
        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");
        
        // Verify that the count is greater than 0
        int count = Integer.parseInt(itemCount.split(" ")[0]);
        Assert.assertTrue(count > 0, "Number of Laptop bags should be greater than 0");
        
        // Verify that the page is displaying only Laptop bags
        List<String> productNames = gearSection.getProductNames();
        for (String productName : productNames) {
            Assert.assertTrue(productName.contains("Laptop"), "Product name should contain 'Laptop'");
        }
        // Click on the "Clear All" button
        gearSection.clickGearAll();
    }
    
    @Test(priority=10)
    public void verifyExerciseBagsDisplay() {
            
    	 // Click on the style options
        gearSection.clickStyleClick();
        
        // Click on the Exercise option
        gearSection.clickExercise();
        
        // Get the count of Exercise bags
        String itemCount = gearSection.getItemCount();
        
        System.out.println("Total Exercise count is: " + itemCount);
        
        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");
        
        // Verify that the count is greater than 0
        int count = Integer.parseInt(itemCount.split(" ")[0]);
        Assert.assertTrue(count > 0, "Number of Laptop bags should be greater than 0");
        
        // Verify that the page is displaying only Exercise bags
        List<String> productNames = gearSection.getProductNames();
        for (String productName : productNames) {
            Assert.assertTrue(productName.contains("Exercise"), "Product name should contain 'Exercise'");
        }
        // Click on the "Clear All" button
        gearSection.clickGearAll();
    }
    @Test(priority=11)
    public void verifyToteBagsDisplay() {
            
    	 // Click on the style options
        gearSection.clickStyleClick();
        
        // Click on the Tote option
        gearSection.clickTote();
        
        // Get the count of Tote bags
        String itemCount = gearSection.getItemCount();
        
        System.out.println("Total Tote count is: " + itemCount);
        
        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");
        
        // Verify that the count is greater than 0
        int count = Integer.parseInt(itemCount.split(" ")[0]);
        Assert.assertTrue(count > 0, "Number of Laptop bags should be greater than 0");
        
        // Verify that the page is displaying only Tote bags
        List<String> productNames = gearSection.getProductNames();
        for (String productName : productNames) {
            Assert.assertTrue(productName.contains("Tote"), "Product name should contain 'Tote'");
        }
        // Click on the "Clear All" button
        gearSection.clickGearAll();
    }
    @Test(priority=12)
    public void verifyProductPriceRange() {
        // Click on the Price filter
        gearSection.clickPrice();
        
        // Click on the Price range 20-30
        gearSection.clickPrice2030();
        
        // Get the count of products
        String itemCount = gearSection.getItemCount();
        System.out.println("Total product count is: " + itemCount);
        
        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");
        
        // Retrieve the product names
        List<String> productNames = gearSection.getProductNames();
        
        // Verify that all products displayed on the page contain prices within the range 20-30
        for (String productName : productNames) {
            // Extract the price from the product name
            String priceString = getPriceFromProductName(productName);
            double price = Double.parseDouble(priceString);
            
            // Verify that the price is within the range 20-30
            Assert.assertTrue(price >= 20 && price <= 30, "Product price should be within the range 20-30");
        }
        
        // Clear all filters
        gearSection.clickGearAll();
    }

    // Method to extract price from product name
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