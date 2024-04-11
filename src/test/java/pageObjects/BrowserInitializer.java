package pageObjects;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
public class BrowserInitializer 
{

	private WebDriver driver;
    WebDriverWait wait;
	public BrowserInitializer() 
	{
        System.setProperty("webdriver.gecko.driver", "E:\\Eclipse\\Jar\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
        wait = new WebDriverWait(driver, Duration.ofSeconds(300));
        driver.get("https://magento.softwaretestingboard.com/");
     }
    public WebDriver getDriver()
    {
        return driver;
    }
    public WebDriverWait getWait()
    {
        return wait;
    }
    public void closeBrowser()
    {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}
