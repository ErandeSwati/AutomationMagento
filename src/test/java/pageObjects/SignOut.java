package pageObjects;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SignOut {
    WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public SignOut(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.actions = new Actions(driver);
    }

    private By menuIcon = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button");
    private By signOutButton = By.xpath("//a[contains(text(),'Sign Out')]");
    public void clickMenuIcon() {
        WebElement menuIconElement = wait.until(ExpectedConditions.elementToBeClickable(menuIcon));
        actions.click(menuIconElement).build().perform();
    }
    public void clickSignOutButton() {
        WebElement signOutOptionElement = wait.until(ExpectedConditions.elementToBeClickable(signOutButton));
        actions.click(signOutOptionElement).build().perform();
    }
}