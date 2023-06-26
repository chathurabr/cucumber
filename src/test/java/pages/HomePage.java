package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private final WebDriver driver;
    WebDriverWait wait;

    private final By lblHeader = By.cssSelector("div[class='header-content'] h2:nth-child(1)");
    private final By requestType = By.xpath("//a[contains(text(),'Single user not found')]");
    private final By listOfRequests = By.xpath("//li[@class='active']");
    private final By request = By.xpath("//div[@class='request']//strong[1]");
    private final By response = By.xpath("//div[@class='response']//strong[1]");
    private final By btnSupport = By.cssSelector("a[href='#support-heading']");


    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getPageHeader(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(lblHeader)));
        return driver.findElement(lblHeader).getText();
    }
    public void selectRequestType(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement list = driver.findElement(listOfRequests);
        js.executeScript("arguments[0].scrollIntoView();", list);
        driver.findElement(requestType).click();
    }

    public void visibilityOfRequestAndResponse(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(request)));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(response)));
    }

    public void listOfRequests(){
        String[] expected = {"get", "get", "get", "get", "get","get", "post", "put", "patch", "delete","post", "post", "post", "post", "get"};
        List<WebElement> allOptions = driver.findElements(By.xpath("//div[@class='endpoints']//ul/li"));

        if (expected.length != allOptions.size()) {
            System.out.println("fail, wrong number of elements found");
        }

        for (int i = 0; i < expected.length; i++) {
            String optionValue = allOptions.get(i).getAttribute("data-http");
            if (optionValue.equals(expected[i])) {
                System.out.println("passed on: " + optionValue);
            } else {
                System.out.println("failed on: " + optionValue);
            }
        }
    }

    public String getRequestUrl(){
        return driver.findElement(By.cssSelector(".url")).getText();
    }

    public String getResponseCode(){
        return driver.findElement(By.cssSelector(".response-code")).getText();
    }

    public void clickOnSupport(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement supportButton = driver.findElement(btnSupport);
        js.executeScript("arguments[0].scrollIntoView();", supportButton);
        supportButton.click();
    }
}
