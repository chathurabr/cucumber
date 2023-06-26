package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.SupportPage;

public class HomePageSteps {

    private WebDriver driver;
    HomePage homePage;

    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://reqres.in/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        Assert.assertEquals(homePage.getPageHeader(),"Test your front-end against a real API");

    }

    @When("I select a specific request type")
    public void i_select_a_specific_request_type() {
        homePage.selectRequestType();
    }

    @Then("I should see the list of end points for that request type")
    public void i_should_see_the_list_of_end_points_for_that_request_type() {
        homePage.listOfRequests();
    }

    @Then("I should be able to view the sample request and response details")
    public void i_should_be_able_to_view_the_sample_request_and_response_details() {
       homePage.visibilityOfRequestAndResponse();
    }

    @Then("I should see the request {string}")
    public void iShouldSeeTheRequest(String request) {
        Assert.assertEquals(homePage.getRequestUrl(),request);
    }

    @And("I should see the response status code {string}")
    public void iShouldSeeTheResponseStatusCode(String response) {
        Assert.assertEquals(homePage.getResponseCode(),response);
    }

    @When("I click on the navigate to support page button")
    public void iClickOnTheNavigateToSupportPageButton() {
        homePage.clickOnSupport();
    }

    @Then("I should be redirected to the support page")
    public void iShouldBeRedirectedToTheSupportPage() {
        SupportPage supportPage = new SupportPage(driver);
        Assert.assertEquals(supportPage.getPageHeader(),"Support");
    }
}
