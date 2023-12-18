Feature: Log into app functionality
  Background: User is on the Login page
    Given User is on "Log In" page

  Scenario: Successful login
    When User fills "Username" input field with "bob@example.com"
    And User fills "Password" input field with "10203040"
    And User clicks "Login button" button
    Then User is redirected to "Products" page

  Scenario Outline: Unsuccessful login
    When User fills "Username" input field with "<username>"
    And User fills "Password" input field with "<password>"
    And User clicks "Login button" button
    Then User sees message "<message>"
    Examples:
    | username          | password  | message                                                     |
    |                   | 10203040  | Username is required                                        |
    | bob@example.com   |           | Password is required                                        |
    |                   |           | Username is required                                        |
    | katinukai         | 10203040  | Provided credentials do not match any user in this service. |
    | bob@example.com   | katinukai | Provided credentials do not match any user in this service. |
    | katinukai         | katinukai | Provided credentials do not match any user in this service. |
    | alice@example.com | 10203040  | Sorry, this user has been locked out.                       |

