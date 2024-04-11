package testScenario;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.BrowserInitializer;
import pageObjects.ShoppingOptions;
import pageObjects.WomenSection;

public class ShoppingOptionFunctionality {
    private BrowserInitializer browserInitializer;
    private WebDriver driver;
    private WomenSection womenSectionPage;
    private ShoppingOptions shoppingOptionsObject;
   	@BeforeTest
    public void setUp()
	{
        browserInitializer = new BrowserInitializer();
        driver = browserInitializer.getDriver();
        womenSectionPage = new WomenSection(driver);
        shoppingOptionsObject=new ShoppingOptions(driver);
     }
    
	@Test(priority=0)
    public void testPageTitleDisplaysJackets()
	{
    	 
    	  Actions action = new Actions(driver);
    	  action.moveToElement(driver.findElement(womenSectionPage.womenLink)).perform();
    	  action.moveToElement(driver.findElement(womenSectionPage.topsClick)).perform();
    	  action.moveToElement(driver.findElement(womenSectionPage.jacketsClick)).perform();
    	  // Click on Jackets
    	  womenSectionPage.clickJacketsClick();
    	  // Verify the page title displays "Jackets"
          String expectedPageTitle = "Jackets";
          String actualPageTitle = shoppingOptionsObject.getPageTitleText();
          System.out.println("Page Title:"+actualPageTitle);
          Assert.assertEquals(actualPageTitle, expectedPageTitle, "Page title is not displaying 'Jackets'");
      }
		
	@Test(priority=1)
	public void testShoppingStyleFunctionality()
	{
	    // Step 1: Click on the Style Option
	    shoppingOptionsObject.clickStyleShoppingOption();
	    
	    // Step 2: Click on the Jacket
	    shoppingOptionsObject.clickJacketLink();
	    
	    // Step 3: Retrieve the Count of Jackets and Print It
	    String actualItemCount = shoppingOptionsObject.getItemCount();
	    System.out.println("Actual Jacket Count: " + actualItemCount);
	    
	    // Step 4: Verify All Page Contains Jackets Only
	    verifyAllPageContainsJacketsOnly();
	}
	private void verifyAllPageContainsJacketsOnly()
	{
	    // Get the page source
	    String pageSource = driver.getPageSource();
	    
	    // Verify if the page contains Jackets only
	    boolean containsJacketOnly = pageSource.contains("Jacket") && !pageSource.contains("OtherItem");
	    Assert.assertTrue(containsJacketOnly, "Page does not contain Jackets only");
	}
	
	@Test(priority=2)
	public void testShoppingJacketsSizeFunctionality() {
	    // Step 1: Click on the Size Option
	    shoppingOptionsObject.clickSizeOptions();
	    
	    // Step 2: Click on the XS size
	    shoppingOptionsObject.clickSizeXs();
	    
	    // Step 3: Verify only XS-sized images are selected
	    verifyOnlyXSSizedImagesSelected();
	}

	private void verifyOnlyXSSizedImagesSelected() {
	    // Get all the images of the products
	    List<WebElement> productImages = driver.findElements(By.xpath("//img[@class='product-image-photo']"));
	    
	    // Loop through each image and verify if it's XS size
	    for (WebElement image : productImages) {
	        // Get the parent element of the image, which contains the size information
	        WebElement parentElement = image.findElement(By.xpath("//*[@class='item product product-item']"));
	        
	        // Check if the parent element contains XS size information
	        boolean isXSSize = parentElement.getAttribute("outerHTML").contains("XS");
	        
	        // Assert that only XS-sized images are selected
	        Assert.assertTrue(isXSSize, "Not all images are XS size");
	    }
	}
	
	@Test(priority = 3)
	public void testSelectBlackColorOption() {
		// Step 1: Click on the Color Options
	    shoppingOptionsObject.clickColorOptions();

	    // Step 2: Click on the Black Color Option
	    shoppingOptionsObject.clickBlackColorOptions();

	    // Step 3: Verify that only black-colored products are displayed
	    boolean areAllProductsBlack = shoppingOptionsObject.areAllProductsBlack();
	    Assert.assertTrue(areAllProductsBlack, "Not all products are black-colored");
    }
	
		@AfterTest
		public void closedBrowser()
		{
        browserInitializer.closeBrowser();
		}
}
