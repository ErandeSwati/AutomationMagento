package testScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import pageObjects.BrowserInitializer;
import pageObjects.Sign_In;
import pageObjects.SignOut;
public class SignOutFunction {
    private BrowserInitializer browserInitializer;
    private WebDriver driver;
    private WebDriverWait wait;
    private Sign_In signInPage;
    private SignOut signOutObject;
 
    @BeforeTest
    public void setUp() {
        browserInitializer = new BrowserInitializer();
        driver = browserInitializer.getDriver();
        wait = browserInitializer.getWait();
        signInPage = new Sign_In(driver);
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
    @Test(priority=2)
    public void testSSignOutAction()
    {
    	signOutObject.clickMenuIcon();
    	signOutObject.clickSignOutButton();
        String pageTitle = driver.getTitle();
        System.out.println("Page Title is: "+pageTitle);
        Assert.assertTrue(pageTitle.contains("My Account"), "User logged in successfully");
    }
    
    @AfterTest
    public void ClosedBrowser()
    		{
    			browserInitializer.closeBrowser();
    		}
}
    