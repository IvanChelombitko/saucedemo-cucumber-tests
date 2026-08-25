Feature: SauceDemo Order Processing

  Scenario Outline: Successful order creation using database records
    Given I am on the SauceDemo login page
    When I login as "<username>" using credentials from the database
    And I add all my stored orders to the cart
    And I proceed to checkout using my profile details
    Then I should see the successful order completion message

    Examples:
      | username      |
      | standard_user |
      | performance_glitch_user |