@Login
Feature: Verifying OMR Branch hotel Login Automation

  Scenario Outline: Verifying login with valid credentials
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should verify success message after login "Welcome Vaijeyanthi"

    Examples: 
      | userName                  | password     |
      | vaijeyanthi7899@gmail.com | Jeyanthi@123 |

  Scenario Outline: Login with Robot - with help of keyboard actions
    Given User is on the OMR Branch hotel page
    When User login using keyboard actions "<userName>","<password>"
    Then User should verify success message after login "Welcome Vaijeyanthi"

    Examples: 
      | userName                  | password     |
      | vaijeyanthi7899@gmail.com | Jeyanthi@123 |

  Scenario Outline: Verifying login with invalid credentials
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should verify error message after login "Invalid Login details"

    Examples: 
      | userName                  | password     |
      | vaijeyanthi7899@gmail.com | Jeyanthi@234 |
