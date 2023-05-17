@ChangeBooking
Feature: Change booking hotel in OMR Branch hotel page Automation

  Scenario Outline: Verify change booking in My Bookings
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
    Then User should verify success message after booking hotel "Booking is Confirmed" and save the order id
    When User navigates to My booking page and enter order id
    Then User should verify order id and hotel name are same
    When User edit the order id "<Check-In>"
    Then User should verify success message after editing the order id "Booking updated successfully"

    Examples: 
      | userName                  | password     | Select State | Select City | Select Room Type | Check-In   | Check-Out  | No. Of Room | No. Of Adults | No. Of Children | Select Salutation | First Name  | Last Name   | Mobile No. | Email                     | Card Type   | Change-Check-In |
      | vaijeyanthi7899@gmail.com | Jeyanthi@123 | Tamil Nadu   | Puducherry  | Luxury           | 2023-05-10 | 2023-05-15 | 3-Three     | 5-Five        |               2 | Ms.               | Vaijeyanthi | Sudalaimani | 7708402098 | vaijeyanthi7899@gmail.com | Credit Card | 2023-05-12      |
