@SelectHotel
Feature: Select hotel with all valid credentials

  Scenario Outline: Select hotel and verify navigate to book hotel upon accepting the alert
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should verify success message after login "Welcome Vaijeyanthi"
    When User search hotels "<Select State>","<Select City>","<Select Room Type>","<Check-In>","<Check-Out>","<No. Of Room>","<No. Of Adults>" and "<No. Of Children>"
    Then User should verify success message after search hotels "Select Hotel"
    When User Select first hotel name and save that hotel name
    Then User handles the confirm alert by clicking OK button
    And User should verify success message after select hotels "Book Hotel"

    Examples: 
      | userName                  | password     | Select State | Select City | Select Room Type | Check-In   | Check-Out  | No. Of Room | No. Of Adults | No. Of Children |
      | vaijeyanthi7899@gmail.com | Jeyanthi@123 | Tamil Nadu   | Puducherry  | Luxury           | 2023-05-10 | 2023-05-15 | 3-Three     | 5-Five        |               2 |

  Scenario Outline: Select hotel and verify navigating in the same page upon dismiss the alert
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should verify success message after login "Welcome Vaijeyanthi"
    When User search hotels "<Select State>","<Select City>","<Select Room Type>","<Check-In>","<Check-Out>","<No. Of Room>","<No. Of Adults>" and "<No. Of Children>"
    Then User should verify success message after search hotels "Select Hotel"
    When User Select first hotel name and save that hotel name
    And User handles the confirm alert by clicking cancel button
    Then User should verify success message after search hotels "Select Hotel"

    Examples: 
      | userName                  | password     | Select State | Select City | Select Room Type | Check-In   | Check-Out  | No. Of Room | No. Of Adults | No. Of Children |
      | vaijeyanthi7899@gmail.com | Jeyanthi@123 | Tamil Nadu   | Puducherry  | Luxury           | 2023-05-10 | 2023-05-15 | 3-Three     | 5-Five        |               2 |

  Scenario Outline: Enter all fields and verify select hotel and sort hotels name by ascending order
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should verify success message after login "Welcome Vaijeyanthi"
    When User search hotels "<Select State>","<Select City>","<Select Room Type>","<Check-In>","<Check-Out>","<No. Of Room>","<No. Of Adults>" and "<No. Of Children>"
    Then User should verify success message after search hotels "Select Hotel"
    When User click name ascending radio button
    Then User should verify the hotel names in ascending order after clicking the name ascending radio button

    Examples: 
      | userName                  | password     | Select State | Select City | Select Room Type | Check-In   | Check-Out  | No. Of Room | No. Of Adults | No. Of Children |
      | vaijeyanthi7899@gmail.com | Jeyanthi@123 | Tamil Nadu   | Puducherry  | Luxury           | 2023-05-10 | 2023-05-15 | 3-Three     | 5-Five        |               2 |

  Scenario Outline: Unselect room type and verify listing all hotels
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should verify success message after login "Welcome Vaijeyanthi"
    When User search hotels "<Select State>","<Select City>","<Select Room Type>","<Check-In>","<Check-Out>","<No. Of Room>","<No. Of Adults>" and "<No. Of Children>"
    Then User should verify success message after search hotels "Select Hotel"
    When User unselect the room type by clicking the room type checkbox
    Then User should verify all the hotels are listed after unselect room type

    Examples: 
      | userName                  | password     | Select State | Select City | Select Room Type | Check-In   | Check-Out  | No. Of Room | No. Of Adults | No. Of Children |
      | vaijeyanthi7899@gmail.com | Jeyanthi@123 | Tamil Nadu   | Puducherry  | Luxury           | 2023-05-10 | 2023-05-15 | 3-Three     | 5-Five        |               2 |
