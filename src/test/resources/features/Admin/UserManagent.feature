@Admin
Feature: Navigate to UserManagment feature
  As a Invalid User
  I want to check users in the system
  So that I can navigate to UserManagment and Create user,delete user via the feature.

  Background:
    Given Logon on the Orangehrm system

  Scenario Outline: navigate to specific tab
    When Navigate to specific tab "<firstLinkName>" -> "<secLinkName>"->"<thirdLinkName>"
    And Click the "<userName>" link

    Examples: User Management
    |firstLinkName|secLinkName    |thirdLinkName|userName|
    |Admin        |User Management|Users        |Admin   |
    #|Admin        |Nationalities  |             |       |

