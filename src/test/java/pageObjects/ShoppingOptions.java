package pageObjects;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ShoppingOptions {

    private final WebDriver driver;
    private final WebDriverWait wait;
    public ShoppingOptions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    private final By styleOption = By.cssSelector("div[data-role='title'][class='filter-options-title']");
    private final By jacketLink = By.xpath("//li[@class='item']/a[contains(text(), 'Jacket')]");
    private final By itemCount = By.xpath("//p[@class='toolbar-amount' and @id='toolbar-amount']");
    private final By pageTitle = By.cssSelector("span.base[data-ui-id='page-title-wrapper']");
    private final By sizeOptions = By.xpath("//div[text()='Size']");
    private final By priceOptions = By.xpath("//div[@class='filter-options-title' and text()='Price']");
    private final By colorOptions = By.xpath("//div[text()='Color']");
    private final By sizeXs = By.xpath("//div[@class='swatch-option text ' and @option-id='166' and @option-label='XS']");
    private final By priceFilter3040 = By.xpath("//a[@href='https://magento.softwaretestingboard.com/women/tops-women/hoodies-and-sweatshirts-women.html?price=30-40']");
    private final By priceFilter5060 = By.xpath("//a[@href='https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html?price=50-60']");
    private final By priceFilter6070 = By.xpath("//a[@href='https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html?price=60-70']");
    private final By priceFilter7080 = By.xpath("//a[@href='https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html?price=70-80']");
    private final By priceFilter80Above = By.xpath("//a[starts-with(@href,'https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html?price=80')]");
    private final By colorBlack = By.xpath("//div[@class='swatch-option color ' and @option-id='49' and @option-label='Black']");

    public void clickStyleShoppingOption() {
        WebElement styleElement = wait.until(ExpectedConditions.elementToBeClickable(styleOption));
        styleElement.click();
    }

    public void clickColorOptions() {
        WebElement colorElement = wait.until(ExpectedConditions.elementToBeClickable(colorOptions));
        colorElement.click();
    }

    public void clickBlackColorOptions() {
        WebElement colorBlackElement = wait.until(ExpectedConditions.elementToBeClickable(colorBlack));
        colorBlackElement.click();
    }

    public boolean areAllProductsBlack() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ol[@class='products list items product-items']/li[contains(@class, 'item product product-item')]")));

        // Get all product elements
        List<WebElement> productElements = driver.findElements(By.xpath("//ol[@class='products list items product-items']/li[contains(@class, 'item product product-item')]"));

        // Check if all products are black-colored
        for (WebElement productElement : productElements) {
            // Find the color attribute of each product
            WebElement colorOption = productElement.findElement(By.xpath(".//*[@id='option-label-color-93-item-49']"));

            // Check if the black color option is selected
            String ariaCheckedAttribute = colorOption.getAttribute("aria-checked");
            if (!"true".equals(ariaCheckedAttribute)) {
                return false; // If black color option is not selected, return false
            }
        }
        return true; // If all products have black color selected, return true
    }

    public void clickPriceOptions() {
        WebElement priceElement = wait.until(ExpectedConditions.elementToBeClickable(priceOptions));
        priceElement.click();
    }

    public void clickJacketLink() {
        driver.findElement(jacketLink).click();
    }

    public void clickSizeOptions() {
        wait.until(ExpectedConditions.elementToBeClickable(sizeOptions));
        driver.findElement(sizeOptions).click();
    }

    public void clickPriceOptions3040() {
        WebElement price3040Element = wait.until(ExpectedConditions.elementToBeClickable(priceFilter3040));
        price3040Element.click();
    }

    public void clickPriceOptions5060() {
        driver.findElement(priceFilter5060).click();
    }

    public void clickPriceOptions6070() {
        driver.findElement(priceFilter6070).click();
    }

    public void clickPriceOptions7080() {
        driver.findElement(priceFilter7080).click();
    }

    public void clickPriceOptions80Above() {
        driver.findElement(priceFilter80Above).click();
    }

    // Methods to interact with elements
    public void clickSizeXs() {
        // Scroll to the parent element of the XS size option
        scrollToElement(driver, driver.findElement(sizeXs).findElement(By.xpath("..")));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(sizeXs));
        element.click();
        WebDriverWait afterClickWait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as per your requirement
        afterClickWait.until(ExpectedConditions.stalenessOf(element)); // Wait for the element to become stale
    }

    private void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public String getItemCount() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(itemCount));
        WebElement itemCountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(itemCount));
        return itemCountElement.getText();
    }

    public String getPageTitleText() {
        return driver.findElement(pageTitle).getText();
    }
}