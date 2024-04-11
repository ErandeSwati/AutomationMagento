package testScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import pageObjects.BrowserInitializer;
import pageObjects.GearSection;
import java.time.Duration;
import java.util.List;

public class GearBagsPriceSectionFunctionality {
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
	    @Test(priority=1)
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
	    
	    @Test(priority=2)
	    public void verifyProductPriceRange2030() {
	        // Click on the Price filter
	        gearSection.clickPrice();
	        
	        // Click on the Price range 20-30
	        gearSection.clickPrice2030();
	        
	        // Get the count of products
	        String itemCount = gearSection.getItemCount();
	        System.out.println("Total product count in range 20 30  is: " + itemCount);
	        
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
	    @Test(priority=3)
	    public void verifyProductPriceRange3040() {
	        // Click on the Price filter
	        gearSection.clickPrice();
	        
	        // Click on the Price range 30-40
	        gearSection.clickPrice3040();
	        
	        // Get the count of products
	        String itemCount = gearSection.getItemCount();
	        System.out.println("Total product count in Range 30 40 is: " + itemCount);
	        
	        // Verify that the count is not empty
	        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");
	        
	        // Retrieve the product names
	        List<String> productNames = gearSection.getProductNames();
	        
	        // Verify that all products displayed on the page contain prices within the range 30-40
	        for (String productName : productNames) {
	            // Extract the price from the product name
	            String priceString = getPriceFromProductName(productName);
	            double price = Double.parseDouble(priceString);
	            
	            // Verify that the price is within the range 30-40
	            Assert.assertTrue(price >= 30 && price <= 40, "Product price should be within the range 30-40");
	        }
	        
	        // Clear all filters
	        gearSection.clickGearAll();
	    }
	    @Test(priority=4)
	    public void verifyProductPriceRange4050() {
	        // Click on the Price filter
	        gearSection.clickPrice();
	        
	        // Click on the Price range 40-50
	        gearSection.clickPrice4050();
	        
	        // Get the count of products
	        String itemCount = gearSection.getItemCount();
	        System.out.println("Total product count in Range 40 50 is: " + itemCount);
	        
	        // Verify that the count is not empty
	        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");
	        
	        // Retrieve the product names
	        List<String> productNames = gearSection.getProductNames();
	        
	        // Verify that all products displayed on the page contain prices within the range 40-50
	        for (String productName : productNames) {
	            // Extract the price from the product name
	            String priceString = getPriceFromProductName(productName);
	            double price = Double.parseDouble(priceString);
	            
	            // Verify that the price is within the range 40-50
	            Assert.assertTrue(price >= 40 && price <= 50, "Product price should be within the range 40-50");
	        }
	        
	        // Clear all filters
	        gearSection.clickGearAll();
	    }
	    
	    @Test(priority=5)
	    public void verifyProductPriceRange5060() {
	        // Click on the Price filter
	        gearSection.clickPrice();
	        
	        // Click on the Price range 50-60
	        gearSection.clickPrice5060();
	        
	        // Get the count of products
	        String itemCount = gearSection.getItemCount();
	        System.out.println("Total product count in Range 50 60 is: " + itemCount);
	        
	        // Verify that the count is not empty
	        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");
	        
	        // Retrieve the product names
	        List<String> productNames = gearSection.getProductNames();
	        
	        // Verify that all products displayed on the page contain prices within the range 50-60
	        for (String productName : productNames) {
	            // Extract the price from the product name
	            String priceString = getPriceFromProductName(productName);
	            double price = Double.parseDouble(priceString);
	            
	            // Verify that the price is within the range 50-60
	            Assert.assertTrue(price >= 50 && price <= 60, "Product price should be within the range 50-60");
	        }
	        
	        // Clear all filters
	        gearSection.clickGearAll();
	    }
	    @Test(priority=6)
	    public void verifyProductPriceRange70Above() {
	        // Click on the Price filter
	        gearSection.clickPrice();
	        
	        // Click on the Price 70Above
	        gearSection.clickPrice70Above();
	        
	        // Get the count of products
	        String itemCount = gearSection.getItemCount();
	        System.out.println("Total product count in Range 70 above is: " + itemCount);
	        
	        // Verify that the count is not empty
	        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");
	        
	        // Retrieve the product names
	        List<String> productNames = gearSection.getProductNames();
	        
	        // Verify that all products displayed on the page contain prices 70Above
	        for (String productName : productNames) {
	            // Extract the price from the product name
	            String priceString = getPriceFromProductName(productName);
	            double price = Double.parseDouble(priceString);
	            
	            // Verify that the price is 70Above
	            Assert.assertTrue(price >= 70, "Product price should be equal or greater than 70");
	        }
	        	        // Clear all filters
	        gearSection.clickGearAll();
	    }
 	    private String getPriceFromProductName(String productName) {
	        // Extracting price from the HTML structure
	        String priceString = "";
	        int startIndex = productName.indexOf("$"); // Find the starting index of price
	        int endIndex = productName.indexOf("</span>", startIndex); // Find the ending index of price
	        if (startIndex != -1 && endIndex != -1) {
	            priceString = productName.substring(startIndex + 1, endIndex); // Extract the price string
	        }
	        return priceString.trim(); // Trim trailing spaces
	    } 
	    
	    
	    @AfterTest
	    public void closeBrowser() {
	        browserInitializer.closeBrowser();
	    }
	
}
