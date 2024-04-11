package testScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.Assert;
import pageObjects.BrowserInitializer;
import pageObjects.Cart;
import pageObjects.Sign_In;
import pageObjects.WishList;
import org.openqa.selenium.By;
import pageObjects.SearchPage;
public class WishListReviewFunctionality 
{
		private BrowserInitializer browserInitializer;
	    private WebDriver driver;
	    private WebDriverWait wait;
	    private Sign_In signInPage;
	    private WishList wishListObject;
	    private Cart cartPage;
	    private Actions action;
	    private SearchPage searchObject;
	    
    @BeforeTest
    public void setUp()
    {browserInitializer = new BrowserInitializer();
    driver = browserInitializer.getDriver();
    wait = browserInitializer.getWait();
    signInPage = new Sign_In(driver);
    wishListObject = new WishList(driver);
    cartPage = new Cart(driver);
    searchObject=new SearchPage(driver);
    action = new Actions(driver); 
    }

    @Test(priority = 1)
    public void testSignInWithValidCredentials() {
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
    public void testJacketsTitle() {
        // Hover over Men, then Tops, then Jackets
        action.moveToElement(driver.findElement(wishListObject.menLink)).perform();
        action.moveToElement(driver.findElement(wishListObject.topsClick)).perform();
        action.moveToElement(driver.findElement(wishListObject.jacketsClick)).click().perform();
        // Verify all page contains jacket with assertion
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Jacket"), "Page contains Jackets");
    }
    @Test(priority=3)
    public void reviewProductTest()
    {
    	//Click on the "Product Link"
    	wishListObject.clickProductItemLink();
    	// Click on the "Add Review" link
    	wishListObject.clickAddReviewLink();
    	// Enter nickname
    	wishListObject.enterNickName("Renu");
    	// Enter summary
    	wishListObject.enterSummary("This product is good.");
    	// Enter review
    	wishListObject.enterReview("I really liked this product. It met my expectations.");
       	wishListObject.click1StarRating();
    	wishListObject.clickSubmitReviewButton();
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
    	Assert.assertTrue(successMessageElement.isDisplayed(), "Success message displayed after Review");
    }
    @Test(priority=4)
    public void testAddToWishlist() {
    	wishListObject.selectSize();
        wishListObject.selectColor();
        wishListObject.setQuantity(1);
        wishListObject.addToWishList();
        // Wait for success message to appear
        By successMessage = By.xpath("//*[@class='message-success success message']");
        WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        // Retrieve the success message text
        String successMessageText = successMessageElement.getText();
        // Print the success message
        System.out.println("Success Message: " + successMessageText);
        // Verify that the success message is displayed
        Assert.assertTrue(successMessageElement.isDisplayed(), "Success message is not displayed after adding item to wishlist");
        // Verify page title is "My Wish List"
        String expectedTitle = "My Wish List";
        System.out.println("Expected title is:"+expectedTitle);
        String actualTitle = driver.getTitle();
        System.out.println("Actual title is:"+actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Page title is not as expected");
    }
    @Test(priority = 5)
    @Ignore
    public void testShareWishList()
    {
        // Enter email and message
        String email = "erandeswati91@gmail.com";
        String message = "My favorite wishlist!";
        wishListObject.clickShareWishListButton();
        wishListObject.setEmailInShareEmailTextBox(email);
        wishListObject.setMessageInMessageTextBox(message);
        wishListObject.clickShareWishListSubmitButton();
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
        Assert.assertTrue(successMessageElement.isDisplayed(), "Success message displayed after Review");
    }
    @Test(priority = 6)
    public void testAddAllToCart() {
        wishListObject.clickAddAllToCartButton();
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
        Assert.assertTrue(successMessageElement.isDisplayed(), "Success message displayed after Review");
    }
    @Test(priority=7)
    public void testProductDetails() {
    	try {
    			
    		try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		cartPage.clickShowCartLink();
    		//click the see details link
    		cartPage.clickSeeDetailsLink();
    		// Retrieve size
            String sizeLabelText = cartPage.getSizeLabelWithValue();
            System.out.println("Size is: "+sizeLabelText);
            Assert.assertEquals(sizeLabelText, "Size: XS", "Size label with value is incorrect");
            // Retrieve color
            String colorLabelText = cartPage.getColorLabelWithValue();
            System.out.println("Color is: "+colorLabelText);
            Assert.assertEquals(colorLabelText, "Color: Black", "Color label with value is incorrect");
            // Retrieve price text
            String priceText = cartPage.getPriceText();
            System.out.println("Price is: "+priceText);
            Assert.assertEquals(priceText, "$45.00", "Price is incorrect");
        } catch (AssertionError e) {
            System.out.println("Price assertion failed: " + e.getMessage());
        }
    }
    
    
    @Test(priority=8)
    public void testCancelAndDeleteProduct() {
    	 // Delete the cart item
        cartPage.clickDeleteCartItemButton();
        // Cancel the deletion
        cartPage.clickCancelDeleteItemButton();
        // Delete the cart item again
        cartPage.clickDeleteCartItemButton();
        // Confirm the deletion
        cartPage.clickOkDeleteItemButton();
        wishListObject.clickMenLink();
       
        cartPage.clickShowCartLink();
        // Verify that the cart is empty
        Assert.assertTrue(cartPage.getNoItemInCartMessageElement().isDisplayed(), "Cart is not empty after deletion");
    }
    @AfterTest
    public void ClosedBrowser()
    		{
    			browserInitializer.closeBrowser();
    		}
}