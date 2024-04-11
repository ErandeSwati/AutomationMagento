package pageObjects;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SearchPage {
    WebDriver driver;
    // Locator for the search textbox
    private By searchTextbox = By.xpath("//*[@id='search']");
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }
    // Method to enter search query
    public void enterSearchQuery(String query) {
        WebElement searchBox = driver.findElement(searchTextbox);
        searchBox.clear();
        searchBox.sendKeys(query);
       // searchBox.click();
    }
   public void submitSearchQuery()
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextbox));
   	    // Enter the search query
   	    searchBox.clear();
   	    searchBox.sendKeys(Keys.ENTER);
    }
    
}