package dataDriven;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SignInTestUsingDataProviderDataDriventesting {
	private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private WebElement menuIcon;
    private WebElement signOut;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "E:\\Eclipse\\Jar\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(300));

        actions = new Actions(driver);
        
        // Initialize menuIcon and signOut elements
     }

    @Test(dataProvider="LoginData")
    public void loginTest(String user, String pwd, String exp) {
        driver.get("https://magento.softwaretestingboard.com/index.php/customer/account/login/");

    	WebElement emailUserId = driver.findElement(By.id("email"));
        emailUserId.clear();
        emailUserId.sendKeys(user);
        WebElement passwordSignIn = driver.findElement(By.id("pass"));
        passwordSignIn.clear();
        passwordSignIn.sendKeys(pwd);
        WebElement signInButton = driver.findElement(By.xpath("//button[@class='action login primary' and .//span[text()='Sign In']]"));
        signInButton.click();
        
        String exp_title = "My Account";
        String act_title = driver.getTitle();
        if(exp.equals("Valid")) {
            if(exp_title.equals(act_title)) {
            	WebElement menuIcon = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button"));
                WebElement signOut = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));

                // Click on the menu icon to initiate sign out
                WebElement menuIconElement = wait.until(ExpectedConditions.elementToBeClickable(menuIcon));
                actions.click(menuIconElement).build().perform();

                // Click on the Sign Out button
                WebElement signOutOptionElement = wait.until(ExpectedConditions.elementToBeClickable(signOut));
                actions.click(signOutOptionElement).build().perform();
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        } else if(exp.equals("Invalid")) {
            if(exp_title.equals(act_title)) {
             Assert.assertTrue(false);
            } else {
                Assert.assertTrue(true);
            }
        }
    }

    @DataProvider(name="LoginData")
    public String[][] getData() {
        String loginData[][] = {
                {"swatii.erande12@gmail.com", "swati#1234", "Valid"},
                {"swatii.erande12@gmail.com", "swati", "Invalid"},
                {"swatii.erande12", "swati#1234", "Invalid"},
                {"swatii.erande12", "swatii", "Invalid"}
        };
        return loginData;
    }

    @AfterClass
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}