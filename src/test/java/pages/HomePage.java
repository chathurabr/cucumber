import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver;

    //By Locators
    private final By requestType = By.xpath("//a[contains(text(),'Single user not found')]");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //methods
    public void selectRequestType(){
        WebElement selectRequestType = driver.findElement(requestType);
        selectRequestType.click();
    }
}
