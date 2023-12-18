Feature: Checkout functionality
  Background: Use is logged in, has some products in the cart and can navigate to the "Checkout" page from "My Cart"
    Given User is logged in
    And User has some products in the cart
    And User is on the "My Cart" page
    When User clicks "Proceed To Checkout button" button
    Then User is redirected to "Checkout" page

  Scenario: User can complete the checkout process by providing the necessary shipping and payment information,
  reviewing order details, and receiving confirmation of a successful purchase.
    Given User is redirected to "Checkout" page
    When User fills "Full Name*" input field with "Viktorija Golovinova"
    And User fills "Address Line 1*" input field with "K. Griniaus g. 13-10"
    And User fills "City*" input field with "Kaunas"
    And User fills "State/Region" input field with "Kauno"
    And User fills "Zip Code*" input field with "48381"
    And User fills "Country*" input field with "Lithuania"
    Then User clicks "To Payment button" button
    And User is redirected to "Enter a payment method" page
    When User fills "Full Name*" input field with "Viktorija Golovinova"
    And User fills "Card Number*" input field with "2343 4534 5444 3535"
    And User fills "Expiration Date*" input field with "05/27"
    And User fills "Security Code*" input field with "456"
    Then User clicks "Review Order button" button
    And User is redirected to "Review your order" page
    When User checks that his "checkout delivery address" contains "Viktorija Golovinova"
    And User checks that his "checkout delivery address" contains "K. Griniaus g. 13-10"
    And User checks that his "checkout delivery address" contains "Kaunas, Kauno"
    And User checks that his "checkout delivery address" contains "Lithuania, 48381"
    And User checks that his "checkout payment info" contains "Viktorija Golovinova"
    And User checks that his "checkout payment info" contains "2343 4534 5444 3535"
    And User checks that his "checkout payment info" contains "Exp: 05/27"
    And User clicks "Place Order button" button
    Then User is redirected to "Checkout Complete" page
    When User clicks "Continue Shopping button" button
    Then User is redirected to "Products" page