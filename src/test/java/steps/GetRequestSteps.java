package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class GetRequestSteps {
    private Response response;

    @Given("the base URL is {string}")
    public void setBaseURL(String baseURL) {
        RestAssured.baseURI = baseURL;
    }

    @When("a GET request is made to {string}")
    public void sendGetRequest(String endpoint) {
        RequestSpecification request = RestAssured.given();
        response = request.get(endpoint);
    }

    @Then("the response status code should be {int}")
    public void verifyResponseStatusCode(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode);
    }

    @And("validate the response having email as {string}")
    public void validateTheResponseHavingEmailAs(String emailID) {
        String userEmail = response.path("data.email");
        Assert.assertEquals(userEmail, emailID);
    }

    @And("validate the response having first name as {string}")
    public void validateTheResponseHavingFirstNameAs(String firstName) {
        String first_name = response.path("data.first_name");
        Assert.assertEquals(firstName, first_name);
    }

    @And("validate the response having last name as {string}")
    public void validateTheResponseHavingLastNameAs(String lastName) {
        String last_name = response.path("data.last_name");
        Assert.assertEquals(lastName, last_name);
    }
}
