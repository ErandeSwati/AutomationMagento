package testScenario;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BrowserInitializer;
import pageObjects.GearSection;
public class GearWatchesCategorySectionFunctionality {
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
    public void testWatchesSectionDisplayAndTitle() {
        // Click on Watches section
        gearSection.clickWatchesSection();

        // Wait for the page to load and verify the Watches section is displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isWatchesSectionDisplayed = wait.until(ExpectedConditions.urlContains("watches.html"));
        
        // Assert that the Watches section is displayed
        Assert.assertTrue(isWatchesSectionDisplayed, "Watches section page is not displayed");

        // Get the title of the page
        String pageTitle = driver.getTitle();
        System.out.println("Watches section page title: " + pageTitle);

        // Assert that the title contains expected text
        Assert.assertTrue(pageTitle.contains("Watches"), "Page title does not contain expected text 'Watches'");
    }
    @Test(priority=3)
    public void testElectronicWatchCategoryDisplay() {
       
    	
    	gearSection.clickWatchCategory();

        // Click on Electronic Watch category
        gearSection.clickElectronicWatchCategory();

        // Wait for the page to load and verify items are displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product-item")));

        // Get the count of Electronic Watch items
        String itemCount = gearSection.getItemCount();
        System.out.println("Total Electronic Watch Item count is: " + itemCount);

        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");

        // Verify that the count is greater than 0
        int count = Integer.parseInt(itemCount.split(" ")[0]);
        Assert.assertTrue(count > 0, "Number of Electronic Watch items should be greater than 0");

        // Verify that the page is displaying items
        List<WebElement> productItems = driver.findElements(By.className("product-item"));
        Assert.assertTrue(productItems.size() > 0, "Page is not displaying any items");

        // Click on the "Clear All" button
        gearSection.clickGearAll();
    }
    
    @Test(priority=4)
    public void testExerciseWatchCategoryDisplay() {
    	gearSection.clickWatchCategory();


        // Click on Exercise Watch category
        gearSection.clickExerciseWatch();

        // Wait for the page to load and verify items are displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product-item")));

        // Get the count of Exercise Watch items
        String itemCount = gearSection.getItemCount();
        System.out.println("Total Exercise Watch Item count is: " + itemCount);

        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");

        // Verify that the count is greater than 0
        int count = Integer.parseInt(itemCount.split(" ")[0]);
        Assert.assertTrue(count > 0, "Number of Exercise Watch items should be greater than 0");

        // Verify that the page is displaying items
        List<WebElement> productItems = driver.findElements(By.className("product-item"));
        Assert.assertTrue(productItems.size() > 0, "Page is not displaying any items");

        // Click on the "Clear All" button
        gearSection.clickGearAll();
    }

    @Test(priority=5)
    public void testFashionWatchCategoryDisplay() {
    	gearSection.clickWatchCategory();


        // Click on Fashion Watch category
        gearSection.clickFashionWatch();

        // Wait for the page to load and verify items are displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product-item")));

        // Get the count of Fashion Watch items
        String itemCount = gearSection.getItemCount();
        System.out.println("Total Fashion Watch Item count is: " + itemCount);

        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");

        // Verify that the count is greater than 0
        int count = Integer.parseInt(itemCount.split(" ")[0]);
        Assert.assertTrue(count > 0, "Number of Fashion Watch items should be greater than 0");

        // Verify that the page is displaying items
        List<WebElement> productItems = driver.findElements(By.className("product-item"));
        Assert.assertTrue(productItems.size() > 0, "Page is not displaying any items");

        // Click on the "Clear All" button
        gearSection.clickGearAll();
    }

    @Test(priority=6)
    public void testTimepieceWatchCategoryDisplay() {
    	gearSection.clickWatchCategory();


        // Click on Timepiece Watch category
        gearSection.clickTimepieceWatch();

        // Wait for the page to load and verify items are displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product-item")));

        // Get the count of Timepiece Watch items
        String itemCount = gearSection.getItemCount();
        System.out.println("Total Timepiece Watch Item count is: " + itemCount);

        // Verify that the count is not empty
        Assert.assertNotEquals(itemCount, "", "Item count should not be empty");

        // Verify that the count is greater than 0
        int count = Integer.parseInt(itemCount.split(" ")[0]);
        Assert.assertTrue(count > 0, "Number of Timepiece Watch items should be greater than 0");

        // Verify that the page is displaying items
        List<WebElement> productItems = driver.findElements(By.className("product-item"));
        Assert.assertTrue(productItems.size() > 0, "Page is not displaying any items");

        // Click on the "Clear All" button
        gearSection.clickGearAll();
    }
    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
