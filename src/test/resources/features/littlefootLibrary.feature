Feature: User should able to enter the data and those data stored into file

  @LittlefoodLibraryTest
  Scenario Outline: Verifying the data output
    Given User is on Littlefoot Library page
    And User enters "<firstName>"
    And User selects "<townResident>"
    And User puts "<Title>" and "<Author>"
    And User enters "<Pages>", "<DDC>" and "<ReadStatus>"
    Then Librarian gets the report

    Examples: test data

      | firstName | townResident | Title                           | Author                  | Pages | DDC        | ReadStatus |
      | Kate      |Yes         | Presumptions of Philosophy      | Donald Daffy Duckworth  | 657   | 120.563DUC | Read      |
      | Pisik     | Yes        | Philosophical Ponderings        | Mickey and Minnie Mouse | 1200  | 125.563MOU | Partially  |
      | Lee       | Yes        | Application of Natural Sciences | Rick Sanchez            | 145   | 601.103SAN | Read      |
      | David     | Yes        | Rented and Unread               | Solitude O’Brien        | 734   | 834.334OBR | Not Read     |
