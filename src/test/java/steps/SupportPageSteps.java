package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.SupportPage;

public class SupportPageSteps {
    private WebDriver driver;
    SupportPage supportPage;

    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://reqres.in/#support-heading");
        driver.manage().window().maximize();
        supportPage = new SupportPage(driver);
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
    @Given("I am on the support page")
    public void iAmOnTheSupportPage() {
        Assert.assertEquals(supportPage.getPageHeader(),"Support");
    }

    @Then("I should see the options for one-time support")
    public void iShouldSeeTheOptionsForOneTimeSupport() {
        Assert.assertEquals(supportPage.getSupportOneTime(),"One-time payment ($)");
    }

    @And("I should see the options for monthly support")
    public void iShouldSeeTheOptionsForMonthlySupport() {
        Assert.assertEquals(supportPage.getSupportMonthly(),"Monthly support ($5/month)");
    }

    @Then("I should be provided with upgrade details")
    public void iShouldBeProvidedWithUpgradeDetails() {
        supportPage.clickOnUpgrade();
        Assert.assertEquals(supportPage.getUpgradeText(),"Looking for pro features?");
    }
}
