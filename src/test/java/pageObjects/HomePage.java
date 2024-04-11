package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage 
{
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	By searchitem=By.xpath("//*[@id='search']");
	
	//Enter search Item in Search field
    public void searchItem(String item)
    {
        driver.findElement(searchitem).sendKeys(item);
    }
    
    
	
}
