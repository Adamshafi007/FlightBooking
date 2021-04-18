Feature: This feature will validate flight booking

  @Sanity
  Scenario Outline: Verify flight booking for users
    Given User navigates to flight booking application
    When user selects "<departure>" and "<destination>" city and click on Find Flights button
    And user choose flight to reserve ticket
    And user enters all passenger details and clicks on Purchase Flight button
    Then user validates purchase details
    Examples:
      | departure   | destination |
      | Paris       | Rome        |
#      | Boston      | Berlin      |





