package testScenario;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.CreateAccount;
import org.testng.annotations.Test;
import org.testng.Assert;

public class NewAccountCreate {
	 String driverPath = "E:\\Eclipse\\Jar\\geckodriver.exe";
	    WebDriver driver;
	    CreateAccount objCreateAcc;

	    @BeforeTest
	    public void launchBrowser() {
	        System.setProperty("webdriver.gecko.driver", driverPath);
	        driver = new FirefoxDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("https://magento.softwaretestingboard.com/");
	        objCreateAcc = new CreateAccount(driver);
	    }
	    @Test(priority=1)
	    public void test_Home_Page_Appear_Correct() {
	        // Click on the Create Account button
	        objCreateAcc.clickCreateAccountButton();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.titleIs("Create New Customer Account"));
	        // Verify page title
	        String loginPageTitle = driver.getTitle().trim(); // Trim to remove leading/trailing whitespaces
	        // Print the actual page title
	        System.out.println("Actual Page Title: " + loginPageTitle);
	        // Assert that the page title matches the expected title
	        Assert.assertTrue(loginPageTitle.toLowerCase().contains("create new customer account"),
	                          "Expected page title to contain 'Create New Customer Account'");
	    }

	    @Test(priority=2)
	    public void test_Fillup_Create_Account_Details_Correctly() {
	        // Fill up Create Account details
	        objCreateAcc.setFirstName("Swati");
	        objCreateAcc.setLastName("Eran");
	        objCreateAcc.setEmailAddress("swatii.erande1234@gmail.com");
	        objCreateAcc.setPassword("swati#1234");
	        objCreateAcc.setConfirmationPassword("swati#1234");
	        objCreateAcc.clickSubmitCreateAccountButton();
	        objCreateAcc.waitForSuccessMessage();
	        WebElement successMessageElement = objCreateAcc.getSuccessMessageElement();
	        Assert.assertTrue(successMessageElement.isDisplayed(), "Success message not displayed after account creation");
	    }
    
	    @AfterTest
	    public void closeBrowser() {
	        if (driver != null) {
	            driver.quit();
	            System.out.println("Browser closed.");
	        }
	    }
	    
}