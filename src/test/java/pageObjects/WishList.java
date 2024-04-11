package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class WishList {
	WebDriver driver;
	 WebDriverWait wait;
	public WishList(WebDriver driver)
	{
		this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Initialize WebDriverWait
	}
	public By menLink=By.xpath("//*[text()='Men']");
	public By topsClick=By.xpath("//*[@id=\"ui-id-17\"]/span[2]");
	public By jacketsClick=By.partialLinkText("Jackets");
	private By productItemClick=By.xpath("//a[@class='product-item-link' and contains(text(), 'Proteus Fitness Jackshirt')]");
    public void clickMenLink()
    {
        WebElement menElement = wait.until(ExpectedConditions.elementToBeClickable(menLink));
        menElement.click();
    }
    public void clickTops()
    {
        WebElement topsElement = wait.until(ExpectedConditions.elementToBeClickable(topsClick));
        topsElement.click();
    }
    public void clickJackets()
    {
        WebElement jacketsElement = wait.until(ExpectedConditions.elementToBeClickable(jacketsClick));
        jacketsElement.click();
    }
    public void clickProductItemLink() {
        WebElement productItemElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productItemClick));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productItemElement);
        productItemElement.click();
    }
    /******************************Review**********************/
    private By addReviewLink=By.xpath("//*[@class='action add']");
    private By click1StarRating=By.xpath("//*[@id='Rating_1_label']");
    private By click2StarRating=By.xpath("//*[@id='Rating_2_label']");
    private By click3StarRating=By.xpath("//*[@id='Rating_3_label']");
    private By click4StarRating=By.xpath("//*[@id='Rating_4_label']");
    private By click5StarRating=By.xpath("//*[@id='Rating_5_label']");
    private By nickNameTextBox=By.xpath("//*[@id='nickname_field']");
    private By summaryTextBox=By.xpath("//*[@id='summary_field']");
    private By reviewTextArea=By.xpath("//*[@id='review_field']");
    private By submitReviewButton=By.xpath("//*[text()='Submit Review']");
    public void clickAddReviewLink()
    {
        WebElement addReviewElement = wait.until(ExpectedConditions.elementToBeClickable(addReviewLink));
        addReviewElement.click();
    }
    public void click3StarRating()
    {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(click3StarRating));
        WebElement star3Element = wait.until(ExpectedConditions.visibilityOfElementLocated(click3StarRating));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", star3Element);
    }
    public void click1StarRating()
    {
        WebElement star1Element = wait.until(ExpectedConditions.elementToBeClickable(click1StarRating));
        star1Element.click();
    }
    public void click2StarRating()
    {
        WebElement star2Element = wait.until(ExpectedConditions.elementToBeClickable(click2StarRating));
        star2Element.click();
    }
    public void click4StarRating()
    {
        WebElement star4Element = wait.until(ExpectedConditions.elementToBeClickable(click4StarRating));
        star4Element.click();
    }
    public void click5StarRating()
    {
        WebElement star5Element = wait.until(ExpectedConditions.elementToBeClickable(click5StarRating));
        star5Element.click();
    }
    public void enterNickName(String nickName)
    {
        WebElement nickNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nickNameTextBox));
        nickNameElement.click();
        nickNameElement.sendKeys(Keys.chord(Keys.CONTROL, "a")); // or Keys.COMMAND for Mac
        nickNameElement.sendKeys(Keys.DELETE);
        nickNameElement.sendKeys(nickName);
    }
    public void enterSummary(String summary)
    {
        WebElement summaryElement = wait.until(ExpectedConditions.visibilityOfElementLocated(summaryTextBox));
        summaryElement.clear();
        summaryElement.sendKeys(summary);
    }
    public void enterReview(String review)
    {
        WebElement reviewElement = wait.until(ExpectedConditions.visibilityOfElementLocated(reviewTextArea));
        reviewElement.clear();
        reviewElement.sendKeys(review);
    }
    public void clickSubmitReviewButton()
    {
        WebElement submitButtonElement = wait.until(ExpectedConditions.elementToBeClickable(submitReviewButton));
        submitButtonElement.click();
    }
    /**************Add item into WishList************/
    By size=By.id("option-label-size-143-item-168");
	By sizeXs=By.id("option-label-size-143-item-166");
	By sizeSmall=By.id("option-label-size-143-item-167");
	By sizeLarge=By.id("option-label-size-143-item-169");
	By sizeXtraLarge=By.id("option-label-size-143-item-170");
	By colorBlack=By.xpath("//*[@id='option-label-color-93-item-49']");
	By colorBlue=By.xpath("//*[@id='option-label-color-93-item-50']");
	By colorOrange=By.xpath("//*[@id='option-label-color-93-item-56']");
	By quantity=By.xpath("//input[@id='qty']");
	By addToWishList=By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[2]/div[5]/div/a[1]");
    public void selectSize()
    {
        WebElement sizeElement = wait.until(ExpectedConditions.elementToBeClickable(sizeXs));
        sizeElement.click();
    }
    public void selectColor()
    {
        WebElement colorElement = wait.until(ExpectedConditions.elementToBeClickable(colorBlack));
        colorElement.click();
    }
    public void setQuantity(int qty)
    {
        WebElement quantityElement = wait.until(ExpectedConditions.elementToBeClickable(quantity));
        quantityElement.clear();
        quantityElement.sendKeys(String.valueOf(qty));
    }
    public void addToWishList()
    {
        WebElement wishListElement = wait.until(ExpectedConditions.elementToBeClickable(addToWishList));
        wishListElement.click();
    }
    /***************************Share wish list**************/
    private By shareWishListButton=By.xpath("//*[text()='Share Wish List']");
    private By shareEmailIdTextBox=By.xpath("//*[@id='email_address']");
    private By messageTextBox=By.xpath("//*[@id='message']");
    private By shareWishListSubmitButton=By.xpath("//*[text()='Share Wish List']");
    private By addAllToCartButton=By.xpath("//*[text()='Add All to Cart']");
    public void clickShareWishListButton()
    {
    	 WebElement shareButton = wait.until(ExpectedConditions.visibilityOfElementLocated(shareWishListButton));
    	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shareButton);
    	    wait.until(ExpectedConditions.elementToBeClickable(shareWishListButton)).click();
    }    
    public void setEmailInShareEmailTextBox(String email)
    {
        WebElement emailTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(shareEmailIdTextBox));
        emailTextBox.clear();
        emailTextBox.sendKeys(email);
    }
    public void setMessageInMessageTextBox(String message)
    {
        WebElement messageTextBoxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(messageTextBox));
        messageTextBoxElement.clear();
        messageTextBoxElement.sendKeys(message);
    }
    public void clickShareWishListSubmitButton()
    {
        wait.until(ExpectedConditions.elementToBeClickable(shareWishListSubmitButton)).click();
    }
    public void clickAddAllToCartButton()
    {
        wait.until(ExpectedConditions.elementToBeClickable(addAllToCartButton)).click();
    }

}
