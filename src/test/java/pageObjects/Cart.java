package pageObjects;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {
    private WebDriver driver;
    private WebDriverWait wait;
    public Cart(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public By showCart = By.xpath("//a[@class='action showcart']");
    private By seedetails = By.xpath("//*[contains(text(),'See Details')]");
    private By subtotalLabel = By.xpath("//span[contains(text(),'Cart Subtotal')]");
    private By priceContainer = By.xpath("//div[contains(@class, 'amount price-container')]/span[@class='price-wrapper']");
    private By sizeLabelLocator = By.xpath("//dl[@class='product options list']//dt[text()='Size']");
    private By sizeValueLocator = By.xpath("//dl[@class='product options list']//dt[text()='Size']/following-sibling::dd/span");
    private By colorLabelLocator = By.xpath("//dl[@class='product options list']//dt[text()='Color']");
    private By colorValueLocator = By.xpath("//dl[@class='product options list']//dt[text()='Color']/following-sibling::dd/span");
    private By priceElementLocator = By.xpath("//div[@class='price-container']//span[@class='price']");
    private By quantityInputLocator = By.xpath("//input[contains(@id,'cart-item')]");
    private By updateButtonLocator = By.xpath("//button[contains(@id,'update-cart-item')]");
    private By countElementLocator = By.xpath("//span[@class='count']");
    private By subtotalElementLocator = By.xpath("//span[contains(text(),'Cart Subtotal')]");
    private By deleteProduct = By.xpath("//*[@id=\"mini-cart\"]/li[1]/div/div/div[3]/div[2]/a");
    private By cancelDeleteButton = By.xpath("//button[@class='action-secondary action-dismiss']");
    private By noItemInCartMessage = By.xpath("//strong[@class='subtitle empty' and text()='You have no items in your shopping cart.']");
    private By editItem = By.xpath("//a[@class='action edit']");
    private By itemsTotalLocator = By.cssSelector(".items-total .count");
    private By clickUpdateCartButton = By.xpath("//*[@id='product-updatecart-button']");
    By okDeleteButton = By.xpath("//button[@class='action-primary action-accept']");
    public void clickShowCartLink() {
        WebElement showCartElement = wait.until(ExpectedConditions.elementToBeClickable(showCart));
        showCartElement.click();
    }

    public void clickSeeDetailsLink() {
    	WebElement seeDetailsElement = driver.findElement(seedetails);
        
        // Scroll to the element
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", seeDetailsElement);
        
        // Wait for the element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(seeDetailsElement));
        
        // Click on the element
        seeDetailsElement.click();
    }

    public WebElement getSubtotalLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(subtotalLabel));
    }

    public List<WebElement> getPriceContainers() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(priceContainer));
    }

    public String getSizeLabelText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sizeLabelLocator)).getText();
    }

    public String getSizeValueText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sizeValueLocator)).getText();
    }

    public String getColorLabelText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(colorLabelLocator)).getText();
    }

    public String getColorValueText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(colorValueLocator)).getText();
    }

    public String getSizeLabelWithValue() {
        return getSizeLabelText() + ": " + getSizeValueText();
    }

    public String getColorLabelWithValue() {
        return getColorLabelText() + ": " + getColorValueText();
    }

    public String getPriceText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(priceElementLocator)).getText();
    }

    public void updateQuantity(String quantity) {
        WebElement quantityInput = wait.until(ExpectedConditions.elementToBeClickable(quantityInputLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", quantityInput);
        wait.until(ExpectedConditions.elementToBeClickable(quantityInput));

    	quantityInput.click();
    	quantityInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));

    	// Clear the selected quantity
    	quantityInput.sendKeys(Keys.DELETE);

    	// Send the new quantity
    	quantityInput.sendKeys(quantity);    }

    public void clickUpdateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(updateButtonLocator)).click();
    }

    public String getCount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(countElementLocator)).getText();
    }

    public WebElement getItemCountElement() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(itemsTotalLocator));
    }

    public String getSubtotal() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(subtotalElementLocator)).getText();
    }

    public void clickEditItem() {
        WebElement editproduct = wait.until(ExpectedConditions.elementToBeClickable(editItem));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editproduct);
        editproduct.click();
    }

    public void clickUpdateCartButton() {
        WebElement updateCartButton = wait.until(ExpectedConditions.elementToBeClickable(clickUpdateCartButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", updateCartButton);
        updateCartButton.click();
    }

    public void clickDeleteCartItemButton() {
    	WebElement deleteCartButton = wait.until(ExpectedConditions.elementToBeClickable(deleteProduct));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteCartButton);
    	deleteCartButton.click();
    }

    public void clickOkDeleteItemButton() {
    	 WebElement deleteOkButtonPopup = wait.until(ExpectedConditions.elementToBeClickable(okDeleteButton));
         
         // Click the element
         deleteOkButtonPopup.click();    }
    public void clickCancelDeleteItemButton() {
   	 WebElement deleteCancelButtonPopup = wait.until(ExpectedConditions.elementToBeClickable(cancelDeleteButton));
        
        // Click the element
   	deleteCancelButtonPopup.click();    }

    public WebElement getNoItemInCartMessageElement() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(noItemInCartMessage));
    }
    public boolean isCartItemVisible() {
    	try {
            WebElement cartItemElement = wait.until(ExpectedConditions.visibilityOfElementLocated(noItemInCartMessage));
            return cartItemElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public void handleAlertPopup(boolean accept) {
        Alert alert = driver.switchTo().alert();
        if (accept) {
            alert.accept(); // Click on OK button
        } else {
            alert.dismiss(); // Click on Cancel button
        }
    }
}