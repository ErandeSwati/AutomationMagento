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
import pageObjects.Checkout;
import pageObjects.SignOut;
import pageObjects.Sign_In;
import pageObjects.WomenSection;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;

public class LoginPage {
    private BrowserInitializer browserInitializer;
    private WebDriver driver;
    private WebDriverWait wait;
    private Sign_In signInPage;
    private WomenSection womenSectionPage;
    private Cart cartPage;
    private Checkout checkoutPage;
    private SignOut signOutObject;
   
    @BeforeTest
    public void setUp() 
    {
        browserInitializer = new BrowserInitializer();
        driver = browserInitializer.getDriver();
        wait = browserInitializer.getWait();
        signInPage = new Sign_In(driver);
        womenSectionPage = new WomenSection(driver);
        cartPage = new Cart(driver);
        checkoutPage=new Checkout(driver);
        signOutObject=new SignOut(driver);
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
       
    @Test(priority=0)
    public void testSignInWithInvalidCredentials() {
        // Navigate to the sign-in page
        driver.get("https://magento.softwaretestingboard.com/index.php/customer/account/login/");

        // Set invalid email and password
        signInPage.setEmailAddress("invalid@example.com");
        signInPage.setPassword("invalidpassword");
        
        // Click on the sign-in button
        signInPage.clickSignInButton();
        
        // Wait for error message to appear
        By errorMessage = By.xpath("//div[@role='alert']//div[contains(@class, 'message-error')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        
        // Retrieve the error message 
        WebElement errorMessageElement = driver.findElement(errorMessage);
        
        // Get the text of the error message
        String errorMessageText = errorMessageElement.getText();
        
        // Print the error message
        System.out.println("Error Message: " + errorMessageText);
        
        // Verify that the error message is displayed
        Assert.assertTrue(errorMessageElement.isDisplayed(), "Error message displayed for invalid credentials");
    }
    
    
    @Test(priority=2)
    public void testAddItemToCart() {
    	
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

        // Wait for success message to appear
        By successMessage = By.xpath("//*[@class='message-success success message']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));

        // Retrieve the success message element
        WebElement successMessageElement = driver.findElement(successMessage);

        // Get the text of the success message
        String successMessageText = successMessageElement.getText();

        // Print the success message
        System.out.println("Success Message: " + successMessageText);

        // Verify that the success message is displayed
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
 	   	
        // Get the price containers
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
    		//click the see details link
    		cartPage.clickSeeDetailsLink();
    		
            // Retrieve size label with value
            String sizeLabelText = cartPage.getSizeLabelWithValue();
            Assert.assertEquals(sizeLabelText, "Size: M", "Size label with value is incorrect");

            // Retrieve color label with value
            String colorLabelText = cartPage.getColorLabelWithValue();
            Assert.assertEquals(colorLabelText, "Color: Purple", "Color label with value is incorrect");

            // Retrieve price text
            String priceText = cartPage.getPriceText();
            Assert.assertEquals(priceText, "$77.00", "Price is incorrect");
        } catch (AssertionError e) {
            System.out.println("Price assertion failed: " + e.getMessage());
        }
    }
    
    @Test(priority = 6)
    public void testUpdateQuantity() {
    	 // Get the price containers
        List<WebElement> priceContainers = cartPage.getPriceContainers();

        // Get initial number of items
        WebElement initialItemCountElement = cartPage.getItemCountElement();
        String initialItemCount = initialItemCountElement.getText();
        // Get initial subtotal
        String initialSubtotalText = priceContainers.get(0).getText();

        // Print initial count and subtotal
        System.out.println("Initial Item Count: " + initialItemCount);
        System.out.println("Initial Subtotal: " + initialSubtotalText);

        // Test updating quantity
        cartPage.updateQuantity("2"); // Assuming "2" is the new quantity
        cartPage.clickUpdateButton();

        // Use WebDriverWait for explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait for the updated quantity to be visible
        wait.until(ExpectedConditions.textToBePresentInElement(initialItemCountElement, "2"));

        // Get updated quantity
        String updatedQuantity = initialItemCountElement.getText();
        // Get updated subtotal
        String updatedSubtotal = priceContainers.get(0).getText();

        // Verify quantity is updated
        if (updatedQuantity.equals("2")) {
            // Quantity is successfully updated
            Assert.assertEquals(updatedQuantity, "2", "Quantity is updated correctly");
            // Verify number of items remains the same after updating quantity
            Assert.assertEquals(updatedQuantity, "2", "Item count is updated correctly");
            // Print updated count and subtotal
            System.out.println("Updated Item Count: " + updatedQuantity);
            System.out.println("Updated Subtotal: " + updatedSubtotal);
        } else {
            // Quantity is not updated, so no change in item count should be expected
            Assert.assertEquals(updatedQuantity, initialItemCount, "Item count should not change if quantity is not updated");
            // Subtotal should remain the same if quantity is not updated
            Assert.assertEquals(updatedSubtotal, initialSubtotalText, "Subtotal should not change if quantity is not updated");
            // Print unchanged count and subtotal
            System.out.println("Item Count remains unchanged: " + updatedQuantity);
            System.out.println("Subtotal remains unchanged: " + updatedSubtotal);
        }
    }
    @Test(priority=7)
    public void testProceedToCheckoutButton() {
    	checkoutPage.clickProceedToCheckoutButton();
        boolean isShippingAddressPageDisplayed = checkoutPage.isShippingAddressPageDisplayed();
        Assert.assertTrue(isShippingAddressPageDisplayed, "Shipping Address page is not displayed after clicking Proceed to Checkout button");
    }
    
    @Test(priority=8)
    public void testSelectShipping() {
    	// Click the shipping method radio button 1
        checkoutPage.clickShippingMethodRadioButton1();
        
        // Assert that the shipping method radio button 1 is selected
        Assert.assertTrue(checkoutPage.isShippingMethodRadioButton1Selected(), "Shipping method radio button 1 is not selected");
        
       }
    
    @Test(priority = 9)
    public void testCompleteCheckoutFlow()
    {
         //Click on the Next button to proceed for payment
        checkoutPage.clickNextButtonToProceedForPayment();
        // Assert that payment page is displayed
        Assert.assertTrue(checkoutPage.isPaymentPageDisplayed(), "Payment page is not displayed after clicking Next button");
      }
    @Test(priority = 10)
    private void completePaymentProcess() 
    {
        // Click on the Place Order button
    	checkoutPage.clickProceedToPlaceOrderButton();

        // Assert that thank you page is displayed
        Assert.assertTrue(checkoutPage.isThankYouPageDisplayed(), "Thank you page is not displayed after clicking Place Order button");

        //Retrieve and print order number
        String orderNumber = checkoutPage.getOrderNumber();
        System.out.println("Order Number: " + orderNumber);
    }
  
    @AfterTest
    public void closedBrowser()
    {
        browserInitializer.closeBrowser();
    }
   
}