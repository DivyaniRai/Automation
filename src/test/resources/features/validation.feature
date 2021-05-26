Feature: I want to register to the webside

 @Validation
  Scenario: validating payment page
    Given I click on the signIn button
    And I give valid credentials to login
    And I add a product to cart
    When I click on checkout page and proceed
   Then I see the payment page