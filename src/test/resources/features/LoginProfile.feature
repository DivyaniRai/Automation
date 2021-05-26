Feature: I want to register to the webside
@LoginProfile
  Scenario: Registration
    Given I click on the sign in button
    And I give my mail id
    Then I click on create an account button
    And I Enter my details from given sheet name
    When I click on register
    Then I see correct name and surname