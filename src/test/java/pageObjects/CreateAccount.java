package pageObjects;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class CreateAccount {
    private WebDriver driver;
    private WebDriverWait wait;
    public CreateAccount(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    private By firstName = By.id("firstname");
    private By lastName = By.id("lastname");
    private By emailAddress = By.id("email_address");
    private By password = By.id("password");
    private By passwordConfirmation = By.id("password-confirmation");
    private By buttonCreateAcc = By.partialLinkText("Create an Account");
    private By titleText = By.xpath("//h1[@class='page-title']/span[@class='base' and text()='Create New Customer Account']");
    private By buttonSubmitCreateAccount = By.xpath("//button[@title='Create an Account']");
    private By msgAfterSubmit = By.xpath("//div[@class='message-success success message']");

    public void setFirstName(String firstNameText) {
        driver.findElement(firstName).sendKeys(firstNameText);
    }

    public void setLastName(String lastNameText) {
        driver.findElement(lastName).sendKeys(lastNameText);
    }

    public void setEmailAddress(String emailAddressText) {
        driver.findElement(emailAddress).sendKeys(emailAddressText);
    }

    public void setPassword(String passwordText) {
        driver.findElement(password).sendKeys(passwordText);
    }

    public void setConfirmationPassword(String confirmationPasswordText) {
        driver.findElement(passwordConfirmation).sendKeys(confirmationPasswordText);
    }

    public void clickCreateAccountButton() {
        driver.findElement(buttonCreateAcc).click();
    }

    public void clickSubmitCreateAccountButton() {
        driver.findElement(buttonSubmitCreateAccount).click();
    }

    public void waitForSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(msgAfterSubmit));
    }

    public WebElement getSuccessMessageElement() {
        return driver.findElement(msgAfterSubmit);
    }

    public String getLoginTitle() {
        return driver.findElement(titleText).getText();
    }
}