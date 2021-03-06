@UnLogin @Smoke
Feature: Invalid login orangehrmlive.com
  As a Invalid User
  I want to login to the orangehrmlive.com
  So that I can ser the error message.

  Background:
    Given Orangehrm has launched

  Scenario Outline: Unsuccess Login

    When Orangehrm Website is launched
    Then Orangehrm Login page is displayed
    When I enter Invalid username "<username>"and"<password>"
    And I tap on the Login button
    Then I should see "<errorMessage>"

    Examples: InvalidData
      | username | password | errorMessage        |
      | invalid  | invalid  | Invalid credentials |