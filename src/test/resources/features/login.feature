Feature: Login functionality

  Scenario Outline: Attempt to login with an empty password field
    Given the user is on the login page
    When the user attempts to log in with an empty password and a valid "<email>"
    And the user press the button summit
    Then the user should see a password field with red border
    Examples:
      | email             |
      | sebas44@gmail.com |

  Scenario Outline: Attempt to login with an empty email field
    Given the user is on the login page
    When the user attempts to log in with an empty email and a valid "<password>"
    And the user press the button summit
    Then the user should see an email field with red border
    Examples:
      | password |
      | abc123   |


  Scenario Outline: Attempt to login with an email and password but captcha empty
    Given the user is on the login page
    When the user attempts to log in with an valid email "<email>" and password "<password>"
    And the user press the button summit
    Then the user should see an error message captcha
    Examples:
      | email             | password |
      | sebas44@gmail.com | abc123   |


  Scenario Outline: Attempt to login with an email and password but captcha with wrong code
    Given the user is on the login page
    When the user attempts to log in with an valid email "<email>" and password "<password>"
    And the user enters a wrong "<captcha>"
    And the user press the button summit
    Then the user should see an error message captcha
    Examples:
      | email             | password | captcha |
      | sebas44@gmail.com | abc123   | abcdf   |
