Feature: Data Management Application - (001B - Support page)

  Scenario: View one-time and monthly support options
    Given I am on the support page
    Then I should see the options for one-time support
    And I should see the options for monthly support

  Scenario: Upgrade details
    Given I am on the support page
    Then I should be provided with upgrade details