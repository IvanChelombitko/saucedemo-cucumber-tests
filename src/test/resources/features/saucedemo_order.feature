Feature: SauceDemo Order Processing

  Scenario: Successful order creation for standard user
    Given I am on the SauceDemo login page
    When I login as "standard_user" using credentials from the database
    And I add all my stored orders to the cart
    And I proceed to checkout using my profile details
    Then I should see the successful order completion message

  Scenario: Successful order creation for performance glitch user
    Given I am on the SauceDemo login page
    When I login as "performance_glitch_user" using credentials from the database
    And I add all my stored orders to the cart
    And I proceed to checkout using my profile details
    Then I should see the successful order completion message