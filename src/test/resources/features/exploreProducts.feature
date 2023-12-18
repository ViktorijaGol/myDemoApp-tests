Feature: Products exploration functionality
  Background: User is on the Products page
    Given User is on "Catalog" page

  Scenario: User scrolls down to view products
    When User scrolls down the page
    Then User can see product 3 and it's photo, title, price
    And User can see product 4 and it's photo, title, price
    And User can see product 5 and it's photo, title, price

  Scenario: User clicks on a product to view details
    When User clicks on a 3 rd product
    Then User is navigated to the detailed product page

  Scenario: User clicks on the star to submit a review
    When User clicks on the 5 star next to a 3 rd product
    Then User sees message "Thank you for submitting your review!"
    When User clicks "Close Modal button" button
    Then User is redirected to "Products" page
