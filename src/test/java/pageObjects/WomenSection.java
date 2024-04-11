package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WomenSection {
    WebDriver driver;
    WebDriverWait wait;

    public WomenSection(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public By womenLink = By.partialLinkText("Women");
    public By topsClick = By.xpath("//*[@id='ui-id-9']");
    public By jacketsClick = By.partialLinkText("Jackets");
    public By hoodiesSweatshirts = By.partialLinkText("Hoodies & Sweatshirts");
    public By teesClick = By.partialLinkText("Tees");
    By productItemLickClick = By.xpath("//a[@class='product-item-link' and contains(text(), 'Juno Jacket')]");
    By size = By.id("option-label-size-143-item-168");
    By sizeXs = By.id("option-label-size-143-item-166");
    By sizeSmall = By.id("option-label-size-143-item-167");
    By sizeLarge = By.id("option-label-size-143-item-169");
    By sizeXtraLarge = By.id("option-label-size-143-item-170");
    By color = By.xpath("//*[@id='option-label-color-93-item-57']");
    By colorBlue = By.xpath("//*[@id='option-label-color-93-item-50']");
    By colorGreen = By.xpath("//*[@id='option-label-color-93-item-53']");
    By quantity = By.xpath("//input[@id='qty']");
    By addTocartButton = By.xpath("//button[@id='product-addtocart-button']");

    public void clickWomenLink() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement womenElement = wait.until(ExpectedConditions.elementToBeClickable(womenLink));
        womenElement.click();
    }

    public void clickTopsClick() {
        WebElement topsElement = wait.until(ExpectedConditions.elementToBeClickable(topsClick));
        topsElement.click();
    }

    public void clickJacketsClick() {
        driver.findElement(jacketsClick).click();
    }

    public void clickHoodiesSweatshirts() {
        WebElement hoodiesSweatshirtsElement = wait.until(ExpectedConditions.elementToBeClickable(hoodiesSweatshirts));
        hoodiesSweatshirtsElement.click();
    }

    public void teesClick() {
        wait.until(ExpectedConditions.elementToBeClickable(teesClick)).click();
    }

    public void productItemLickClick() {
        driver.findElement(productItemLickClick).click();
    }

    public void clickSize() {
        driver.findElement(size).click();
    }

    public void clickColor() {
        driver.findElement(color).click();
    }

    public void clickQuantity() {
        driver.findElement(quantity).click();
    }

    public void setQuantity(String noOfQuantity) {
        WebElement quantityField = driver.findElement(quantity);
        quantityField.clear();  
        quantityField.sendKeys(noOfQuantity);  
    }

    public void clicAddToCartButton() {
        driver.findElement(addTocartButton).click();
    }

    public void clickSizeXs() {
        driver.findElement(sizeXs).click();
    }

    public void clickSizeSmall() {
        driver.findElement(sizeSmall).click();
    }

    public void clickSizeLarge() {
        driver.findElement(sizeLarge).click();
    }

    public void clickSizeXtraLarge() {
        driver.findElement(sizeXtraLarge).click();
    }

    public void clickColorBlue() {
        WebElement blueColorElement = wait.until(ExpectedConditions.elementToBeClickable(colorBlue));
        blueColorElement.click();
    }

    public void clickColorGreen() {
        driver.findElement(colorGreen).click();
    }

    public void updateQuantity(String updatedQuantity) {
        WebElement quantityInput = driver.findElement(quantity);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", quantityInput);
        wait.until(ExpectedConditions.elementToBeClickable(quantityInput));
        quantityInput.click();
        quantityInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        quantityInput.sendKeys(Keys.DELETE);
        quantityInput.sendKeys(updatedQuantity);
    }

    public boolean verifyAllProductsAreHoodiesOrSweatshirts() {
        boolean allProductsAreHoodiesOrSweatshirts = true;
        List<WebElement> products = driver.findElements(By.xpath("//li[contains(@class, 'product-item')]"));
        for (WebElement product : products) {
            String productName = product.findElement(By.xpath(".//a[contains(@class, 'product-item-link')]"))
                    .getText();
            if (!productName.toLowerCase().contains("hoodie") && !productName.toLowerCase().contains("sweatshirt")) {
                allProductsAreHoodiesOrSweatshirts = false; 
                System.out.println("Non-Hoodie/Sweatshirt Product: " + productName);
            }
        }
        return allProductsAreHoodiesOrSweatshirts;
    }

    public List<String> getAllProductNames() {
        List<String> productNames = new ArrayList<>();
        List<WebElement> products = driver.findElements(By.xpath("//li[contains(@class, 'product-item')]"));
        for (WebElement product : products) {
            try {
                WebElement productNameElement = product
                        .findElement(By.xpath(".//a[contains(@class, 'product-item-link')]"));
                String productName = productNameElement.getText();
                productNames.add(productName);
            } catch (StaleElementReferenceException e) {
                System.out.println("Encountered stale element while retrieving product names.");
            }
        }
        return productNames;
    }
}