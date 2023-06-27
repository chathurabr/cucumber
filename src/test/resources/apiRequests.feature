Feature: API Spec and Schema

  Background:
    Given the base URL is "https://reqres.in/"

  Scenario: Get user by ID
    When a GET request is made to "/api/users/2"
    Then the response status code should be 200
    And validate the response having email as "janet.weaver@reqres.in"
    And validate the response having first name as "Janet"
    And validate the response having last name as "Weaver"


  Scenario: Create user
    Given the user data is provided as:
      | name     | job    |
      | morpheus | leader |
    When a POST request is made to "/api/users" with the payload
    Then the response status code POST request should be 201
    And the response body should contain user details