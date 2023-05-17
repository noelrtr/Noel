@BookHotel
Feature: Book hotel in OMR Branch hotel page Automation
  Scenario Outline: Book hotel without including GST and special request
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should verify success message after login "Welcome Vaijeyanthi"
    When User search hotels "<Select State>","<Select City>","<Select Room Type>","<Check-In>","<Check-Out>","<No. Of Room>","<No. Of Adults>" and "<No. Of Children>"
    Then User should verify success message after search hotels "Select Hotel"
    When User Select first hotel name and save that hotel name
    Then User handles the confirm alert by clicking OK button
    Then User add guest details without enter GST details and special request "<Select Salutation>","<First Name>","<Last Name>","<Mobile No.>" and "<Email>"
    When User enter payment details,proceed with card type "<Card Type>"
      | Select Card | Card Number      | Name On Card | Month   | Year | CVV |
      | Visa        | 5555555555552223 | Vaijeyanthi  | August  | 2027 | 777 |
      | Amex        | 5555555555555555 | Vaijeyanthi  | May     | 2025 | 765 |
      | MasterCard  | 7777666655552222 | Vaijeyanthi  | January | 2027 | 567 |
      | Discover    | 8888555555552222 | Vaijeyanthi  | June    | 2028 | 456 |
    Then User should verify success message after booking hotel "Booking is Confirmed"
    And User should verify Booked hotel name is same as the saved hotel name

    Examples: 
      | userName                  | password     | Select State | Select City | Select Room Type | Check-In   | Check-Out  | No. Of Room | No. Of Adults | No. Of Children | Select Salutation | First Name  | Last Name   | Mobile No. | Email                     | Card Type   |
      | vaijeyanthi7899@gmail.com | Jeyanthi@123 | Tamil Nadu   | Puducherry  | Luxury           | 2023-05-10 | 2023-05-15 | 3-Three     | 5-Five        |               2 | Ms.               | Vaijeyanthi | Sudalaimani | 7708402098 | vaijeyanthi7899@gmail.com | Credit Card |

  Scenario Outline: Enter invalid UPI id and verify error message
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should verify success message after login "Welcome Vaijeyanthi"
    When User search hotels "<Select State>","<Select City>","<Select Room Type>","<Check-In>","<Check-Out>","<No. Of Room>","<No. Of Adults>" and "<No. Of Children>"
    Then User should verify success message after search hotels "Select Hotel"
    When User Select first hotel name and save that hotel name
    Then User handles the confirm alert by clicking OK button
    Then User add guest details without enter GST details and special request "<Select Salutation>","<First Name>","<Last Name>","<Mobile No.>" and "<Email>"
    When User select UPI payment and enter payment details "<Enter UPI ID>"
    Then User should verify error message after upiPayment "Invalid UPI ID"

    Examples: 
      | userName                  | password     | Select State | Select City | Select Room Type | Check-In   | Check-Out  | No. Of Room | No. Of Adults | No. Of Children | Select Salutation | First Name  | Last Name   | Mobile No. | Email                     | Enter UPI ID |
      | vaijeyanthi7899@gmail.com | Jeyanthi@123 | Tamil Nadu   | Puducherry  | Luxury           | 2023-05-10 | 2023-05-15 | 3-Three     | 5-Five        |               2 | Ms.               | Vaijeyanthi | Sudalaimani | 7708402098 | vaijeyanthi7899@gmail.com | jeyanthi@789 |

  Scenario Outline: Enter invalid card details and verify error message
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should verify success message after login "Welcome Vaijeyanthi"
    When User search hotels "<Select State>","<Select City>","<Select Room Type>","<Check-In>","<Check-Out>","<No. Of Room>","<No. Of Adults>" and "<No. Of Children>"
    Then User should verify success message after search hotels "Select Hotel"
    When User Select first hotel name and save that hotel name
    Then User handles the confirm alert by clicking OK button
    Then User add guest details without enter GST details and special request "<Select Salutation>","<First Name>","<Last Name>","<Mobile No.>" and "<Email>"
    When User enter payment details,proceed with card type "<Card Type>"
      | Select Card | Card Number      | Name On Card | Month   | Year | CVV |
      | Visa        | 5555555555554567 | Vaijeyanthi  | August  | 2027 | 777 |
      | Amex        | 5555578655555555 | Vaijeyanthi  | May     | 2025 | 765 |
      | MasterCard  | 7777666655552222 | Vaijeyanthi  | January | 2027 | 567 |
      | Discover    | 8888555555552222 | Vaijeyanthi  | June    | 2028 | 456 |
    Then User should verify error message after cardPayment "Invalid Card Details"

    Examples: 
      | userName                  | password     | Select State | Select City | Select Room Type | Check-In   | Check-Out  | No. Of Room | No. Of Adults | No. Of Children | Select Salutation | First Name  | Last Name   | Mobile No. | Email                     | Card Type   |
      | vaijeyanthi7899@gmail.com | Jeyanthi@123 | Tamil Nadu   | Puducherry  | Luxury           | 2023-05-10 | 2023-05-15 | 3-Three     | 5-Five        |               2 | Ms.               | Vaijeyanthi | Sudalaimani | 7708402098 | vaijeyanthi7899@gmail.com | Credit Card |
