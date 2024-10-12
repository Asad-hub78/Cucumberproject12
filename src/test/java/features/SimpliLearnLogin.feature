@Simplilearn
Feature: This feature will validate the login scenarios for simplilearn.com
@U_100
  Scenario: Validate the Login failure scenario
    Given I have launched the application
    And I click on the Login link
    When I enter the username
    And I enter the password
    And I click on the login button
    Then I should get the error message as "The email or password you have entered is invalid."
@U_101
  Scenario: Validate the Login failure scenario using parameters
    Given I have launched the application
    And I click on the Login link
    When I enter the username "abc@fgh.com"
    And I enter the password "Abcd@1234"
    And I click on the login button
    Then I should get the error message as "The email or password you have entered is invalid."

  Scenario Outline: Validate the Login failure scenario using scenario outline
    Given I have launched the application
    And I click on the Login link
    When I enter the username "<UserName>"
    And I enter the password "<Password>"
    And I click on the login button
    Then I should get the error message as "The email or password you have entered is invalid."

    Examples: 
      | UserName        | Password     | Error                              |
      | abc@efg.com | Abcd@9876 | Please enter a valid email address |
      | xyz@abc.com | Xyza@1234    | Please enter a valid email address |
@U_103
  Scenario: Validate the different login options present on the login screen
    Given I have launched the application
    And I click on the Login link
    Then I see the below login options present on the screen
      | Google   |
      | Facebook |
      | Linkedin |
      | Apple    |
