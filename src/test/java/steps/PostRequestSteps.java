package steps;

import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.Map;

public class PostRequestSteps {
    private Response response;
    private Map<String, String> userData;

    @Given("the user data is provided as:")
    public void the_user_data_is_provided_as(Map<String, String> userData) {
        this.userData = userData;
    }

    @When("a POST request is made to {string} with the payload")
    public void a_post_request_is_made_to_with_the_payload(String endpoint) {
        RequestSpecification request = RestAssured.given();
        Gson gson = new Gson();
        String payload = gson.toJson(userData);
        request.body(payload);
        response = request.post(endpoint);
    }

    @Then("the response status code POST request should be {int}")
    public void the_response_status_code_should_be(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode);
    }

    @Then("the response body should contain user details")
    public void the_response_body_should_contain_user_details() {
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("id"));
        Assert.assertTrue(responseBody.contains("createdAt"));
    }
}
