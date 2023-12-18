Feature: User can choose the color and the count of a product, so that he could by what he wants
  Background: User is on the product detailed page
    Given User is on "Catalog" page
    And User clicks on a 2 rd product
    Then User is navigated to the detailed product page

  Scenario: User can see product details on the product detailed page
    Then User can see product's "container header"
    And User can see product's "product description"
    And User can see product's "product price"
    And User can see product's "review star 1"
    And User can see product's "review star 2"
    And User can see product's "review star 3"
    And User can see product's "review star 4"
    And User can see product's "review star 5"
    And User can see product's "counter amount"
    And User can see product's "Add To Cart button"
    And User can see product's image
    And User can see product's color options

  Scenario: User can choose product count, color and add product to the cart
    When User clicks "counter plus button" button
    And User selects the color "black"
    And User clicks "Add To Cart button" button
    Then The product is added to the cart
    And The cart badge displays the total count of items in the cart