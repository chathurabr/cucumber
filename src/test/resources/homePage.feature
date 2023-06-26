Feature: Data Management Application - (001 UI Spec 001A - Home page)

  Scenario: Home page functionality
    Given I am on the home page
    When I select a specific request type
    Then I should see the list of end points for that request type
    And I should be able to view the sample request and response details

  Scenario: Display sample request and response details
    Given I am on the home page
    When I select a specific request type
    Then I should see the request "/api/users/23"
    And I should see the response status code "404"

  Scenario: Navigate to support page
    Given I am on the home page
    When I click on the navigate to support page button
    Then I should be redirected to the support page