package pageObjects;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Sign_In {
    WebDriver driver;
    WebDriverWait wait;
    public Sign_In(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(35));
    }
    By emailUserId = By.id("email");
    By passwordSignIn = By.id("pass");
    By signInButton = By.xpath("//button[@class='action login primary' and .//span[text()='Sign In']]");
    By signIn = By.xpath("//*[text()='Sign In']");
    public void setEmailAddress(String email_Address) {
        driver.findElement(emailUserId).sendKeys(email_Address);
    }
    public void setPassword(String pwd) {
        driver.findElement(passwordSignIn).sendKeys(pwd);
    }
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }
    public void signInClick() {
        WebElement signInElement = wait.until(ExpectedConditions.elementToBeClickable(signIn));
        signInElement.click();
    }
}