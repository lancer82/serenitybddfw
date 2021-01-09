@Login
Feature: Login into orangehrmlive.com
  As a Valid User
  I want to login to the orangehrm
  So that I can see the overview page.

  Scenario Outline: Success Login

    Given I use Valid "<userName>" and Valid "<password>"
    When I perform Login Action
    Then I should see my Overview page.


    Examples: Valid Data
      |userName        |password  |
      |admin           |admin123  |