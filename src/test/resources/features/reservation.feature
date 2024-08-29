Feature: Hotel reservation

  Scenario Outline: Successful hotel reservation with specific filters
    Given the user is on the hotel booking page
    When the user selects "Las Vegas, USA" on location field
    And the user selects the check-in date <checkInDate> days from today
    And the user selects the check-out date <checkOutDate> days from today
    And the user selects "<totalRooms>" rooms
    And the user selects "<totalAdults>" adults
    And the user selects "<totalChildren>" children
    And the user press the button search
    And the user selects a price range above "<priceRange>" USD
    And the user selects 3 stars rating or more
    And the user applies the selected filters
    And the user selects the cheapest hotel that meets the filters
    Then the user should see the message "Your Reservation Summary"

    Examples:
      | checkInDate | checkOutDate | totalRooms | totalAdults | totalChildren | priceRange |
      | 2           | 7            | 2          | 3           | 2             | 200        |