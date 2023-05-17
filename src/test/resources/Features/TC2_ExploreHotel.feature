@ExploreHotel
Feature: Exploring Hotels in OMR Branch hotel page Automation

  Scenario Outline: Enter all field and verify Select Hotel
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should verify success message after login "Welcome Vaijeyanthi"
    When User search hotels "<Select State>","<Select City>","<Select Room Type>","<Check-In>","<Check-Out>","<No. Of Room>","<No. Of Adults>" and "<No. Of Children>"
    Then User should verify success message after search hotels "Select Hotel"

    Examples: 
      | userName                  | password     | Select State | Select City | Select Room Type | Check-In   | Check-Out  | No. Of Room | No. Of Adults | No. Of Children |
      | vaijeyanthi7899@gmail.com | Jeyanthi@123 | Tamil Nadu   | Puducherry  | Luxury           | 2023-05-10 | 2023-05-15 | 3-Three     | 5-Five        |               2 |

  Scenario Outline: Select multiple room type and verify same filters in header
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should verify success message after login "Welcome Vaijeyanthi"
    When User search hotels "<Select State>","<Select City>","<Select Room Type>","<Check-In>","<Check-Out>","<No. Of Room>","<No. Of Adults>" and "<No. Of Children>"
    Then User should verify success message after search hotels "Select Hotel"
    And User should verify selected room types are present in header "<Select Room Type>"

    Examples: 
      | userName                  | password     | Select State | Select City | Select Room Type    | Check-In   | Check-Out  | No. Of Room | No. Of Adults | No. Of Children |
      | vaijeyanthi7899@gmail.com | Jeyanthi@123 | Tamil Nadu   | Puducherry  | Deluxe/Suite/Luxury | 2023-05-10 | 2023-05-15 | 3-Three     | 5-Five        |               2 |

  Scenario Outline: Passing room type and verify filter is listed then verify hotel name ends with same room type
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should verify success message after login "Welcome Vaijeyanthi"
    When User search hotels "<Select State>","<Select City>","<Select Room Type>","<Check-In>","<Check-Out>","<No. Of Room>","<No. Of Adults>" and "<No. Of Children>"
    Then User should verify success message after search hotels "Select Hotel"
    And User should verify listed hotel names are ends with same as room type "<Select Room Type>"

    Examples: 
      | userName                  | password     | Select State | Select City | Select Room Type | Check-In   | Check-Out  | No. Of Room | No. Of Adults | No. Of Children |
      | vaijeyanthi7899@gmail.com | Jeyanthi@123 | Tamil Nadu   | Puducherry  | Luxury           | 2023-05-10 | 2023-05-15 | 3-Three     | 5-Five        |               2 |

  Scenario Outline: Without enter any field click search and verify all 6 error message
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should verify success message after login "Welcome Vaijeyanthi"
    When User search hotels without enter any values and click search button
    Then User should verify all 6 error message "Please select state","Please select city","Please select Check-in date","Please select Check-out date","Please select no. of rooms" and "Please select no. of adults"

    Examples: 
      | userName                  | password     |
      | vaijeyanthi7899@gmail.com | Jeyanthi@123 |
