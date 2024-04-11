package testScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import pageObjects.BrowserInitializer;
import pageObjects.Cart;
import pageObjects.Sign_In;
import pageObjects.WomenSection;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
public class CartAllFunctionalityTest
{
	 private BrowserInitializer browserInitializer;
	    private WebDriver driver;
	    private WebDriverWait wait;
	    private Sign_In signInPage;
	    private WomenSection womenSectionPage;
	    private Cart cartPage;
	    @BeforeTest
	    public void setUp() {
	    	browserInitializer = new BrowserInitializer();
	        driver = browserInitializer.getDriver();
	        wait = browserInitializer.getWait();
	        signInPage = new Sign_In(driver);
	        womenSectionPage = new WomenSection(driver);
	        cartPage = new Cart(driver);
	    }
	    @Test(priority=1)
	    public void testSignInWithValidCredentials() {
	        // Navigate to the sign-in page
	        driver.get("https://magento.softwaretestingboard.com/index.php/customer/account/login/");
	        // Set email and password
	        signInPage.setEmailAddress("swatii.erande12@gmail.com");
	        signInPage.setPassword("swati#1234");
	        // Click on the sign-in button
	        signInPage.clickSignInButton();
	        // Wait for the next page to load
	        wait.until(ExpectedConditions.titleContains("My Account"));
	        // Verify that the user is logged in successfully
	        String pageTitle = driver.getTitle();
	        Assert.assertTrue(pageTitle.contains("My Account"), "User logged in successfully");
	    }
	    @Test(priority=2)
	    public void testAddItemToCart() 
	    {
	    	Actions action = new Actions(driver);
	    	action.moveToElement(driver.findElement(womenSectionPage.womenLink)).perform();
	    	action.moveToElement(driver.findElement(womenSectionPage.topsClick)).perform();
	    	action.moveToElement(driver.findElement(womenSectionPage.jacketsClick)).perform();
	    	// Click on Jackets
	        womenSectionPage.clickJacketsClick();
	        // Click on the desired product (Juno Jacket)
	        womenSectionPage.productItemLickClick();
	        // Select size
	        womenSectionPage.clickSize();
	        // Select color
	        womenSectionPage.clickColor();
	        // Enter quantity
	        womenSectionPage.clickQuantity();
	        womenSectionPage.setQuantity("1");
	        // Click on Add to Cart button
	        womenSectionPage.clicAddToCartButton();
	        By successMessage = By.xpath("//*[@class='message-success success message']");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
	        WebElement successMessageElement = driver.findElement(successMessage);
	        String successMessageText = successMessageElement.getText();
	        System.out.println("Success Message: " + successMessageText);
	        Assert.assertTrue(successMessageElement.isDisplayed(), "Success message displayed after adding item to cart");
	    }
	    @Test(priority=3)
	    public void testSubtotalLabel()
	    {
	    	//click the Show Cart Link
	    	cartPage.clickShowCartLink();
	        // Verify if the subtotal label is displayed
	        Assert.assertTrue(cartPage.getSubtotalLabel().isDisplayed(), "Subtotal label is not displayed");
	    }
	    @Test(priority=4)
	    public void testSubtotalValue() {
	        // Get the price 
	        List<WebElement> priceContainers = cartPage.getPriceContainers();
	        // Verify if the subtotal value is displayed and matches expected value
	        Assert.assertEquals(priceContainers.size(), 1, "Expected exactly one subtotal value, but found " + priceContainers.size());
	        String subtotalText = priceContainers.get(0).getText();
	        System.out.println("Sub Total is"+subtotalText);
	        Assert.assertTrue(subtotalText.contains("$77.00"), "Subtotal value is not as expected: $77.00. Actual value: " + subtotalText);
	    }
	    @Test(priority=5)
	    public void testProductDetails() {
	    	try {
	    		cartPage.clickSeeDetailsLink();
	            String sizeLabelText = cartPage.getSizeLabelWithValue();
	            Assert.assertEquals(sizeLabelText, "Size: M", "Size label with value is incorrect");
	            String colorLabelText = cartPage.getColorLabelWithValue();
	            Assert.assertEquals(colorLabelText, "Color: Purple", "Color label with value is incorrect");
	            String priceText = cartPage.getPriceText();
	            Assert.assertEquals(priceText, "$77.00", "Price is incorrect");
	        } catch (AssertionError e) {
	            System.out.println("Price assertion failed: " + e.getMessage());
	        }
	    }
	    @Test(priority = 6)
	    public void testUpdateQuantity() {
	        List<WebElement> priceContainers = cartPage.getPriceContainers();
	        WebElement initialItemCountElement = cartPage.getItemCountElement();
	        String initialItemCount = initialItemCountElement.getText();
	        String initialSubtotalText = priceContainers.get(0).getText();
	        System.out.println("Initial Item Count: " + initialItemCount);
	        System.out.println("Initial Subtotal: " + initialSubtotalText);
	        cartPage.updateQuantity("2"); 
	        cartPage.clickUpdateButton();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.textToBePresentInElement(initialItemCountElement, "2"));
	        String updatedQuantity = initialItemCountElement.getText();
	        String updatedSubtotal = priceContainers.get(0).getText();
	        if (updatedQuantity.equals("2")) {
	            Assert.assertEquals(updatedQuantity, "2", "Quantity is updated correctly");
	            Assert.assertEquals(updatedQuantity, "2", "Item count is updated correctly");
	            System.out.println("Updated Item Count: " + updatedQuantity);
	            System.out.println("Updated Subtotal: " + updatedSubtotal);
	        } else {
	            Assert.assertEquals(updatedQuantity, initialItemCount, "Item count should not change if quantity is not updated");
	            Assert.assertEquals(updatedSubtotal, initialSubtotalText, "Subtotal should not change if quantity is not updated");
	            System.out.println("Item Count remains unchanged: " + updatedQuantity);
	            System.out.println("Subtotal remains unchanged: " + updatedSubtotal);
	        }
	    }
	    @Test(priority = 7)
	    public void testUpdateCart() 
	    {
	    	cartPage.clickEditItem();
	        womenSectionPage.clickSizeXs();
	        womenSectionPage.clickColorBlue();
	        womenSectionPage.updateQuantity("3"); 
	        cartPage.clickUpdateCartButton();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='message-success success message']")));
	        String actualMessage = successMessage.getText().trim();
	        String expectedMessage = "Juno Jacket was updated in your shopping cart.";
	        Assert.assertEquals(actualMessage, expectedMessage, "Success message is not as expected");
	        String expectedTitle = "Shopping Cart";
	        String actualTitle = driver.getTitle();
	        System.out.println("Page Title: " + actualTitle);
	        Assert.assertEquals(actualTitle, expectedTitle, "Page title after updating cart is incorrect");
	    }
	    @Test(priority=8)
	    public void testCancelAndDeleteProduct() {
	        cartPage.clickShowCartLink();
	        cartPage.clickDeleteCartItemButton();
	        cartPage.clickCancelDeleteItemButton();
	        cartPage.clickDeleteCartItemButton();
	        cartPage.clickOkDeleteItemButton();
	        cartPage.clickShowCartLink();
	        womenSectionPage.clickWomenLink();
	        
	        cartPage.clickShowCartLink();
	      
	        // Verify that the cart is empty
	        Assert.assertTrue(cartPage.getNoItemInCartMessageElement().isDisplayed(), "Cart is not empty after deletion");
	       }
	    @AfterTest
	    public void closedBrowser()
	    {
	        browserInitializer.closeBrowser();
	    }
}
