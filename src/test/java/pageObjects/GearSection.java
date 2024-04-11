package pageObjects;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class GearSection {
	WebDriver driver;
    WebDriverWait wait;
	public GearSection(WebDriver driver)
	{
		this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	 	By gearClick = By.xpath("//*[text()='Gear']");
	    By bagsClick = By.xpath("//*[@id=\"narrow-by-list2\"]/dd/ol/li[1]/a");
	    By sorterDropdown = By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/div[3]/select");
	    By styleClick = By.xpath("//*[text()='Style']");
	    By fitnessEquipment = By.xpath("//*[@id=\"narrow-by-list2\"]/dd/ol/li[2]/a");
	    By backpackClick = By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[1]/a");
	    By luggage = By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[2]/a");
	    By itemCount = By.xpath("//p[@class='toolbar-amount' and @id='toolbar-amount']");
	    By clearAllButton = By.xpath("//*[text()='Clear All']");
	    By duffel = By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[3]/a");
	    By messenger = By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[4]/a");
	    By laptop = By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[5]/a");
	    By exercise = By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[6]/a");
	    By tote = By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[7]/a");
	    By price = By.xpath("//*[text()='Price']");
	    By price2030 = By.xpath("//*[@id=\"narrow-by-list\"]/div[2]/div[2]/ol/li[1]/a");
	    By price3040 = By.xpath("//*[@id=\"narrow-by-list\"]/div[2]/div[2]/ol/li[2]/a");
	    By price4050 = By.xpath("//*[@id=\"narrow-by-list\"]/div[2]/div[2]/ol/li[3]/a");
	    By price5060 = By.xpath("//*[@id=\"narrow-by-list\"]/div[2]/div[2]/ol/li[4]/a");
	    By price70Above = By.xpath("//*[@id=\"narrow-by-list\"]/div[2]/div[2]/ol/li[5]/a");

	    public void clickGearSection() {
	        WebElement gearElement = wait.until(ExpectedConditions.elementToBeClickable(gearClick));
	        gearElement.click();
	    }

	    public void clickBagsSection() {
	        WebElement bagsElement = wait.until(ExpectedConditions.elementToBeClickable(bagsClick));
	        bagsElement.click();
	    }

	    public void clickbackpackClick() {
	        WebElement styleBackpackClick = wait.until(ExpectedConditions.elementToBeClickable(backpackClick));
	        styleBackpackClick.click();
	    }

	    public void clickDuffel() {
	        WebElement styleDuffelClick = wait.until(ExpectedConditions.elementToBeClickable(duffel));
	        styleDuffelClick.click();
	    }

	    public void clickLuggage() {
	        WebElement styleLuggageClick = wait.until(ExpectedConditions.elementToBeClickable(luggage));
	        styleLuggageClick.click();
	    }

	    public void clickMessenger() {
	        WebElement styleMessengerClick = wait.until(ExpectedConditions.elementToBeClickable(messenger));
	        styleMessengerClick.click();
	    }

	    public void clickExercise() {
	        WebElement styleExerciseClick = wait.until(ExpectedConditions.elementToBeClickable(exercise));
	        styleExerciseClick.click();
	    }

	    public void clickLaptop() {
	        WebElement styleLaptopClick = wait.until(ExpectedConditions.elementToBeClickable(laptop));
	        styleLaptopClick.click();
	    }

	    public void clickTote() {
	        WebElement styleToteClick = wait.until(ExpectedConditions.elementToBeClickable(tote));
	        styleToteClick.click();
	    }

	    public void clickPrice() {
	        WebElement PriceClick = wait.until(ExpectedConditions.elementToBeClickable(price));
	        PriceClick.click();
	    }

	    public void clickPrice2030() {
	        WebElement price2030Click = wait.until(ExpectedConditions.elementToBeClickable(price2030));
	        price2030Click.click();
	    }

	    public void clickPrice3040() {
	        WebElement price3040Click = wait.until(ExpectedConditions.elementToBeClickable(price3040));
	        price3040Click.click();
	    }

	    public void clickPrice4050() {
	        WebElement price4050Click = wait.until(ExpectedConditions.elementToBeClickable(price4050));
	        price4050Click.click();
	    }

	    public void clickPrice5060() {
	        WebElement price5060Click = wait.until(ExpectedConditions.elementToBeClickable(price5060));
	        price5060Click.click();
	    }

	    public void clickPrice70Above() {
	        WebElement price70AboveClick = wait.until(ExpectedConditions.elementToBeClickable(price70Above));
	        price70AboveClick.click();
	    }

	    public void clickStyleClick() {
	        WebElement styleElement = wait.until(ExpectedConditions.elementToBeClickable(styleClick));
	        styleElement.click();
	    }

	    public void selectSortByProductName() {
	        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(sorterDropdown));
	        Select dropdown = new Select(dropdownElement);
	        dropdown.selectByVisibleText("Product Name");
	    }

	    public List<String> getProductNames() {
	        List<String> productNames = new ArrayList<>();
	        List<WebElement> productNameElements = driver.findElements(By.xpath("//div[@class='product-name']"));
	        for (WebElement productNameElement : productNameElements) {
	            productNames.add(productNameElement.getText());
	        }
	        return productNames;
	    }

	    public String getItemCount() {
	        WebElement itemCountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(itemCount));
	        return itemCountElement.getText();
	    }

	    public void clickGearAll() {
	        WebElement clearAllButtonElement = wait.until(ExpectedConditions.elementToBeClickable(clearAllButton));
	        clearAllButtonElement.click();
	    }

	    public void clickFitnessEquipmentSection() {
	        WebElement fitnessEquipmentElement = wait.until(ExpectedConditions.elementToBeClickable(fitnessEquipment));
	        fitnessEquipmentElement.click();
	    }
/********************Category*************************/
private By category = By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]");
private By cadio = By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[1]/a");
private By exerciseCategory = By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[2]/a");

public void clickCategory() {
    WebElement categoryClick = wait.until(ExpectedConditions.elementToBeClickable(category));
    categoryClick.click();
}

public void clickCardio() {
    WebElement cardioClick = wait.until(ExpectedConditions.elementToBeClickable(cadio));
    cardioClick.click();
}

public void clickExerciseCategory() {
    WebElement exerciseCategoryClick = wait.until(ExpectedConditions.elementToBeClickable(exerciseCategory));
    exerciseCategoryClick.click();
}

private By size = By.xpath("//*[@id=\"narrow-by-list\"]/div[2]/div[1]");
private By size55 = By.xpath("//div[@class='swatch-option text ' and text()='55 cm']");
private By size65 = By.xpath("//div[@class='swatch-option text ' and text()='65 cm']");
private By size75 = By.xpath("//div[@class='swatch-option text ' and text()='75 cm']");
private By size6Foot = By.xpath("//div[@class='swatch-option text ' and text()='6 foot']");
private By size8Foot = By.xpath("//div[@class='swatch-option text ' and text()='8 foot']");
private By size10Foot = By.xpath("//div[@class='swatch-option text ' and text()='10 foot']");

public void clickSize() {
    WebElement sizeClick = wait.until(ExpectedConditions.elementToBeClickable(size));
    sizeClick.click();
}

public void clickSize55() {
    WebElement size55Click = wait.until(ExpectedConditions.elementToBeClickable(size55));
    size55Click.click();
}

public void clickSize65() {
    WebElement size65Click = wait.until(ExpectedConditions.elementToBeClickable(size65));
    size65Click.click();
}

public void clickSize75() {
    WebElement size75Click = wait.until(ExpectedConditions.elementToBeClickable(size75));
    size75Click.click();
}

public void clickSize6Foot() {
    WebElement size6FootClick = wait.until(ExpectedConditions.elementToBeClickable(size6Foot));
    size6FootClick.click();
}

public void clickSize8Foot() {
    WebElement size8FootClick = wait.until(ExpectedConditions.elementToBeClickable(size8Foot));
    size8FootClick.click();
}

public void clickSize10Foot() {
    WebElement size10FootClick = wait.until(ExpectedConditions.elementToBeClickable(size10Foot));
    size10FootClick.click();
}

private By color = By.xpath("//*[@id=\"narrow-by-list\"]/div[4]/div[1]");
private By colorBlue = By.xpath("//*[@id=\"narrow-by-list\"]/div[4]/div[2]/div/div/a/div");

public void clickColor() {
    WebElement colorClick = wait.until(ExpectedConditions.elementToBeClickable(color));
    colorClick.click();
}

public void clickColorBlue() {
    WebElement colorBlueClick = wait.until(ExpectedConditions.elementToBeClickable(colorBlue));
    colorBlueClick.click();
}

private By priceFitness = By.xpath("//*[@id=\"narrow-by-list\"]/div[3]/div[1]");
private By price910 = By.xpath("//*[@id=\"narrow-by-list\"]/div[3]/div[2]/ol/li[1]/a");
private By price1020 = By.xpath("//*[@id=\"narrow-by-list\"]/div[3]/div[2]/ol/li[2]/a");
private By price2030Fitness = By.xpath("//*[@id=\"narrow-by-list\"]/div[3]/div[2]/ol/li[3]/a");
private By price60Above = By.xpath("//*[@id=\"narrow-by-list\"]/div[3]/div[2]/ol/li[4]/a");

public void clickPriceFitness() {
    WebElement priceFitnessClick = wait.until(ExpectedConditions.elementToBeClickable(priceFitness));
    priceFitnessClick.click();
}

public void clickPrice910() {
    WebElement price910Click = wait.until(ExpectedConditions.elementToBeClickable(price910));
    price910Click.click();
}

public void clickPrice1020() {
    WebElement price1020Click = wait.until(ExpectedConditions.elementToBeClickable(price1020));
    price1020Click.click();
}

public void clickPrice2030Fitness() {
    WebElement price2030FitnessClick = wait.until(ExpectedConditions.elementToBeClickable(price2030Fitness));
    price2030FitnessClick.click();
}

public void clickPrice60Above() {
    WebElement price60AboveClick = wait.until(ExpectedConditions.elementToBeClickable(price60Above));
    price60AboveClick.click();
}

private By watchesSection = By.xpath("//*[@id=\"narrow-by-list2\"]/dd/ol/li[3]/a");
private By watchCategory = By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]");
private By electronicWatchCategory = By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[1]/a");
private By exerciseWatch = By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[2]/a");
private By fashionWatch = By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[3]/a");
private By timepieceWatch = By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[4]/a");

public void clickWatchesSection() {
    WebElement watchesSectionClick = wait.until(ExpectedConditions.elementToBeClickable(watchesSection));
    watchesSectionClick.click();
}

public void clickWatchCategory() {
    WebElement watchCategoryClick = wait.until(ExpectedConditions.elementToBeClickable(watchCategory));
    watchCategoryClick.click();
}

public void clickElectronicWatchCategory() {
    WebElement electronicWatchCategoryClick = wait.until(ExpectedConditions.elementToBeClickable(electronicWatchCategory));
    electronicWatchCategoryClick.click();
}

public void clickExerciseWatch() {
    WebElement exerciseWatchClick = wait.until(ExpectedConditions.elementToBeClickable(exerciseWatch));
    exerciseWatchClick.click();
}

public void clickFashionWatch() {
    WebElement fashionWatchClick = wait.until(ExpectedConditions.elementToBeClickable(fashionWatch));
    fashionWatchClick.click();
}

public void clickTimepieceWatch() {
    WebElement timepieceWatchClick = wait.until(ExpectedConditions.elementToBeClickable(timepieceWatch));
    timepieceWatchClick.click();
}

}
