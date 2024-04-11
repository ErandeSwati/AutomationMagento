package pageObjects;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout {
    private WebDriver driver;
    private WebDriverWait wait;

    public Checkout(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private By proceedToCheckoutButton = By.id("top-cart-btn-checkout");
    private By shippingAddressTitle = By.xpath("//div[@class='step-title' and text()='Shipping Address']");
    private By shippingMethodRadioButton1 = By.xpath("//input[@type='radio' and @class='radio' and @value='tablerate_bestway']");
    private By shippingMethodRadioButton2 = By.xpath("//input[@type='radio' and @class='radio' and @value='flatrate_flatrate']");
    private By nextButtonforProceedPayment = By.xpath("//button[@class='button action continue primary']");
    private By paymentPageTitle = By.xpath("//div[@class='step-title' and text()='Shipping Address']");
    private By placeOrderButton = By.xpath("//div[@class='primary']/button[@class='action primary checkout']/*[text()='Place Order']");
    private By finalThankuPage = By.xpath("//h1[@class='page-title']/*[text()='Thank you for your purchase!']");
    private By successOrderNumber = By.xpath("//div[@class='checkout-success']");

    public void clickProceedToCheckoutButton() {
        WebElement proceedToCheckoutElement = wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
        proceedToCheckoutElement.click();
    }

    public boolean isShippingAddressPageDisplayed() {
        WebElement shippingAddressTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(shippingAddressTitle));
        return shippingAddressTitleElement.isDisplayed();
    }

    public void clickShippingMethodRadioButton1() {
        WebElement shippingMethodRadioButton = wait.until(ExpectedConditions.elementToBeClickable(shippingMethodRadioButton1));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shippingMethodRadioButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", shippingMethodRadioButton);
    }

    public boolean isShippingMethodRadioButton1Selected() {
        WebElement shippingMethodRadioButton1Element = driver.findElement(shippingMethodRadioButton1);
        return shippingMethodRadioButton1Element.isSelected();
    }

    public void clickShippingMethodRadioButton2() {
        WebElement shippingMethodRadioButton2Element = wait.until(ExpectedConditions.elementToBeClickable(shippingMethodRadioButton2));
        shippingMethodRadioButton2Element.click();
    }

    public boolean isShippingMethodRadioButton2Selected() {
        WebElement shippingMethodRadioButton2Element = driver.findElement(shippingMethodRadioButton2);
        return shippingMethodRadioButton2Element.isSelected();
    }

    public void clickNextButtonToProceedForPayment() {
        WebElement nextButtonElement = wait.until(ExpectedConditions.elementToBeClickable(nextButtonforProceedPayment));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButtonElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextButtonElement);
    }

    public boolean isPaymentPageDisplayed() {
        WebElement paymentPageTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentPageTitle));
        return paymentPageTitleElement.isDisplayed();
    }

    public void clickProceedToPlaceOrderButton() {
        WebElement placeOrderButtonElement = wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", placeOrderButtonElement);
    }

    public boolean isThankYouPageDisplayed() {
        WebElement thankYouPageTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(finalThankuPage));
        return thankYouPageTitleElement.isDisplayed();
    }

    public String getOrderNumber() {
        WebElement orderNumberElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successOrderNumber));
        return orderNumberElement.getText();
    }
}