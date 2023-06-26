package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SupportPage {
    private final WebDriver driver;
    WebDriverWait wait;

    private final By lblHeader = By.cssSelector("#support-heading");
    private final By supportOneTime = By.cssSelector("label[for='supportOneTime']");
    private final By supportMonthly = By.cssSelector("label[for='supportRecurring']");
    private final By btnUpgrade = By.cssSelector("#trigger-pro");
    private final By upgradeText = By.cssSelector("div[class='container'] h2:nth-child(1)");


    public SupportPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public String getPageHeader(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(lblHeader)));
        return driver.findElement(lblHeader).getText();
    }

    public String getSupportMonthly(){
        return driver.findElement(supportMonthly).getText();
    }

    public String getSupportOneTime(){
        return driver.findElement(supportOneTime).getText();
    }

    public void clickOnUpgrade(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement button = driver.findElement(btnUpgrade);
        js.executeScript("arguments[0].scrollIntoView();", button);
        button.click();
    }

    public String getUpgradeText(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(upgradeText)));
        return driver.findElement(upgradeText).getText();
    }
}
